package vista;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.FormProspecto;

public class testProspectoForm {
	CRM crmEngine = new CRM();
	
	@Before
	public void inicializar() {
		// Configura el sistema
		crmEngine.loadTestData();
		crmEngine.setCompanyName("Instituto Benedictino");
		crmEngine.setIGV(18.00);
		crmEngine.setUser("admin");
		crmEngine.setPassword("Curs0d3p002012");
		crmEngine.setLocalCurrency("Sol");
		//crmEngine.addForeignCurrency("USD", "US$", 2.65);
		crmEngine.setSystemDateFormat("dd/mm/yyyy");
		crmEngine.setSystemDecimalFormat("#,###,##0.00");
	}
	
	@After
	public void finalizar() {
		crmEngine.resetSecuencias();
	}
	
	@Test
	public void testAgregarForm() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de datos
		input.add("1");  // No se va a añadir, pero es necesario para que tenga la cantidad de elementos completa
		input.add("Juan");
		input.add("Perez");
		input.add("Rojas");
		input.add("juanperez@hotmail.com");
		input.add("16201123");
		input.add("720-1222");
		input.add("01/01/2012");
		
		// Editar un nuevo prospecto
		crmEngine.setProspectoInputArray(input);
		crmEngine.nuevoProspecto();
		crmEngine.listarProspecto();
	}
	
	@Test
	public void testBuscarForm() {
		ArrayList<String> input = new ArrayList<String>();
		
		// Simulacion de ingreso de criterios de búsqueda
		input.add(null);	// codigo
		input.add(null);	// nombre
		input.add(null);	// apellido paterno
		input.add(null);	// apellido materno
		input.add(null);	// correo
		input.add("16201123");	// DNI
		input.add(null);	// telefono
		input.add(null);	// fecha de contacto
		
		// Ingresar los datos a filtrar
		crmEngine.setProspectoInputArray(input);
		crmEngine.buscarProspecto();
		
		// Emitir listado de registros coincidentes
		crmEngine.listarProspecto();
	}
	
	@Test
	public void testModificarForm() {
		ArrayList<String> input = new ArrayList<String>();
		int userIndex = 0;
		
		// Simulacion de ingreso de criterios de búsqueda
		input.add(null);	// codigo
		input.add(null);	// nombre
		input.add(null);	// apellido paterno
		input.add(null);	// apellido materno
		input.add(null);	// correo
		input.add("16201123");	// DNI
		input.add(null);	// telefono
		input.add(null);	// fecha de contacto
		
		// Modificar un prospecto existente
		crmEngine.setProspectoInputArray(input);	// asignar datos a formulario
		crmEngine.buscarProspecto();	// usar datos para filtrar
		crmEngine.listarProspecto();	// mostrar registros que se pueden modificar
		
		// Simulacion de modificación de datos
		input.clear();
		input.add(null);	// codigo, no se va a añadir, pero debe incluirse en el arreglo
		input.add("Juanito");	// nombre
		input.add(null);	// apellido paterno
		input.add("Quispe");	// apellido materno
		input.add("juanito@hotmail.com");	// correo
		input.add(null);	// DNI
		input.add(null);	// telefono
		input.add(null);	// fecha de contacto
		
		crmEngine.setProspectoInputArray(input);	// asignar datos a formulario
		// Indicar el prospecto a modificar, userIndex indica el valor
		// interno de base de datos a modificar, se debe conseguir
		// con una conversion de la entrada del usuario por pantalla
		// hacia el indice que corresponda (en progreso...)
		crmEngine.modificaProspecto(userIndex);	// modifica el prospecto indicado por el indice
		
		// Listar la modificación
		crmEngine.listarProspecto();
	}
}
