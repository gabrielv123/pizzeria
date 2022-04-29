package Coneccion;

import java.io.Serializable;
import java.util.Scanner;

public class complejo implements Comparable<complejo>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3418835133349924766L;

	private double real;
	private double imaginario;

	// constructores

	public complejo() {

	}

	// constructor copia

	public complejo(complejo r) {
		this.real = r.real;
		this.imaginario = r.imaginario;
	}

	// constructor de 1 variable

	public complejo(double r) {
		this.real = r;
		this.imaginario = 8;
	}

	// constructor de 2 variables
	public complejo(double r, double i) {

		this.real = r;
		this.imaginario = i;

	}

	// metodo escribir

	public void escribir() {
		System.out.println("numero" + real + " + " + imaginario + "i");
	}

	public void finalize() {
		System.out.println("complejo destruido");
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginario() {
		return imaginario;
	}

	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		complejo other = (complejo) obj;
		// comparo las propiedades de los objetos this y other
		if (this.real == other.real && this.imaginario == other.imaginario) {
			// si son iguales
			return true;
		}
		return false;
	}

	// metodo cambiar las cosas a String
	@Override
	public String toString() {
		return (real + " + " + imaginario + "i");
	}

	// metodo ordernar
	@Override
	public int compareTo(complejo other) {

		if (this.real > other.real) {
			return 1;
		}

		else if (this.real < other.real) {
			return -1;
		}

		else {

			if (this.imaginario > other.imaginario) {
				return 1;
			}

			else if (this.imaginario < other.imaginario) {
				return -1;
			}

			else {
				return 0;
			}
		}
	}

	public void leer(Scanner teclado) {

		System.out.println("dime un numero real ");
		this.real = teclado.nextDouble();

		System.out.println("dime un imaginario ");
		this.imaginario = teclado.nextDouble();

	}

}
