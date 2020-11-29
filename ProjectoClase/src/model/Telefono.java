package model;

public class Telefono {
	
	private String dni;
	private String tlf;
	


	



	public Telefono(String dni, String tlf2) {
		super();
		this.dni = dni;
		this.tlf = tlf2;
	}







	public Telefono() {
		super();
		// TODO Auto-generated constructor stub
	}







	public String getDni() {
		return dni;
	}







	public void setDni(String dni) {
		this.dni = dni;
	}







	public String getTlf() {
		return tlf;
	}







	public void setTlf(String tlf) {
		this.tlf = tlf;
	}







	@Override
	public String toString() {
		return "Telefono [dni=" + dni + ", tlf=" + tlf + "]";
	}
	
	

}
