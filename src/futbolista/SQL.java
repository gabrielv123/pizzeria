package futbolista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {
	
	public void conexion(ArrayList<futbolista> base_futbolista , ArrayList<equipo> base_equipo) {

		Connection conexion;
		
		try {
			
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/futbol", "root", "");
	

		System.out.println("Conexión Correcta.");

		Statement futbolista = conexion.createStatement();
		Statement equipo = conexion.createStatement();
		
	

		ResultSet fut = futbolista.executeQuery("SELECT * FROM futbolista;");
		ResultSet equi = equipo.executeQuery("SELECT * FROM equipos;");
		
		
	
		if (fut.first()) {
			fut.beforeFirst();

			while (fut.next()) {

				futbolista futbol = new futbolista();

				futbol.setIdfubtolista((int) fut.getObject("dni"));
				futbol.setNombre((String) fut.getObject("nombre"));
				futbol.setApellido((String) fut.getObject("apellido"));
				futbol.setSalario((int) fut.getObject("salario"));
				futbol.setIdequipo((int) fut.getObject("idequipo"));

				base_futbolista.add(futbol);

			}
		}


		if (equi.first()) {
			equi.beforeFirst();

			while (equi.next()) {

				equipo eq = new equipo();

				eq.setNombre((String) equi.getObject("idequipo"));
				eq.setIdequipo((int) equi.getObject("nombre"));
				eq.setCiudad((String) equi.getObject("ciudad"));

				base_equipo.add(eq);

			}
		}

		futbolista.close();
		equipo.close();
		conexion.close();
		
		} catch (SQLException e) {
			System.out.println("error en la conexion " + e.getMessage());
		}


	}

	public void insertar(ArrayList<futbolista> base_futbolista , ArrayList<equipo> base_equipo ,boolean futbol , boolean equipo) {
		
		Connection conexion;
		
		try {

		conexion = DriverManager.getConnection("jdbc:mysql://localhost/futbol", "root", "");

		System.out.println("Conexión Correcta.");
		
		if (equipo) {
			
			Statement futbolista = conexion.createStatement();
			futbolista.executeUpdate("DELETE FROM equipos");
			
			for (int i = 0; i < base_equipo.size(); i++) {
	
				equipo insertar_equipo = new equipo();
	
				insertar_equipo = base_equipo.get(i);
	
				futbolista.executeUpdate("INSERT INTO erabiltzaileak VALUES ('" + insertar_equipo.getIdequipo() + "','"+ insertar_equipo.getNombre() + "','" + insertar_equipo.getCiudad() + "');");

			}
		}
		
		if (futbol) {
			
			Statement pizzas = conexion.createStatement();
			pizzas.executeUpdate("DELETE FROM pizzak");
	
			for (int i = 0; i < base_futbolista.size(); i++) {
	
				futbolista insertar_futbolista = new futbolista();
	
				insertar_futbolista = base_futbolista.get(i);
	
				pizzas.executeUpdate("INSERT INTO pizzak VALUES ('" + insertar_futbolista.getIdfubtolista() + "','" + insertar_futbolista.getNombre() + "','"+ insertar_futbolista.getApellido() + "','" + insertar_futbolista.getSalario() + "'" + insertar_futbolista.getIdequipo() + "');");
				
			}
		}

		conexion.close();
		
		} catch (SQLException e) {
			System.out.println("error en la inserccion " + e.getMessage());
		}

	}

}
