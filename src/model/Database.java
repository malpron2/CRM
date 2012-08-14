package model;

import java.util.ArrayList;

public class Database {
	ArrayList<Prospecto> prospectoData = new ArrayList<Prospecto>();
	ArrayList<Cliente> clienteData = new ArrayList<Cliente>();
	ArrayList<Venta> ventaData = new ArrayList<Venta>();
	ArrayList<Compra> compraData = new ArrayList<Compra>();
	ArrayList<GrupoEstudio> grupoEstudioData = new ArrayList<GrupoEstudio>();
	ArrayList<Usuario> usuarioData = new ArrayList<Usuario>();
	ArrayList<Rol> rolData = new ArrayList<Rol>();
	ArrayList<Currency> currencyData = new ArrayList<Currency>();
	ArrayList<Modulo> moduloData = new ArrayList<Modulo>();
	ArrayList<Opcion> opcionData = new ArrayList<Opcion>();

	// Instanciador
	public Database() {
		moduloData.add(new Modulo("Prospectos"   ,"Modulo de Prospectos"       ,true));
		moduloData.add(new Modulo("Clientes"     ,"Modulo de Clientes"         ,true));
		moduloData.add(new Modulo("Ventas"       ,"Modulo de Ventas"           ,true));
		moduloData.add(new Modulo("Compras"      ,"Modulo de Compras"          ,true));
		moduloData.add(new Modulo("GruposEstudio","Modulo de Grupos de Estudio",true));
		moduloData.add(new Modulo("Usuarios"     ,"Modulo de Usuarios"         ,true));
		moduloData.add(new Modulo("Roles"        ,"Modulo de Roles"            ,true));
		
		opcionData.add(new Opcion("Agregar"   ,"Nuevo registro"       ,true));
		opcionData.add(new Opcion("Modificar" ,"Modificar registro"   ,true));
		opcionData.add(new Opcion("Eliminar"  ,"Eliminar registro"    ,true));
		opcionData.add(new Opcion("Buscar"    ,"Buscar registro"      ,true));
		opcionData.add(new Opcion("Listar"    ,"Listar registro"      ,true));
	}
	
	// Generar datos de prueba
	public void loadTestData() {
		// Prospectos de Clientes
		prospectoData.add(new Prospecto("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1221","2012/01/01"));
		prospectoData.add(new Prospecto("Maria","Ocaña","Rios","mariaocana@hotmail.com","12345667","720-1222","2012/05/07"));
		prospectoData.add(new Prospecto("Gabriel","Osorio","Iriarte","gabrielosorio@hotmail.com","87654321","720-1223","2012/06/15"));
		prospectoData.add(new Prospecto("Raul","Quispe","Mendizabal","raulquispe@msn.com","87654321","720-1222","2012/04/21"));
		prospectoData.add(new Prospecto("Miguel","Huaman","Flor","miguelhuaman@msn.com","12345667","720-1224","2012/01/18"));
		prospectoData.add(new Prospecto("Karina","Pita","Branco","karinapita@gmail.com","16201123","720-1222","2012/07/22"));
		prospectoData.add(new Prospecto("Olga","Julca","Zambrano","olgajulca@gmail.com","87654321","720-1225","2012/05/28"));
		prospectoData.add(new Prospecto("Susana","Chavez","Garcia","susanachavez@yahoo.com","16201123","720-1222","2012/03/09"));
		prospectoData.add(new Prospecto("Mariela","Ugarte","Velez","marielaugarte@yahoo.com","12345667","720-1226","2012/11/24"));
		
		clienteData.add(new Cliente("Jose","Leon","Calderon","joseleon@yahoo.com","12345667","720-1226","2012/11/24","2012/11/24"));
		
		// Monedas
		currencyData.add(new Currency("SOL", "S/.", 1.00));
		currencyData.add(new Currency("DOL", "US$", 2.65));
		
		// Permisos por Rol (Modulo, Consultar, Agregar, Modificar, Eliminar)
		ArrayList<Permiso> permisoRAdmin = new ArrayList<Permiso>();
		permisoRAdmin.add(new Permiso("Prospectos"   , true, true, true, true, true));
		permisoRAdmin.add(new Permiso("Clientes"     , true, true, true, true, true));
		permisoRAdmin.add(new Permiso("Compras"      , true, true, true, true, true));
		permisoRAdmin.add(new Permiso("Ventas"       , true, true, true, true, true));
		permisoRAdmin.add(new Permiso("GruposEstudio", true, true, true, true, true));
		permisoRAdmin.add(new Permiso("Usuarios"     , true, true, true, true, true));
		permisoRAdmin.add(new Permiso("Roles"        , true, true, true, true, true));

		ArrayList<Permiso> permisoROperador = new ArrayList<Permiso>();
		permisoROperador.add(new Permiso("Prospectos"   , true, true, true, true, false));
		permisoROperador.add(new Permiso("Clientes"     , true, true, true, true, true));
		permisoROperador.add(new Permiso("Compras"      , true, true, true, true, true));
		permisoROperador.add(new Permiso("Ventas"       , true, true, true, true, true));
		permisoROperador.add(new Permiso("GruposEstudio", true, true, true, true, true));
		permisoROperador.add(new Permiso("Usuarios"     , false, true, true, true, true));
		permisoROperador.add(new Permiso("Roles"        , false, true, true, true, true));

		// Roles
		rolData.add(new Rol("radmin", permisoRAdmin));
		rolData.add(new Rol("roperador", permisoROperador));
		
		// Usuarios
		usuarioData.add(new Usuario("admin","Curs0d3p002012",
				"06259735","Jorge","Cabezudo","Perez","jorge.cabezudo@gmail.com",
				"2012/07/08","Administrador","radmin"));
		usuarioData.add(new Usuario("operador","0p3r4d0r",
				"06259735","Ruth","Navarro","Guevara","ruth.navarro@gmail.com",
				"2012/07/18","Operador","roperador"));
	}

	public Usuario getUsuario(String p_atributo, String p_valor) {
		Usuario usuarioFound = null;
		// retornar el objeto que coincide con el valor del atributo
		for (Usuario u : usuarioData) {
			if (p_atributo.equals("cuenta")) {
				if (u.getCuenta().equals(p_valor)) {
					usuarioFound = u;
				}
			}
		}
		return usuarioFound;
	}

	public Currency getCurrency(String p_atributo, String p_valor) {
		Currency currencyFound = null;
		// retornar el objeto que coincide con el valor del atributo
		for (Currency c : currencyData) {
			if (p_atributo.equals("currencyName")) {
				if (c.getCurrencyName().equals(p_valor)) {
					currencyFound = c;
				}
			}
		}
		return currencyFound;
	}

	public ArrayList<Modulo> getModulos() {
		return this.moduloData;
	}

	public ArrayList<Permiso> getPermisos(String p_userName) {
		ArrayList<Permiso> permisoList = null;
		for (Usuario u : usuarioData) {
			if (u.getCuenta().equals(p_userName)) {
				for (Rol r : rolData) {
					if (u.getRol().equals(r.getNombre())) {
						permisoList = r.getPermisoList();
					}
				}
			}
		}
		return permisoList;
	}

	public ArrayList<Opcion> getOpciones() {
		return this.opcionData;
	}

	public void addProspecto(Prospecto p) {
		prospectoData.add(p);
	}

	public ArrayList<Prospecto> getProspectos() {
		return prospectoData;
	}
	
	public void addCliente(Cliente c) {
		clienteData.add(c);
	}
	
	public ArrayList<Cliente> getClientes() {
		return clienteData;
	}
	
	public void resetSecuencias() {
		Secuencia.reset();
	}
}
