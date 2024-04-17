package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;
import utilities.DatosExcel;

public class Practica5bTest {
	String url = "http://www.automationpractice.pl/";
	WebDriver driver;
	String directorioArchivo = "../EducacionIT-70853/Datos/";
	String nombreArchivo = "Datos_Login12Abr2024.xlsx";
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Obtener Datos Excel", description="Iniciar Sesion en AutomationPractice")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirCorreo(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider(name="Obtener Datos Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		/* Leer los datos desde un archivo Excel 
		 * y con ellos construir un arreglo
		 */
		return DatosExcel.leerExcel(
				directorioArchivo + nombreArchivo,
				"Hoja1");	
	}
	
	@DataProvider(name="Obtener Datos")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		// Completar el arreglo con los valores de prueba
		datos[0][0] = "abc@gmail.com"; // correo
		datos[0][1] = "4345t45et"; // contraseña
		
		datos[1][0] = "def@gmail.com"; // correo
		datos[1][1] = "76i78oiy7"; // contraseña
		
		datos[2][0] = "ghi@gmail.com"; // correo
		datos[2][1] = "2q3e32qe"; // contraseña
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}






