package Stepdefintion;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/Automationexcercise.feature",
    glue = "Stepdefinition",
    		plugin = { "pretty", "html:target/reports.html", "json:target/cucumber.json", "junit:target/reports.xml"}
   )

public class testrunner {
	

}
