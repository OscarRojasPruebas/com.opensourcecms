package com.automatitaonpractice.pageoprs;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.automatitaonpractice.pagesobjs.GestionUsuario_objs;
import com.opensourcecms.util.Utils;

public class GestionUsuario_oprs extends GestionUsuario_objs {

	Utils utils = new Utils();

	public GestionUsuario_oprs(WebDriver webDriver) {
		super(webDriver);
	}

	public void seleccionarItem() {

		utils.espera(3);
		itemMenuUsers.click();
		utils.waitForElementToAppear(itemAddNew, 20);
		itemAddNew.click();

	}

	public void llenarCamposNuevoUsuario(Map<String, String> lista) {
		utils.waitForElementToAppear(inputUserName, 20);
		inputUserName.sendKeys(lista.get("NOMBREUSUARIO"));
		inputEmail.sendKeys(lista.get("EMAIL"));
		inputFirstName.sendKeys(lista.get("FIRSNAME"));
		inputLastName.sendKeys(lista.get("LASTNAME"));
		showPassword.click();
		if (inputShowPassword.getText().isEmpty()) {
			inputShowPassword.sendKeys("aklsdmlaksmKMLLkalk2323");
		}
		buttonNewUser.click();
		utils.espera(3);
		if (buttonNewUser.isDisplayed()) {
			buttonNewUser.click();
		}
	}

	public String validarRegistroExitoso() {
		String resultado = "";
		utils.espera(4);
		if (mensajeError.isDisplayed()) {
			resultado = mensajeError.getText();
		}
		return resultado == "" ? "New user created. Edit user" : resultado;
	}
}
