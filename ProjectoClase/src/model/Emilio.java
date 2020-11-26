package model;

public class Emilio {

	private String dni;
	private String email;
	
	
	public Emilio() {
		super();
	}

	public Emilio(String dni, String email) {
		super();
		this.dni = dni;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Emilio [dni=" + dni + ", email=" + email + "]";
	}
	
	
}
