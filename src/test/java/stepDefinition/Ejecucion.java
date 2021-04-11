package stepDefinition;

import constants.Navegador;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.DriverContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import reportes.EstadoPrueba;
import reportes.PdfBciReports;
import xml.LeerPasos;

import java.util.List;

public class Ejecucion {

    private static LeerPasos xml = new LeerPasos();

    @Before
    public static void setup(){
        List<String> url = xml.getxmlSucursalVirtual("Url", "PCFactory");
        DriverContext.setUp(Navegador.Chrome, url.get(1));
        String urlWeb = DriverContext.getDriver().getCurrentUrl();
        //PdfBciReports.createPDF();

        /*if(urlWeb.equals(url.get(1))){
            PdfBciReports.addWebReportImage("Levantamiento de navegador", "levantamiento de navegador en la pagina :"+url, EstadoPrueba.PASSED, false);
        }else{
            PdfBciReports.addWebReportImage("Levantamiento de navegador", "levantamiento de navegador en la pagina no fue correcto se cargo la URL:"+urlWeb, EstadoPrueba.FAILED, true);
        }*/
    }
    @After
    public static void tearDown(){
        //PdfBciReports.closePDF();
        DriverContext.quitDriver();
    }
}
