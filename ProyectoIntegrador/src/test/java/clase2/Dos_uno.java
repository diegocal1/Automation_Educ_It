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

public class Dos_uno {
	String url = "http://www.automationpractice.pl/";
	
	@Test
	public void Ej2_1() throws InterruptedException {  
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(url);
		
		WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
		searchInput.sendKeys("printed dress");

		driver.close();
		
	}
	@Test
	public void Ej2_2() throws InterruptedException {  
		//Tambien aplica al 2.3 verificar que todos los elementos tengan la espera explicita.
		Random rand = new Random(); 
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		WebElement loginLink = driver.findElement(By.className("login"));
		loginLink.click();
		
		WebElement emailCreateInput = driver.findElement(By.id("email_create"));
		emailCreateInput.sendKeys("test" + rand.nextInt(10000) + "@test.com");
		
		WebElement submitCreateAccountBtn = driver.findElement(By.name("SubmitCreate"));
		submitCreateAccountBtn.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//WebElement mrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		WebElement mrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
		
		//WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_firstname")));
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
		
		firstNameInput.sendKeys("Juan");
		
		WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_lastname")));
		lastNameInput.sendKeys("Sanchez");
		
		//WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-validate='isPasswd']")));
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-validate='isPasswd']")));
		//otro CSSselector para passwordInput input#passwd.is_required.validate.form-control
		passwordInput.sendKeys("juansanchez01");
		
		WebElement day = driver.findElement(By.id("days"));
		Select dayListaDesplegable = new Select(day);
		dayListaDesplegable.selectByValue("22");
		
		WebElement month = driver.findElement(By.id("months"));
		Select monthListaDesplegable = new Select(month);
		monthListaDesplegable.selectByVisibleText("October ");
		
		WebElement years = driver.findElement(By.id("years"));
		Select yearsListaDesplegable = new Select(years);
		yearsListaDesplegable.selectByValue("1970");
		
		WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount")));
		registerButton.click();

		//Thread.sleep tiene que elminarse
		Thread.sleep(5000);
		
		driver.close();
		
	}
	String accountUrl = "http://automationpractice.com/index.php?controller=authentication#account-creation";
	@Test
	public void Ej2_5() throws InterruptedException {  
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(accountUrl);
		
		
		Thread.sleep(5000);
		
		driver.close();
		
	}
	
}
