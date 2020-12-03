package com.automatitaonpractice.pageoprs;

import org.openqa.selenium.WebDriver;

import com.automatitaonpractice.pagesobjs.InicioSesion_objs;
import com.opensourcecms.util.Utils;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://s1.demo.opensourcecms.com/wordpress/wp-login.php")
public class InicioSesion_oprs extends InicioSesion_objs {

	Utils utils =  new Utils();
	public InicioSesion_oprs(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void iniciarSesion(String strusername, String strpassword) {
		inputUserName.sendKeys(strusername);
		inputPassword.sendKeys(strpassword);
		inputLogIn.click();
	}
	
	public String validarInicioSesion() {
		String textValidaUser = spanUser.isDisplayed() ? spanUser.getText() : "El log in no fue exitoso" ;
		return textValidaUser;
	}
}
