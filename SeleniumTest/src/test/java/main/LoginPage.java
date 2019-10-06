package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	//Locators
	@FindBy(css = ".login-button")
	private WebElement _loginButton;
   
	@FindBy(id = "Email")
	private WebElement _email;

	@FindBy(id = "Password")
	private WebElement _password;

	//Constructor
	public LoginPage(WebDriver driver) {
       this.driver = driver;
       //Initialise Elements
       PageFactory.initElements(driver, this);
	}
   
	public void setEmail(String email){
       _email.clear();
       _email.sendKeys(email);
	}

	public void setPassword(String password){
       _password.clear();
       _password.sendKeys(password);
	}

	public void clickOnLoginButton() {
       _loginButton.click();
	}
	
	public String login(String email, String password) {
		//Create object of HomePage Class
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginLink();
		
		setEmail(email);
		setPassword(password);
		clickOnLoginButton();
				
		if(homePage.isUserLoggedin())
		{
			if(email.equals(homePage.getLoggedUsernameLinkText())) {
				homePage.clickOnLogoutLink();
			}
			
			return "Valid User";
		}
		else 
		{
			return "Invalid User";
		}
	}
}
