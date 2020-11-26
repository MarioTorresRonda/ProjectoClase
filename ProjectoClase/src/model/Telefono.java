package model;

public class Telefono {
	
	private String dni;
	private Long tlf;
	


	



	public Telefono(String dni, Long tlf) {
		super();
		this.dni = dni;
		this.tlf = tlf;
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







	public Long getTlf() {
		return tlf;
	}







	public void setTlf(Long tlf) {
		this.tlf = tlf;
	}







	@Override
	public String toString() {
		return "Telefono [dni=" + dni + ", tlf=" + tlf + "]";
	}
	
	

}
