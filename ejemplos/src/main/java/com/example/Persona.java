package com.example;

import java.util.Objects;

public class Persona {
	private int id;
	private String nombre;
	private String apellidos;
	double bruto = 1000;
	double retencion = 100;
	
	Calculadora calculadora = new CalculadoraImpl();
	
	public Persona(int id) {
		super();
		this.id = id;
	}
	
	public Persona(int id, String nombre, String apellidos) {
		super();
		this.id = id;
		setNombre(nombre);
		this.apellidos = apellidos;
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
		if(nombre == null || "".equals(nombre))
			throw new IllegalArgumentException("El nombre es obligatorio");
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
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
		Persona other = (Persona) obj;
		return id == other.id;
	}
	
	public double salario() {
		return calculadora.add(bruto, -retencion);
	}
	
}
