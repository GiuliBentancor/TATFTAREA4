package Selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	static WebDriver driver;
	String textoBusqueda = "CES";
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();	
		
		String googleTitulo = driver.getTitle();
		assertTrue(googleTitulo.contains("Google"));
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	

	@Test
	public void testBusqueda() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.click();
		searchbox.sendKeys(textoBusqueda);
		searchbox.submit();
		
		assertTrue(driver.getTitle().contains(textoBusqueda + " - Buscar con Google"));
	}

}
