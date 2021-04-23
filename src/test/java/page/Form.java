package page;

import drivers.DriverContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

import static metodosEnvueltos.Metodos.*;

public class Form {
    private WebDriver driver;
    public Form(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //Elementos
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement inputUserEmail;
    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement inputUserNumber;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement inputBirth;
    @FindBy(xpath = "//input[@id='subjectsInput']")
    private WebElement inputSubjects;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement inputAddress;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement btnSubmit;
    @FindBy(xpath = "//label[contains(@class,'custom-control-label')]")
    private List<WebElement> inputGenderList;
    @FindBy(xpath = "//div[contains(@id,'react-select-3-option')]")
    private List<WebElement> estados;
    @FindBy(xpath = "//div[contains(@id,'react-select-4-option')]")
    private List<WebElement> ciudades;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[10]/div[2]/div[1]/div[1]/div[2]/div[1]")
    private WebElement expandEstados;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[10]/div[3]/div[1]/div[1]/div[2]/div[1]")
    private WebElement expandCiudades;
    @FindBy(xpath = "//*[contains(@class,'modal-content')]")
    private WebElement modalContent;

    //Metodos
    public void clickBotonSubmit(){
        clickElemento(btnSubmit);
    }
    public void rellenarLastName(String lastName){
        sendKeys(inputLastName,lastName);
    }
    public void rellenarFirstName(String firstName){
        sendKeys(inputFirstName,firstName);
    }
    public void rellenarEmail(String email){
        sendKeys(inputUserEmail,email);
    }
    public void rellenarNumber(String number){
        sendKeys(inputUserNumber,number);
    }
    public void rellenarBirth(String birth) {
        //clearInput(inputBirth);
        //sendKeys(inputBirth,birth); no funciona el input de fecha si se borra la fecha se cae la pagina
    }
    public void rellenarDireccion(String direccion){
        sendKeys(inputAddress,direccion);
    }
    public void seleccionarGenero(String genero){
        for(WebElement inputGenero: inputGenderList){
            if (esperarElemento(inputGenero,10)){
                if (obtenerValorDeWebElement(inputGenero).toLowerCase(Locale.ROOT).equals(genero.toLowerCase(Locale.ROOT))){
                    clickElemento(inputGenero);
                }
            }
        }
    }
    public void seleccionarHobbie(String genero){
        for(WebElement inputGenero: inputGenderList){
            if (esperarElemento(inputGenero,10)){
                if (obtenerValorDeWebElement(inputGenero).toLowerCase(Locale.ROOT).equals(genero.toLowerCase(Locale.ROOT))){
                    clickElemento(inputGenero);
                }
            }
        }
    }
    public void ingresarSubject(String subject){
        if (esperarElemento(inputSubjects,10)){
            sendKeys(inputSubjects,subject);
            sendKeys(inputSubjects,Keys.TAB);
        }
    }
    public void seleccionarEstado(String estado){
        if (esperarElemento(expandEstados,10)){
            expandEstados.click();
            for (WebElement estadosDesplegados: estados){
                if (estadosDesplegados.getText().toLowerCase(Locale.ROOT).equals(estado.toLowerCase(Locale.ROOT))){
                    clickEnCoordenadas(estadosDesplegados.getLocation().getX(),estadosDesplegados.getLocation().getY(),estadosDesplegados);
                }

            }
        }
    }
    public void esperarModalContent(){
        esperarElemento(modalContent,10);
    }

}
