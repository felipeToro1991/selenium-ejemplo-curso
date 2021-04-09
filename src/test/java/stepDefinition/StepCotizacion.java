package stepDefinition;

import constants.Navegador;
import cucumber.api.java.en.Given;
import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import page.InicioPO;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.sql.Driver;

public class StepCotizacion {

    WebDriver driver = DriverContext.getDriver();

    @Given("^usuario realiza busqueda de producto \"([^\"]*)\"$")
    public void usuarioRealizaBusquedaDeProducto(String producto) {
        InicioPO inicioPO = new InicioPO();
        inicioPO.insertarProducto(producto);
        PdfBciReports.addWebReportImage("Pagina principal con ingreso del producto", "Ingreso del producto", EstadoPrueba.PASSED, false);
        inicioPO.clickBtnBuscar();
    }


}
