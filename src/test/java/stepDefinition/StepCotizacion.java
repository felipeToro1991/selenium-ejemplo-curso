package stepDefinition;

import constants.Navegador;
import cucumber.api.java.en.Given;
import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import page.Home;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.sql.Driver;

public class StepCotizacion {

    WebDriver driver = DriverContext.getDriver();

    @Given("^usuario realiza busqueda de producto \"([^\"]*)\"$")
    public void usuarioRealizaBusquedaDeProducto(String producto) {
        Home home = new Home();
        home.buscarProducto(producto);


    }


}
