package com.automatitaonpractice.pagesobjs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class Tags_objs extends PageObject  {

	
	public WebDriver webDriver;

	public Tags_objs(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	// ITEM PARA DE DESPLEGAR OPCIONES DE  POST
	
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/a/div[3]")
	public WebElement itemMenuPost;
	
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[5]/a")
	public WebElement itemMenuTag;
	
	@FindBy(xpath = "//*[@id=\"tag-name\"]")
	public WebElement inputTagname;
	
	@FindBy(xpath = "//*[@id=\"tag-slug\"]")
	public WebElement inputtagSlug;
	
	@FindBy(xpath = "//*[@id=\"tag-description\"]")
	public WebElement inputtagDescription;
	
	@FindBy(xpath = "//*[@id=\"submit\"]")
	public WebElement buttonAddNewTag;
	
	@FindBy(xpath = "//*[@id=\"posts-filter\"]/table")
	public WebElement tableListTag;

	public List<WebElement> elementosTabla() {
		List<WebElement> elemen = tableListTag.findElements(By.tagName("tr"));
		return elemen;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
