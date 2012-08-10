package vista;

import java.util.ArrayList;

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
	public void testModificarForm() {
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
		
		// Modificar un prospecto existente
		crmEngine.setProspectoInputArray(input);
		crmEngine.nuevoProspecto();
		crmEngine.listarProspecto();
	}
}
