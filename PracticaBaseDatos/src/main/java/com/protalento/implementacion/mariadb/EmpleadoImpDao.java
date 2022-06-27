package com.protalento.implementacion.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.protalento.Model.Empleado;
import com.protalento.interfaces.DaoException;
import com.protalento.interfaces.DatabaseConnection;
import com.protalento.interfaces.EmpleadoDAO;

public class EmpleadoImpDao implements EmpleadoDAO, DatabaseConnection {
	
	final String GETONE = "SELECT idEmpleado, nombreEmp, telefonoEmp, subordinadosEmp, fechaIngresoEmp, idSupervisor, cliente FROM empleados WHERE idEmpleado = ?";
	final String GETALL = "SELECT idEmpleado, nombreEmp, telefonoEmp, subordinadosEmp, fechaIngresoEmp, idSupervisor, cliente FROM empleados";
	final String INSERT = "INSERT INTO empleados(nombreEmp, telefonoEmp, subordinadosEmp, fechaIngresoEmp, idSupervisor) VALUES (?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE empleados SET nombreEmp = ?, telefonoEmp = ?, subordinadosEmp = ?, fechaIngresoEmp = ?, idSupervisor = ? WHERE idEmpleado = ?";
	final String DELETE = "DELETE FROM empleados WHERE idEmpleado = ?";
	
	
	private Empleado convertir(ResultSet rs) throws SQLException {  //utilizamos el convertir y el ResulSet por los metodos que nos permiten obtener byte a partir de un numero, un long, int, lo que sea.
																	//Se debe convertir en un objeto. debemos identificar los datos que queremos extraer
			String nombreEmp = rs.getString("nombreEmp");
			String telefonoEmp =rs.getString("telefonoEmp");
			String subordinadosEmp = rs.getString("subordinadosEmp");
			LocalDateTime fechaIngresoEmp = LocalDateTime.parse(rs.getString("fechaIngresoEmp"),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			Long idSupervisor = rs.getLong("idSupervisor");
			Long cliente = rs.getLong("cliente");
			Empleado empleado = new Empleado(nombreEmp, telefonoEmp, subordinadosEmp, fechaIngresoEmp, idSupervisor, cliente);
			empleado.setIdEmpleado(rs.getLong("idEmpleado"));
			
			return empleado;
	}

	@Override
	public Empleado get(Long id) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Empleado e = null;
		try {
			preparedStatement = getConnection().prepareStatement(GETONE);
			preparedStatement.setLong(1, id);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				e = convertir(rs);
			}else {
				throw new DaoException("No se ha encontrado ese registro");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error en SQL", ex);
			
		} finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				}catch(SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
		}
		return e;
		
	}

	@Override
	public List<Empleado> getAll() throws DaoException{
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Empleado> empleados = new ArrayList<>();
		try {
			preparedStatement = getConnection().prepareStatement(GETALL);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				empleados.add(convertir(rs));
			}
			
		} catch (SQLException ex) {
			throw new DaoException("Error en SQL", ex);
			
		} finally {
			if(rs != null) {
				try {
					rs.close();				// cerramos el ResultSet
				}catch (SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();  //cerramos el PreparedStatement
				}catch(SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
		}
		return empleados;
		
	}
 
	@Override
	public void save(Empleado t) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = getConnection().prepareStatement(INSERT);
			
			preparedStatement.setString(1, t.getNombreEmp());
			preparedStatement.setString(2, t.getTelefonoEmp());
			preparedStatement.setString(3, t.getSubordinadosEmp());
			preparedStatement.setString(4, t.getFechaIngresoEmp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			preparedStatement.setLong(5, t.getIdSupervisor());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que no se haya guardado el empleado");
			}
			
			rs = preparedStatement.getGeneratedKeys(); // este ResultSet almacena las claves que se han generado
			if(rs.next()) {
				t.setIdEmpleado(rs.getLong(1));  // se extrae el ID
			}else {
				throw new DaoException("No se puede asignar ID a este empleado");
			}
		
		}catch(SQLException ex) {
			throw new DaoException("Error en SQL", ex);
		
	}finally {
		if(rs != null) {
			try {
				rs.close();				// cerramos el ResultSet
			}catch (SQLException ex) {
				new DaoException("Error en SQL", ex);
			}
		}
		if(preparedStatement != null) {
			try {
				preparedStatement.close(); //cerramos el PreparedStatement
				
			} catch (SQLException ex) {
				throw new DaoException("Error en SQL", ex);
			}
			
		}
		}
		
	}

	@Override
	public void update(Empleado t) throws DaoException{
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(UPDATE);
			
			preparedStatement.setString(1, t.getNombreEmp());
			preparedStatement.setString(2, t.getTelefonoEmp());
			preparedStatement.setString(3, t.getSubordinadosEmp());
			preparedStatement.setString(4, t.getFechaIngresoEmp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			preparedStatement.setLong(5, t.getIdSupervisor());
			preparedStatement.setLong(6, t.getIdEmpleado());
						
			if(preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que los datos no se hayan actualizado ");
				
			}
		}catch(SQLException ex) {
			throw new DaoException("Error de SQL", ex);
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				}catch (SQLException ex) {
					throw new DaoException("Error de SQL", ex);
				}
			}
		}
		
		
	}

	@Override
	public void delete(Empleado t) throws DaoException {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = getConnection().prepareStatement(DELETE);
			preparedStatement.setLong(1, t.getIdEmpleado());
			if(preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que el Empleado no se haya Eliminado");
			}
		}catch(SQLException ex) {
			throw new DaoException("Error de SQL", ex);
		}finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				}catch(SQLException ex) {
					throw new DaoException("Error de SQL", ex);
				}
			}
		}
		
	}

}
