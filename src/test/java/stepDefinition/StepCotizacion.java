package stepDefinition;

import constants.Navegador;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import db.Conexion;
import db.Consultas;
import drivers.DriverContext;
import excel.PcfactoryExcel;
import org.junit.Assert;
import page.Home;
import page.Producto;
import page.ResultadoBusqueda;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.List;

public class StepCotizacion {

    Home home;
    ResultadoBusqueda resultadoBusqueda;
    Producto producto;

    PcfactoryExcel excel;
    Conexion conexion;
    Consultas sql;

    String id;
    List<String> datosPagina;
    List<String> datosDb;
    String [] datosExcel;

    @Given("^el usuario ingresa a la pagina de PCFactory \"([^\"]*)\"$")
    public void elUsuarioIngresaALaPaginaDePCFactory(String url) {
        DriverContext.setUp(Navegador.Chrome, url);
    }

    @And("^el usuario busca el producto \"([^\"]*)\"$")
    public void elUsuarioBuscaElProducto(String tipoProducto) {
        home = new Home();
        home.buscarProducto(tipoProducto);
    }

    @And("^el usuario seleciona el producto \"([^\"]*)\"$")
    public void elUsuarioSelecionaElProducto(String nombreProducto) {
        resultadoBusqueda = new ResultadoBusqueda();
        resultadoBusqueda.selecionarProducto(nombreProducto);
    }

    @And("se valida que el producto sea el correcto")
    public void seValidaQueElProductoSeaElCorrecto() {
        excel = new PcfactoryExcel();
        conexion = new Conexion();
        sql = new Consultas();

        producto = new Producto();
        id = producto.extraerId();
        datosPagina = producto.extraerTextos();
        datosExcel = new String[datosPagina.size()];
        datosDb = sql.consultaProductos(id);

        Assert.assertEquals("Las listas no son iguales", datosPagina,datosDb);
        int i = 0;
        for(String info : datosPagina){
            datosExcel[i] = info;
            i++;
        }

        excel.excelPcfactory(datosExcel);

    }
}
