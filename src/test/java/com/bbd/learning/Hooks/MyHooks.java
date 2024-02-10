package com.bbd.learning.Hooks;

import java.security.Principal;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.bdd.learning.DriverLogic.DriverFactory;
import com.tutorialsninja.bdd.qa.Utilities.Config_Reader;
import com.tutorialsninja.bdd.qa.Utilities.DataProp_reader;
import com.tutorialsninja.bdd.qa.Utilities.Util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class MyHooks {//this will essentially be the testbase for all the step definitions
	
	public WebDriver driver;
	public Properties prop; 
	public Properties dataprop;
	
	@Before
	public void setup() throws Exception {
		
		
		
		prop = Config_Reader.initializeConfigPropertiesFile();// throw declaration for this
		dataprop = DataProp_reader.initializeDataPropPropertiesFile();// this is initializing the different properties file we made for system generated response
			
		//DriverFactory.initializeBrowser("chrome");//this initializes the chrome code in the DriverFactory class we made 
		//since we coded in properties file we can recode the top line 
		DriverFactory.initializeBrowser(prop.getProperty("browser"));
		
		driver = DriverFactory.getDriver();// this returns the driver
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
		//driver.manage().window().maximize(); dont need this line since its initialized in the driverfactory class
		
		
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("url"));// this recodes the top to use the properties file 
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	
	// There are two more types of Hooks
	
	@BeforeStep
	public void checksBeforeEachStep() {
		System.out.println("Check this step to see if its working fine or not");
		
	}
	

}
