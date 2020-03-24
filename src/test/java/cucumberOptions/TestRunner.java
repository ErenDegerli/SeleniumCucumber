package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions") //package names not the classes!!

public class TestRunner extends AbstractTestNGCucumberTests {


}
