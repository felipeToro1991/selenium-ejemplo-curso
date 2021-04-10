package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

import java.util.List;


public class ResultadoBusqueda {

    WebDriver driver = DriverContext.getDriver();

    public ResultadoBusqueda() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span [@class='nombre']")
    public List<WebElement> listadoNombreProductos;

    public void selecionarProducto(String nombreProducto) {

        for (WebElement l : listadoNombreProductos) {
            if (l.getText().equals(nombreProducto)) {
                PdfBciReports.addWebReportImage(
                        "Pagina resultados de busqueda de producto", "Selecion del producto",
                        EstadoPrueba.PASSED, false);
                l.click();
                break;
            }
        }
    }
}
