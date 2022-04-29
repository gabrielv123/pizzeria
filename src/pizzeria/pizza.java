package pizzeria;

import java.util.ArrayList;
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

	public void leer(Scanner teclado) {

		System.out.println("dime la id de la pizza ");
		this.id = teclado.nextInt();

		System.out.println("dime el nombre de la pizza ");
		this.nombre = teclado.nextLine();

		System.out.println("dime el ingredientes ");
		this.ingredientes = teclado.nextLine();

		System.out.println("dime el precio de la pizza");
		this.precio = teclado.nextInt();

	}
	
	public void visualizar(ArrayList<pizza> lista) {

		for (pizza arti : lista) {

			System.out.println(arti);
		}

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
