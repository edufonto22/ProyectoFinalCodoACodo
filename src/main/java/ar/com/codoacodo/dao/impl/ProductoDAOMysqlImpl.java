package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Producto;

public class ProductoDAOMysqlImpl implements IProductoDAO{

	@Override
	public Producto getById(Long id) throws Exception{
		
		Connection connection = AdministradorDeConexiones.getConnection();
		
		String sql = "SELECT * FROM producto WHERE id = " + id;
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		if(resultSet.next()) {
			Producto p = this.crearProducto(resultSet);
			cerrar(connection);
			return p;
		}
		
		return null;
	}

	private void cerrar(Connection connection) throws Exception {
		connection.close();
	}
	
	@Override
	public List<Producto> findAll() throws Exception {

		Connection connection = AdministradorDeConexiones.getConnection();
		
		String sql = "SELECT * FROM producto";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		List<Producto> productos = new ArrayList<Producto>();
		
		while(resultSet.next()) {
			productos.add(this.crearProducto(resultSet));
		}
		
		cerrar(connection);
		
		return productos;
		
	}

	@Override
	public void delete(Long id) throws Exception {

		Connection connection = AdministradorDeConexiones.getConnection();
		
		String sql = "DELETE FROM producto WHERE id = " + id;
		
		Statement statement = connection.createStatement();
		
		int eliminado = statement.executeUpdate(sql);
		cerrar(connection);
		System.out.println(eliminado);
		
	}

	@Override
	public void update(Producto producto) throws Exception {

		Connection connection = AdministradorDeConexiones.getConnection();
		
		String sql = "UPDATE producto SET titulo = ?, puntuacion = ?, comentario = ? WHERE id = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, producto.getTitulo());
		statement.setInt(2, producto.getPuntuacion());
		statement.setString(3, producto.getComentario());
		statement.setLong(4, producto.getId());
		
		statement.execute();
		
		cerrar(connection);
		
	}

	@Override
	public void create(Producto producto) throws Exception {

		Connection connection = AdministradorDeConexiones.getConnection();
		
		String sql = "INSERT INTO producto (tipo, titulo, fecha_alta, puntuacion, comentario) VALUES (?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, producto.getTipo());
		statement.setString(2, producto.getTitulo());
		statement.setDate(3, new java.sql.Date(producto.getFechaAlta().getTime()));
		statement.setDouble(4, producto.getPuntuacion());
		statement.setString(5, producto.getComentario());
		
		statement.execute();
		
		ResultSet res = statement.getGeneratedKeys();
		
		if(res.next()) {
			producto.setId(res.getLong(1));
		}
		
		cerrar(connection);
		
	}

	private Producto crearProducto(ResultSet resultSet) throws Exception {
		
		Long idDb = resultSet.getLong("id");
		String tipo = resultSet.getString("tipo");
		String titulo = resultSet.getString("titulo");
		Date fechaAlta = resultSet.getDate("fecha_alta");
		Integer puntuacion = resultSet.getInt("puntuacion");
		String comentario = resultSet.getString("comentario");
		
		return new Producto(idDb, tipo, titulo, fechaAlta, puntuacion, comentario);
	
	}

	@Override
	public List<Producto> search(String clave) throws Exception {
		
/*String sql = "SELECT * FROM PRODUCTO WHERE nombre LIKE '%"+clave+"%' ";
		
		Connection con = AdministradorDeConexiones.getConnection();
	
		List<Producto> listado = new ArrayList<Producto>();
		
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				String tipo = rs.getString(1);
				String titulo = rs.getString(2);
				String precio = rs.getString(3);
				String fechaAlta = rs.getString(4);
				String autor = rs.getString(5);
				
				//Producto prodFromDb = new Producto(tipo, titulo, Double.parseDouble(precio), new Date(), autor);
				
				//listado.add(prodFromDb);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listado;*/
		
		Connection connection = AdministradorDeConexiones.getConnection();
		
		String sql = "SELECT * FROM producto WHERE titulo LIKE '%"+clave+"%'";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		List<Producto> productos = new ArrayList<Producto>();
		
		while(resultSet.next()) {
			productos.add(this.crearProducto(resultSet));
		}
		
		cerrar(connection);
		
		return productos;
		
	}
	
}
