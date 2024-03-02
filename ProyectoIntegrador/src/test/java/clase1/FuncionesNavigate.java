package clase1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FuncionesNavigate {
	static WebDriver driver; 
	public static void main(String []args) {
	  //driver = new ChromeDriver();	//comento esta linea para inicializar firefox
	  driver = new FirefoxDriver();
	  //maximizo el navegador antes de entrar a la pagina
	  driver.manage().window().maximize();
	  
	  driver.get("https://seleniumjavalocators.neocities.org/");
	  System.out.println("entrando al iniciar el driver: " + driver.getCurrentUrl());  
	  //navego hacia otra pagina
	  driver.navigate().to("https://seleniumjavalocators.neocities.org/pages/registro");
	  System.out.println("navegando a la pagina de registro: " + driver.getCurrentUrl());
	  
	  //hacemos back en el navegador
	  driver.navigate().back();
	  System.out.println("volviendo a la pagina inicial con back: " + driver.getCurrentUrl());
	  
	  driver.navigate().forward();
	  System.out.println("yendo hacia adelante a la pagina de registro nuevamente: " + driver.getCurrentUrl());
	  	  
	  driver.close();
	  
	}
	
}
