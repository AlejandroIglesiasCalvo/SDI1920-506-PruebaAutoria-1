package com.uniovi;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.pageobjets.PO_AddPublicationView;
import com.uniovi.pageobjets.PO_AdminLoginView;
import com.uniovi.pageobjets.PO_ExitView;
import com.uniovi.pageobjets.PO_HomeView;
import com.uniovi.pageobjets.PO_JustLoggedInView;
import com.uniovi.pageobjets.PO_ListUsers;
import com.uniovi.pageobjets.PO_LoginView;
import com.uniovi.pageobjets.PO_NavView;
import com.uniovi.pageobjets.PO_Properties;
import com.uniovi.pageobjets.PO_RegisterView;
import com.uniovi.pageobjets.PO_View;
import com.uniovi.test.util.SeleniumUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sdi1920Entrega1506ApplicationTests {

	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox65 = "D:\\ProgramasInstalados\\Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\alejandro\\Downloads\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	// En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas):
	// static String PathFirefox65 =
	// "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
	// static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	static public void begin() {
	}

	@AfterClass
	static public void end() {
		driver.quit();
	}

//	// Registro de Usuario con datos válidos
//	@Test
//	public void PR01() {
//		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//		PO_RegisterView.fillForm(driver, "prueb1@email.com", "Pedo", "letras", "123456", "123456");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//	}
//
//	// Registro de Usuario con datos inválidos (email vacío, nombre vacío, apellidos
//	// Error.signup.email.length
//
//	// vacíos).
//	@Test
//	public void PR02() {
//		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//		PO_RegisterView.fillForm(driver, " ", "a", "b", "123456", "123456");
//		PO_View.getP();
//		PO_RegisterView.checkKey(driver, "Error.empty", PO_Properties.getSPANISH());
//	}
//
//	// Registro de Usuario con datos inválidos (repetición de contraseña inválida).
//	@Test
//	public void PR03() {
//		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//		PO_RegisterView.fillForm(driver, "prueba2@email.es", "Pedro", "numeros", "123456", "123458");
//		PO_View.getP();
//		PO_RegisterView.checkKey(driver, "Error.signup.passwordConfirm.coincidence", PO_Properties.getSPANISH());
//	}
//
//	// Registro de Usuario con datos inválidos (email existente) 99999990A@uniovi.es
//	@Test
//	public void PR04() {
//		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//		PO_RegisterView.fillForm(driver, "99999990A@uniovi.es", "Pedo", "letras", "123456", "123456");
//		PO_View.getP();
//		PO_RegisterView.checkKey(driver, "Error.signup.email.duplicate", PO_Properties.getSPANISH());
//	}
//
//	// Inicio de sesión con datos válidos (administrador)
//	@Test
//	public void PR05() {
//		driver.navigate().to("http://localhost:8090/admin/login");
//		PO_AdminLoginView.fillForm(driver, "admin@email.com", "admin");
//		PO_LoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//	}
//
//	// Inicio de sesión con datos válidos (usuario estándar)
//	@Test
//	public void PR06() {
//		driver.navigate().to("http://localhost:8090/login");
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_LoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//	}
//
//	// Inicio de sesión con datos inválidos (usuario estándar, campo email y
//	// contraseña vacíos).
//	@Test
//	public void PR07() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, " ", " ");
//		PO_LoginView.checkInvalidLogIn(driver, PO_Properties.getSPANISH());
//	}
//
//	// Inicio de sesión con datos válidos (usuario estándar, email existente, pero
//	// contraseña incorrecta).
//	@Test
//	public void PR08() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "casa");
//		PO_LoginView.checkInvalidLogIn(driver, PO_Properties.getSPANISH());
//	}
//
//	// Hacer click en la opción de salir de sesión y comprobar que se redirige a la
//	// página de inicio de sesión (Login)
//	@Test
//	public void PR09() {
//		driver.navigate().to("http://localhost:8090/login");
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_LoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//		PO_ExitView.Exit(driver);
//		PO_ExitView.checkLogOut(driver, PO_Properties.getSPANISH());
//	}
//
//	// Comprobar que el botón cerrar sesión no está visible si el usuario no está
//	// autenticado
//	@Test
//	public void PR10() {
//		SeleniumUtils.textoNoPresentePagina(driver, "Desconectar");
//	}
//
//	// Mostrar el listado de usuarios y comprobar que se muestran todos los que
//	// existen en el sistema
//	@Test
//	public void PR11() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/list')]");
//		elementos.get(0).click();
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr", PO_View.getTimeout());
//		assertTrue(elementos.size() == 5);
//	}
//
////	Hacer una búsqueda con el campo vacío y comprobar que se muestra la página que
////	corresponde con el listado usuarios existentes en el sistema.
//	@Test
//	public void PR12() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/list')]");
//		elementos.get(0).click();
//		PO_ListUsers.fillSearchText(driver, "");
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr", PO_View.getTimeout());
//		assertTrue(elementos.size() == 5);
//	}
//
//	// Hacer una búsqueda escribiendo en el campo un texto que no exista y comprobar
//	// que se
//	// muestra la página que corresponde, con la lista de usuarios vacía
//	@Test
//	public void PR13() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/list')]");
//		elementos.get(0).click();
//		PO_ListUsers.fillSearchText(driver, "ornitorrinco");
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class", "col-md-1", PO_View.getTimeout());
//		assertTrue(elementos.size() == 1);
//	}
//
////	Hacer una búsqueda con un texto específico y comprobar que se muestra la página que
////	corresponde, con la lista de usuarios en los que el texto especificados sea parte de su nombre, apellidos o
////	de su email.
//	@Test
//	public void PR14() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/list')]");
//		elementos.get(0).click();
//		PO_ListUsers.fillSearchText(driver, "ar");
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr", PO_View.getTimeout());
//		assertTrue(elementos.size() == 2);
//	}
//
//	@Test
//	public void PR15() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/list')]");
//		elementos.get(0).click();
//		By enlace = By.xpath("//td[contains(text(), 'Pelayo')]/following-sibling::*[3]");
//		SeleniumUtils.esperarSegundos(driver, 1);
//		driver.findElement(enlace).click();
//		PO_View.checkElement(driver, "id", "cancelRequestButton6");
//	}
//
////	Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un usuario al
////	que ya le habíamos enviado la invitación previamente. No debería dejarnos enviar la invitación, se podría
////	ocultar el botón de enviar invitación o notificar que ya había sido enviada previamente.
//	@Test
//	public void PR16() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/list')]");
//		elementos.get(0).click();
//		By enlace = By.xpath("//td[contains(text(), 'Pelayo')]/following-sibling::*[3]");
//		SeleniumUtils.esperarSegundos(driver, 1);
//		driver.findElement(enlace).click();
//		PO_View.checkElement(driver, "id", "cancelRequestButton6");
//	}
//
//	@Test
//	public void PR17() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/friendRequests')]");
//		elementos.get(0).click();
//		elementos = PO_View.checkElement(driver, "free", "//td/following-sibling::*[1]");
//		assertTrue(elementos.size() == 2);
//	}
//
////	Sobre el listado de invitaciones recibidas. Hacer click en el botón/enlace de una de ellas y
////	comprobar que dicha solicitud desaparece del listado de invitaciones.
//	@Test
//	public void PR18() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/friendRequests')]");
//		elementos.get(0).click();
//		elementos = PO_View.checkElement(driver, "free", "//td[contains(text(), 'Marta')]/following-sibling::*[1]");
//		elementos.get(0).click();
//		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Marta", PO_View.getTimeout());
//	}
//
//	@Test
//	public void PR19() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos;
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/friends')]");
//		elementos.get(0).click();
//		elementos = PO_View.checkElement(driver, "free", "//td[contains(text(), 'Marta')]");// la que añadimos antes
//		assertTrue(elementos.size() == 1);
//	}
//
//	@Test
//	public void PR20() {
//		driver.navigate().to("http://localhost:8090/login");
//		PO_NavView.changeIdiom(driver, "English");
//		PO_NavView.checkIdiom(driver, PO_Properties.getENGLISH());
//		// 2
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_NavView.checkIdiom(driver, PO_Properties.getENGLISH());
//		// 3
//		PO_NavView.changeIdiom(driver, "Spanish");
//		PO_NavView.checkIdiom(driver, PO_Properties.getSPANISH());
//		// 4
//		PO_NavView.changeIdiom(driver, "English");
//		PO_NavView.checkIdiom(driver, PO_Properties.getENGLISH());
//	}
//
////	Intentar acceder sin estar autenticado a la opción de listado de usuarios. Se deberá volver al
////	formulario de login.
//	@Test
//	public void PR21() {
//		driver.navigate().to("http://localhost:8090/user/list");
//		String url = driver.getCurrentUrl();
//		PO_LoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//	}
//
////	Intentar acceder sin estar autenticado a la opción de listado de publicaciones de un usuario
////	estándar. Se deberá volver al formulario de login.
//	@Test
//	public void PR22() {
//		driver.navigate().to("http://localhost:8090/publication/list");
//		String url = driver.getCurrentUrl();
//		PO_LoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//	}
//
////	Estando autenticado como usuario estándar intentar acceder a una opción disponible solo
////	para usuarios administradores (Se puede añadir una opción cualquiera en el menú). Se deberá indicar un
////	mensaje de acción prohibida.
//	@Test
//	public void PR23() {
//		driver.navigate().to("http://localhost:8090/login");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		driver.navigate().to("http://localhost:8090/admin/users");
//		PO_View.checkElement(driver, "text", "Access is denied");
//	}
//
////	Ir al formulario crear publicaciones, rellenarla con datos válidos y pulsar el botón Submit.
////	Comprobar que la publicación sale en el listado de publicaciones de dicho usuario.
//	@Test
//	public void PR24() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "publiDropdownMenuButton", PO_View.getTimeout());
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "addPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		PO_View.checkElement(driver, "text", "Añade una nueva publicación");
//		PO_AddPublicationView.fillForm(driver, "Me merezco buena nota", "Que ya canso de tanta aweb");
//		elementos = PO_View.checkElement(driver, "free", "//td[contains(text(), 'Me merezco buena nota')]");
//		assertTrue(elementos.size() == 1);
//	}
//
////	Ir al formulario de crear publicaciones, rellenarla con datos inválidos (campo título vacío) y
////	pulsar el botón Submit. Comprobar que se muestra el mensaje de campo obligatorio
//	@Test
//	public void PR25() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "publiDropdownMenuButton", PO_View.getTimeout());
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "addPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		PO_View.checkElement(driver, "text", "Añade una nueva publicación");
//		PO_AddPublicationView.fillForm(driver, "", "Que ya canso de tanta aweb");
//		SeleniumUtils.EsperaCargaPagina(driver, "class", "form-control", 2);
//	}
//
////	Mostrar el listado de publicaciones de un usuario y comprobar que se muestran todas las que
////	existen para dicho usuario
//	@Test
//	public void PR26() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999990A@uniovi.es", "caca");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		driver.navigate().to("http://localhost:8090/publication/list");
//		List<WebElement> elementos;
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr", PO_View.getTimeout());
//		assertTrue(elementos.size() == 1);
//	}
//
////	Mostrar el listado de publicaciones de un usuario amigo y comprobar que se muestran todas
////	las que existen para dicho usuario. 
////	@Test
////	public void PR27() {
////		// Vamos al formulario de logueo.
////		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
////		// Rellenamos el formulario
////		PO_LoginView.fillForm(driver, "99999993D@uniovi.es", "me");
////		// COmprobamos que entramos en la pagina privada
////		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
////		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/user/friends')]");
////		elementos.get(0).click();
////		// Hacemos click sobre el botón de las publicaciones del amigo 
////		elementos = PO_View.checkElement(driver, "free", "//td[contains(text(), 'Lucas')]/following-sibling::*[2]");
////		elementos.get(0).click();
////		// Comprobamos que se lista la publicación
////		PO_View.checkElement(driver, "free", "//td[contains(text(), 'Prueba Publicación')]");
////	}
////	@Test
////	public void PR28() {}
////	Desde el formulario de crear publicaciones, crear una publicación con datos válidos y una
////	foto adjunta. Comprobar que en el listado de publicaciones aparecer la foto adjunta junto al resto de
////	datos de la publicación
//	@Test
//	public void PR29() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999993D@uniovi.es", "me");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "publiDropdownMenuButton", PO_View.getTimeout());
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "addPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		PO_View.checkElement(driver, "text", "Añade una nueva publicación");
//		PO_AddPublicationView.fillForm(driver, "Publicación con foto",
//				"THolaaaaaaaaaaAAAAAAAAAAAAAA", System.getProperty("user.dir") + "\\gatito.jpg");//La foto esta, no se porque no la encuentra
//		elementos = PO_View.checkElement(driver, "free",
//				"//td[contains(text(), 'Publicación con foto')]");
//		assertTrue(elementos.size() == 1);
//	}
////	Crear una publicación con datos válidos y sin una foto adjunta. Comprobar que la
////	publicación se a creado con éxito, ya que la foto no es obligaría
//	@Test
//	public void PR30() {
//		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//		PO_LoginView.fillForm(driver, "99999993D@uniovi.es", "me");
//		PO_JustLoggedInView.checkAuthenticated(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "publiDropdownMenuButton", PO_View.getTimeout());
//		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "addPubli", PO_View.getTimeout());
//		elementos.get(0).click();
//		PO_View.checkElement(driver, "text", "Añade una nueva publicación");
//		PO_AddPublicationView.fillForm(driver, "¿un 10?",
//				"yo creo que si");
//		elementos = PO_View.checkElement(driver, "free",
//				"//td[contains(text(), '¿un 10?')]");
//		assertTrue(elementos.size() == 1);
//	}
////	Mostrar el listado de usuarios y comprobar que se muestran todos los que existen en el
////	sistema.	
//	@Test
//	public void PR31() {
//		driver.navigate().to("http://localhost:8090/admin/login");
//		PO_AdminLoginView.fillForm(driver, "admin@email.com", "admin");
//		PO_AdminLoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'admin-menu')]/a");
//		elementos.get(0).click();
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'admin/users')]");
//		elementos.get(0).click();
//		PO_AdminLoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//	}
////	Ir a la lista de usuarios, borrar el primer usuario de la lista, comprobar que la lista se actualiza
////	y dicho usuario desaparece
//	@Test
//	public void PR32() {
//		driver.navigate().to("http://localhost:8090/admin/login");
//		PO_AdminLoginView.fillForm(driver, "admin@email.com", "admin");
//		PO_AdminLoginView.checkLogIn(driver, PO_Properties.getSPANISH());
//		List<WebElement> elementos = PO_View.checkElement(driver, "free",
//				"//td[contains(text(), 'Marta')]/following-sibling::*[2]");//Matamos a marta
//		elementos.get(0).click();
//		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Marta", PO_View.getTimeout());
//	}

}
