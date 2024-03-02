package clase2;


import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Esperas {
	String url = "http://www.automationpractice.pl/";
	@Test
	public void Ej_esperas() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//espera implicita
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		driver.manage().window().maximize();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//WebElement searchElement = driver.findElement(By.id("search_query_top"));
		WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
		
		searchElement.sendKeys("printed dress");

		Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
		//WebElement searchButton = driver.findElement(By.name("submit_search"));
		WebElement searchButton = wait2.until(ExpectedConditions.elementToBeClickable(By.name("submit_search")));
		searchButton.click();

		
		driver.close();
		
	}
}
