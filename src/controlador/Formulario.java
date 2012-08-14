package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Formulario {
	private int columnaActual = 0;
	private ArrayList<String> columnasEtiqueta = new ArrayList<String>();
	private ArrayList<String> columnasNombre = new ArrayList<String>();
	private ArrayList<String> columnasTipo = new ArrayList<String>();
	private ArrayList<String> columnasFormato = new ArrayList<String>();
	private ArrayList<String> columnasValor = new ArrayList<String>();
	private ArrayList<String> columnasEditable = new ArrayList<String>();
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        	
	
	private int modo = 0;
	final int AGREGAR = 1;
	final int MODIFICAR = 2;
	final int ELIMINAR = 3;
	final int CONSULTAR = 4;
	final int LISTAR = 5;
	
	private ArrayList<String> inputArray = null;
	
	public int getModo() {
		return this.modo;
	}
	
	// Grabar en base de datos (se debe implementar en cada herencia)
	public void grabar(int p_id) {
	}
	
	public void grabar() {
	}
/*	
	public boolean editar() {
		if (this.columnaActual >= this.columnasNombre.size())
			return false;
		return true;
	}
	*/
	public int obtenerTotalColumnas() {
		return this.columnasNombre.size();
	}
	
	public void siguienteColumna() {
		if (this.columnaActual < this.columnasNombre.size()+1)
			this.columnaActual++;
	}
	
	public void anteriorColumna() {
		if (this.columnaActual > 0)
			this.columnaActual--;
	}
	
	public void editar(boolean p_editar) {
		String dato = null;
		
		// Editar todas las columnas para ingresar
		for (int i = 0; i < this.columnasEtiqueta.size(); i++) {
			// Mostrar etiqueta de la columna a editar
			if (this.columnasEditable.get(i).equals(""+true)) {
				System.out.print(i+". "+this.columnasEtiqueta.get(i)+" : ");
				if (this.columnasValor.get(i) != null && !this.columnasValor.get(i).isEmpty()) {
					System.out.print(this.columnasValor.get(i)+" : ");
				}
				
				// Si el formulario es para editar (agregar, modificar)
				if (p_editar) {
					if (this.inputArray == null) {
						// Leer el valor de la columna desde el teclado
						try {
							dato = in.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						// Tomar el valor del indice correspondiente
						dato = this.inputArray.get(i);
						System.out.println(dato);
					}
					// Dar formato de acuerdo al formato requerido
					
					// El tipo de dato se usará al momento de almacenar en la base de datos
					
					// Asignar el valor obtenido, si es que distinto de nulo o vacio
					if (dato != null && !dato.isEmpty()) {
						this.columnasValor.set(i, dato);
					}
				}
			}
		}

	}
	
	private void clearValues() {
		for (int i = 0; i < this.columnasValor.size(); i++)
			this.columnasValor.set(i, null);
	}
	
	public void nuevo() {
		// Prepara el buffer para el nuevo registro
		this.modo = this.AGREGAR;
		this.columnaActual = 0;
		this.clearValues();
		// Editar las columnas sin valores (nuevo registro)
		this.editar(true);
		this.grabar();
		this.clearValues();
	}
	
	public void modificar(int p_id) {
		this.modo = this.MODIFICAR;
		this.columnaActual = 0;
		// Editar las columnas con valores (modificar registro)
		this.editar(true);
		this.grabar(p_id);
		this.clearValues();
	}
	
	public void eliminar(int p_id) {
		this.modo = this.ELIMINAR;
		this.columnaActual = 0;
		// Mostrar las columnas del registro a eliminar
		//this.editar(false);
		this.clearValues();
	}

	public void consultar() {
		this.modo = this.CONSULTAR;
		this.columnaActual = 0;
		// Limpiar datos de formulario
		//this.clearValues();
		// Editar las columnas para usar como filtro
		this.clearValues();
		this.editar(true);
	}

	public void listar() {
		this.modo = this.LISTAR;
		this.columnaActual = 0;
		// Listar los registros filtrados
	}

	// Retorna la siguiente columna cuando se está en modo edición
	public String obtenerColumnaNombre(int index) {
		if (index >= 0 && index < this.columnasNombre.size())
			return this.columnasNombre.get(index);
		else
			return "";
	}
	
	public String obtenerColumnaTipo(int index) {
		if (index >= 0 && index < this.columnasTipo.size())
			return this.columnasTipo.get(index);
		else
			return "";
	}
	
	public String obtenerColumnaValor(int index) {
		if (index >= 0 && index < this.columnasValor.size())
			return this.columnasValor.get(index);
		else
			return "";
	}
	
	public void asignarColumnaValor(int index, String p_valor) {
		if (index >= 0 && index < this.columnasValor.size())
			this.columnasValor.set(index, p_valor);
	}

	public String obtenerColumnaEtiqueta(int index) {
		if (index >= 0 && index < this.columnasEtiqueta.size())
			return this.columnasEtiqueta.get(index);
		else
			return "";
	}
	
	public String obtenerColumnaFormato(int index) {
		if (index >= 0 && index < this.columnasFormato.size())
			return this.columnasFormato.get(index);
		else
			return "";
	}
	
	// Añadir una columna al formulario
	public void agregarColumna(String p_etiqueta, String p_nombre, String p_tipo, String p_formato, boolean p_editable) {
		this.columnasEtiqueta.add(p_etiqueta);
		this.columnasNombre.add(p_nombre);
		this.columnasTipo.add(p_tipo);
		this.columnasFormato.add(p_formato);
		this.columnasEditable.add(""+p_editable);
		this.columnasValor.add(null);
	}
	
	public ArrayList<String> obtenerColumnasValor() {
		return this.columnasValor;
	}
	
	public void asignarColumnasValor(ArrayList<String> p_columnasValor) {
		this.columnasValor = p_columnasValor;
	}
	
	public void setInputArray(ArrayList<String> p_inputArray) {
		this.inputArray = p_inputArray;
	}
}
