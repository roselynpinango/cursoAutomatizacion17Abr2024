package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos Web
	@FindBy(partialLinkText="Sign")
	WebElement lnkSign;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre elementos web
	public void hacerClicEnSignIn() {
		lnkSign.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
}
