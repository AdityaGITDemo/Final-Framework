package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(
features={"src/test/java/features/Login.feature"},
glue= {"stepDefinitions"},
dryRun = false,
monochrome=true
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	

}
