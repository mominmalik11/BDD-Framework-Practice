package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	// what elements do we find on login page? email box, password, submit button

	@FindBy(id = "input-email")
	private WebElement emailTextBoxField;

	@FindBy(id = "input-password")
	private WebElement passwordTextBoxField;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement credentialsMismatchWarningMessage;

	public LoginPage(WebDriver driver) { // create the constructor and overload it with Driver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String emailText) {
		emailTextBoxField.sendKeys(emailText);

	}

	public void enterPassword(String passwordText) {
		passwordTextBoxField.sendKeys(passwordText);

	}
	
	public AccountPage clickOnLoginButton() {//-----------> this takes us to accountpage so we can add a return new accountPage
		
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String retrieveCredentialsMismatchWarningMessage() {
		
	String warningCredentialsMismatch =	credentialsMismatchWarningMessage.getText();
		return warningCredentialsMismatch;
		
		
	}

}
