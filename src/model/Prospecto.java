package model;

import java.util.ArrayList;

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

	// Recibe un arreglo con datos o nulos, debe coincidir con
	// los datos del objeto para retornar true o
	// los datos del arreglo deben ser todos nulos para retornar true
	public boolean coincide(ArrayList<String> prospectoFiltroVal) {
		boolean ret = true;
		int i = 0;
		// Recorrer el arreglo para comparar por indice
		for (String s : prospectoFiltroVal) {
			if (s != null && !s.isEmpty()) {
				// Si cualquiera de las comparaciones es falsa, no cumple
				switch(i) {
				case 0:
					ret = this.codigo.equals(s);
					break;
				case 1:
					ret = this.nombres.equals(s);
					break;
				case 2:
					ret = this.apellidoPaterno.equals(s);
					break;
				case 3:
					ret = this.apellidoMaterno.equals(s);
					break;
				case 4:
					ret = this.eMail.equals(s);
					break;
				case 5:
					ret = this.DNI.equals(s);
					break;
				case 6:
					ret = this.telefono.equals(s);
					break;
				case 7:
					ret = this.fechaContacto.equals(s);
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				default:
					break;
				}
			}
			i++;
		}
		return ret;
	}
}
