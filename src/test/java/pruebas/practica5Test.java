package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaAlerta;

public class practica5Test {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	PaginaAlerta pagina;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		/* Necesitamos ajustar el zoom de la página o hacer scroll 
		 * para que se vean los botones
		 */
        ChromeOptions options = new ChromeOptions();
        double zoomLevel = 0.75;
        options.addArguments("--force-device-scale-factor=" + zoomLevel);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
		pagina = new PaginaAlerta(driver);
	}
	
	@Test
	public void alertaNotificacion() {
		pagina.clicEnNotificacion();
		
		Alert alerta = pagina.obtenerAlerta(driver);
		pagina.aceptarAlerta(alerta);
	}
	
	@Test
	public void alertaDemora() {
		pagina.clicEnDemora();
		
		Alert alerta = pagina.obtenerAlerta(driver);
		alerta.accept();
	}
	
	@Test
	public void alertaConfirmacion() {
		pagina.clicEnConfirmacion();
		
		Alert alerta = pagina.obtenerAlerta(driver);
		pagina.cancelarAlerta(alerta);
	}
	
	@Test
	public void alertaPrompt() {
		pagina.clicEnPrompt();
		
		Alert alerta = pagina.obtenerAlerta(driver);
		pagina.escribirEnAlerta(alerta, "Mensaje en Alerta");
		pagina.aceptarAlerta(alerta);
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
