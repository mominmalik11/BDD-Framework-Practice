package runner_files;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)//write this code first
@CucumberOptions(
		
		features = "src/test/resources",
		glue     = {"step_definitions"},
		tags     = "@TutorialsNinjaLogin") //write this second, features is where the features file is, glue is where the step definition file is, tag is the top part of the features file

public class Runner_Junit {
	
	
	

}
