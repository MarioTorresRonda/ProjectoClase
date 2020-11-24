package model;

import java.util.ArrayList;

public class Curso {

	private String grupo;
	
	ArrayList <Alumno> alumnos = new ArrayList();
	
	public Curso() {
		super();
	}

	public Curso(String grupo, ArrayList<Alumno> alumnos) {
		super();
		this.grupo = grupo;
		this.alumnos = alumnos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [grupo=" + grupo + ", alumnos=" + alumnos + "]";
	}

	
	
	
	
}
