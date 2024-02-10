package step_definitions;




import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.AccountPage;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.LoginPage;
import com.tutorialsninja.bdd.qa.Utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {// we need to make a gluecode to connect the features file and step definition file
	
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public Properties dataprop;

	
	
	

	@Given("User navigates to LoginPage")
	public void user_navigates_to_loginpage() {
		driver = DriverFactory.getDriver();
		
		//driver.findElement(By.linkText("My Account")).click();;
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		
		//driver.findElement(By.linkText("Login")).click();// this takes us to the LoginPage
		loginPage = homePage.selectLoginOption();
		
		
		
		}
	@When("^User enters valid email (.+) into email textbox field$")
	public void user_enters_valid_email_into_email_text_box_field(String validEmailText) {
		//loginPage = new LoginPage(driver); because we added the loginoption new reurn in homepage we dont need to add this anymore
		loginPage.enterEmail(validEmailText);
		
		
		
		//driver.findElement(By.id("input-email")).sendKeys(validEmailText);
		
	}
	
	@And("^user enters valid password (.+) into password textbox field$")
	public void user_enters_valid_password_into_password_textbox_field(String validPasswordText) {
		//loginPage = new LoginPage(driver);

		loginPage.enterPassword(validPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(validPasswordText);

		
	}
	
	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		//loginPage = new LoginPage(driver);
		accountPage = loginPage.clickOnLoginButton();//----------> this takes us to the account page 
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
	}
	
	@Then("user is navigated to the AccountPage")
	public void user_is_navigated_to_the_accountpage() {//make sure to import this using testNG NOT Junit
		
		//accountPage = new AccountPage(driver);---------> adding new return accountPage action item in loginpage java 
		accountPage.validateDisplayStatusOfEditAccountInforLink();
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());		
	
	
	}

	@When("User enters invalid email")
	public void user_enters_invalid_email() {
		//loginPage = new LoginPage(driver);// since method occurs in login page
		loginPage.enterEmail(Util.emailWithDateTimeStamp());

		
		//driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);

		
	}
	
	@And("user enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPasswordText) {
		//loginPage = new LoginPage(driver);
		loginPage.enterPassword(invalidPasswordText);
		
		
		
		//driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);

		
	}
	
	@Then("user gets warning message about the credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() {
		//loginPage = new LoginPage(driver);
		String actualWarningMessageString = loginPage.retrieveCredentialsMismatchWarningMessage();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		
		
		
		//String actualWarningMessageString = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		//String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessageString.contains(expectedWarningMessage));
	}
	
	
	}



	

