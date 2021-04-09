package runner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Navegador"},
        glue = {"stepDefinition"},
        features = "./src/test/java/feature/",
        plugin = {"pretty", "json:target/ReportJson/LocalChromecucumber.json"})
public class Runner {


}