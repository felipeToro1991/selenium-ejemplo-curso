package metodosEnvueltos;

import drivers.DriverContext;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Metodos extends DriverContext {
    public static boolean esperarElemento(WebElement elemento, int segundos){
        try{
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),segundos);
            wait.until(ExpectedConditions.elementToBeClickable(elemento));
            return true;

        } catch (Exception e) {
            return false;
        }

    }
    public static void clickElemento(WebElement elemento){
        if (esperarElemento(elemento,10)){
            elemento.click();
        }
        else System.out.println("No se puedo realizar click en el WebElement");
    }
    public static void sendKeys(WebElement elemento,String key){
        if (esperarElemento(elemento,10)){
            elemento.sendKeys(key);
        }
        else System.out.println("No se pudo enviar las keys al elemento");
    }
    public static void sendKeys(WebElement elemento, Keys key){
        if (esperarElemento(elemento,10)){
            elemento.sendKeys(key);
        }
        else System.out.println("No se pudo enviar las keys al elemento");
    }
    public static String getAlertText(){
        try {
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),10);
            wait.until(ExpectedConditions.alertIsPresent());
            return DriverContext.getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            return "";
        }

    }
    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("window.scrollBy(0,1000)");
    }
    public static String getCurrentUrl(){
        return DriverContext.getDriver().getCurrentUrl();
    }
    public static void takeScreenshot(String folder){
        File scrFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\" + folder + "\\" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void screenshotAlert(String folder){
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\" + folder + "\\" + System.currentTimeMillis() + ".png"));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DriverContext.getDriver().switchTo().alert().accept();
    }
    public static void clearInput(WebElement webElement){
        if (esperarElemento(webElement,10)){
            webElement.clear();
        }
    }
    public static String obtenerValorDeWebElement(WebElement element){
        if (esperarElemento(element,10)){
            return element.getText();
        }
        else return "";
    }
    public static void clickEnCoordenadas(int x,int y,WebElement element){
        Actions actions = new Actions(DriverContext.getDriver());
        actions.moveToElement(element, 0, 0);
        actions.click(element);
    }
    public static void aceptarAlerta(){
        try {
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),10);
            wait.until(ExpectedConditions.alertIsPresent());
            DriverContext.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
