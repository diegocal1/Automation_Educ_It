package clase3;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;


public class RegistroEjemplo {
	String url = "http://www.automationpractice.pl/";
	WebDriver driver;
	Faker faker;
	
	@BeforeSuite
	public void init() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
	}
	@Test(description="Registro de usuario")
	public void registrationTest() throws InterruptedException {
		//Random rand = new Random(); 
		faker = new Faker();
		
		WebElement loginLink = driver.findElement(By.className("login"));
		loginLink.click();
		
		WebElement emailCreateInput = driver.findElement(By.id("email_create"));
		//emailCreateInput.sendKeys("test" + rand.nextInt(1000000) + "@test.com");
		emailCreateInput.sendKeys(faker.internet().emailAddress());
		
		WebElement submitCreateAccountBtn = driver.findElement(By.name("SubmitCreate"));
		submitCreateAccountBtn.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//WebElement mrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		WebElement mrsRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
		
		//WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_firstname")));
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
		
		String fullName = "Juan Sanchez Velez";
		String[] fullNameSplitted = fullName.split(" ");
		firstNameInput.sendKeys(fullNameSplitted[0]);
		
		WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_lastname")));
		lastNameInput.sendKeys(fullNameSplitted[1] + " " + fullNameSplitted[2]);
		
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
		Assert.assertTrue(registerButton.isDisplayed());
		registerButton.click();
		
		WebElement successfulRegistrationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.alert.alert-success")));
		String successfulRegistrationMessageText = successfulRegistrationMessage.getText();
		
		Assert.assertEquals(successfulRegistrationMessageText, "Your account has been created.", "El mensaje de creacion de cuenta no es el esperado");
		
		WebElement accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
		Assert.assertEquals(accountName.getText(), fullName, "El nombre no es correcto");
		
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}
