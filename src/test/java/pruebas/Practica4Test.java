package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Practica4Test {
	String url = "http://www.automationpractice.pl/";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="Iniciar Sesion en AutomationPractice")
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirCorreo("correo@gmail.com");
		login.escribirPassword("1q2w3e4r5t");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerBusqueda();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
