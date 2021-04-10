package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.DriverContext;
import reportes.PdfBciReports;

public class Ejecucion {

    @Before
    public static void config() {
        PdfBciReports.createPDF();
    }

    @After
    public static void tearDown(){
        PdfBciReports.closePDF();
        /*DriverContext.quitDriver();*/
    }

}
