package pizzeria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Coneccion.complejo;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		ArrayList<cliente> base_clientes = new ArrayList<cliente>();
		ArrayList<pedidos> base_pedidos = new ArrayList<pedidos>();
		ArrayList<pizza> base_pizza = new ArrayList<pizza>();

		cliente clientes = new cliente();
		pedidos pedidos = new pedidos();
		pizza pizzas = new pizza();
		
		boolean cambios_clientes = false;
		boolean cambios_pizza = false;
		boolean cambios_pedidos = false;

		int opcion = 0;

		conexion(base_clientes, base_pedidos, base_pizza);

		do {

			System.out.println("---------------------MENU PIZZA-------------------");
			System.out.println("OPCION 0 : SALIR");
			System.out.println("OPCION 1 : VIZUALIZAR PIZZA");
			System.out.println("OPCION 2 : VIZUALIZAR CLIENTES");
			System.out.println("OPCION 3 : VIZUALIZAR PEDIDOS");
			System.out.println("OPCION 4 : ANADIR UNA PIZZA");
			System.out.println("OPCION 5 : ANADIR UN USUARIO");
			System.out.println("OPCION 6 : ANADIR UN PEDIDO");
			System.out.println("---------------------------------------------------");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:

				pizzas.visualizar(base_pizza);

				break;

			case 2:

				clientes.visualizar(base_clientes);

				break;

			case 3:

				pedidos.visualizar(base_pedidos);

				break;

			case 4:

				pizza meter_pizzas = new pizza();
				cambios_pizza = meter_pizzas.leer(teclado, meter_pizzas, base_pizza, cambios_pizza);

				break;

			case 5:

				cliente meter_cliente = new cliente();
				cambios_clientes = meter_cliente.leer(teclado, base_clientes, meter_cliente, cambios_clientes);

				break;

			case 6:

				pedidos meter_pedido = new pedidos();
				cambios_pedidos = meter_pedido.leer(teclado, base_pedidos, meter_pedido, cambios_pedidos);
		
				break;

			case 0:

				if (cambios_pedidos || cambios_clientes || cambios_pizza) {

					insertar(base_clientes, base_pedidos, base_pizza, cambios_pizza, cambios_pedidos, cambios_clientes);

				}
				
				else {
					
					System.out.println("no hay cambios");
					
				}

				break;

			}

		} while (opcion != 0);

	}

	public static void conexion(ArrayList<cliente> base_clientes, ArrayList<pedidos> base_pedidos,ArrayList<pizza> base_pizza) throws SQLException {

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/pizzeria", "root", "");

		System.out.println("Conexión Correcta.");

		Statement pizzas = conexion.createStatement();
		Statement clientes = conexion.createStatement();
		Statement pedidos = conexion.createStatement();

		ResultSet pizz = pizzas.executeQuery("SELECT * FROM pizzak;");
		ResultSet clien = clientes.executeQuery("SELECT * FROM erabiltzaileak;");
		ResultSet pedid = pedidos.executeQuery("SELECT * FROM eskaerak;");

		if (clien.first()) {
			clien.beforeFirst();

			while (clien.next()) {

				cliente insertar_clientes = new cliente();

				insertar_clientes.setId((int) clien.getObject("id"));
				insertar_clientes.setNombre((String) clien.getObject("izena"));
				insertar_clientes.setApellido((String) clien.getObject("abizena"));

				base_clientes.add(insertar_clientes);

			}
		}

		if (pizz.first()) {
			pizz.beforeFirst();

			while (pizz.next()) {

				pizza insertar_pizza = new pizza();

				insertar_pizza.setId((int) pizz.getObject("id"));
				insertar_pizza.setNombre((String) pizz.getObject("izena"));
				insertar_pizza.setIngredientes((String) pizz.getObject("osagaiak"));
				insertar_pizza.setPrecio((int) pizz.getObject("prezioa"));

				base_pizza.add(insertar_pizza);

			}
		}

		if (pedid.first()) {
			pedid.beforeFirst();

			while (pedid.next()) {

				pedidos insertar_pedidos = new pedidos();

				insertar_pedidos.setId_pizza((int) pedid.getObject("idpizza"));
				insertar_pedidos.setId_cliente((int) pedid.getObject("iderabiltzailea"));
				insertar_pedidos.setId_pedido((int) pedid.getObject("ideskaera"));
				insertar_pedidos.setCantidad((int) pedid.getObject("kopurua"));

				base_pedidos.add(insertar_pedidos);

			}
		}

		pizzas.close();
		clientes.close();
		pedidos.close();
		conexion.close();

	}

	public static void insertar(ArrayList<cliente> base_clientes, ArrayList<pedidos> base_pedidos,ArrayList<pizza> base_pizza ,boolean pizza , boolean pedido , boolean cliente) throws SQLException {

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/pizzeria", "root", "");

		System.out.println("Conexión Correcta.");
		
		if (cliente) {
			
			Statement clientes = conexion.createStatement();
			clientes.executeUpdate("DELETE FROM erabiltzaileak");
			
			for (int i = 0; i < base_clientes.size(); i++) {
	
				cliente insertar_clientes = new cliente();
	
				insertar_clientes = base_clientes.get(i);
	
				clientes.executeUpdate("INSERT INTO erabiltzaileak VALUES ('" + insertar_clientes.getId() + "','"+ insertar_clientes.getNombre() + "','" + insertar_clientes.getApellido() + "');");

			}
		}
		
		if (pizza) {
			
			Statement pizzas = conexion.createStatement();
			pizzas.executeUpdate("DELETE FROM pizzak");
	
			for (int i = 0; i < base_pizza.size(); i++) {
	
				pizza insertar_pizza = new pizza();
	
				insertar_pizza = base_pizza.get(i);
	
				pizzas.executeUpdate("INSERT INTO pizzak VALUES ('" + insertar_pizza.getId() + "','" + insertar_pizza.getNombre() + "','"+ insertar_pizza.getIngredientes() + "','" + insertar_pizza.getPrecio() + "');");
				
			}
		}
		
		
		if (pedido) {	
		
			Statement pedidos = conexion.createStatement();
			pedidos.executeUpdate("DELETE FROM eskaerak");
			
			for (int i = 0; i < base_pedidos.size(); i++) {
	
				pedidos insertar_pedidos = new pedidos();
	
				insertar_pedidos = base_pedidos.get(i);
	
				pedidos.executeUpdate("INSERT INTO eskaerak VALUES ('" + insertar_pedidos.getId_pizza() + "','"+ insertar_pedidos.getId_cliente() + "','" + insertar_pedidos.getId_pedido() + "','"+ insertar_pedidos.getCantidad() + "');");
			}
		}

		conexion.close();

	}

}
