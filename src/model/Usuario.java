package model;

public class Usuario {

	private String cuenta;
	private String clave;
	private String DNI;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String eMail;
	private String fechaIngreso;
	private String puesto;
	private String rol;

	public Usuario(String p_cuenta, String p_clave, String p_DNI,
			String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno, String p_eMail,
			String p_fechaIngreso, String p_puesto, String p_rol) {
		this.setCuenta(p_cuenta);
		this.setClave(p_clave);
		this.setDNI(p_DNI);
		this.setNombres(p_nombres);
		this.setApellidoPaterno(p_apellidoPaterno);
		this.setApellidoMaterno(p_apellidoMaterno);
		this.seteMail(p_eMail);
		this.setFechaIngreso(p_fechaIngreso);
		this.setPuesto(p_puesto);
		this.setRol(p_rol);
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
