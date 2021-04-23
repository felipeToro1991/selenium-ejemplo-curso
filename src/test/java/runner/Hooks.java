package runner;

import constants.Navegador;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import drivers.DriverContext;
import org.junit.After;

public class Hooks{
    @Before
    public static void beforeScenario(Scenario scenario){
        DriverContext.setUp(Navegador.Chrome,"https://demoqa.com");
    }
    @After
    public static void afterScenario(Scenario scenario){
        DriverContext.quitDriver();
    }
}
