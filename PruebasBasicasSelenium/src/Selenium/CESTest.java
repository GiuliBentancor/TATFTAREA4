package Selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CESTest {
	static WebDriver driver;
	String user = "agregarUsuario";
	String password = "agregarContraseña";
	String userName = "agregarNombreUsuario";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://capacitacion.ces.com.uy");
		driver.manage().window().maximize();	
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	public void funcionInicio(){
		String cesTitulo = driver.getTitle();
		assertTrue(cesTitulo.contains("CES - AULA VIRTUAL"));
	}
	
	public void funcionLogin() {
		driver.findElement(By.linkText("Acceder")).click();
		
		WebElement userbox = driver.findElement(By.name("username"));
		userbox.click();
		userbox.sendKeys(user);
		
		WebElement passwordbox = driver.findElement(By.name("password"));
		passwordbox.click();
		passwordbox.sendKeys(password);
		passwordbox.submit();
		
		WebElement name = driver.findElement(By.className("userbutton"));
		assertTrue(name.getText().contains(userName));
	}
	

	@Test
	public void testBusquedaBienvenidaTaller() {
		funcionInicio();
		funcionLogin();
		
		driver.findElement(By.linkText("TALLER DE AUTOMATIZACIÓN DEL TESTING FUNCIONAL 202108")).click();
		String tallerTitulo = driver.getTitle();
		assertTrue(tallerTitulo.contains("Curso: TALLER DE AUTOMATIZACIÓN DEL TESTING FUNCIONAL 202108"));
		
		driver.findElement(By.xpath("//li[@id=\"module-24961\"]//a")).click();
		String novedadesTitulo = driver.getTitle();
		assertTrue(novedadesTitulo.contains("Novedades del taller"));
		
		WebElement searchbox = driver.findElement(By.name("search"));
		searchbox.click();
		searchbox.sendKeys("Bienvenida");
		searchbox.submit();
		
		assertTrue(driver.getTitle().contains("Resultado"));
	}

}
