package Coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base_Datos {

	public static Connection conexion;

	public static void conexion(String url, String usuario, String contraseña) {

		try {
			
			conexion = DriverManager.getConnection(url, usuario, contraseña);
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");
			// cierro la conexion

		}

		catch (SQLException e) {
			// si NO se ha conectado correctamente
			e.printStackTrace();
			System.out.println("Error de Conexión");

		}
	}

	public void cerrarconexion() {

		try {
			conexion.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void select(String Consulta) throws SQLException {

		Statement st = conexion.createStatement();

		ResultSet rs = st.executeQuery(Consulta);

		if (rs.first()) {
			
			rs.beforeFirst();
		}

		else {
		
			System.out.println("La tabla no tiene Registros");
		}

	}

}
