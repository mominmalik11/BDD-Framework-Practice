package step_definitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.AccountSuccessPage;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.RegisterPage;
import com.tutorialsninja.bdd.qa.Utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Register {//to get the below methods ready to be filled right click on the feature file associated and run as cucumber feature
	// in the output console copy and paste all the snippets and implements into this page and complete as follows 
	
	public WebDriver driver;
	public HomePage homePage;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;
	
	
	
	
	
	@Given("User navigates to RegisterPage")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();// ----> leads to register page
		
		
		
		//driver.findElement(By.linkText("My Account")).click();;
		//driver.findElement(By.linkText("Register")).click();

	    
	}

	

	@When("User enter below mandatory fields")
	public void user_enter_below_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {//this datatable is done using the map interface, study map interface
      Map<String, String>dataMap =  dataTable.asMap(String.class, String.class);//here you have delcared the map
      //registerPage = new RegisterPage(driver);
      registerPage.enterFirstName(dataMap.get("firstname"));
      registerPage.enterLastName(dataMap.get("lastname"));
      registerPage.enterEmail(Util.emailWithDateTimeStamp());
      registerPage.enterTelephoneNumber(dataMap.get("telephone"));
      registerPage.enterPassword(dataMap.get("password"));
      registerPage.confirmPassword(dataMap.get("confirmpassword"));
      
      
      
      
      
      
      
      
      //driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));//here you are giving it coordinates based on the register feature file
      //driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
      //driver.findElement(By.id("input-email")).sendKeys((Util.emailWithDateTimeStamp()));//need emailWithTimeStamp, not on the feature file 
      //driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
      //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
      //driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	
	
	}
	
	@When("User enter below all fields")
	public void user_enter_below_all_fields(io.cucumber.datatable.DataTable dataTable) {//this datatable is done using the map interface, study map interface
      Map<String, String>dataMap =  dataTable.asMap(String.class, String.class);//here you have delcared the map
      
      //registerPage = new RegisterPage(driver);
      registerPage.enterFirstName(dataMap.get("firstname"));
      registerPage.enterLastName(dataMap.get("lastname"));
      registerPage.enterEmail(Util.emailWithDateTimeStamp());
      registerPage.enterTelephoneNumber(dataMap.get("telephone"));
      registerPage.enterPassword(dataMap.get("password"));
      registerPage.confirmPassword(dataMap.get("confirmpassword")); 
      
      
      
      
      
      
      
      
      //driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));//here you are giving it coordinates based on the register feature file
      //driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
      //driver.findElement(By.id("input-email")).sendKeys((Util.emailWithDateTimeStamp()));//need emailWithTimeStamp, not on the feature file 
      //driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
      //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
      //driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	
	
	}
	
	@When("User enter below all fields with existing email")
	public void user_enter_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {//this datatable is done using the map interface, study map interface
      Map<String, String>dataMap =  dataTable.asMap(String.class, String.class);//here you have delcared the map
     
      
      //registerPage = new RegisterPage(driver);
      registerPage.enterFirstName(dataMap.get("firstname"));
      registerPage.enterLastName(dataMap.get("lastname"));
      registerPage.enterEmail(dataMap.get("email"));
      registerPage.enterTelephoneNumber(dataMap.get("telephone"));
      registerPage.enterPassword(dataMap.get("password"));
      registerPage.confirmPassword(dataMap.get("confirmpassword"));
      
      
      
      
      
      
      
      
      //driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));//here you are giving it coordinates based on the register feature file
      //driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
      //driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
      //driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
      //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
      //driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	
	
	}
	
	@And("User selects Yes for newletter")
	public void user_selects_yes_for_newletter() {
		 //registerPage = new RegisterPage(driver);
		 registerPage.clickOnNewsLetter();
		
		
		
		//driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();

	    
	}

	@And("User selects PrivacyPolicy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		 //registerPage = new RegisterPage(driver);
		 registerPage.clickOnPrivacyPolicy();
		
		//driver.findElement(By.xpath("//input[@name = 'agree' and @value = '1']")).click();

	    
	}
	
	@When("User clicks on Conintue button")//-------------------> this takes us to account success page
	public void user_clicks_on_conintue_button() {
		//registerPage = new RegisterPage(driver);
		accountSuccessPage = registerPage.clickOnContinueButton();
		
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	    
	}

	@Then("User account gets created succesfully")
	public void user_account_gets_created_succesfully() {
	
		//accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.verifyDisplayStatusOfAccountSuccessMessage()); 
		
		
		//Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")).isDisplayed());
	    
	}

	

	@Then("User account gets warning message of duplicate email")
	public void user_account_gets_warning_message_of_duplicate_email() {
		//registerPage = new RegisterPage(driver);
		String actualWarningMessage = registerPage.retrieveDuplicateEmailWarningText();
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		
		
		
		
		
		
		
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		//String expectedWarningMessage =	"Warning: E-Mail Address is already registered!";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	    
	}

	@Then("User account gets PrivacyPolicy warning message")
	public void user_account_gets_privacy_policy_warning_message() {
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		String expectedWarningMessage =	"Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	   
	}


}
