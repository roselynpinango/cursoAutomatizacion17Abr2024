package edit.EducacionIT_70853;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.CapturaEvidencia;

public class Practica3 {
	String url = "http://www.automationpractice.pl";
	String directorioEvidencias = "../EducacionIT-70853/Evidencias/";
	String nombreDocumento = "Evidencias AutomationPractice.docx";
	File screen;
	WebDriver driver;
	
	@BeforeTest
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 3, description = "CP-159 Buscar palabra")
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Toma la captura
		FileUtils.copyFile(screen, new File(directorioEvidencias + "01_pantallaPrincipal.jpg")); // Crear el archivo de imagen
		
		// Acciones para buscar palabra
		driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Toma la captura
		FileUtils.copyFile(screen, new File(directorioEvidencias + "02_palabraABuscar.jpg")); // Crear el archivo de imagen
		
		driver.findElement(By.name("submit_search")).click();
		
		// Captura de Pantlalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Toma la captura
		FileUtils.copyFile(screen, new File(directorioEvidencias + "03_resultadoBusqueda.jpg")); // Crear el archivo de imagen
		
		// Chequeo para comprobar si se ejecutó bien o no
		String tituloEsperado = "Search - My Shop";
		String tituloActual = driver.getTitle();
		
		//Assert.assertEquals(url, tituloEsperado); // forzar una falla
		
		Assert.assertEquals(tituloActual, tituloEsperado); // Valida si el resultado esperado = resultado obtenido
		
		/*
		 * Otros métodos para hacer chequeos
		 * 1) assertNotEquals("1", "2")
		 * 2) assertTrue(1 == 1)
		 * 3) assertFalse(1 == 2)
		 * 4) assertNull(url)
		 * 5) assertNotNull(url)
		 * */
		
		/* Automatización tiene dos formas de validar: Fuerte y Débil
			1) Fuerte (Assert) -> Si no se cumple, todo el @Test falla
			2) Débil (SoftAssert) -> Si no se cumple, el @Test no falla pero te muestra un mensaje con lo que no se está cumpliendo
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(tituloActual, tituloEsperado);
		*/
	}
	
	@Test(priority = 1, description = "CP-548 Ir a Contáctanos")
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Evidencia
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreDocumento,
				"Documento de Evidencias - AutomationPractice",
				20);
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 1: Pantalla Principal");
		
		// Acciones para ir a contactanos
		driver.findElement(By.partialLinkText("Contact")).click();
		
		// Captura de Evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 2: Luego de hacer clic en 'Contact us'");
		
		Select lstSubject = new Select(driver.findElement(By.id("id_contact")));
		lstSubject.selectByVisibleText("Webmaster");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("correo@gmail.com");
		
		driver.findElement(By.name("id_order")).sendKeys("ORD-123");
		
		driver.findElement(By.cssSelector("#fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de contacto a la empresa");
		
		// Captura de Evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 3: Luego de completar el formulario");
		
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
		
		// Captura de Evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 4: Luego de enviar el formulario");
	}
	
	@AfterTest
	public void cerrarNavegador() {
		driver.close();
	}
}
