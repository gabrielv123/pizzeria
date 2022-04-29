package Coneccion;

import java.io.Serializable;
import java.util.Scanner;

public class Persona implements Comparable<Persona> , Serializable {

	// defino las variables

	private String dni;
	private String nombre;
	private String apellido;
	private fecha fecha_nacimiento;

	// constructor por defecto

	public Persona() {

		this.dni = "";
		this.nombre = "";
		this.apellido = "";
		this.fecha_nacimiento = new fecha();
	}

	// constructor copia
	public Persona(Persona f) {

		this.dni = f.dni;
		this.nombre = f.nombre;
		this.apellido = f.apellido;
		this.fecha_nacimiento = f.fecha_nacimiento;
	}

	public Persona(String dni, String nombre, String apellido) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = new fecha();
	}

	public Persona(String dni, String nombre, String apellido, fecha p) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = new fecha();
	}

	// getter and setter

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;

	}

	public fecha getFechanacimiento() {
		return fecha_nacimiento;
	}

	public void setFechanacimiento(fecha fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;

	}

	// metodo escribir

	public String toString() {
		return " dni: " +dni + " nombre: " + nombre + " apellido: " + apellido + " fecha: " + fecha_nacimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
		return result;
	}

	// metodo equals
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			// si es el mismo objeto

			return true;
		if (obj == null)

			// si el objeto es nulo (no está creado)
			return false;

		if (getClass() != obj.getClass())

			// si los objetos no son de la misma clase

			return false;
		// creo un objeto temporal de esta clase
		Persona other = (Persona) obj;

		// comparo las propiedades de los objetos this y other

		return (this.dni.equals(other.dni));

	}

	public int CompareTo(Persona other) {

		return (this.dni.compareTo(other.dni));

	}

	public void leer(Scanner teclado) {

		System.out.println("dime tu dni ");
		this.dni = teclado.nextLine();

		while (dni.equals("0")) {
			System.out.println("el valor del dni no puede ser 0");
			System.out.println("dni :");
			this.dni = teclado.nextLine();
		}

		System.out.println("dime un nombre ");
		this.nombre = teclado.nextLine();

		System.out.println("dime un apellido ");
		this.apellido = teclado.nextLine();
		
		//this.fecha_nacimiento.leer(teclado);
	}


	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return 0;
	}
}