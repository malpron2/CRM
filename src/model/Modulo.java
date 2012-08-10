package model;

public class Modulo {
	private String nombre;
	private String descripcion;
	private boolean estado;
	
	public Modulo(String p_nombre, String p_descripcion, boolean p_estado) {
		this.nombre = p_nombre;
		this.descripcion = p_descripcion;
		this.estado = p_estado;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String p_nombre) {
		this.nombre = p_nombre;
	}
	
	public String getDescripcion() {
		if (this.isEstado())
			return descripcion;
		else
			return "...................";
	}
	
	public void setDescripcion(String p_descripcion) {
		this.descripcion = p_descripcion;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean p_estado) {
		this.estado = p_estado;
	}
}
