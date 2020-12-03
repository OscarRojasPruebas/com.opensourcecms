package com.automatitaonpractice.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automatitaonpractice.pageoprs.Tags_oprs;
import com.opensourcecms.util.Utils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tags_stepdefinition {

	WebDriver driver;
//	Utils utils = new Utils();
	Tags_oprs tags_oprs = new Tags_oprs(Utils.webdriver);

	Map<String, String> parametrosNuevaEtiqueta = new HashMap<String, String>();

	@Given("que me dirijo al menu post y selecciono Tags")
	public void que_me_dirijo_al_menu_post_y_selecciono_Tags() {
		tags_oprs.seleccionarItem();
	}

	@When("el sistema muestre el formulario de agregar un nueva etiqueta, completo los campos requeridos")
	public void el_sistema_muestre_el_formulario_de_agregar_un_nueva_etiqueta_completo_los_campos_requeridos(
			DataTable dataTable) {
		List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
		parametrosNuevaEtiqueta = lista.get(0);
		tags_oprs.agregarNuevaEtiqueta(parametrosNuevaEtiqueta);

	}

	@Then("valido que la etiqueta se registre correctamente")
	public void valido_que_la_etiqueta_se_registre_correctamente() {
		// Write code here that turns the phrase above into concrete actions
		assertTrue("El tag no se creo correctamente", tags_oprs.validarNuevoTag());
	}

}
