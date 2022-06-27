package com.protalento.implementacion.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.protalento.Model.Producto;
import com.protalento.interfaces.DaoException;
import com.protalento.interfaces.DatabaseConnection;
import com.protalento.interfaces.ProductoDAO;

public class ProductoImpDao implements ProductoDAO, DatabaseConnection {

	final String GETONE = "SELECT idProducto, numProducto, tipoProducto, cliente FROM productos WHERE idProducto = ?";
	final String GETALL = "SELECT idProducto, numProducto, tipoProducto, cliente FROM productos";
	final String INSERT = "INSERT INTO productos(numProducto, tipoProducto) VALUES (?, ?)";
	final String UPDATE = "UPDATE productos SET numProducto = ?, tipoProducto = ? WHERE idProducto = ?";
	final String DELETE = "DELETE FROM productos WHERE idProducto = ?";

	private Producto convertir(ResultSet rs) throws SQLException { // utilizamos el convertir y el ResulSet por los
																	// metodos que nos permiten obtener byte a partir de
																	// un numero, un long, int, lo que sea.
																	// Se debe convertir en un objeto. debemos
																	// identificar los datos que queremos extraer
		String numProducto = rs.getString("numProducto");
		String tipoProducto = rs.getString("tipoProducto");
		Long cliente = rs.getLong("cliente");
		Producto producto = new Producto(numProducto, tipoProducto, cliente);
		producto.setIdProducto(rs.getLong("idProducto"));

		return producto;
	}

	@Override
	public Producto get(Long id) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Producto p = null;
		try {
			preparedStatement = getConnection().prepareStatement(GETONE);
			preparedStatement.setLong(1, id);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				p = convertir(rs);
			} else {
				throw new DaoException("No se ha encontrado ese registro");
			}
		} catch (SQLException ex) {
			throw new DaoException("Error en SQL", ex);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
		}
		return p;
	}

	@Override
	public List<Producto> getAll() throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Producto> producto = new ArrayList<>();
		try {
			preparedStatement = getConnection().prepareStatement(GETALL);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				producto.add(convertir(rs));
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
					preparedStatement.close(); // cerramos el PreparedStatement
				} catch (SQLException ex) {
					new DaoException("Error en SQL", ex);
				}
			}
		}
		return producto;

	}

	@Override
	public void save(Producto t) throws DaoException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = getConnection().prepareStatement(INSERT);

			preparedStatement.setString(1, t.getNumProducto());
			preparedStatement.setString(2, t.getTipoProducto());
			
			if (preparedStatement.executeUpdate() == 0) {
				throw new DaoException("Puede que no se haya guardado el producto");
			}

			rs = preparedStatement.getGeneratedKeys(); // este ResultSet almacena las claves que se han generado
			if (rs.next()) {
				t.setIdProducto(rs.getLong(1)); // se extrae el ID
			} else {
				throw new DaoException("No se puede asignar ID a este cliente");
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
	public void update(Producto t) throws DaoException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(UPDATE);
			preparedStatement.setString(1, t.getNumProducto());
			preparedStatement.setString(2, t.getTipoProducto());
			preparedStatement.setLong(3, t.getCliente());
			preparedStatement.setLong(4, t.getIdProducto());
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
	public void delete(Producto t) throws DaoException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(DELETE);
			preparedStatement.setLong(1, t.getIdProducto());
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
