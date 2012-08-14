package model;

public class Cliente extends Prospecto {
	private String fechaPase;
	
	public Cliente() {
	}

	public Cliente(String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto, String p_fechaPase) {
		this.setCodigo(Secuencia.get("Cliente"));
		this.setNombres(p_nombres);
		this.setApellidoPaterno(p_nombres);
		this.setApellidoMaterno(p_apellidoMaterno);
		this.setEMail(p_eMail);
		this.setDNI(p_DNI);
		this.setTelefono(p_telefono);
		this.setFechaContacto(p_fechaContacto);
		this.fechaPase = p_fechaPase;
	}

	public void setFechaPase(String p_fechaPase) {
		this.fechaPase = p_fechaPase;
	}
	
	public String getFechaPase() {
		return this.fechaPase;
	}
}
