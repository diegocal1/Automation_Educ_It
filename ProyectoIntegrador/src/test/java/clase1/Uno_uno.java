package clase1;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;


public class Uno_uno {
	String url = "http://www.automationpractice.pl/";
	@Test
	public void Ej1_1() throws InterruptedException {  
	  System.out.println("Hola Mundo de Automatizacion");

	}
	@Test
	public void Ej1_2() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(url);
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
	@Test
	public void Ej1_3() throws InterruptedException {
		WebDriver driver;
		//instaciamos Firefox
		driver = new FirefoxDriver();
	    //Maximizamos la pagina web
		driver.manage().window().maximize();  
	    //Ingresamos la URL
		driver.get(url);
		
		System.out.println(driver.getTitle());
		
		//Cerramos el driver
		driver.close();
		
	}	
	@Test
	public void Ej1_4() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(url);
		
		WebElement searchElement = driver.findElement(By.id("search_query_top"));
		searchElement.sendKeys("printed dress");
		//ingreso enter para simular el enter del teclado
		//searchElement.sendKeys(Keys.ENTER);
		
		//busco el elemento de la lupa y hago click
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
		
		Thread.sleep(5000);
		
		driver.close();
		
	}
}
