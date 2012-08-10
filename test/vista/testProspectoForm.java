package vista;

import org.junit.Before;
import org.junit.Test;

import controlador.FormProspecto;

public class testProspectoForm {
	@Before
	public void inicializar() {
		
	}
	
	@Test
	public void testAgregarForm() {
		FormProspecto fp = new FormProspecto();
		// Prepara el formulario para ingresar un nuevo prospecto
		fp.nuevo();
	}
}
