package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.ArrayList;
import java.util.List;


public class Producto {

    String idProducto;
    String nombreProducto;
    String marcaProducto;
    String precioNormalProducto;
    String precioEfectivoProducto;
    String url;
    WebDriver driver = DriverContext.getDriver();

    public Producto() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div [@class='ficha_titulos'] //span [@itemprop='sku']")
    public WebElement id;
    @FindBy(xpath = "//div [@class='ficha_titulos'] //span [@itemprop='name']")
    public WebElement nombre;
    @FindBy(xpath = "//div [@class='ficha_titulos'] //span [@itemprop='brand']")
    public WebElement marca;
    @FindBy(xpath = "//div [@class='ficha_precio_efectivo'] //h2")
    public WebElement precioEfectivo;
    @FindBy(xpath = "//div [@class='ficha_precio_normal'] //h2")
    public WebElement precioNormal;

    public List<String> extraerTextos(){
        idProducto = id.getText();
        nombreProducto = nombre.getText();
        marcaProducto = marca.getText();
        precioNormalProducto = precioNormal.getText();
        precioEfectivoProducto = precioEfectivo.getText();

        ArrayList<String> datos = new ArrayList();
        PdfBciReports.addWebReportImage(
                "Pagina detalle del producto", "Detalles del producto",
                EstadoPrueba.PASSED, false);
        datos.add(idProducto);
        datos.add(nombreProducto);
        datos.add(marcaProducto);
        datos.add(precioNormalProducto);
        datos.add(precioEfectivoProducto);
        datos.add(extraerUrl());
        return datos;
    }

    public String extraerUrl(){
        url = driver.getCurrentUrl();
        return url;
    }

    public String extraerId(){
        return id.getText();
    }


}
