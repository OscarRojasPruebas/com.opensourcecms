package com.opensourcecms.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

	public static WebDriver webdriver;

	public void setDriver(WebDriver webdriver) {
		Utils.webdriver = webdriver;
	}

	public void espera(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void waitForElementToAppear(WebElement webElement, long timeOutInSeconds) {
		for (int i = 0; i <= timeOutInSeconds; i++) {
			espera(1);
			if (existElement(webElement)) {
				break;
			}
		}
	}

	public boolean existElement(WebElement webElement) {
		try {
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
