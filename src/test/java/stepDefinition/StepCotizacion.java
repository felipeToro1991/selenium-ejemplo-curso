package stepDefinition;

import cucumber.api.java.en.Given;
import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import page.Home;
import xml.LeerPasos;

import java.util.List;


public class StepCotizacion {

    LeerPasos xml = new LeerPasos();
    WebDriver driver = DriverContext.getDriver();
    Home home;

    @Given("^el usuario ingresa a la pagina de PCFactory \"([^\"]*)\"$")
    public void elUsuarioIngresaALaPaginaDePCFactory(String url) {

    }
}
