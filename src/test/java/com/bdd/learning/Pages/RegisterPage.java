package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	// list webelements on register page

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTextField;

	@FindBy(id = "input-email")
	private WebElement emailTextField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextField;

	@FindBy(id = "input-password")
	private WebElement passwordTextField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement subscribeYesButton;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckBox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	
	

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// make actions for each webelement up top

	public void enterFirstName(String firstnametext) {

		firstNameTextField.sendKeys(firstnametext);

	}

	public void enterLastName(String lastnametext) {

		lastNameTextField.sendKeys(lastnametext);

	}

	public void enterEmail(String emailtext) {

		emailTextField.sendKeys(emailtext);

	}

	public void enterTelephoneNumber(String telephonetext) {

		telephoneTextField.sendKeys(telephonetext);

	}
	
	public void enterPassword(String passwordText) {
		passwordTextField.sendKeys(passwordText);
		
		}
	
	public void confirmPassword(String confirmPasswordText) {
		
		confirmPasswordTextField.sendKeys(confirmPasswordText);
		
		
	}
	public void clickOnNewsLetter() {
		
		subscribeYesButton.click();
	}
	
	public void clickOnPrivacyPolicy() {
		privacyPolicyCheckBox.click();
		
	}
	
	public AccountSuccessPage clickOnContinueButton() {//------------> leads to accountsSuccessPage
		
		continueButton.click();
		return new AccountSuccessPage(driver);
		
		
	}
	
	
	public String retrieveDuplicateEmailWarningText() {
		String dEmailMessage = duplicateEmailWarningMessage.getText();
		return dEmailMessage;

}
}
