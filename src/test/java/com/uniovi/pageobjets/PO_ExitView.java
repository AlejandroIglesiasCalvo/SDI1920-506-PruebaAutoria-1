package com.uniovi.pageobjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uniovi.test.util.SeleniumUtils;

public class PO_ExitView extends PO_NavView {
	public static void Exit(WebDriver driver) {
		By boton = By.linkText("Desconectar");
		driver.findElement(boton).click();
	}

	static public void checkLogOut(WebDriver driver, int language) {
		SeleniumUtils.EsperaCargaPagina(driver, "text", p.getString("login.message", language), getTimeout());
	}
}
