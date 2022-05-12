package futbolista;

import java.util.ArrayList;
import java.util.Scanner;

public class mainSql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		futbolista futbol = new futbolista();
		equipo equi = new equipo();

		ArrayList<futbolista> base_futbolista = new ArrayList<futbolista>();
		ArrayList<equipo> base_equipo = new ArrayList<equipo>();

		boolean equipo = false;
		boolean futbolista = false;

		int opcion = 0;

		SQL base_datos = new SQL();

		base_datos.conexion(base_futbolista, base_equipo);

		do {

			System.out.println("---------------------MENU PIZZA-------------------");
			System.out.println("OPCION 0 : SALIR");
			System.out.println("OPCION 1 : VER FUTBOLISTA");
			System.out.println("OPCION 2 : VER EQUIPOS");
			System.out.println("OPCION 3 : AÑADIR FUTBOLISTA");
			System.out.println("OPCION 4 : AÑADIR EQUIPOS");
			System.out.println("---------------------------------------------------");

			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:

				futbol.visualizar(base_futbolista);

				break;

			case 2:

				equi.visualizar(base_equipo);

				break;

			case 3:

				base_futbolista.add(new futbolista().añadir(teclado));

				futbolista = true;

				break;

			case 4:

				base_equipo.add(new equipo().añadir(teclado));

				equipo = true;

				break;

			case 0:

				if (equipo | futbolista) {

					base_datos.insertar(base_futbolista, base_equipo, futbolista, equipo);

				}

				break;

			}

		} while (opcion != 0);

	}

}
