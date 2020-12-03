package com.automatitaonpractice.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automatitaonpractice.pageoprs.GestionUsuario_oprs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class GestionUsuario_stepdefinition {
	
	WebDriver driver;
	GestionUsuario_oprs gestionUsuario_oprs = new GestionUsuario_oprs(driver);
	String strUserName = "";
	
	@Given("que me dirijo al menu users y selecciono add New")
	public void que_me_dirijo_al_menu_users_y_selecciono_add_New() {
	    // Write code here that turns the phrase above into concrete actions
		gestionUsuario_oprs.seleccionarItem();
	}

	@Given("el sistema me muestre el formulario de agregar un nuevo usuario ingreso los campos requeridos")
	public void el_sistema_me_muestre_el_formulario_de_agregar_un_nuevo_usuario_ingreso_los_campos_requeridos(DataTable dataTable) {
	
		List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
		strUserName = lista.get(0).get("NOMBREUSUARIO");
		gestionUsuario_oprs.llenarCamposNuevoUsuario(lista.get(0));
	}

	@Given("valido que el usuario se registre correctamente")
	public void valido_que_el_usuario_se_registre_correctamente() {
	    // Write code here that turns the phrase above into concrete actions
		String mensajeresultado = gestionUsuario_oprs.validarRegistroExitoso();
	    assertTrue("El usuario no pudo ser registrado: Mensaje : " + mensajeresultado, mensajeresultado.contains("New user created. Edit user"));
	}


}
