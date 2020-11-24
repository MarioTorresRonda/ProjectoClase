package model;

public class Telefono {
	
	private String dni;
	private long tlf;
	
	public Telefono() {
		super();
	}

	public Telefono(String dni, long tlf) {
		super();
		this.dni = dni;
		this.tlf = tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public long getTlf() {
		return tlf;
	}

	public void setTlf(long tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "Telefono [dni=" + dni + ", tlf=" + tlf + "]";
	}
	
	

}
