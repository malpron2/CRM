package controlador;

import java.util.ArrayList;

import model.Secuencia;
import model.Database;
import model.Prospecto;

// Clase para procesar los prospectos
public class FormProspecto extends Formulario {
	Database db = null;
	
	public FormProspecto() {
		// Definir las columnas del formulario
		this.agregarColumna("Código", "codigo", "String", "", false);
		this.agregarColumna("Nombre", "nombre", "String", "", true);
		this.agregarColumna("Apellido Paterno", "apellidoPaterno", "String", "", true);
		this.agregarColumna("Apellido Materno", "apellidoMaterno", "String", "", true);
		this.agregarColumna("Correo electrónico", "eMail", "String", "", true);
		this.agregarColumna("DNI", "DNI", "String", "", true);
		this.agregarColumna("Teléfono", "telefono", "String", "", true);
		this.agregarColumna("Fecha de Contacto", "fechaContacto", "String", "", true);
	}
	
	public void setDatabase(Database p_database) {
		this.db = p_database;
	}
	
	@Override
	// Asignar todos los valores y colocarlos en la base de datos
	public void grabar() {
		ArrayList<String> columnasValor = new ArrayList<String>();
		Prospecto p = new Prospecto();
		
		super.grabar();
		columnasValor = this.obtenerColumnasValor();
		p.setNombres(columnasValor.get(1));
		p.setApellidoPaterno(columnasValor.get(2));
		p.setApellidoMaterno(columnasValor.get(3));
		p.setEMail(columnasValor.get(4));
		p.setDNI(columnasValor.get(5));
		p.setTelefono(columnasValor.get(6));
		p.setFechaContacto(columnasValor.get(7));
		
		// Todos los datos se han ingresado, asignar el código
		String seq_codigo = null;
		seq_codigo = Secuencia.get("Prospecto");
		p.setCodigo(seq_codigo);
		System.out.println("0. "+this.obtenerColumnaEtiqueta(0)+" : "+seq_codigo);
		
		// Agregar registro
		db.addProspecto(p);
	}
	
	public void listar() {
		for (Prospecto p : db.getProspectos()) {
			System.out.println(p);
		}
	}
}
