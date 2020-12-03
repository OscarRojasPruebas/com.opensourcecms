package com.automatitaonpractice.pagesobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class InicioSesion_objs extends PageObject {

	public WebDriver webDriver;

	public InicioSesion_objs(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath = "//*[@id='user_login']")
	public WebElement inputUserName;
	
	
	@FindBy(xpath = "//*[@id='user_pass']")
	public WebElement inputPassword;
	
	@FindBy(xpath = "//*[@id=\"wp-submit\"]")
	public WebElement inputLogIn;
	
	//Elemento para validar sesion
	
	@FindBy(xpath = "//*[@id=\"wp-admin-bar-my-account\"]/a/span")
	public WebElement spanUser;
	
}
