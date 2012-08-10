package model;

public class Opcion {
	private String nombre;
	private String descripcion;
	private boolean estado;
	
	public Opcion(String p_nombre, String p_descripcion, boolean p_estado) {
		this.nombre = p_nombre;
		this.descripcion = p_descripcion;
		this.estado = p_estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
