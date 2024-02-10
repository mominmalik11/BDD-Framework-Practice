package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	//list difference elements in the homepage 
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText = "Login")
	private WebElement loginDown;
	
	@FindBy(linkText = "Register")
	private WebElement registerDown;
	
	@FindBy(name = "search")
	private WebElement searchTextBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	
	
	public HomePage(WebDriver driver) {//create constructor with reference 
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	//now we list the actions for each of the elements above
	
	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}
	
	public LoginPage selectLoginOption() {
		loginDown.click();// -------> if you make the return of this to loginPage then you dont have to enter LoginPage loginPage = new LoginPage() in every method in Login.java
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {///----------------> same case as above 
		registerDown.click();
		return new RegisterPage(driver);
		
	}
	
	public void enterProductDetail(String productNameText) {
		
		searchTextBox.sendKeys(productNameText);
		
		
	}
	
	public SearchPage clickOnSeachButton() {//----------> leads to searchPage
		searchButton.click();
		return new SearchPage(driver);
	}
	

}
