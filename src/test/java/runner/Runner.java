package runner;

import constants.Navegador;
import drivers.DriverContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Navegador"},
                 glue = {"stepDefinition"},
                 features = {"./src/test/java/feature/"},
                 plugin = {"pretty", "json:target/ReportJson/LocalChromecucumber.json"})
public class Runner {
    public Runner() { /* compiled code */ }
}