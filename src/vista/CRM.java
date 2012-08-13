package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controlador.FormProspecto;

import model.Currency;
import model.Database;
import model.Modulo;
import model.Opcion;
import model.Permiso;
import model.Usuario;

public class CRM {
	private Database db;
	private String companyName;
	private double IGV;
	private String userName;
	private String userPassword;
	private Currency localCurrency;
//	private ArrayList<Currency> foreignCurrencyList;
	private String systemDateFormat;
	private String systemDecimalFormat;
	private FormProspecto formProspecto = new FormProspecto();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public CRM() {
		db = new Database();
		formProspecto.setDatabase(db);
	}
	
	public void setUser(String p_userName) {
		this.userName = p_userName;
	}

	public void setPassword(String p_password) {
		this.userPassword = p_password;
	}

	public void setLocalCurrency(String p_currencyName) {
		this.localCurrency = db.getCurrency("currencyName", p_currencyName);
	}

	public boolean login() {
		// Recibir el codigo de usuario, ubicarlo en los datos
		// y comparar el resultado de la clave
		boolean ret = false;
		Usuario u = db.getUsuario("cuenta", this.userName);
		if (u != null) {
			ret = u.getClave().equals(this.userPassword);
		}
		return ret;
	}

	public ArrayList<String> menu() {
		// Construye menu seg�n permisos de usuario
		int opcion = 1;
		ArrayList<String> menuList = new ArrayList<String>();
		ArrayList<Permiso> permisoList = null;
		String buffer = null;
		
		// Recuperar permisos de usuario para el modulo
		permisoList = db.getPermisos(this.userName);
		for (Modulo m : db.getModulos()) {
			buffer = opcion+". ";
			// Recorrer los permisos
			for (Permiso p : permisoList) {
				// Para cada m�dulo existente en el sistema
				if (m.getNombre().equals(p.getNombreModulo())) {
					// Determinar si se tiene acceso para mostrar
					if (p.isAcceso()) {
						buffer = buffer.concat(m.getDescripcion());
					}
					else
						buffer = buffer.concat("................");
					break;
				}
			}
			// Cargar el arreglo con el listado del men�
			menuList.add(buffer);
			opcion++;
		}
		menuList.add("0. Salir");
		return menuList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String p_companyName) {
		this.companyName = p_companyName;
	}

	public double getIGV() {
		return IGV;
	}

	public void setIGV(double p_IGV) {
		IGV = p_IGV;
	}

	public void loadTestData() {
		db.loadTestData();
	}

	public String getSystemDateFormat() {
		return systemDateFormat;
	}

	public void setSystemDateFormat(String p_systemDateFormat) {
		this.systemDateFormat = p_systemDateFormat;
	}

	public String getSystemDecimalFormat() {
		return systemDecimalFormat;
	}

	public void setSystemDecimalFormat(String p_systemDecimalFormat) {
		this.systemDecimalFormat = p_systemDecimalFormat;
	}

	public ArrayList<String> opcion(String p_modulo) {
		// Construye menu seg�n permisos de usuario
		int opcion = 1;
		ArrayList<String> formList = new ArrayList<String>();
		ArrayList<Permiso> permisoList = null;
		String buffer = null;
		
		// Recorrer los permisos
		for (Permiso p : db.getPermisos(this.userName)) {
			// Obtener los permisos que corresponden al m�dulo
			if (p.getNombreModulo().equals(p_modulo)) {
				// Leer opciones de un formulario est�ndar
				for (Opcion o : db.getOpciones()) {
					buffer = opcion+". ";
					switch(opcion) {
					case 1:
						if (p.isAdicionar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 2:
						if (p.isModificar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 3:
						if (p.isEliminar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 4:
						if (p.isConsultar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					case 5:
						if (p.isConsultar()) {
							buffer = buffer.concat(o.getDescripcion());
						}
						else
							buffer = buffer.concat("................");
						break;
					default:
						break;
					}
					formList.add(buffer);
					opcion++;
				}
				break;
			}
		}
		formList.add("0. Salir");
		return formList;
	}

	public String leerOpcionForm() {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Opcion> op = db.getOpciones();
	    String dato = null;
	    int opcion = -1;
	    
		// Leer el valor de la columna desde el teclado
		try {
			dato = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		opcion = Integer.parseInt(dato);
		// Si la opcion es v�lida
		if (opcion >= 0 && opcion < op.size()) {
			// Retornar opcion encontrada
			return op.get(opcion).getNombre();
		}
		
		return "";
	}

	public String leerOpcionMenu() {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Modulo> mo = db.getModulos();
	    String dato = null;
	    int opcion = -1;
	    
		// Leer el valor de la columna desde el teclado
		try {
			dato = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		opcion = Integer.parseInt(dato);
		// Si la opcion es v�lida
		if (opcion >= 0 && opcion < mo.size()) {
			// Retornar opcion encontrada
			return mo.get(opcion).getNombre();
		}
		
		return "";
	}

	public void nuevoProspecto() {
		formProspecto.nuevo();
	}
	
	public void setProspectoInputArray(ArrayList<String> p_prospectoInputArray) {
		formProspecto.setInputArray(p_prospectoInputArray);
	}

	public void listarProspecto() {
		formProspecto.listar();
	}

	public void modificaProspecto(int p_opcion) {
		int prospectoId = -1;
		prospectoId = formProspecto.getListadoIndex(p_opcion);
		if (prospectoId >= 0) {
			formProspecto.modificar(prospectoId);
		}
		else
			System.out.println("Opci�n fuera de rango.");
	}

	public void buscarProspecto() {
		formProspecto.consultar();
	}
	
	public void resetSecuencias() {
		this.db.resetSecuencias();
	}

	public void eliminarProspecto(int p_opcion) {
		int prospectoId = -1;
		prospectoId = formProspecto.getListadoIndex(p_opcion);
		if (prospectoId >= 0) {
			formProspecto.eliminar(prospectoId);
		}
		else
			System.out.println("Opci�n fuera de rango.");
	}

	public void run() {
		boolean ok = false;
		String dato = null;
		int intentos = 3;
		String modulo = null;
		String opcion = null;
		
		System.out.println(this.companyName);
		do {
			// Solicitar el usuario y la clave
			System.out.print("Usuario : ");
			try {
				dato = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setUser(dato);
			System.out.print("Clave : ");
			try {
				dato = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setPassword(dato);
			
			// Si la autenticacion es correcta
			if (this.login())
				// Continuar con la siguiente parte
				break;
			// Si no es valido, reingresar o salir
		} while (intentos-- > 0);
			
		// Si fallo la autenticacion
		if (intentos == 0)
			// regresar o salir del sistema
			return;
			
		do {
			System.out.println(this.companyName);
			for (String s : this.menu()) {
				System.out.println(s);
			}
			System.out.print("Ingrese su opci�n : ");
			modulo = this.leerOpcionMenu();
			if (modulo != null) {
				do {
					System.out.println(this.companyName);
					for (String s : this.opcion(modulo)) {
						System.out.println(s);
					}
					System.out.print("Ingrese su opci�n");
					opcion = this.leerOpcionForm();
				} while (opcion != null);
			}
		} while (modulo != null);
	}
}
