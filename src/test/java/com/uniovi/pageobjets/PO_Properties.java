package com.uniovi.pageobjets;

import java.util.Locale;
import java.util.ResourceBundle;

public class PO_Properties {
	public static int getSPANISH() {
		return SPANISH;
	}

	public static int getENGLISH() {
		return ENGLISH;
	}

	static private String Path;
	static int SPANISH = 0;
	static int ENGLISH = 1;
	static Locale[] idioms = new Locale[] { new Locale("ES"), new Locale("EN") };

	public PO_Properties(String Path) {
		PO_Properties.Path = Path;
	}

	public String getString(String prop, int locale) {

		ResourceBundle bundle = ResourceBundle.getBundle(Path, idioms[locale]);
		return bundle.getString(prop);
	}

}
