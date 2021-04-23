package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static metodosEnvueltos.Metodos.clickElemento;
import static metodosEnvueltos.Metodos.sendKeys;

public class Login {
    private WebDriver driver;
    public Login(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //Elementos
    @FindBy(xpath = "//button[@id='newUser']")
    private WebElement buttonNewUser;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@id='login']")
    private WebElement btnLogin;


    //Metodos
    public void clickButtonNewUser(){
        clickElemento(buttonNewUser);
    }
    public void clickBotonLogin(){
        clickElemento(btnLogin);
    }
    public void rellenarUserName(String user){
        sendKeys(inputUserName,user);
    }
    public void rellenarPassword(String pass){
        inputPassword.click();
        sendKeys(inputPassword,pass);
    }



}
