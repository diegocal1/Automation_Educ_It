package clase2;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*******************************************************
*                                                      *
* "//Etiqueta[@propiedad='Valor']"                     *
* "//Etiqueta[contains(text(),'Texto a buscar')]"      *
*                                                      *
* //       : Posicion sobre el nodo actual.            *
* Etiqueta  : Tagname del nodo.                        *
* @        : Atributo a elegir.                        *
* Attribute: Nombre del atributo del nodo.             *
* Value    : Valor del atributo.                       *
* https://www.guru99.com/xpath-selenium.html           *
*******************************************************/

public class ListaDesplegable {
	String url = "https://seleniumjavalocators.neocities.org/";

	@Test
	public void listaDesplegable() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement fechas = driver.findElement(By.xpath("//a[@class='nav-link' and @href='./pages/fechas.html']"));
		fechas.click();
		

		WebElement dia = driver.findElement(By.id("dia"));
		Select diaListaDesplegable = new Select(dia);
		diaListaDesplegable.selectByValue("8");
		
		WebElement mes = driver.findElement(By.id("mes"));
		Select mesListaDesplegable = new Select(mes);
		mesListaDesplegable.selectByVisibleText("Agosto");
		
		WebElement anio = driver.findElement(By.id("año"));
		Select anioListaDesplegable = new Select(anio);
		anioListaDesplegable.selectByValue("1997");
		
		WebElement mostrarFecha = driver.findElement(By.id("mostrarFechaBtn"));
		mostrarFecha.click();
		
		WebElement mensajeFecha = driver.findElement(By.id("fechaNacimiento"));
		System.out.println(mensajeFecha.getText());
		
		//espera para demostrar que el elemento se encuentra por name
		driver.close();
		
	}
}
