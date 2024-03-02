package clase3;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;

public class BaseTest {
	String url = "http://www.automationpractice.pl/";
	WebDriver driver;
	Faker faker;

	@BeforeSuite
	public void setUp() {
		System.out.println("inicio de la suite de pruebas");
	}
	@BeforeMethod
	public void irUrl() {
		faker = new Faker();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url);

	}
	@AfterMethod
	public void screenshot(ITestContext context) throws IOException {
		//el context sirve para tomar informacion del contexto del test que se esta ejecutando.
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println(datetime);
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\ProyectoIntegrador\\Evidencias\\" + context.getName() + " " + datetime.getNano() +".png"));
	
		driver.close();
	}
	@AfterSuite
	public void finSuitePruebas() {
		System.out.println("finalizó la suite de pruebas.");
		
	}
}
