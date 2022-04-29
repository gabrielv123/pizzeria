package Coneccion;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class ArrayListAlumnosMenuBD {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		//--------------------------------------------------------------------------------declaracion del array variables y variables -----------------------------------------------------------------------------------------//		
				
				ArrayList<Alumno> base = new ArrayList<>();
				int opcion;
				boolean encontrado;
				boolean enviar = false; 
			
				
				Alumno meter = new Alumno();
				
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");

				System.out.println("Conexión Correcta.");

				Statement st = conexion.createStatement();

				ResultSet rs = st.executeQuery("SELECT * FROM alumnos;");

				if (rs.first()) {

					rs.beforeFirst();

					while (rs.next()) {

						Alumno agregar = new Alumno();

						agregar.setDni((String) rs.getObject("dni"));
						agregar.setNombre((String) rs.getObject("nombre"));
						agregar.setApellido((String) rs.getObject("apellidos"));
						agregar.setGrupo((String) rs.getObject("grupo"));

						base.add(agregar);

					}
				}

				else {

					System.out.println("La tabla no tiene Registros");
				}
				
		
				
		//--------------------------------------------------------------------------------menu-----------------------------------------------------------------------------------------//
				
				do {

					System.out.println("1 : añadir");
					System.out.println("2 : buscar");
					System.out.println("3 : borrar");
					System.out.println("4 : listar");

					opcion = teclado.nextInt();

					switch (opcion) {
					
		//--------------------------------------------------------------------------------case 1 -----------------------------------------------------------------------------------------//


					case 1:

						teclado.nextLine();
						Alumno crear = new Alumno();
						
						crear.leer(teclado);

						if (!base.contains(crear)) { // pongo la condicion para que no sea un valor repetido
							
							base.add(crear);

							Collections.sort(base);

						}

						else {

							
							System.out.println("ya esta en la cuenta ");
						}
						
						

						break;
						
		//--------------------------------------------------------------------------------case 2 -----------------------------------------------------------------------------------------//

					case 2:

						teclado.nextLine();

						

						meter.leer(teclado);

						int pos = 0;

						encontrado = false;

						for (int i = 0; i < base.size() && encontrado == false; i++) {
							if (base.contains(meter)) {
								encontrado = true;

							}

							pos = i; // inicializo esta variale para que solo muestre el mensaje de la posicion una
										// sola vez
						}

						if (encontrado) {

							System.out.println("la persona se encuentra en la posicion " + pos); // mostrar la posicion
						}

						if (!encontrado) {

							System.out.println("la persona no esta en la cuenta ");
						}

						break;
						
		//--------------------------------------------------------------------------------case 3 -----------------------------------------------------------------------------------------//

					case 3:

						teclado.nextLine();

						meter.leer(teclado); // llamo el metodo leer

						int posborrar = 0;
						encontrado = false;

						for (int i = 0; i < base.size(); i++) {
							if (base.contains(meter)) { // este if dice que si contiene exactamente todos los datos de la
															// persona
															// lo borre
								encontrado = true;

							}

							posborrar = i; // inicializo esta variale para que solo muestre el mensaje de borrar una sola
											// vez
						}

						if (encontrado) {
							base.remove(posborrar); // si lo encuentra lo borra
							//st.executeUpdate("DELETE FROM alumnos WHERE dni='" +meter.getDni()+ "' AND nombre='" +meter.getNombre()+ "'AND apellidos='" +meter.getApellidos()+ "' AND grupo='"+meter.getGrupo()+"'");
							System.out.println("la persona se ha borrado de la base ");

						}

						else {
							System.out.println("la persona no se encontro");
						}
				

						break;
						
		//--------------------------------------------------------------------------------case 4 -----------------------------------------------------------------------------------------//

					// listar

					case 4:

						teclado.nextLine();

						for (int i = 0; i < base.size(); i++) {
							System.out.println(base.get(i)); // un for que recorre el array y lo va mostrando lo que tiene
						}

						break;
						
					case 0 :
						
						enviar = true;
						
						if (enviar) {
							
							st.executeUpdate("DELETE FROM alumnos");
							
						for (int i = 0; i < base.size(); i++) {
							
							Alumno agregar1 = new Alumno();
							agregar1 = base.get(i);
							
							st.executeUpdate("INSERT INTO alumnos VALUES ('" + agregar1.getDni() + "','" + agregar1.getNombre() + "','" +agregar1.getApellidos() + "','" +agregar1.getGrupo()+ "');");
							//st.executeUpdate("DELETE FROM alumnos WHERE dni='" +agregar.getDni()+ "' AND nombre='" +agregar.getNombre()+ "'AND apellidos='" +agregar.getApellidos()+ "' AND grupo='"+agregar.getGrupo()+"'");
							
						}
						
					}
						
					}
					

				} while (opcion != 0);

			}

		

	}


