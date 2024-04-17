package edit.EducacionIT_70853;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practica2 {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// Definir el navegador que queremos usar
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		// Abrir el navegador en la página a probar
		driver.navigate().to(url);
		
		// Hacer clic en 'Sign in'
		driver.findElement(By.partialLinkText("Sign")).click();
		
		// Escribir el correo y hacer clic en 'Create An Account'
		driver.findElement(By.name("email_create")).sendKeys("correo2203@gmail.com");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		// Espera
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']")));
		
		// Completar el formulario
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click(); // Campo Title
		driver.findElement(By.id("customer_firstname")).sendKeys("Arturo"); // Nombre
		driver.findElement(By.name("customer_lastname")).sendKeys("Lopez"); // Apellido
		
		// Generación de datos Aleatorios
		// Opción 1: Crear el correo variando un número generado aleatoriamente
		//String email = "correo" + Math.random() + "@gmail.com";
		
		// Opción 2: Utilizar una librería de datos aleatorios (JavaFaker)
		Faker faker = new Faker();
		String email = faker.internet().emailAddress(); // Devolver un correo
		
		// faker.internet().password(8, 12, true, true, true);
				
		WebElement txtEmail = driver.findElement(By.cssSelector("#email"));
		txtEmail.clear();
		txtEmail.sendKeys(email); // Correo
		
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4r5t"); // Contraseña
		
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByVisibleText("18  "); // Dia
		
		Select months = new Select(driver.findElement(By.name("months")));
		months.selectByValue("6"); // Mes
		
		Select years = new Select(driver.findElement(By.cssSelector("#years")));
		years.selectByIndex(30); // Año
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		// Hacer clic en 'Register'
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	}
}
