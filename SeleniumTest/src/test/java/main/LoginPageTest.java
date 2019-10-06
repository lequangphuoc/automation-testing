package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoginPageTest {
	WebDriver driver;

	@Before
	public void setup(){
       //use Chrome Driver
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\phuoclq\\Desktop\\PL\\Thuy\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver(); driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		 
	}
	
	@Test
	public void verifyLogin() {
		JSONParser jsonParser = new JSONParser();
		InputStream inputStream = LoginPageTest.class.getResourceAsStream("/TestData.json");
		try {
			JSONArray userList = (JSONArray)jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
						
			for (Object object : userList) {
				JSONObject user = (JSONObject) object;
				
				//Fill up data
				String email = (String) user.get("email");
		        String password = (String) user.get("password");
		        String expectedResult = (String) user.get("result");
		        
		        //Create object of LoginPage Class
				LoginPage loginPage = new LoginPage(driver);
		        String actualResult = loginPage.login(email, password);
		        
		        Assert.assertTrue(expectedResult.equals(actualResult));
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@After
    public void close(){
		driver.quit();
    }
}
