package com.automatitaonpractice.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automatitaonpractice.pageoprs.InicioSesion_oprs;
import com.opensourcecms.util.Utils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class InicioSesion_stepdefinition {

	WebDriver driver;
	InicioSesion_oprs inicioSesion_oprs = new InicioSesion_oprs(driver);
	String strusuario;
	Utils utils = new Utils();

	@Given("que accedo al sitio")
	public void que_accedo_al_sitio() {
		// Write code here that turns the phrase above into concrete actions
		inicioSesion_oprs.open();
		inicioSesion_oprs.getDriver().manage().window().maximize();
		utils.setDriver(inicioSesion_oprs.getDriver());
	}

	@Then("me autentico con las credenciales")
	public void me_autentico_con_las_credenciales(DataTable dataTable) {
		List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
		strusuario = lista.get(0).get("Usuario");
		inicioSesion_oprs.iniciarSesion(strusuario, lista.get(0).get("Clave"));
	}

	@Then("valido que el ingreso sea exitoso")
	public void valido_que_el_ingreso_sea_exitoso() {
		// Write code here that turns the phrase above into concrete actions
		String resultado = inicioSesion_oprs.validarInicioSesion();
		assertTrue(resultado, resultado.contains(strusuario));
	}

}
