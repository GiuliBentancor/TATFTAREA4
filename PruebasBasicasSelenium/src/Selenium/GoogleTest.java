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
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();	
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	public void funcionInicio(){
		String googleTitulo = driver.getTitle();
		assertTrue(googleTitulo.contains("Google"));
	}


	@Test
	public void testBusqueda() {
	
		funcionInicio();
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.click();
		searchbox.sendKeys("CES");
		searchbox.submit();
		
		assertTrue(driver.getTitle().contains("CES - Buscar con Google"));
	}

}
