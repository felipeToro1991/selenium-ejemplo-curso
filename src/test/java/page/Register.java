package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static metodosEnvueltos.Metodos.*;

public class Register {
    private WebDriver driver;
    public Register(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //Elementos
    @FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[contains(@placeholder,'Last Name')]")
    private WebElement inputLastName;
    @FindBy(xpath = "//input[contains(@placeholder,'UserName')]")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[contains(@placeholder,'Password')]")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@id='register']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//div[contains(@class,'recaptcha-checkbox-checkmark')]")
    private WebElement captcha;


    //Metodos
    public String obtenerMensajeDeRegistro(){
        return getAlertText();
    }
    public void rellenarFirstName(String firstName){
        sendKeys(inputFirstName,firstName);
    }
    public void rellenarLastName(String lastName){
        sendKeys(inputLastName,lastName);
    }
    public void rellenarUserName(String userName){
        sendKeys(inputUserName,userName);
    }
    public void rellenarPassword(String password){
        sendKeys(inputPassword,password);
    }
    public void clickEnRegister(){
        clickElemento(buttonRegister);
    }
    public void esperarCaptchaCompleto(){
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
