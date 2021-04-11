package page;

import drivers.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultadoBusqueda {

    public ResultadoBusqueda() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }
    @FindBy(xpath = "//span [@class = 'nombre']")
    public List<WebElement> listaProductos;
    public void seleccionarProducto (String nombre) throws InterruptedException {
        for (WebElement producto: listaProductos){
            if(producto.getText().equals(nombre)){
                producto.click();
                Thread.sleep(3000);
                break;
            }
        }
    }
}
