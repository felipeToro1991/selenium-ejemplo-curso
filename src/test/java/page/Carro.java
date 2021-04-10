package page;

import db.Conexion;
import db.Consultas;
import drivers.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Carro {

    WebDriver driver = DriverContext.getDriver();
    String idProducto;
    String descripcionProducto;
    String precioEfectivoProducto;

    Conexion conexion;
    Carro carro;
    Consultas sql;
    List<String> datosPagina;
    List<String> datosDb;


    public Carro() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div [@class='caluga-left-id'] /p")
    public List<WebElement> listaId;
    @FindBy(xpath = "//div [@id='enunciado-caluga']  //h1")
    public WebElement descripcion;
    @FindBy(xpath = "//p [@id='producto_precio']")
    public WebElement precioEfectivo;

    public List<String> extraerTextos(){
        List<String> id = new ArrayList<>();
        for(WebElement s : listaId){
            id.add(s.getText());
        }
        return id;
    }

    public void seValidaProductosDelCarrito(){
        conexion = new Conexion();
        sql = new Consultas();
        carro = new Carro();

        datosPagina = carro.extraerTextos();
        datosDb = sql.consultaID();
        Collections.sort(datosPagina);
        Collections.sort(datosDb);
        Assert.assertEquals("Las listas no son iguales", datosPagina, datosDb);
    }

}
