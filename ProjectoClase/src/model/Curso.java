package model;

import java.util.ArrayList;

public class Curso {

	private String grupo;
	

	
	public Curso() {
		super();
	}

	public Curso(String grupo) {
		super();
		this.grupo = grupo;
	
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	

	@Override
	public String toString() {
		return "Curso [grupo=" + grupo + "]";
	}

	
	
	
	
}
