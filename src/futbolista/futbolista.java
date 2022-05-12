package futbolista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class futbolista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idfubtolista;
	private String nombre;
	private String apellido;
	private int salario;
	private int idequipo;

	public futbolista() {

		this.idfubtolista = 0;
		this.nombre = "";
		this.apellido = "";
		this.salario = 0;
		this.idequipo = 0;

	}

	public futbolista(futbolista f) {

		this.idfubtolista = f.idfubtolista;
		this.nombre = f.nombre;
		this.apellido = f.apellido;
		this.salario = f.salario;
		this.idequipo = f.idequipo;

	}

	public futbolista(int idfutbolista, String nombres, String apellido, int salario, int idequipo) {

		this.idfubtolista = idfutbolista;
		this.nombre = nombres;
		this.apellido = apellido;
		this.salario = salario;
		this.idequipo = idequipo;

	}

	@Override
	public String toString() {
		return "futbolista [idfubtolista=" + idfubtolista + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", salario=" + salario + ", idequipo=" + idequipo + "]";
	}

	public void visualizar(ArrayList<futbolista> lista) {

		for (futbolista arti : lista) {
			System.out.println(arti);
		}

	}

	public futbolista añadir(Scanner teclado) {

		teclado.nextLine();

		System.out.println("id fubolista");
		this.idfubtolista = teclado.nextInt();

		System.out.println("nombre");
		this.nombre = teclado.next();

		teclado.nextLine();

		System.out.println("apellido");
		this.apellido = teclado.nextLine();

		System.out.println("salario");
		this.salario = teclado.nextInt();

		System.out.println("id equipo");
		this.idequipo = teclado.nextInt();

		return this;
	}

	public int getIdfubtolista() {
		return idfubtolista;
	}

	public void setIdfubtolista(int idfubtolista) {
		this.idfubtolista = idfubtolista;
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

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getIdequipo() {
		return idequipo;
	}

	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}

}
