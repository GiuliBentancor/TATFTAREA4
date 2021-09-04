package Selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {
	static WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://es.wikipedia.org");
		driver.manage().window().maximize();	
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	
	public void funcionInicio(){
		String wikiTitulo = driver.getTitle();
		assertTrue(wikiTitulo.contains("Wikipedia, la enciclopedia libre"));
	}
	
	@Test
	public void testBusqueda() {
		
		funcionInicio();
		WebElement searchbox = driver.findElement(By.name("search"));
		searchbox.click();
		searchbox.sendKeys("Hola Mundo");
		searchbox.submit();
		
		assertTrue(driver.getTitle().contains("Hola mundo - Wikipedia, la enciclopedia libre"));
	}
}
