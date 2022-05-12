package futbolista;

import java.util.ArrayList;
import java.util.Scanner;

import pizzeria.cliente;
import pizzeria.pedidos;
import pizzeria.pizza;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fubolistaserializable ficherofutbol = new fubolistaserializable();
		equiposerializable ficheroequipo = new equiposerializable();

		Scanner teclado = new Scanner(System.in);

		futbolista futbol = new futbolista();
		equipo equi = new equipo();

		ArrayList<futbolista> base_futbolista = new ArrayList<futbolista>();
		ArrayList<equipo> base_equipo = new ArrayList<equipo>();

		boolean equipo = false;
		boolean futbolista = false;

		int opcion = 0;

		ficherofutbol.lectura(futbol, base_futbolista);
		ficheroequipo.lectura(equi, base_equipo);

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

				if (equipo) {

					ficheroequipo.cargar(base_equipo.toArray(), "./memoria/equipo.dat");

				}

				if (futbolista) {

					ficherofutbol.cargar(base_futbolista.toArray(), "./memoria/futbolista.dat");

				}

				break;

			}

		} while (opcion != 0);

	}

}
