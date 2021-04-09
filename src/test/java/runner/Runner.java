package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {""},
        glue = {"stepDefinition"},
        features = "./src/test/java/feature/",
        plugin = {"pretty", "json:target/ReportJson/LocalChromecucumber.json"})
public class Runner {
}
