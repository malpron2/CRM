package vista;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testMenuForm {
	CRM crmEngine = new CRM();
	ArrayList<String> formArray = new ArrayList<String>();
	
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
		
		formArray.add("1. Nuevo registro");
		formArray.add("2. Modificar registro");
		formArray.add("3. Eliminar registro");
		formArray.add("4. Buscar registro");
		formArray.add("5. Listar registro");
		formArray.add("0. Salir");
	}
	
	@Test
	public void testMenuOpcion() {
		ArrayList<String> ls = crmEngine.opcion("Prospectos");
		for (String s : ls) {
			System.out.println(s);
		}
		assertEquals(true, formArray.equals(crmEngine.opcion("Prospectos")));
	}

	@Test
	public void testRestrictedMenuOpcion() {
		formArray.clear();
		formArray.add("1. Nuevo registro");
		formArray.add("2. Modificar registro");
		formArray.add("3. Eliminar registro");
		formArray.add("4. ................");
		formArray.add("5. ................");
		formArray.add("0. Salir");
		crmEngine.setUser("operador");
		crmEngine.setPassword("0p3r4d0r");
		
		ArrayList<String> ls = crmEngine.opcion("Prospectos");
		for (String s : ls) {
			System.out.println(s);
		}
		assertEquals(true, formArray.equals(crmEngine.opcion("Prospectos")));
	}

}
