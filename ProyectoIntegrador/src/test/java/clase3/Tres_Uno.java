package clase3;
import org.testng.Assert;
import org.testng.annotations.*;

import clase4.pages.LandingPage;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;



public class Tres_Uno extends BaseTest{
	@Test
	public void registrationTest(){
		LandingPage landingPage = new LandingPage(driver);
		//Landing Page 
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		//LoginPage
		WebElement emailCreateInput = driver.findElement(By.id("email_create"));
		emailCreateInput.sendKeys(faker.internet().emailAddress());
		
		WebElement submitCreateAccountBtn = driver.findElement(By.name("SubmitCreate"));
		submitCreateAccountBtn.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//RegistrationPage
		WebElement mrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
		
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
		
		String fullName = "Juan Sanchez Velez";
		String[] fullNameSplitted = fullName.split(" ");
		firstNameInput.sendKeys(fullNameSplitted[0]);
		
		WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_lastname")));
		lastNameInput.sendKeys(fullNameSplitted[1] + " " + fullNameSplitted[2]);
		
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-validate='isPasswd']")));
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
		Assert.assertTrue(registerButton.isDisplayed());
		registerButton.click();
		
		WebElement successfulRegistrationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.alert.alert-success")));
		String successfulRegistrationMessageText = successfulRegistrationMessage.getText();
		
		//Account Page
		Assert.assertEquals(successfulRegistrationMessageText, "Your account has been created.", "El mensaje de creacion de cuenta no es el esperado");
		
		WebElement accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
		Assert.assertEquals(accountName.getText(), fullName, "El nombre no es correcto");
		
	}
	@Test
	public void invalidRegistrationTest() throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		
		WebElement loginLink = landingPage.getLoginLink();
		loginLink.click();
		
		WebElement emailCreateInput = driver.findElement(By.id("email_create"));
		emailCreateInput.sendKeys(faker.internet().emailAddress());
		
		WebElement submitCreateAccountBtn = driver.findElement(By.name("SubmitCreate"));
		submitCreateAccountBtn.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement mrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
	
		String fullName = "Juan Sanchez Velez";
		String[] fullNameSplitted = fullName.split(" ");
		
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
     	firstNameInput.sendKeys(fullNameSplitted[0]);
		
		WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_lastname")));
		lastNameInput.sendKeys(fullNameSplitted[1] + " " + fullNameSplitted[2]);
		
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
		Assert.assertTrue(registerButton.isDisplayed());
		registerButton.click();
		
		WebElement invalidRegistrationTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-danger']//p")));
		String invalidRegistrationMessageTitle = invalidRegistrationTitle.getText();
		
		WebElement invalidRegistrationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-danger']//ol//li")));
		String invalidRegistrationMessageText = invalidRegistrationText.getText();

		
		Assert.assertEquals(invalidRegistrationMessageTitle, "There is 1 error", "El titulo no es correcto");
		Assert.assertEquals(invalidRegistrationMessageText, "passwd is required.", "El texto no es correcto");
		Assert.assertTrue(true);
	}

}
