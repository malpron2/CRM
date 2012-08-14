package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controlador.FormCliente;
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
	private FormCliente formCliente = new FormCliente();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public CRM() {
		db = new Database();
		formProspecto.setDatabase(db);
		formCliente.setDatabase(db);
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
		// Construye menu según permisos de usuario
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
				// Para cada módulo existente en el sistema
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
			// Cargar el arreglo con el listado del menú
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
		// Construye menu según permisos de usuario
		int opcion = 1;
		ArrayList<String> formList = new ArrayList<String>();
		ArrayList<Permiso> permisoList = null;
		String buffer = null;
		
		// Recorrer los permisos
		for (Permiso p : db.getPermisos(this.userName)) {
			// Obtener los permisos que corresponden al módulo
			if (p.getNombreModulo().equals(p_modulo)) {
				// Leer opciones de un formulario estándar
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
	    ArrayList<Opcion> op = db.getOpciones();
	    String dato = null;
	    int opcion = -1;
	    
		// Leer el valor de la opcion desde el teclado
		try {
			dato = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		opcion = Integer.parseInt(dato);
		// Si la opcion es válida
		if (opcion > 0 && opcion <= op.size()) {
			// Retornar opcion encontrada
			return op.get(opcion-1).getNombre();
		}
		
		return "";
	}

	public String leerOpcionMenu() {
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
		// Si la opcion es válida
		if (opcion > 0 && opcion <= mo.size()) {
			// Retornar opcion encontrada
			return mo.get(opcion-1).getNombre();
		}
		
		return "";
	}

	public void nuevoProspecto() {
		formProspecto.nuevo();
	}
	public void nuevoCliente() {
		formCliente.nuevo();
	}
	
	public void setProspectoInputArray(ArrayList<String> p_prospectoInputArray) {
		formProspecto.setInputArray(p_prospectoInputArray);
	}
	public void setClienteInputArray(ArrayList<String> p_clienteInputArray) {
		formCliente.setInputArray(p_clienteInputArray);
	}

	public void listarProspecto() {
		formProspecto.listar();
	}
	public void listarCliente() {
		formCliente.listar();
	}

	public void modificaProspecto(int p_opcion) {
		int prospectoId = -1;
		prospectoId = formProspecto.getListadoIndex(p_opcion);
		if (prospectoId >= 0) {
			formProspecto.modificar(prospectoId);
		}
		else
			System.out.println("Opción fuera de rango.");
	}
	
	public void modificaCliente(int p_opcion) {
		int clienteId = -1;
		clienteId = formCliente.getListadoIndex(p_opcion);
		if (clienteId >= 0) {
			formCliente.modificar(clienteId);
		}
		else
			System.out.println("Opción fuera de rango.");
	}

	public void buscarProspecto() {
		formProspecto.consultar();
	}
	public void buscarCliente() {
		formCliente.consultar();
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
			System.out.println("Opción fuera de rango.");
	}
	public void eliminarCliente(int p_opcion) {
		int clienteId = -1;
		clienteId = formCliente.getListadoIndex(p_opcion);
		if (clienteId >= 0) {
			formCliente.eliminar(clienteId);
		}
		else
			System.out.println("Opción fuera de rango.");
	}

	public void run() {
		boolean ok = false;
		String dato = null;
		int userIndex = -1;
		int intentos = 3;
		String modulo = null;
		String opcion = null;
		
		System.out.println("Bienvenido a nuestro servicio CRM");
		do {
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
				if (dato == null || dato.isEmpty()) {
					ok = false;
					break;
				}
				
				System.out.print("Clave : ");
				try {
					dato = in.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.setPassword(dato);
				
				// Si la autenticacion es correcta
				if (this.login()) {
					// Continuar con la siguiente parte
					ok = true;
					break;
				}
				else
					System.out.println("Error en usuario o clave, intente nuevamente ("+intentos+")");
				// Si no es valido, reingresar o salir
			} while (intentos-- > 0);
				
			// Si fallo la autenticacion
			if (intentos == 0) {
				// regresar o salir del sistema
				System.out.println("Ha excedido el número de intentos, reintente más tarde");
				break;
			}
			
			if (!ok)
				break;
			
			do {
				System.out.println(this.companyName);
				for (String s : this.menu()) {
					System.out.println(s);
				}
				System.out.print("Ingrese su opción : ");
				modulo = this.leerOpcionMenu();
				//System.out.println("Modulo : ["+modulo+"]");
				if (modulo != null && !modulo.isEmpty()) {
					do {
						System.out.println(this.companyName);
						for (String s : this.opcion(modulo)) {
							System.out.println(s);
						}
						System.out.print("Ingrese su opción : ");
						opcion = this.leerOpcionForm();
						//System.out.println("Opcion : ["+opcion+"]");
						//System.out.println("Modulo : ["+modulo+"]");
						// De acuerdo a la opción y el módulo
						if (modulo.equals("Prospectos")) {
							if (opcion == null || opcion.isEmpty())
								break;
							else if (opcion.equals("Agregar")) {
								this.nuevoProspecto();
							} else if (opcion.equals("Modificar")) {
								this.buscarProspecto();	// usar datos para filtrar
								this.listarProspecto();	// mostrar registros que se pueden modificar
								
								// Indicar registro a modificar
								// Leer el valor de la columna desde el teclado
								if (userIndex < 0) {
									System.out.println("Registro a modificar : ");
									try {
										dato = in.readLine();
									} catch (IOException e) {
										e.printStackTrace();
									}
									
									userIndex = Integer.parseInt(dato);
								}
								
								this.modificaProspecto(userIndex);	// modifica el prospecto indicado por el indice
								userIndex = -1;
							} else if (opcion.equals("Eliminar")) {
								this.buscarProspecto();	// usar datos para filtrar
								this.listarProspecto();	// mostrar registros que se pueden eliminar
								
								// Indicar registro a eliminar
								// Leer el valor del registro desde el teclado
								if (userIndex < 0) {
									System.out.println("Registro a eliminar : ");
									try {
										dato = in.readLine();
									} catch (IOException e) {
										e.printStackTrace();
									}
									
									userIndex = Integer.parseInt(dato);
								}
								this.eliminarProspecto(userIndex);	// elimina el prospecto indicado por el indice
								userIndex = -1;
							} else if (opcion.equals("Buscar")) {
								this.buscarProspecto();
							} else if (opcion.equals("Listar")) {
								this.listarProspecto();	// mostrar registros que se pueden eliminar
							}
						} else if (modulo.equals("Clientes")) {
								if (opcion == null || opcion.isEmpty())
									break;
								else if (opcion.equals("Agregar")) {
									this.nuevoCliente();
								} else if (opcion.equals("Modificar")) {
									this.buscarCliente();	// usar datos para filtrar
									this.listarCliente();	// mostrar registros que se pueden modificar
									
									// Indicar registro a modificar
									// Leer el valor de la columna desde el teclado
									if (userIndex < 0) {
										System.out.println("Registro a modificar : ");
										try {
											dato = in.readLine();
										} catch (IOException e) {
											e.printStackTrace();
										}
										
										userIndex = Integer.parseInt(dato);
									}
									
									this.modificaCliente(userIndex);	// modifica el prospecto indicado por el indice
									userIndex = -1;
								} else if (opcion.equals("Eliminar")) {
									this.buscarCliente();	// usar datos para filtrar
									this.listarCliente();	// mostrar registros que se pueden eliminar
									
									// Indicar registro a eliminar
									// Leer el valor del registro desde el teclado
									if (userIndex < 0) {
										System.out.println("Registro a eliminar : ");
										try {
											dato = in.readLine();
										} catch (IOException e) {
											e.printStackTrace();
										}
										
										userIndex = Integer.parseInt(dato);
									}
									this.eliminarCliente(userIndex);	// elimina el prospecto indicado por el indice
									userIndex = -1;
								} else if (opcion.equals("Buscar")) {
									this.buscarCliente();
								} else if (opcion.equals("Listar")) {
									this.listarCliente();	// mostrar registros que se pueden eliminar
								}
						} else if (modulo == null || modulo.isEmpty()) {
							opcion = null;
							break;
						}
						
					} while (opcion != null && !opcion.isEmpty());
				}
			} while (modulo != null && !modulo.isEmpty());
			intentos = 3;
		} while (intentos > 0);
		System.out.println("Gracias por usar nuestro servicio.");
	}
		
}
