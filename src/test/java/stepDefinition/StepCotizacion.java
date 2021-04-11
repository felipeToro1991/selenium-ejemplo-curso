package stepDefinition;

import constants.Navegador;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import page.InicioPO;
import page.Producto;
import page.ResultadoBusqueda;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;
import xml.LeerPasos;

import java.sql.Driver;
import java.util.List;

public class StepCotizacion {

    WebDriver driver = DriverContext.getDriver();


    @Given("^usuario realiza busqueda de producto (.*)$")
    public void usuarioRealizaBusquedaDeProducto(String producto) {
        InicioPO inicioPO = new InicioPO();
        inicioPO.insertarProducto(producto);
        //PdfBciReports.addWebReportImage("Pagina principal con ingreso del producto", "Ingreso del producto", EstadoPrueba.PASSED, false);
        inicioPO.clickBtnBuscar();
    }

    @And("^usuario selecciona (.*)$")
    public void seleccionarProductoEnListado(String nombre) throws InterruptedException {
        ResultadoBusqueda resultadoBusqueda = new ResultadoBusqueda();
        resultadoBusqueda.seleccionarProducto(nombre);
    }

    @Then("usuario agrega el producto a la cotizacion")
    public void agregarProductoCotizacion(){
        Producto producto = new Producto();
        producto.presionarCotizar();
    }


}
