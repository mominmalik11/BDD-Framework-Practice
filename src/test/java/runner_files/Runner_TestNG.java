package runner_files;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		
		dryRun = false,
		monochrome = true,
		features = {"src/test/resources/feature_files"} ,
		glue     = {"step_definitions", "com.bbd.learning.Hooks"} ,
		tags     = "@TutorialsNinjaLogin or @TutorialsNinjaRegister or @TutorialsNinjaSearchProduct",
		plugin   = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}
				)//write this second, features is where the features file is, glue is where the step definition file and hooks are, tag is the top part of the features file
				// the plugin is where reports are saved
public class Runner_TestNG extends AbstractTestNGCucumberTests {// you must extend the abstract StestNG cucmber class
	
	
	
	
	
	

}
