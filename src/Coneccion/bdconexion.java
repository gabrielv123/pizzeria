package Coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bdconexion {

	public static void main(String[] args) {

		conexion("jdbc:mysql://localhost/bdalumnos", "root", "");

	}

	public static void conexion(String url, String usuario, String contraseña) {

		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");
			// cierro la conexion

			Statement st = conexion.createStatement();
			
			//st.executeUpdate("DELETE FROM bdalumnos.alumnos WHERE dni='11111111A';");
			st.executeUpdate("UPDATE bdalumnos.alumnos SET grupo='1DW3' WHERE dni='11111111A';");
			//st.executeUpdate("INSERT INTO bdalumnos.alumnos VALUES ('99999999A','N9','A9','2AS3;'");

			ResultSet rs = st.executeQuery("SELECT * FROM alumnos;");
			
			// compruebo si hay registros
			if (rs.first()) {
				// si hay registros vuelvo al primero
				rs.beforeFirst();
				
				// recorro registro a registro el ResultSet
				while (rs.next()) {
					System.out.println("DNI: " + rs.getObject("dni") + ", nombre: " + rs.getObject("nombre")
							+ ", Apellidos: " + rs.getObject("apellidos") + ", Grupo: " + rs.getObject("grupo"));
				}
			} 
			
			else {
				// si no hay registros
				System.out.println("La tabla no tiene Registros");
			}
			rs.close();
			conexion.close();
		}

		catch (SQLException e) {
			// si NO se ha conectado correctamente
			e.printStackTrace();
			System.out.println("Error de Conexión");

		}
	}
}
