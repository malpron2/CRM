package model;

public class Prospecto {
	private String codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String eMail;
	private String DNI;
	private String telefono;
	private String fechaContacto;
	
	public Prospecto() {
	}
	
	public Prospecto(String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto) {
		this.nombres = p_nombres;
		this.apellidoPaterno = p_apellidoPaterno;
		this.apellidoMaterno = p_apellidoMaterno;
		this.eMail = p_eMail;
		this.DNI = p_DNI;
		this.telefono = p_telefono;
		this.fechaContacto = p_fechaContacto;
		this.codigo = Secuencia.get("Prospecto");
	}
	
	public void setNombres(String p_nombres) {
		this.nombres = p_nombres;
	}
	public void setApellidoPaterno(String p_apellidoPaterno) {
		this.apellidoPaterno = p_apellidoPaterno;
	}
	public void setApellidoMaterno(String p_apellidoMaterno) {
		this.apellidoMaterno = p_apellidoMaterno;
	}
	public void setEMail(String p_eMail) {
		this.eMail = p_eMail;
	}
	public void setDNI(String p_DNI) {
		this.DNI = p_DNI;
	}
	public void setTelefono(String p_telefono) {
		this.telefono = p_telefono;
	}
	public void setFechaContacto(String p_fechaContacto) {
		this.fechaContacto = p_fechaContacto;
	}
	
	public String getNombres() {
		return this.nombres;
	}
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}
	public String getEMail() {
		return this.eMail;
	}
	public String getDNI() {
		return this.DNI;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public String getFechaContacto() {
		return this.fechaContacto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";

		return "| " + String.format(formato1, this.codigo)+
			   "| " + String.format(formato2, this.nombres)+
			   "| " + String.format(formato2, this.apellidoPaterno)+
			   "| " + String.format(formato2, this.apellidoMaterno)+
			   "| " + String.format(formato3, this.eMail)+
			   "| " + String.format(formato2, this.DNI)+
			   "| " + String.format(formato2, this.telefono)+
			   "| " + String.format(formato2, this.fechaContacto)+
			   "|";
	}

}
