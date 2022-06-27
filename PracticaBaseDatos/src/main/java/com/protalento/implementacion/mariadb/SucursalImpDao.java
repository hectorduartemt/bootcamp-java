package com.protalento.implementacion.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.protalento.Model.Sucursal;
import com.protalento.interfaces.DaoException;
import com.protalento.interfaces.DatabaseConnection;
import com.protalento.interfaces.SucursalDAO;

public class SucursalImpDao implements SucursalDAO, DatabaseConnection {
	
	static final String INSERT = "INSERT INTO sucursales(nomSucursal, ciudadSuc) VALUES (?, ?)";
	static final String UPDATE = "UPDATE sucursales SET ciudadSuc = ? WHERE nomSucursal = ?";
	static final String GETONE = "SELECT idProducto, numProducto, tipoProducto, cliente FROM productos WHERE idProducto = ?";
	static final String GETALL = "SELECT nomSucursal, numProducto, empleado FROM productos";
	static final String DELETE = "DELETE FROM sucursales WHERE nomSucursales = ? AND ciudadSuc = ?";
	
	
	private Sucursal convertir(ResultSet rs) throws SQLException {  //utilizamos el convertir y el ResulSet por los metodos que nos permiten obtener byte a partir de un numero, un long, int, lo que sea.
																	//Se debe convertir en un objeto. debemos identificar los datos que queremos extraer
			String nomSucursal = rs.getString("nomSucursal");
			String ciudadSuc =rs.getString("ciudadSuc");
			Long empleado = rs.getLong("empleado");
			Sucursal sucursal = new Sucursal(nomSucursal, ciudadSuc, empleado);
			sucursal.setNombreSuc(rs.getString("nomSucursal"));
			  
			
			return sucursal;
	}


	@Override
	public Sucursal get(String id) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Sucursal s = null;
		
		try {
			preparedStatement = getConnection().prepareStatement(GETONE);
			preparedStatement.setString(1, id);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				s = convertir(rs);
			}else {
				throw new DaoException("No se ha encontrado la sucursal");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error en SQL");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					new DaoException("Error en SQL");
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
		return s;
	}


	@Override
	public List<Sucursal> getAll() throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Sucursal> sucursal = new ArrayList<>();
		try {
			preparedStatement = getConnection().prepareStatement(GETALL);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				sucursal.add(convertir(rs));
			}
		}catch (SQLException ex) {
			throw new DaoException("Error en SQL", ex);
		}finally {
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
		return sucursal;
	}


	@Override
	public void save(Sucursal t) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = getConnection().prepareStatement(DELETE);
			preparedStatement.setString(1, t.getNombreSuc());
			preparedStatement.setString(2, t.getCiudadSuc());
			
			if(preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que no se hayan registrado los cambios");
			}
			
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				t.setNombreSuc(rs.getString(1));				
			}else {
				throw new DaoException("No se puede asignar ID a esta sucursal");
			}
 		} catch (SQLException ex) {
 			throw new DaoException("Error en SQL", ex);

		} finally {
			if (rs != null) {
				try {
					rs.close(); // cerramos el ResultSet
				} catch (SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();

				} catch (SQLException ex) {
					throw new DaoException("Error en SQL", ex);
				}

			}
		}
	}


	@Override
	public void update(Sucursal t) throws DaoException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(UPDATE);
			preparedStatement.setString(1, t.getNombreSuc());
			preparedStatement.setString(2, t.getCiudadSuc());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que los datos no se hayan actualizado ");

			}
		} catch (SQLException ex) {
			throw new DaoException("Error de SQL", ex);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
					throw new DaoException("Error de SQL", ex);
				}
			}
		}
		
	}


	@Override
	public void delete(Sucursal t) throws DaoException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(DELETE);
			preparedStatement.setString(1, t.getNombreSuc());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que el Producto no se haya eliminado");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error de SQL", ex);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
					throw new DaoException("Error de SQL", ex);
				}
			}
		}
		
	}

	

}
