package pizzeria;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class pizza {

	private int id;
	private String nombre;
	private String ingredientes;
	private int precio;

	public pizza() {

		this.id = 0;
		this.nombre = "";
		this.ingredientes = "";
		this.precio = 0;

	}

	public pizza(pizza p) {

		this.id = p.id;
		this.nombre = p.nombre;
		this.ingredientes = p.ingredientes;
		this.precio = p.precio;

	}

	public pizza(int id, String nombre, String ingredientes, int precio) {

		this.id = id;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.precio = precio;
	}

	public boolean leer(Scanner teclado, pizza meter_pizzas, ArrayList<pizza> base_pizza, boolean cambios) {

		System.out.println("dime la id de la pizza ");
		this.id = teclado.nextInt();

		teclado.nextLine();
		System.out.println("dime el nombre de la pizza ");
		this.nombre = teclado.nextLine();

		System.out.println("dime el ingredientes ");
		this.ingredientes = teclado.nextLine();

		System.out.println("dime el precio de la pizza");
		this.precio = teclado.nextInt();

		if (!base_pizza.contains(meter_pizzas)) {

			base_pizza.add(meter_pizzas);
			
			if (base_pizza.size() > 0) {
				
				meter_pizzas.setId(base_pizza.get(base_pizza.size() -1).getId() +1);
				
			}

			cambios = true;

			System.out.println("pizza introducida correctamente");

		}

		else {

			System.out.println("el id de la pizza ya esta puesta");

		}
		
		return cambios;

	}

	public void visualizar(ArrayList<pizza> lista) {

		for (pizza arti : lista) {
			System.out.println(arti);
		}

	}

	@Override
	public String toString() {
		return "pizza [id=" + id + ", nombre=" + nombre + ", ingredientes=" + ingredientes + ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pizza other = (pizza) obj;
		return id == other.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
