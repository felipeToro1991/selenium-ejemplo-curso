package page;

import drivers.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultadoBusquedaPO {

    public ResultadoBusquedaPO() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(@class, 'nombre')]")
    private List<WebElement> listNomProducto;

    @FindBy(xpath = "//div[contains(@class, 'filtro-ordenar-txt')]")
    private WebElement labelFiltroOrdenar;



    public void seleccionarProducto(String nombreProducto){

        for (WebElement list : listNomProducto){
            if(list.getText().equals(nombreProducto)){
                list.click();
                break;
            }
        }
    }

    public Boolean consultarElemento(){
        if(labelFiltroOrdenar.isDisplayed()){
            System.out.println("El elemento esta presente");
            return true;
        }else{
            System.out.println("El elemento no esta presente");
            return false;
        }
    }

    /*public Boolean ExisteProducto(String producto){
        if(){

        }


    }*/
}
