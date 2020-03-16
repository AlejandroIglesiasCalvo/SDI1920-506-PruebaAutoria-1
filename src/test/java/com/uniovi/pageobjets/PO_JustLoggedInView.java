package com.uniovi.pageobjets;

import org.openqa.selenium.WebDriver;

import com.uniovi.test.util.SeleniumUtils;

public class PO_JustLoggedInView extends PO_NavView {

	static public void checkAuthenticated(WebDriver driver, int language) {
		SeleniumUtils.EsperaCargaPagina(driver, "text", p.getString("authenticateduser.message", language),
				getTimeout());
	}
}
