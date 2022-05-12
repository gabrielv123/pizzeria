package futbolista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idequipo;
	private String nombre;
	private String ciudad;

	public equipo() {

		this.idequipo = 0;
		this.nombre = "";
		this.ciudad = "";

	}

	public equipo(equipo f) {

		this.idequipo = f.idequipo;
		this.nombre = f.nombre;
		this.ciudad = f.ciudad;

	}

	public equipo(int idequipo, String nombres, String ciudad) {

		this.idequipo = idequipo;
		this.nombre = nombres;
		this.ciudad = ciudad;

	}

	@Override
	public String toString() {
		return "equipo [idequipo=" + idequipo + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}

	public void visualizar(ArrayList<equipo> lista) {

		for (equipo arti : lista) {
			System.out.println(arti);
		}

	}

	public equipo añadir(Scanner teclado) {

		System.out.println("id equipo");
		this.idequipo = teclado.nextInt();
		
		teclado.nextLine();

		System.out.println("nombre");
		this.nombre = teclado.nextLine();

		System.out.println("apellido");
		this.ciudad = teclado.nextLine();

		return this;

	}

	public int getIdequipo() {
		return idequipo;
	}

	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
