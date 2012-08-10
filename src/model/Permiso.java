package model;

public class Permiso {
	private String nombreModulo;
	private boolean acceso;
	private boolean consultar;
	private boolean adicionar;
	private boolean modificar;
	private boolean eliminar;
	
	public Permiso(String p_nombreModulo, boolean p_acceso, boolean p_adicionar, boolean p_modificar, boolean p_eliminar, boolean p_consultar) {
		this.nombreModulo = p_nombreModulo;
		this.acceso = p_acceso;
		this.consultar = p_consultar;
		this.adicionar = p_adicionar;
		this.modificar = p_modificar;
		this.eliminar = p_eliminar;
	}
	
	public String getNombreModulo() {
		return nombreModulo;
	}
	
	public void setNombreModulo(String p_nombreModulo) {
		this.nombreModulo = p_nombreModulo;
	}
	
	public boolean isConsultar() {
		return consultar;
	}
	
	public void setConsultar(boolean p_consultar) {
		this.consultar = p_consultar;
	}
	
	public boolean isAdicionar() {
		return adicionar;
	}
	
	public void setAdicionar(boolean p_adicionar) {
		this.adicionar = p_adicionar;
	}
	
	public boolean isModificar() {
		return modificar;
	}
	
	public void setModificar(boolean p_modificar) {
		this.modificar = p_modificar;
	}
	
	public boolean isEliminar() {
		return eliminar;
	}
	
	public void setEliminar(boolean p_eliminar) {
		this.eliminar = p_eliminar;
	}

	public boolean isAcceso() {
		return acceso;
	}
}
