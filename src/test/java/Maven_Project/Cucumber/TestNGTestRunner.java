package Maven_Project.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\Dell\\IdeaProjects\\mvn\\src\\test\\java\\Maven_Project\\Cucumber",glue ="Maven_Project.StepDefinition",monochrome = true,tags = "@Regression",plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests
{

}
//src/test/java/Maven_Project/Cucumber