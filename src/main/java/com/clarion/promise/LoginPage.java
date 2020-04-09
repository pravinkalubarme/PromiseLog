package com.clarion.promise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
private WebDriver driver;
	
	@FindBy(xpath="//input[@name='txtUsername']") WebElement userName;
	
	@FindBy(xpath="//input[@name='txtPassword']") WebElement password;
	
	@FindBy(name="submit1") WebElement login;
	
	@FindBy(xpath="//font[@color='red']") WebElement ValidationText;

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginPageUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void loginPagePassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void loginPageLoginButton() {
		login.click();
	}
	
	public String loginPageValidationForInvalidUser() {
		String validationMessage = ValidationText.getText();
		return validationMessage;
	}
}
