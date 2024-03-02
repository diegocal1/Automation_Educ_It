package clase1;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class LocalizacionDeElementos {
	static WebDriver driver; 
	public static void main(String []args) throws InterruptedException {
	  driver = new ChromeDriver();	//comento esta linea para inicializar firefox
	  //maximizo el navegador antes de entrar a la pagina
	  driver.manage().window().maximize();  
	  driver.get("https://seleniumjavalocators.neocities.org/index.html");

	  WebElement h1 = driver.findElement(By.id("titulo"));
	  System.out.println("H1: " + h1.getText());
	  System.out.println("Etiqueta del titulo: " + h1.getTagName());
	  
	  
	  List<WebElement> p = driver.findElements((By.tagName("p")));
	  System.out.println(p.size());
	  System.out.println("Elementos parrafo");
	  //imprimo el elemento que este en el indice 1
	  System.out.println(p.get(1).getText());
	  
	  for(WebElement pEl : p) {
		  System.out.println(pEl.getText());
	  }
	  
	  WebElement loginLink = driver.findElement((By.id("loginLink")));
	  loginLink.click();
	  System.out.println(driver.getCurrentUrl());
	  
	  WebElement nameInput = driver.findElement(By.cssSelector("#username_id"));
	  nameInput.sendKeys("Gerardo");
	  
	  WebElement loginBtn = driver.findElement((By.id("iniciarSesionBtn")));
	  loginBtn.sendKeys(Keys.ENTER);

	  Thread.sleep(2000);
	  nameInput.clear();
	  
	  //esta es una espera explicita que no es recomendable usar solamente para mostrar la funcion de borrar
	  Thread.sleep(2000);
	  
	  driver.close();
	  
	}
	
}
