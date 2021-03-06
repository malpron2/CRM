package controlador;

import java.util.ArrayList;
import java.util.Comparator;

import model.Secuencia;
import model.Database;
import model.Prospecto;

// Clase para procesar los prospectos
public class FormProspecto extends Formulario {
	Database db = null;
	private ArrayList<Integer> listado = new ArrayList<Integer>();
	
	public FormProspecto() {
		// Definir las columnas del formulario
		this.agregarColumna("C�digo", "codigo", "String", "", false);
		this.agregarColumna("Nombre", "nombre", "String", "", true);
		this.agregarColumna("Apellido Paterno", "apellidoPaterno", "String", "", true);
		this.agregarColumna("Apellido Materno", "apellidoMaterno", "String", "", true);
		this.agregarColumna("Correo electr�nico", "eMail", "String", "", true);
		this.agregarColumna("DNI", "DNI", "String", "", true);
		this.agregarColumna("Tel�fono", "telefono", "String", "", true);
		this.agregarColumna("Fecha de Contacto", "fechaContacto", "String", "", true);
	}
	
	public void setDatabase(Database p_database) {
		this.db = p_database;
	}
	
	@Override
	// Asignar todos los valores y colocarlos en la base de datos
	public void grabar(int p_id) {
		ArrayList<String> columnasValor = new ArrayList<String>();
		Prospecto p = null;
		// Si no es agregar, recuperar el registro a modificar
		if (this.getModo() == this.AGREGAR)
			p = new Prospecto();
		else
			p = this.db.getProspectos().get(p_id);
		super.grabar(p_id);
		
		columnasValor = this.obtenerColumnasValor();
		p.setNombres(columnasValor.get(1));
		p.setApellidoPaterno(columnasValor.get(2));
		p.setApellidoMaterno(columnasValor.get(3));
		p.setEMail(columnasValor.get(4));
		p.setDNI(columnasValor.get(5));
		p.setTelefono(columnasValor.get(6));
		p.setFechaContacto(columnasValor.get(7));
		
		// Agregar registro
		if (this.getModo() == this.AGREGAR) {
			// Todos los datos se han ingresado, asignar el c�digo
			String seq_codigo = null;
			seq_codigo = Secuencia.get("Prospecto");
			p.setCodigo(seq_codigo);
			System.out.println("0. "+this.obtenerColumnaEtiqueta(0)+" : "+seq_codigo);
			
			db.addProspecto(p);
		}
	}
	
	@Override
	public void listar() {
		int numero = 1;
		int index = 0;
		boolean retorno = false;
		super.listar();
		// Mostrar la cabecera del listado
		//System.out.println(String.format("%1$02d", numero) + ". "+pt.cabecera());
		this.listado.clear();
		// Leer todos los registros
		for (Prospecto p : db.getProspectos()) {
			if (p.coincide(this.obtenerColumnasValor())) {
				this.listado.add(index);
				System.out.println(String.format("%1$02d", numero) + ". "+p);
				numero++;
				retorno = true;
			}
			index++;
		}
	}
	
	// Retorna el �ndice de base de datos que corresponde con
	// el �ltimo listado emitido
	public int getListadoIndex(int p_opcion) {
		if (p_opcion <= this.listado.size() && p_opcion > 0)
			return this.listado.get(p_opcion - 1);
		return -1;
	}
	
	// Modifica el registro de base de datos indicado por el indice p_id
	public void modificar(int p_id) {
		// Ubicar registro a modificar
		Prospecto p = this.db.getProspectos().get(p_id);
		this.asignarColumnaValor(0, p.getCodigo());
		this.asignarColumnaValor(1, p.getNombres());
		this.asignarColumnaValor(2, p.getApellidoPaterno());
		this.asignarColumnaValor(3, p.getApellidoMaterno());
		this.asignarColumnaValor(4, p.getEMail());
		this.asignarColumnaValor(5, p.getDNI());
		this.asignarColumnaValor(6, p.getTelefono());
		this.asignarColumnaValor(7, p.getFechaContacto());
		
		// Modificar registro
		super.modificar(p_id);
	}
	
	public void eliminar(int p_id) {
		// Ubicar registro a modificar
		this.db.getProspectos().remove(p_id);
		super.eliminar(p_id);
	}
}

class ProspectoFechaContactoComparator implements Comparator { 

public int compare(Object o1, Object o2) { 
        Prospecto p1 = (Prospecto) o1; 
        Prospecto p2 = (Prospecto) o2; 
        return p1.getFechaContacto(). 
                compareTo(p2.getFechaContacto()); 

    } 
} 