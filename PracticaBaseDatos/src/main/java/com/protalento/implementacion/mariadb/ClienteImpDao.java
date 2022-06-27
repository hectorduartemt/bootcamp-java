package com.protalento.implementacion.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.protalento.Model.Cliente;
import com.protalento.interfaces.ClienteDAO;
import com.protalento.interfaces.DaoException;
import com.protalento.interfaces.DatabaseConnection;

public class ClienteImpDao implements ClienteDAO, DatabaseConnection{
	
	final String GETONE = "SELECT idCliente, nombreCli, direccionCli, ciudadCli, producto FROM clientes WHERE idCliente = ?";
	final String GETALL = "SELECT idCliente, nombreCli, direccionCli, ciudadCli, producto FROM clientes";
	final String INSERT = "INSERT INTO clientes(nombreCli, direccionCli, ciudadCli) VALUES (?, ?, ?)";
	final String UPDATE = "UPDATE clientes SET nombreCli = ?, direccionCli = ?, ciudadCli = ? WHERE idCliente = ?";
	final String DELETE = "DELETE FROM clientes WHERE idCliente = ?";
	
	
	private Cliente convertir(ResultSet rs) throws SQLException {  //utilizamos el convertir y el ResulSet por los metodos que nos permiten obtener byte a partir de un numero, un long, int, lo que sea.
																	//Se debe convertir en un objeto. debemos identificar los datos que queremos extraer
			String nombreCli = rs.getString("nombreCli");
			String direccionCli =rs.getString("direccionCli");
			String ciudadCli = rs.getString("ciudadCli");
			Long producto = rs.getLong("producto");
			Cliente cliente = new Cliente(nombreCli, direccionCli,ciudadCli,producto);
			cliente.setIdCliente(rs.getLong("idClient"));
			
			return cliente;
	}

	@Override
	public Cliente get(Long id) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Cliente c = null;
		try {
			preparedStatement = getConnection().prepareStatement(GETONE);
			preparedStatement.setLong(1, id);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				c = convertir(rs);
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
		return c;
	}

	@Override
	public List<Cliente> getAll() throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Cliente> cliente = new ArrayList<>();
		try {
			preparedStatement = getConnection().prepareStatement(GETALL);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				cliente.add(convertir(rs));
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
		return cliente;
	}

	@Override
	public void save(Cliente t) throws DaoException{
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = getConnection().prepareStatement(INSERT);
			
			preparedStatement.setString(1, t.getNombreCli());
			preparedStatement.setString(2, t.getDireccionCli());
			preparedStatement.setString(3, t.getCiudadCli());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que no se haya guardado el Cliente");
			}
			
			rs = preparedStatement.getGeneratedKeys(); // este ResultSet almacena las claves que se han generado
			if(rs.next()) {
				t.setIdCliente(rs.getLong(1));  // se extrae el ID
			}else {
				throw new DaoException("No se puede asignar ID a este cliente");
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
				preparedStatement.close();
				
			} catch (SQLException ex) {
				throw new DaoException("Error en SQL", ex);
			}
			
		}
		}
		
	}

	@Override
	public void update(Cliente t) throws DaoException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(UPDATE);
			preparedStatement.setString(1, t.getNombreCli());
			preparedStatement.setString(2, t.getDireccionCli());
			preparedStatement.setString(3, t.getCiudadCli());
			preparedStatement.setLong(4, t.getIdCliente());
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
	public void delete(Cliente t) throws DaoException{
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(DELETE);
			preparedStatement.setLong(1, t.getIdCliente());
			if(preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que el Cliente no se haya Eliminado");
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
