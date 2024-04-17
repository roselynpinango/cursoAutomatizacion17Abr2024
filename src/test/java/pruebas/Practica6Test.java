package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;

public class Practica6Test {
	String url = "http://automationpractice.pl/";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void setUp(String navegador) {
		if (navegador.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (navegador.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			
			// Modo incognito
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			
			driver = new ChromeDriver(options);
		}
				
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
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
