package clase2;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*******************************************************
*     XPATH                                                 *
* "//Etiqueta[@propiedad='Valor']"                     *
* "//Etiqueta[contains(text(),'Texto a buscar')]" 
*  //*[text()='Texto a buscar']                        *
*                                                      *
* //       : Posicion sobre el nodo actual.            *
* Etiqueta  : Tagname del nodo.                        *
* @        : Atributo a elegir.                        *
* Attribute: Nombre del atributo del nodo.             *
* Value    : Valor del atributo.                       *
* https://www.guru99.com/xpath-selenium.html           *
*******************************************************/
//CssSelector
//nombreElemento[nombreAtributo=‘valorAtributo']
//input[data-validate='isPasswd']

public class LocalizadoresSelenium {
	String url = "https://seleniumjavalocators.neocities.org/";
	String loginUrl = url + "pages/login";
	@Test
	public void locateNameClassName() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();	
		driver.get(loginUrl);
		
		WebElement usernameByName = driver.findElement(By.name("username"));
		usernameByName.sendKeys("Gerardo");
		
		WebElement passwordByName = driver.findElement(By.name("passwd"));
		passwordByName.sendKeys("Sanchez");	
		
		WebElement loginButtonById = driver.findElement(By.id("iniciarSesionBtn"));
		loginButtonById.click();
		
		WebElement message = driver.findElement(By.className("mensaje"));
		System.out.println(message.getText());
		
		//espera para demostrar que el elemento se encuentra por name
		Thread.sleep(3000);
		
		driver.close();
		
	}
	@Test
	public void locateLinkText() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement registroLink = driver.findElement(By.linkText("Registro"));
		registroLink.click();
		//espera para demostrar que el elemento se encuentra por name
		Thread.sleep(3000);
		
		driver.close();
		
	}
	@Test
	public void locatePartialLinkText() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement registroLink = driver.findElement(By.partialLinkText("Catalogo"));
		registroLink.click();
		//espera para demostrar que el elemento se encuentra por name
		Thread.sleep(3000);
		
		driver.close();
		
	}
	@Test
	public void locateXPath() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement h2 = driver.findElement(By.xpath("//h2[@data-test-id='subtitulo']"));
		System.out.println(h2.getText());
		
		List<WebElement> imgList = driver.findElements(By.xpath("//img[@src='./images/black_970x90.gif' or @alt='greylorem']"));
		System.out.println("Cantidad de imagenes con src black_970x90 o alt greylorem: " + imgList.size());
		
		//WebElement fechas = driver.findElement(By.xpath("//a[contains(@href,'./fechas.html')]"));
		//WebElement fechas = driver.findElement(By.xpath("//a[contains(text(),'Fechas')]"));
		//WebElement fechas = driver.findElement(By.xpath("//*[text()='Fechas']"));
		
		WebElement fechas = driver.findElement(By.xpath("//a[@class='nav-link' and @href='./pages/fechas.html']"));
		fechas.click();
		
		//espera para demostrar que el elemento se encuentra por name
		Thread.sleep(3000);
		driver.close();
		
	}
}
