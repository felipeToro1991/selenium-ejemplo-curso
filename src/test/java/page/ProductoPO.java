package page;

import drivers.DriverContext;
import excel.PcfactoryExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.ArrayList;
import java.util.List;

public class ProductoPO {

    String idProducto;
    String nombreProducto;
    String marcaProducto;
    String precioNormalProducto;
    String precioEfectivoProducto;
    String url;
    WebDriver driver = DriverContext.getDriver();

    ProductoPO producto;


    List<String> datosPagina;
    List<String> datosDb;
    String[] datosExcel;
    PcfactoryExcel excel;

    public ProductoPO() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span [@itemprop='sku'])[2]")
    public WebElement id;
    @FindBy(xpath = "//div [@class='ficha_titulos'] //span [@itemprop='name']")
    public WebElement nombre;
    @FindBy(xpath = "//div [@class='ficha_titulos'] //span [@itemprop='brand']")
    public WebElement marca;
    @FindBy(xpath = "//div [@class='ficha_precio_efectivo'] //h2")
    public WebElement precioEfectivo;
    @FindBy(xpath = "//div [@class='ficha_precio_normal'] //h2")
    public WebElement precioNormal;
    @FindBy(xpath = "//a [@id='agrega_carro']")
    WebElement btnAgregarCarrito;
    @FindBy(xpath = "//*[@id='agrega_cotiza']")
    WebElement btnCotizacion;

    public List<String> extraerTextos() {
        idProducto = id.getText();
        nombreProducto = nombre.getText();
        marcaProducto = marca.getText();
        precioNormalProducto = precioNormal.getText();
        precioEfectivoProducto = precioEfectivo.getText();

        ArrayList<String> datos = new ArrayList<>();
        PdfBciReports.addWebReportImage(
                "Pagina detalle del producto", "Detalles del producto: " + nombreProducto,
                EstadoPrueba.PASSED, false);
        datos.add(idProducto);
        datos.add(nombreProducto);
        datos.add(marcaProducto);
        datos.add(precioNormalProducto);
        datos.add(precioEfectivoProducto);
        datos.add(extraerUrl());
        return datos;
    }

    public String extraerUrl() {
        url = driver.getCurrentUrl();
        return url;
    }

    public String extraerId() {
        return idProducto;
    }

    public void agregaraCarrito() {
        btnAgregarCarrito.click();
    }
    public void agregarCotizacion(){
        btnCotizacion.click();
    }


    public void seValidaQueElProductoSeaElCorrecto() {
        excel = new PcfactoryExcel();

        producto = new ProductoPO();

        datosPagina = producto.extraerTextos();
        datosExcel = new String[datosPagina.size()];

        int i = 0;
        for (String info : datosPagina) {
            datosExcel[i] = info;
            i++;
        }
        excel.excelPcfactory(datosExcel);
    }

    public void cargaDatosExcel(List<String> datos){
        excel = new PcfactoryExcel();
        int largo = 0;
        largo = datos.size();

        datosExcel = new String[largo];
        int i = 0;
        for (String info : datos) {
            datosExcel[i] = info;
            i++;
        }
        excel.excelPcfactory(datosExcel);

    }

}
