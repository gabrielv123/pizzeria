package pizzeria;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		ArrayList<cliente> base_clientes = new ArrayList<cliente>();
		ArrayList<pedidos> base_pedidos = new ArrayList<pedidos>();
		ArrayList<pizza> base_pizza = new ArrayList<pizza>();

		cliente clientes = new cliente();
		pedidos pedidos = new pedidos();
		pizza pizzas = new pizza();

		int opcion = 0;

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
				
				cliente meter = new cliente();
				
				meter.leer(teclado);

				break;

			case 5:

				break;

			case 6:

				break;

			}

		} while (opcion != 0);

	}

}
