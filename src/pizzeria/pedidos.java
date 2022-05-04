package pizzeria;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class pedidos {

	private int id_pizza;
	private int id_cliente;
	private int id_pedido;
	private int cantidad;

	public pedidos() {

		this.id_pizza = 0;
		this.id_cliente = 0;
		this.id_pedido = 0;
		this.cantidad = 0;

	}

	public pedidos(pedidos p) {

		this.id_pizza = p.id_pizza;
		this.id_cliente = p.id_cliente;
		this.id_pedido = p.id_pedido;
		this.cantidad = p.cantidad;

	}

	public pedidos(int pizza, int cliente, int pedido, int cantidad) {

		this.id_pizza = pizza;
		this.id_cliente = cliente;
		this.id_pedido = pedido;
		this.cantidad = cantidad;

	}

	public boolean leer(Scanner teclado, ArrayList<pedidos> base_pedidos, pedidos meter_pedido, boolean cambios) {

		teclado.nextLine();
		System.out.println("dime la id del pizza ");
		this.id_pizza = teclado.nextInt();

		teclado.nextLine();
		System.out.println("dime la id del cliente ");
		this.id_cliente = teclado.nextInt();

		teclado.nextLine();
		System.out.println("dime la id del pedido ");
		this.id_pedido = teclado.nextInt();

		teclado.nextLine();
		System.out.println("dime la cantidad ");
		this.cantidad = teclado.nextInt();

		if (!base_pedidos.contains(meter_pedido)) {

			base_pedidos.add(meter_pedido);

			cambios = true;
			System.out.println("pedido introducido correctamente");

		}

		else {

			cambios = false;
			System.out.println("el id de el pedido ya esta puesta");

		}
		
		return cambios;
	}

	public void visualizar(ArrayList<pedidos> lista) {

		for (pedidos arti : lista) {

			System.out.println(arti);
		}

	}

	@Override
	public String toString() {
		return "pedidos [id_pizza=" + id_pizza + ", id_cliente=" + id_cliente + ", id_pedido=" + id_pedido
				+ ", cantidad=" + cantidad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pedido, id_pizza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pedidos other = (pedidos) obj;
		return id_pedido == other.id_pedido && id_pizza == other.id_pizza;
	}

	public int getId_pizza() {
		return id_pizza;
	}

	public void setId_pizza(int id_pizza) {
		this.id_pizza = id_pizza;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
