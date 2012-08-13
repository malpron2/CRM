package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.FormProspecto;

public class testProspectoForm {
	CRM crmEngine = new CRM();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
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
		input.add("Gabriel");
		input.add("Sanchez");
		input.add("Huaman");
		input.add("gabrielsanchez@hotmail.com");
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
		String dato = null;
		int userIndex = 2;
		
		// Simulacion de ingreso de criterios de búsqueda
		input.add(null);	// codigo
		input.add(null);	// nombre
		input.add(null);	// apellido paterno
		input.add(null);	// apellido materno
		input.add(null);	// 1correo
		input.add("16201123");	// DNI
		input.add(null);	// telefono
		input.add(null);	// fecha de contacto
		
		// Modificar un prospecto existente
		crmEngine.setProspectoInputArray(input);	// asignar datos a formulario
		crmEngine.buscarProspecto();	// usar datos para filtrar
		crmEngine.listarProspecto();	// mostrar registros que se pueden modificar
		
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
		crmEngine.modificaProspecto(userIndex);	// modifica el prospecto indicado por el indice
		
		// Listar la modificación
		crmEngine.listarProspecto();
	}

	@Test
	public void testEliminarForm() {
		ArrayList<String> input = new ArrayList<String>();
		String dato = null;
		int userIndex = -1;
		
		// Simulacion de ingreso de criterios de búsqueda
		input.add(null);	// codigo
		input.add(null);	// nombre
		input.add(null);	// apellido paterno
		input.add(null);	// apellido materno
		input.add(null);	// 1correo
		input.add("16201123");	// DNI
		input.add(null);	// telefono
		input.add(null);	// fecha de contacto
		
		// Eliminar un prospecto existente
		crmEngine.setProspectoInputArray(input);	// asignar datos a formulario
		crmEngine.buscarProspecto();	// usar datos para filtrar
		crmEngine.listarProspecto();	// mostrar registros que se pueden eliminar
		
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
		crmEngine.eliminarProspecto(userIndex);	// elimina el prospecto indicado por el indice
		crmEngine.listarProspecto();	// mostrar registros, no debe aparecer el eliminado
	}
}
