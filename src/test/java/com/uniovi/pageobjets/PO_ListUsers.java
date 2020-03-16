package com.uniovi.pageobjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_ListUsers extends PO_NavView {

	public static void fillSearchText(WebDriver driver, String searchTextp) {
		WebElement searchText = driver.findElement(By.name("searchText"));
		searchText.click();
		searchText.clear();
		searchText.sendKeys(searchTextp);
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}

}
