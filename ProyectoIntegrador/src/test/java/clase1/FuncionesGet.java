package clase1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FuncionesGet {
	static WebDriver driver; 
	public static void main(String []args) {
	  driver = new ChromeDriver();	
	  driver.get("https://seleniumjavalocators.neocities.org/");
	  
	  //obtener titulo
	  String title = driver.getTitle();
	  System.out.println("El titulo de la pagina es: " + title);
	  
	  //obtener url
	  String currentUrl = driver.getCurrentUrl();
	  System.out.println(currentUrl);
	  
	  //obtener el codigo fuente de la pagina como valor de cadena
	  String pageSource = driver.getPageSource();
	  System.out.println(pageSource);  
	  
	  //obtengo el elemento h1 por tagname
	  WebElement h1 = driver.findElement(By.tagName("h1"));
	  //imprimo por consola el texto del elemento h1
	  System.out.println("H1: " + h1.getText());
	  
	  //navego hacia otra pagina
	  driver.navigate().to("https://seleniumjavalocators.neocities.org/pages/registro");
	  System.out.println(driver.getCurrentUrl());
	  
	  //cierro el driver
	  driver.close();
	}
	
}
