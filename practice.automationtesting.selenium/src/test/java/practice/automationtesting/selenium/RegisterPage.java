package practice.automationtesting.selenium;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class RegisterPage {
	WebDriver _driver;
	
	@FindBy(id = "reg_email")
	private WebElement emailEl;
	
	@FindBy(id = "reg_password")
	private WebElement passwordEl;
	
	@FindBy(name = "register")
	private WebElement btnSubmit;
	
	public RegisterPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void setEmail(String email) {
		emailEl.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordEl.sendKeys(password);
	}
	
	public String getEmailHtml5ValidationMessage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) _driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", emailEl);
	}
	
	public void submit() {
		btnSubmit.submit();
	}
}
