package controlador;

import java.util.ArrayList;

import model.Secuencia;
import model.Database;
import model.Prospecto;

// Clase para procesar los prospectos
public class FormProspecto extends Formulario {
	Prospecto prospectoRegistro = null;
	Database db = null;
	
	public void setDatabase(Database p_database) {
		this.db = p_database;
	}
	
	public void asignarProspecto(Prospecto p_prospecto) {
		this.prospectoRegistro = p_prospecto;
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
}
