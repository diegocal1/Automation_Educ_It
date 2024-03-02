package clase4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import clase4.BaseTest;

public class LandingPage extends BaseTest {
	public LandingPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	
	}
	//localizador = valor
	//driver.findElement(By.className("login"));
	@FindBy(className = "login")
	WebElement loginLink;
	public WebElement getLoginLink() {
		return loginLink;
		
	}
	
}
