package logicaAccesoADatos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logicaDeNegocios.Curso;

public class conexion {

	private static final String SQL_SERIALIZE_OBJECTUsuario = "INSERT INTO usuario(name, object_value) VALUES (?, ?)";
	private static final String SQL_DESERIALIZE_OBJECTUsuario = "SELECT object_value FROM usuario WHERE name = ?";

	private static final String SQL_SERIALIZE_OBJECTCurso = "INSERT INTO curso(name, object_value) VALUES (?, ?)";
	private static final String SQL_DESERIALIZE_OBJECTCurso = "SELECT object_value FROM curso WHERE name = ?";
	private static final String SQL_DELETE_OBJECTCursos = "DELETE FROM curso WHERE name=?";

	private static final String SQL_DESERIALIZE_OBJECTCursos = "SELECT name FROM curso";

	private static final String SQL_CLOSE_CONNECTION = "select concat('KILL ',id,';') from information_schema.processlist where user='b63d126d987374';";

	public Connection conexionDB() throws ClassNotFoundException, SQLException {
		Connection connection = null;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_df5e3357b4ef02b";
		String username = "b63d126d987374";
		String password = "5dc317b4";
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}

	public ArrayList<String> obtenerIdCursos(Connection connection) {

		ArrayList<String> cursosId = new ArrayList<String>();
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_DESERIALIZE_OBJECTCursos);
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
				cursosId.add(name);
			}
			rs.close();
			connection.close();
			return cursosId;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cursosId;

	}
	
	public void actualizarCurso(Connection connection,Curso curso){
		eliminarCurso(connection,curso.getId());
		try {
			serializeJavaObjectToDBCurso(connection,curso.getId(),curso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void eliminarCurso(Connection connection,String curso) {
		cerrarConexiones(connection);
		try {
			PreparedStatement ejecucionQuery = connection.prepareStatement(SQL_DELETE_OBJECTCursos);
			ejecucionQuery.setString(1, curso);
			ejecucionQuery.execute();
			
			ejecucionQuery.close();
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	@SuppressWarnings("unused")
	public static void serializeJavaObjectToDB(Connection connection, String id, Object objetoGuardar)
			throws SQLException {
		cerrarConexiones(connection);
		// just setting the class name
		PreparedStatement ejecucionQuery = connection.prepareStatement(SQL_SERIALIZE_OBJECTUsuario);

		// just setting the class name
		ejecucionQuery.setString(1, id);
		ejecucionQuery.setObject(2, objetoGuardar);
		ejecucionQuery.executeUpdate();
		ResultSet resultadoQuery = ejecucionQuery.getGeneratedKeys();
		int serialized_id = -1;
		if (resultadoQuery.next()) {
			serialized_id = resultadoQuery.getInt(1);
		}
		resultadoQuery.close();
		ejecucionQuery.close();
		connection.close();

	}

	/**
	 * To de-serialize a java object from database
	 *
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerializeJavaObjectFromDB(Connection connection, String serialized_id) {
		try {
			cerrarConexiones(connection);
			PreparedStatement ejecucionQuery = connection.prepareStatement(SQL_DESERIALIZE_OBJECTUsuario);
			ejecucionQuery.setString(1, serialized_id);
			ResultSet resultadoQuery = ejecucionQuery.executeQuery();
			resultadoQuery.next();

			byte[] buf = resultadoQuery.getBytes(1);
			ObjectInputStream objectIn = null;
			if (buf != null)
				objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
			Object deSerializedObject = objectIn.readObject();

			resultadoQuery.close();
			ejecucionQuery.close();
			connection.close();
			cerrarConexiones(connection);

			return deSerializedObject;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	// *******************************************************************************
	// CURSOS

	@SuppressWarnings("unused")
	public static void serializeJavaObjectToDBCurso(Connection connection, String id, Object objetoGuardar)
			throws SQLException {

		// just setting the class name
		PreparedStatement ejecucionQuery = connection.prepareStatement(SQL_SERIALIZE_OBJECTCurso);
		cerrarConexiones(connection);
		// just setting the class name
		ejecucionQuery.setString(1, id);
		ejecucionQuery.setObject(2, objetoGuardar);
		ejecucionQuery.executeUpdate();
		ResultSet resultadoQuery = ejecucionQuery.getGeneratedKeys();
		int serialized_id = -1;
		if (resultadoQuery.next()) {
			serialized_id = resultadoQuery.getInt(1);
		}
		resultadoQuery.close();
		ejecucionQuery.close();
		connection.close();

	}

	/**
	 * To de-serialize a java object from database
	 *
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerializeJavaObjectFromDBCurso(Connection connection, String serialized_id) {
		try {
			cerrarConexiones(connection);
			PreparedStatement ejecucionQuery = connection.prepareStatement(SQL_DESERIALIZE_OBJECTCurso);
			ejecucionQuery.setString(1, serialized_id);
			ResultSet resultadoQuery = ejecucionQuery.executeQuery();
			resultadoQuery.next();

			byte[] buf = resultadoQuery.getBytes(1);
			ObjectInputStream objectIn = null;
			if (buf != null)
				objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
			Object deSerializedObject = objectIn.readObject();

			resultadoQuery.close();
			ejecucionQuery.close();
			connection.close();
			return deSerializedObject;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public static void cerrarConexiones(Connection connection) {

		PreparedStatement ejecucionQuery;
		try {
			ejecucionQuery = connection.prepareStatement(SQL_CLOSE_CONNECTION);
			ejecucionQuery.executeQuery();
			ejecucionQuery.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
