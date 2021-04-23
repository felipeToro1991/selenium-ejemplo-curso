package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static metodosEnvueltos.Metodos.clickElemento;
import static metodosEnvueltos.Metodos.scrollDown;

public class Inicio {
    private WebDriver driver;
    public Inicio(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //Elementos
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]")
    private WebElement cardBookStore;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    private WebElement cardForms;

    //Metodos
    public void clickCardBookStore(){
        scrollDown();
        clickElemento(cardBookStore);
    }
    public void clickCardForms(){
        clickElemento(cardForms);
    }
}
