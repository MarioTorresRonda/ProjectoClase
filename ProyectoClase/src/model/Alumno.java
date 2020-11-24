package model;

public class Alumno {

	private String dni;
	private String nombre;
	private String curso;
	
	public Alumno() {
		super();
	}

	public Alumno(String dni, String nombre, String curso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.curso = curso;
	}
	
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

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", curso=" + curso + "]";
	}
	
	
	}
