package com.automatitaonpractice.pagesobjs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class GestionUsuario_objs extends PageObject {
	
	public WebDriver webDriver;

	public GestionUsuario_objs(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	
	// ITEM PARA DE DESPLEGAR OPCIONES DE GESTION
	
	@FindBy(xpath = "//*[@id=\"menu-users\"]/a/div[3]")
	public WebElement itemMenuUsers;
	
	// PROCESO DE AGREGAR USUARIO
	
	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[3]/a")
	public WebElement itemAddNew;
	
	//FORMULARIO
	@FindBy(xpath = "//*[@id=\"user_login\"]")
	public WebElement inputUserName;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	public WebElement inputEmail;
	
	
	@FindBy(xpath = "//*[@id=\"first_name\"]")
	public WebElement inputFirstName;
	
	@FindBy(xpath = "//*[@id=\"last_name\"]")
	public WebElement inputLastName;
	
	@FindBy(xpath = "//*[@id=\"createusersub\"]")
	public WebElement buttonNewUser;
	
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[5]/div[1]")
	public WebElement mensajeError;
	
	@FindBy(xpath = "//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	public WebElement showPassword;
	
	@FindBy(xpath = "//*[@id=\"pass1-text\"]")
	public WebElement inputShowPassword;
	
	
	
	
	
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[5]/form/table")
	public WebElement tableListUser;
	
	
	public List<WebElement> elementosTabla() {
		List<WebElement> elemen = tableListUser.findElements(By.tagName("tr"));
		return elemen;
	}
	
	
	
	
	
	

}
