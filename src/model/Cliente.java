package model;

public class Cliente extends Prospecto {
	private String fechaPase;
	
	public Cliente() {
	}

	public void setFechaPase(String p_fechaPase) {
		this.fechaPase = p_fechaPase;
	}
	
	public String getFechaPase() {
		return this.fechaPase;
	}
}
