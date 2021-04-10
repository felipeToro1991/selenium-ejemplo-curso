package page;

import drivers.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;

public class Home {

    WebDriver driver = DriverContext.getDriver();

    public Home() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='search']")
    public WebElement inputSearch;
    @FindBy(xpath = "//*[@id='search_btn']")
    public WebElement btnSearch;


    public void buscarProducto(String tipoProducto) {
        inputSearch.sendKeys(tipoProducto);
        PdfBciReports.addWebReportImage(
                "Pagina principal con ingreso del producto", "Ingreso del producto: " + tipoProducto,
                EstadoPrueba.PASSED, false);
        btnSearch.click();
    }




}
