package vista;

public class start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Programa de inicio a la aplicación
		CRM crmEngine = new CRM();
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
		
		crmEngine.run();
	}

}
