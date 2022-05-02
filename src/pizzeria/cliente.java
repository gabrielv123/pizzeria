package pizzeria;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Coneccion.Alumno;

public class cliente {

	private int id;
	private String nombre;
	private String apellido;

	public cliente() {

		this.id = 0;
		this.nombre = "";
		this.apellido = "";

	}

	public cliente(cliente c) {

		this.id = c.id;
		this.nombre = c.nombre;
		this.apellido = c.nombre;

	}

	public cliente(int id, String nombre, String apellido) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;

	}

	public void leer(Scanner teclado, ArrayList<cliente> base_clientes, cliente meter_cliente, boolean cambios) {

		System.out.println("dime el dni ");
		this.id = teclado.nextInt();

		teclado.nextLine();
		System.out.println("dime el nombre ");
		this.nombre = teclado.nextLine();

		System.out.println("dime el apellido ");
		this.apellido = teclado.nextLine();

		if (!base_clientes.contains(meter_cliente)) {

			base_clientes.add(meter_cliente);

			cambios = true;
			System.out.println("cliente introducida correctamente");

		}

		else {

			cambios = false;
			System.out.println("el id de el cliente ya esta puesta");

		}

	}

	public void visualizar(ArrayList<cliente> listar) {

		for (cliente clie : listar) {
			System.out.println(clie);
		}
	}

	@Override
	public String toString() {
		return "cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
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
		cliente other = (cliente) obj;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
