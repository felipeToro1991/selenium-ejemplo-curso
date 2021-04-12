package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import page.InicioPO;
import page.ProductoPO;
import page.ResultadoBusquedaPO;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.List;

public class StepCotizacion {

    WebDriver driver = DriverContext.getDriver();

    @Given("^usuario realiza busqueda de producto \"([^\"]*)\"$")
    public void usuarioRealizaBusquedaDeProducto(String producto) {
        InicioPO inicioPO = new InicioPO();
        inicioPO.insertarProducto(producto);
        PdfBciReports.addWebReportImage("Pagina principal con ingreso del producto", "Ingreso del producto", EstadoPrueba.PASSED, false);
        inicioPO.clickBtnBuscar();
    }


    @Given("usuario busca y selecciona el producto")
    public void usuarioBuscaYSeleccionaElProducto(DataTable tabla) {

        InicioPO inicioPO = new InicioPO();
        ResultadoBusquedaPO resultPO = new ResultadoBusquedaPO();
        ProductoPO productoPO = new ProductoPO();

        List<List<String>> datos = tabla.raw();
        for(int i=0; i < datos.size();i++){
            inicioPO.insertarProducto(datos.get(i).get(1));
            PdfBciReports.addWebReportImage("registro pagina", "Registro de recorrido por pagina", EstadoPrueba.PASSED,false);
            resultPO.seleccionarProducto(datos.get(i).get(1));

            
        }

    }
}
