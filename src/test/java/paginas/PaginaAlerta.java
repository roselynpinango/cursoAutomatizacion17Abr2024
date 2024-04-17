package paginas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaAlerta {
	// Elementos Web
	@FindBy(css="#alertButton")
	WebElement btnNotificacion;
	
	@FindBy(id="timerAlertButton")
	WebElement btnDemora;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	WebElement btnConfirmacion;
	
	@FindBy(css="#promtButton")
	WebElement btnPrompt;
	
	// Contructor
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos web
	public void clicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void clicEnDemora() {
		btnDemora.click();
	}
	
	public void clicEnConfirmacion() {
		btnConfirmacion.click();
	}
	
	public void clicEnPrompt() {
		btnPrompt.click();
	}
	
	public Alert obtenerAlerta(WebDriver driver) {
		// Espera preventiva
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		return driver.switchTo().alert();
	}
	
	public void aceptarAlerta(Alert alerta) {
		alerta.accept(); // Clic en Aceptar-OK
	}
	
	public void cancelarAlerta(Alert alerta) {
		alerta.dismiss(); // Clic en Cancelar-NO
	}
	
	public void escribirEnAlerta(Alert alerta, String palabra) {
		alerta.sendKeys(palabra);
	}
	
	public String obtenerTextoAlerta(Alert alerta) {
		return alerta.getText();
	}
	
	
}
