package controlador;

import java.util.ArrayList;
import java.util.Comparator;

import model.Secuencia;
import model.Database;
import model.Cliente;

// Clase para procesar los prospectos
public class FormCliente extends Formulario {
	Database db = null;
	private ArrayList<Integer> listado = new ArrayList<Integer>();
	
	public FormCliente() {
		// Definir las columnas del formulario
		this.agregarColumna("Código", "codigo", "String", "", false);
		this.agregarColumna("Nombre", "nombre", "String", "", true);
		this.agregarColumna("Apellido Paterno", "apellidoPaterno", "String", "", true);
		this.agregarColumna("Apellido Materno", "apellidoMaterno", "String", "", true);
		this.agregarColumna("Correo electrónico", "eMail", "String", "", true);
		this.agregarColumna("DNI", "DNI", "String", "", true);
		this.agregarColumna("Teléfono", "telefono", "String", "", true);
		this.agregarColumna("Fecha de Contacto", "fechaContacto", "String", "", true);
		this.agregarColumna("Fecha de Pase", "fechaPase", "String", "", true);
	}
	
	public void setDatabase(Database p_database) {
		this.db = p_database;
	}
	
	@Override
	// Asignar todos los valores y colocarlos en la base de datos
	public void grabar(int p_id) {
		ArrayList<String> columnasValor = new ArrayList<String>();
		Cliente c = null;
		// Si no es agregar, recuperar el registro a modificar
		if (this.getModo() == this.AGREGAR)
			c = new Cliente();
		else
			c = this.db.getClientes().get(p_id);
		super.grabar(p_id);
		
		columnasValor = this.obtenerColumnasValor();
		c.setNombres(columnasValor.get(1));
		c.setApellidoPaterno(columnasValor.get(2));
		c.setApellidoMaterno(columnasValor.get(3));
		c.setEMail(columnasValor.get(4));
		c.setDNI(columnasValor.get(5));
		c.setTelefono(columnasValor.get(6));
		c.setFechaContacto(columnasValor.get(7));
		c.setFechaPase(columnasValor.get(8));
		
		// Agregar registro
		if (this.getModo() == this.AGREGAR) {
			// Todos los datos se han ingresado, asignar el código
			String seq_codigo = null;
			seq_codigo = Secuencia.get("Cliente");
			c.setCodigo(seq_codigo);
			System.out.println("0. "+this.obtenerColumnaEtiqueta(0)+" : "+seq_codigo);
			
			db.addCliente(c);
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
		for (Cliente p : db.getClientes()) {
			if (p.coincide(this.obtenerColumnasValor())) {
				this.listado.add(index);
				System.out.println(String.format("%1$02d", numero) + ". "+p);
				numero++;
				retorno = true;
			}
			index++;
		}
	}
	
	// Retorna el índice de base de datos que corresponde con
	// el último listado emitido
	public int getListadoIndex(int p_opcion) {
		if (p_opcion <= this.listado.size() && p_opcion > 0)
			return this.listado.get(p_opcion - 1);
		return -1;
	}
	
	// Modifica el registro de base de datos indicado por el indice p_id
	public void modificar(int p_id) {
		// Ubicar registro a modificar
		Cliente p = this.db.getClientes().get(p_id);
		this.asignarColumnaValor(0, p.getCodigo());
		this.asignarColumnaValor(1, p.getNombres());
		this.asignarColumnaValor(2, p.getApellidoPaterno());
		this.asignarColumnaValor(3, p.getApellidoMaterno());
		this.asignarColumnaValor(4, p.getEMail());
		this.asignarColumnaValor(5, p.getDNI());
		this.asignarColumnaValor(6, p.getTelefono());
		this.asignarColumnaValor(7, p.getFechaContacto());
		this.asignarColumnaValor(8, p.getFechaPase());
		
		// Modificar registro
		super.modificar(p_id);
	}
	
	public void eliminar(int p_id) {
		// Ubicar registro a modificar
		this.db.getClientes().remove(p_id);
		super.eliminar(p_id);
	}
}

class ClienteFechaContactoComparator implements Comparator { 

public int compare(Object o1, Object o2) { 
        Cliente p1 = (Cliente) o1; 
        Cliente p2 = (Cliente) o2; 
        return p1.getFechaContacto(). 
                compareTo(p2.getFechaContacto()); 

    } 
} 