package Coneccion;

import java.io.Serializable;
import java.util.Scanner;

public class Alumno extends Persona implements  Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2199360568091254310L;
	private String grupo;

	// constructor por defecto
	public Alumno() {

		super();
		this.grupo = "1aw3";
	}

	// constructor copia
	public Alumno(Persona p) {

		super(p);
		this.grupo = "1aw3";
	}

	// personalizado
	public Alumno(Persona p, String g) {

		super(p);
		this.grupo = g;

	}

	// personalizado copia
	public Alumno(String d, String n, String a, fecha f, String g) {

		super(d, n, a, f);
		this.grupo = g;

	}

	// to string
	@Override
	public String toString() {
		return super.toString() + " grupo: " + grupo;
	}

	// getter and setter
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	// equals
	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Alumno other = (Alumno) obj;

		return (this.getDni().equals(other.getDni()));

	}

	// compare to
	public int CompareTo(Alumno other) {

		return (this.grupo.compareTo(other.grupo));

	}

	// leer

	public void leer(Scanner teclado) {

		
		
		super.leer(teclado);
		
		System.out.println("dime un grupo ");
		this.grupo = teclado.nextLine();
		
		
	}

}
