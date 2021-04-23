package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static metodosEnvueltos.Metodos.clickElemento;
import static metodosEnvueltos.Metodos.scrollDown;

public class BarraLateral {
    private WebDriver driver;
    public BarraLateral(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //Elementos
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    private WebElement spanLogin;
    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    private WebElement spanPracticeForm;

    //Metodos
    public void clickSpanLogin(){
        scrollDown();
        clickElemento(spanLogin);
    }
    public void clickSpanPracticeForm(){
        clickElemento(spanPracticeForm);
    }
}
