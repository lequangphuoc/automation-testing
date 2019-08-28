package practice.automationtesting.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;

public class RegisterPageTest {
	private WebDriver driver;
	private RegisterPage registerPage;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\Thuy\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://practice.automationtesting.in/my-account/");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
	
	@Test
	public void InvalidEmail_ResgiterFail() {
		registerPage = new RegisterPage(driver);
		registerPage.setEmail("invalidEmail");
		registerPage.submit();
		
		String emailValidationMsg = registerPage.getEmailHtml5ValidationMessage();
		Assert.assertTrue(!emailValidationMsg.isEmpty());
	}
}
