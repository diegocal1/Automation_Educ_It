package clase3;

import org.testng.annotations.*;

public class Anotaciones {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE");
	
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BEFORE TEST");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("BEFORE CLASS");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BEFORE METHOD");
	} 
	@Test(priority=2, description="descripcion del primer test")
	public void firstTest() {
		//Assert.assertEquals(true, false);
		//esta es una validacion para comprobar el atributo dependsOnMethods
		System.out.println("PRIMER TEST");
	}
	@Test(dependsOnMethods = "firstTest", description="descripcion del tercer test")
	public void thirdtTest() {
		System.out.println("TERCER TEST");
	}
	@Test
	public void secondTest() {
		System.out.println("SEGUNDO TEST");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AFTER CLASS");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("AFTER TEST");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("AFTER SUITE");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AFTER METHOD");
	}
}
