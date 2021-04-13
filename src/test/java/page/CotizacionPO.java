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

public class CotizacionPO {

    WebDriver driver = DriverContext.getDriver();
    String idProducto;
    String descripcionProducto;
    String precioEfectivoProducto;


    CotizacionPO cotizacionPO;

    List<String> datosPagina;
    List<String> datosDb;


    public CotizacionPO() {
        PageFactory.initElements(driver, this);
    }




    @FindBy(xpath = "//div [@class='caluga-left-id'] /p")
    public List<WebElement> listaId;
    @FindBy(xpath = "//div [@id='enunciado-caluga']  //h1")
    public WebElement descripcion;
    @FindBy(xpath = "//p [@id='producto_precio']")
    public WebElement precioEfectivo;
    @FindBy(xpath = "//H1[contains(text(), 'CARRO COTIZACIÓN ONLINE')]")
    public WebElement tituloCotizacion;

    public List<String> extraerTextos(){
        List<String> id = new ArrayList<>();
        for(WebElement s : listaId){
            id.add(s.getText());
        }
        return id;
    }

    /*public void seValidaProductosDelCarrito(){


        cotizacionPO = new CotizacionPO();

        datosPagina = carro.extraerTextos();
        datosDb = sql.consultaID();
        Collections.sort(datosPagina);
        Collections.sort(datosDb);
        Assert.assertEquals("Las listas no son iguales", datosPagina, datosDb);
    }*/

    public Boolean consultarTextoElemento(){
        if(tituloCotizacion.getText().equals("CARRO COTIZACIÓN ONLINE")){
            System.out.println("El elemento texto esta presente");
            PdfBciReports.addReport("Validacion titulo cotizacion","Validacion texto titulo pagina", EstadoPrueba.PASSED, false);
            return true;
        }else{
            System.out.println("El elemento texto no esta presente");
            PdfBciReports.addReport("Validacion titulo cotizacion","Validacion texto titulo pagina error", EstadoPrueba.FAILED, true);
            return false;
        }
    }

    public boolean compararIdProducto(String idProducto){
        for (WebElement info:listaId){
            if (idProducto.equals(info.getText())){
                System.out.println("El id del producto se encuentra en la cotizacion");
                PdfBciReports.addReport("validacion id cotizacion correcta", "validacion id cotizacion correcta", EstadoPrueba.PASSED, false);
                return true;
            }
        }
        System.out.println("El id del producto se encuentra en la cotizacion");
        PdfBciReports.addReport("validacion id cotizacion Error", "validacion id cotizacion error", EstadoPrueba.FAILED, true);
        return false;
    }



}