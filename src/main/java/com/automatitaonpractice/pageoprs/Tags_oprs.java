package com.automatitaonpractice.pageoprs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automatitaonpractice.pagesobjs.Tags_objs;
import com.opensourcecms.util.Utils;

public class Tags_oprs extends Tags_objs {

	public Tags_oprs(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	Utils utils = new Utils();
	String strTagName = "";

	public void seleccionarItem() {

		utils.espera(3);
		if (itemMenuPost.isDisplayed()) {
			itemMenuPost.click();
		}
		utils.waitForElementToAppear(itemMenuTag, 20);
		itemMenuTag.click();
	}

	public void agregarNuevaEtiqueta(Map<String, String> map) {

		utils.waitForElementToAppear(inputTagname, 20);
		strTagName = map.get("NOMBRE");
		inputTagname.sendKeys(strTagName);
		inputtagSlug.sendKeys(map.get("SLUG"));
		inputtagDescription.sendKeys(map.get("DESCRIPTION"));
		buttonAddNewTag.click();

	}

	public boolean validarNuevoTag() {
	    boolean resultado = false;
		List<WebElement> elemen = elementosTabla();
		for (WebElement elements : elemen) {
			String resultad = elements.getText();
			if (resultad.contains(strTagName)) {
				resultado =  true;
				break;
			}
		}
		return resultado;
	}
}
