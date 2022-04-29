package pizzeria;

import java.util.ArrayList;
import java.util.Scanner;

public class cliente {
	
	private int id;
	private String nombre;
	private String apellido;
	
	public cliente () {
		
		this.id = 0;
		this.nombre = "";
		this.apellido= "";
		
	}
	
	public cliente (cliente c) {
		
		this.id = c.id;
		this.nombre = c.nombre;
		this.apellido = c.nombre;
		
	}
	
	public cliente (int id , String nombre , String apellido) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public void leer(Scanner teclado) {
		
		System.out.println("dime el dni ");
		this.id = teclado.nextInt();
		
		System.out.println("dime el nombre ");
		this.nombre = teclado.nextLine();
		
		System.out.println("dime el apellido ");
		this.apellido = teclado.nextLine();
		
	}
	
	public void visualizar (ArrayList<cliente> listar) {
		
		for (cliente clie : listar) {
			System.out.println(clie);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
