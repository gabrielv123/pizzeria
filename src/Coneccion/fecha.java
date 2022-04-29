package Coneccion;

import java.io.Serializable;
import java.util.Scanner;

public class fecha implements Comparable<fecha>, Serializable {

	// defino las variables

	private int dia;
	private int mes;
	private int año;

	// constructor por defecto

	public fecha() {

		this.dia = 1;
		this.mes = 1;
		this.año = 2021;
	}

	// constructor copia
	public fecha(fecha f) {

		this.dia = f.dia;
		this.mes = f.mes;
		this.año = f.año;
	}

	public fecha(int dia, int mes, int año) {

		// comprueblo el valor del denominador

		if (dia > 0 && dia <= 31) {
			// si no es 0
			this.dia = dia;
		}

		else {
			// si es 0 muestro un mensaje de error

			System.out.println("el dia no puede ser mayor que 31 ni 0 o menor, le pongo 1");
			// pongo 1 al dia
			this.dia = 1;
		}

		if (mes > 0 && mes <= 12) {
			// si no es 0
			this.mes = mes;
		}

		else {
			// si es 0 muestro un mensaje de error

			System.out.println("el mes no puede ser 0 o mayor a 12, le pongo 1");
			// pongo 1 al mes
			this.mes = 1;

		}

		if (año != 0) {
			// si no es 0
			this.año = año;
		}

		else {
			// si es 0 muestro un mensaje de error

			System.out.println("no puede haber un año que sea menor que cero");
			// pongo 2021 al año
			this.año = 2021;
		}
	}

	// getter and setter

	public int getDia() {
		return dia;
	}

	public void setDia(int dia, int i, int j) {
		this.dia = dia;

		if (dia == 0 || dia <= 31) {
			this.dia = dia;
		}

		else {
			System.out.println("no es valido pon otro");
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes, int i, int j) {
		this.mes = mes;

		if (mes == 0 || dia <= 12) {
			this.mes = mes;
		}

		else {
			System.out.println("no es valido pon otro");
		}
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;

		if (año != 0) {
			this.año = año;
		}

		else {
			System.out.println("no es valido pon otro");
		}
	}

	// metodo escribir

	public String toString() {
		return (dia + "/" + mes + "/" + año);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dia;
		result = prime * result + mes;
		result = prime * result + año;
		return result;
	}

	// metodo equals
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			// si es el mismo objeto

			return true;
		if (obj == null)

			// si el objeto es nulo (no estÃ¡ creado)
			return false;

		if (getClass() != obj.getClass())

			// si los objetos no son de la misma clase

			return false;
		// creo un objeto temporal de esta clase
		fecha other = (fecha) obj;

		// comparo las propiedades de los objetos this y other
		if (this.año != other.año)
			return false;
		if (this.mes > other.mes)
			return false;
		if (this.dia > other.dia)
			return false;

		// si son iguales
		return true;

	}

	public int CompareTo(fecha other) {

		if (this.dia > other.dia) {
			return 1;
		}

		else if (this.dia < other.dia) {
			return -1;
		}

		else {

			if (this.mes > other.mes) {
				return 1;
			}

			else if (this.mes < other.mes) {
				return -1;
			}

			if (this.año > other.año) {
				return 1;
			}

			else if (this.año < other.año) {
				return -1;
			}

			else {
				return 1;
			}
		}

	}

	public void leer(Scanner teclado) {

		System.out.println("dime un dia ");
		dia = teclado.nextInt();

		while (dia < 1 || dia > 31) {
			System.out.println("el  valor del dia no es valido");
			System.out.println("dia: ");
			dia = teclado.nextInt();
		}

		System.out.println("dime un mes ");
		this.mes = teclado.nextInt();

		while (mes < 1 || mes > 12) {
			System.out.println("el  valor del mes no es valido");
			System.out.println("mes: ");
			mes = teclado.nextInt();
		}

		System.out.println("dime un año ");
		this.año = teclado.nextInt();

		while (año == 0) {
			System.out.println("el  valor del año no es valido");
			System.out.println("año: ");
			año = teclado.nextInt();

		}
	}

	@Override
	public int compareTo(fecha o) {
		// TODO Auto-generated method stub
		return 0;
	}
}