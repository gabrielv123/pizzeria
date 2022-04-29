package Coneccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArrayListComplejosMenuBD {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		ArrayList<complejo> lista = new ArrayList<>();

		int opcion;

		// conexion("jdbc:mysql://localhost/bdcomplejos", "root", "");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdcomplejos", "root", "");

		System.out.println("Conexión Correcta.");

		Statement st = conexion.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM complejos;");

		if (rs.first()) {

			rs.beforeFirst();

			while (rs.next()) {
				System.out
						.println("real: " + rs.getObject("partereal") + ", imaginaria: " + rs.getObject("imaginaria"));

				complejo complejo = new complejo();

				complejo.setImaginario((double) rs.getObject("imaginaria"));

				complejo.setReal((double) rs.getObject("partereal"));

				lista.add(complejo);

			}
		}

		else {

			System.out.println("La tabla no tiene Registros");
		}

		do {

			System.out.println("1: pedir un numero ");
			System.out.println("2: buscar el numero ");
			System.out.println("3: borrar numero ");
			System.out.println("4: Listar numero ");
			System.out.println("5: salir ");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:

				teclado.nextLine();

				complejo nuevo = new complejo();
				nuevo.leer(teclado);

				if (lista.contains(nuevo)) {
					System.out.println("error, el complejo ya esta añadida");
				}

				else {

					

					lista.add(nuevo);

					Collections.sort(lista, new Comparator<complejo>() {

						@Override
						public int compare(complejo c1, complejo c2) {

							int comparacion;

							Double i1 = c1.getImaginario();
							Double i2 = c2.getImaginario();

							comparacion = i1.compareTo(i2);

							if (comparacion == 0) {
								Double r1 = c1.getReal();
								Double r2 = c2.getReal();

								comparacion = r1.compareTo(r2);
							}
							return comparacion;
						}
					});

				}

				System.out.println("complejo añadido");

				break;

			case 2:

				teclado.nextLine();

				complejo buscar = new complejo();
				buscar.leer(teclado);

				if (lista.contains(buscar)) {

					int posicion = 0;
					posicion = lista.indexOf(buscar);

					System.out.println("el complejo se encuentra en la posicion " + posicion);

				}

				else {

					System.out.println("error, no se encuentra el numero");
				}

				break;

			case 3:

				teclado.nextLine();

				complejo borrar = new complejo();
				borrar.leer(teclado);

				if (lista.contains(borrar)) {

					int posicion = 0;
					posicion = lista.indexOf(borrar);

					lista.remove(posicion);

					Collections.sort(lista);

					System.out.println("se ha borrado el complejo ");
				}

				else {

					System.out.println("error, no encontrado ");

				}

				break;

			case 4:

				Collections.sort(lista, Collections.reverseOrder());
				System.out.println(lista);
				break;

			case 5:
				
				st.executeUpdate("DELETE FROM complejos");
				
				for (int i = 0 ; i < lista.size(); i++) {
					
					complejo crear = new complejo();
					
					crear = lista.get(i);
					
					st.executeUpdate("INSERT INTO complejos VALUES (" + crear.getReal() + "," + crear.getImaginario() + ");");
					
				}

				System.out.println("adios, no me hables mas");
				System.exit(0);
				break;

			default:

				break;
			}

		} while (opcion != 5);

		teclado.close();

	}

}
