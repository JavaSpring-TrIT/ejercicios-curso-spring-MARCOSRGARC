package com.academia.model;

public class Formacion {

	String nombreCurso;
	int numeroAsignaturas;
	float precio;
	
	
	
	public Formacion() {
		super();
	}
	public Formacion(String nombreCurso, int numeroAsignaturas, float precio) {
		super();
		this.nombreCurso = nombreCurso;
		this.numeroAsignaturas = numeroAsignaturas;
		this.precio = precio;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public int getNumeroAsignaturas() {
		return numeroAsignaturas;
	}
	public void setNumeroAsignaturas(int numeroAsignaturas) {
		this.numeroAsignaturas = numeroAsignaturas;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
