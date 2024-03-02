package clase2;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Desafio1 {
	@Test
	public void desafio_1_2() throws InterruptedException {  
	
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		//no hay id, solo name
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
		WebElement userNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		userNameInput.sendKeys("Admin");

		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		passwordInput.sendKeys("admin123");
		
		WebElement ingresarBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")));
		ingresarBtn.click();
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
