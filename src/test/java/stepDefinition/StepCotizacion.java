package stepDefinition;


import constants.Navegador;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import drivers.DriverContext;
import gherkin.lexer.Ca;
import page.Carro;
import page.Home;
import page.Producto;
import page.ResultadoBusqueda;


import java.util.List;

public class StepCotizacion {

    Home home;
    ResultadoBusqueda resultadoBusqueda;
    Producto producto;
    Carro carro;

    int i;

    @Given("^el usuario ingresa a la pagina de PCFactory \"([^\"]*)\"$")
    public void elUsuarioIngresaALaPaginaDePCFactory(String url) {
        DriverContext.setUp(Navegador.Chrome, url);
    }

    @And("^el usuario busca y selecciona el producto$")
    public void elUsuarioBuscaYSeleccionaElProducto(DataTable dataTable) {
        home = new Home();
        resultadoBusqueda = new ResultadoBusqueda();
        producto = new Producto();

        List<List<String>> dato = dataTable.raw();
        for (i = 1; i < dato.size(); i++) {
            home.buscarProducto(dato.get(i).get(0));
            resultadoBusqueda.selecionarProducto(dato.get(i).get(1));
            producto.seValidaQueElProductoSeaElCorrecto();
            producto.agregarAlCarrito();
        }
    }

    @Then("se verifica que los productos se han agregado al carrito correctamente")
    public void seVerificaQueLosProductosSeHanAgregadoAlCarritoCorrectamente() {
        carro = new Carro();
        carro.seValidaProductosDelCarrito();
    }
}
