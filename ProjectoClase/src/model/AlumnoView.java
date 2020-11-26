package model;

import java.util.ArrayList;

public class AlumnoView {
	private String dni;
	private String nombre;
	private String curso;
	public ArrayList<Telefono> telefonos;
	public ArrayList<Emilio> emilios;
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public ArrayList<Emilio> getEmilios() {
		return emilios;
	}
	public void setEmilios(ArrayList<Emilio> emilios) {
		this.emilios = emilios;
	}
	public AlumnoView(String dni, String nombre, String curso, ArrayList<Telefono> telefonos,
			ArrayList<Emilio> emilios) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.curso = curso;
		this.telefonos = telefonos;
		this.emilios = emilios;
	}
	public AlumnoView() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AlumnoView [dni=" + dni + ", nombre=" + nombre + ", curso=" + curso + ", telefonos=" + telefonos
				+ ", emilios=" + emilios + "]";
	}
	
	
	
	
	
}
