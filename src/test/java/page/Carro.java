package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.List;

public class Carro {

    WebDriver driver = DriverContext.getDriver();
    String idProducto;
    String descripcionProducto;
    String precioEfectivoProducto;

    public Carro() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='search']")
    public WebElement inputSearch;
    @FindBy(xpath = "//*[@id='search_btn']")
    public WebElement btnSearch;

    @FindBy(xpath = "//div [@class='caluga-left-id'] /p")
    public WebElement id;
    @FindBy(xpath = "//div [@id='enunciado-caluga']  //h1")
    public WebElement descripcion;
    @FindBy(xpath = "//p [@id='producto_precio']")
    public WebElement precioEfectivo;

    public List<String> extraerTextos(List<String> datos){

        idProducto = id.getText();
        precioEfectivoProducto = precioEfectivo.getText();

        /*PdfBciReports.addWebReportImage(
                "Pagina carrito", "Detalles del carrito",
                EstadoPrueba.PASSED, true);*/
        datos.add(idProducto);
        datos.add(precioEfectivoProducto);
        return datos;
    }

}
