package model;

import java.util.ArrayList;

public class Rol {
	private String nombre;
	private ArrayList<Permiso> permisoList = new ArrayList<Permiso>();
	
	public Rol(String p_nombre, ArrayList<Permiso> p_permisoList) {
		this.nombre = p_nombre;
		this.permisoList = p_permisoList;
		
	}

	public ArrayList<Permiso> getPermisoList() {
		return permisoList;
	}

	public void setPermisoList(ArrayList<Permiso> permisoList) {
		this.permisoList = permisoList;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
	public void setNombre(String p_nombre) {
		this.nombre = p_nombre;
	}
}
