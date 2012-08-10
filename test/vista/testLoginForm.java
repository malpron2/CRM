package vista;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testLoginForm {
	CRM crmEngine = new CRM();
	ArrayList<String> menuArray = new ArrayList<String>();
	
	@Before
	public void initialize() {
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
		
		menuArray.add("1. Modulo de Prospectos");
		menuArray.add("2. Modulo de Clientes");
		menuArray.add("3. Modulo de Ventas");
		menuArray.add("4. Modulo de Compras");
		menuArray.add("5. Modulo de Grupos de Estudio");
		menuArray.add("6. Modulo de Usuarios");
		menuArray.add("7. Modulo de Roles");
		menuArray.add("0. Salir");
		
	}
	
	@Test
	public void systemAuthorizationOk() {
		assertEquals(true, crmEngine.login());
	}
	
	@Test
	public void systemAuthorizationBad() {
		crmEngine.setUser("unknown");
		crmEngine.setPassword("");
		assertEquals(false, crmEngine.login());
	}
	
	@Test
	public void systemAuthorizationBadPassword() {
		crmEngine.setUser("admin");
		crmEngine.setPassword("password");
		assertEquals(false, crmEngine.login());
	}
	
	@Test
	public void showAuthorizedMenu() {
		ArrayList<String> ls = crmEngine.menu();
		
		for (String s : ls) {
			System.out.println(s);
		}
		assertEquals(true, menuArray.equals(crmEngine.menu()));
	}
	
	@Test
	public void showAutorizedRestrictedMenu() {
		menuArray.clear();
		menuArray.add("1. Modulo de Prospectos");
		menuArray.add("2. Modulo de Clientes");
		menuArray.add("3. Modulo de Ventas");
		menuArray.add("4. Modulo de Compras");
		menuArray.add("5. Modulo de Grupos de Estudio");
		menuArray.add("6. ................");
		menuArray.add("7. ................");
		menuArray.add("0. Salir");
		crmEngine.setUser("operador");
		crmEngine.setPassword("0p3r4d0r");
		
		ArrayList<String> ls = crmEngine.menu();
		for (String s : ls) {
			System.out.println(s);
		}
		assertEquals(true, menuArray.equals(crmEngine.menu()));
	}
}
