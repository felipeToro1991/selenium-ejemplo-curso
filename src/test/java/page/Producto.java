package page;

import db.Conexion;
import db.Consultas;
import drivers.DriverContext;
import excel.PcfactoryExcel;
import org.junit.Assert;
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

    Producto producto;
    Conexion conexion;
    Consultas sql;
    List<String> datosPagina;
    List<String> datosDb;
    String[] datosExcel;
    PcfactoryExcel excel;

    public Producto() {
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
    @FindBy (xpath = "//a [@id='agrega_carro']")
    WebElement btnAgregarCarrito;

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

    public void agregarAlCarrito(){
        btnAgregarCarrito.click();
    }

    public void seValidaQueElProductoSeaElCorrecto() {
        excel = new PcfactoryExcel();
        conexion = new Conexion();
        sql = new Consultas();
        producto = new Producto();

        datosPagina = producto.extraerTextos();
        datosExcel = new String[datosPagina.size()];
        datosDb = sql.consultaProductos(extraerId());

        Assert.assertEquals("Las listas no son iguales", datosPagina,datosDb);
        int i = 0;
        for(String info : datosPagina){
            datosExcel[i] = info;
            i++;
        }
        excel.excelPcfactory(datosExcel);
    }


}
