package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	//Page URL
	private static String PAGE_URL="http://demowebshop.tricentis.com";

	//Locators
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement _logoutLink;
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement _loginLink;
   
	@FindBy(xpath = "//a[@href='/customer/info']")
	private WebElement _loggedUsernameLink;

	//Constructor
	public HomePage(WebDriver driver) {
       this.driver = driver;
       driver.get(PAGE_URL);
       //Initialise Elements
       PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogoutLink() {
		_logoutLink.click();
	}
	
	public void clickOnLoginLink() {
		_loginLink.click();
	}
	
	public String getLoggedUsernameLinkText( ) {
		return _loggedUsernameLink.getText();
	}
	
	//We will use this boolean to check if user is logged in
	public boolean isUserLoggedin(){
	       return driver.findElements(By.xpath("//a[@href='/logout']")).size() > 0;
	}
}
