package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

import static metodosEnvueltos.Metodos.*;

public class Book {
    private WebDriver driver;
    public Book(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    //Elementos
    @FindBy(xpath = "//button[@id='login']")
    private WebElement btnLogin;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    private WebElement cardForms;
    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement nombreUsuarioConectado;
    @FindBy(xpath = "//div[@id='ISBN-wrapper']") private WebElement isbn;
    @FindBy(xpath = "//div[@id='title-wrapper']") private WebElement title;
    @FindBy(xpath = "//div[@id='subtitle-wrapper']") private WebElement subtitle;
    @FindBy(xpath = "//div[@id='author-wrapper']") private WebElement author;
    @FindBy(xpath = "//div[@id='publisher-wrapper']") private WebElement publisher;
    @FindBy(xpath = "//div[@id='pages-wrapper']") private WebElement pages;
    @FindBy(xpath = "//div[@id='website-wrapper']") private WebElement website;
    @FindBy(xpath = "//button[contains(text(),'Back To Book Store')]") private WebElement backToBookStore;
    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]") private WebElement anadirAColeccion;
    @FindBy(xpath = "//span[contains(@id,'see-book-')]") private List<WebElement> librosEnTienda;
    @FindBy(xpath = "//span[contains(text(),'Profile')]") private WebElement profile;




    //Metodos
    public void clickBotonLogin(){
        clickElemento(btnLogin);
    }
    public String obtenerUsuarioConectado(){
        return obtenerValorDeWebElement(nombreUsuarioConectado);
    }
    public void seleccionarLibroSegunTitulo(String titulo){
        for (WebElement libro: librosEnTienda){
            if (esperarElemento(libro,10)){
                if (obtenerValorDeWebElement(libro).toLowerCase(Locale.ROOT).equals(titulo.toLowerCase(Locale.ROOT))){
                    clickElemento(libro);
                }
            }

        }
    }
    public void volverABookStore(){
        clickElemento(backToBookStore);
    }
    public String obtenerISBN(){
        String textoFormateado = obtenerValorDeWebElement(isbn).replaceAll("\n","");
        return textoFormateado.replaceAll("ISBN :","");
    }
    public String obtenerTitle(){
        String textoFormateado = obtenerValorDeWebElement(title).replaceAll("\n","");
        return textoFormateado.replaceAll("Title :","");
    }
    public String obtenerSubTitle(){
        String textoFormateado = obtenerValorDeWebElement(subtitle).replaceAll("\n","");
        return textoFormateado.replaceAll("Sub Title :","");
    }
    public String obtenerAuthor(){
        String textoFormateado = obtenerValorDeWebElement(author).replaceAll("\n","");
        return textoFormateado.replaceAll("Author :","");
    }
    public String obtenerPublisher(){
        String textoFormateado = obtenerValorDeWebElement(publisher).replaceAll("\n","");
        return textoFormateado.replaceAll("Publisher :","");
    }
    public String obtenerPages(){
        String textoFormateado = obtenerValorDeWebElement(pages).replaceAll("\n","");
        return textoFormateado.replaceAll("Total Pages :","");
    }
    public String obtenerWebsite(){
        String textoFormateado = obtenerValorDeWebElement(website).replaceAll("\n","");
        return textoFormateado.replaceAll("Website :","");
    }
    public void anadirALaColeccion(){
        clickElemento(anadirAColeccion);
    }
    public void aceptarAlertaDeLibroAgregado(){
        aceptarAlerta();
    }
    public void irAPerfil(){
        scrollDown();
        clickElemento(profile);
    }

}
