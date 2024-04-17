package edit.EducacionIT_70853;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practica1 {
	
	@Test
	public void buscarPalabraFirefox() {
		// 1) Definir qué navegador queremos usar
		WebDriver navegador = new FirefoxDriver();
		
		// 2) Abrir el navegador en la página a probar
		navegador.get("http://www.automationpractice.pl");
		navegador.manage().deleteAllCookies(); // Borrar las cookies
		navegador.manage().window().maximize(); // Maximizar ventana
		
		// 3) Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.clear(); // Limpiar el campo
		txtBuscador.sendKeys("dress"); // Escribir en un campo de texto 
		
		// 4) Simular que presionamos la tecla Enter
		txtBuscador.sendKeys(Keys.ENTER); // Simular que presionamos una tecla
		
		// 5) Cerrar el navegador
		navegador.close(); // Cerrar la pestaña del navegador actual
		//navegador.switchTo()...// Cambiar de ventana a ventana
		//navegador.quit(); // Cerrar todas las pestañas que se abrieron
	}
	
	@Test
	public void buscarPalabraChrome() {
		// 1) Definir qué navegador queremos usar
		WebDriverManager.chromedriver().setup();
		WebDriver navegador = new ChromeDriver();
		
		// 2) Abrir el navegador en la página a probar
		navegador.get("http://www.automationpractice.pl");
		
		// 3) Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // Escribir en un campo de texto 
		
		// 4) Simular que presionamos la tecla Enter
		txtBuscador.sendKeys(Keys.ENTER); // Simular que presionamos una tecla
		
		// 5) Cerrar el navegador
		
	}

}
