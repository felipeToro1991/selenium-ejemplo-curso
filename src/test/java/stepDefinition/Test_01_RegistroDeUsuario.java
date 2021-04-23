package stepDefinition;

import bd.Consultas;
import constants.Navegador;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import drivers.DriverContext;
import org.junit.Assert;
import page.BarraLateral;
import page.Inicio;
import page.Login;
import page.Register;
import runner.Hooks;

import java.util.List;
import java.util.Map;

import static metodosEnvueltos.Metodos.*;

public class Test_01_RegistroDeUsuario {
    private String carpetaScreenshots = "Test_01";
    @Given("^El usuario navega hasta la pagina de registro con url: \"([^\"]*)\"$")
    public void el_usuario_navega_hasta_la_pagina_de_registro(String url) throws InterruptedException {
        DriverContext.setUp(Navegador.Chrome,"https://demoqa.com");
        Inicio inicio = new Inicio();
        takeScreenshot(carpetaScreenshots);
        inicio.clickCardBookStore(); // Se va hacia la pagina de libros para alcanzar mas rapidamente el boton de login
        BarraLateral barraLateral = new BarraLateral();
        takeScreenshot(carpetaScreenshots);
        barraLateral.clickSpanLogin(); // se realiza click en login
        Login login = new Login();
        login.clickButtonNewUser(); // se hace click en el boton new user
        takeScreenshot(carpetaScreenshots);
        Assert.assertEquals(getCurrentUrl(),url);
    }
    @Given("^se registra con los siguientes datos:$")
    public void se_registra_con_los_siguientes_datos(List<Map<String,String>> datos){
        Register register = new Register();
        register.rellenarFirstName(datos.get(0).get("nombre"));
        register.rellenarLastName(datos.get(0).get("apellido"));
        String user = datos.get(0).get("usuario");
        String pass = datos.get(0).get("password");
        register.rellenarUserName(user);
        register.rellenarPassword(pass);
        Consultas consultas = new Consultas();
        consultas.crearUsuario(user,pass);
        takeScreenshot(carpetaScreenshots);
        register.esperarCaptchaCompleto();
        register.clickEnRegister();
    }
    @Then("^se valida que se despliegue un mensaje que diga \"([^\"]*)\"$")
    public void se_valida_que_se_despliegue_un_mensaje_que_diga(String mensajeDeExito){
        Register register = new Register();
        Assert.assertEquals(register.obtenerMensajeDeRegistro(),mensajeDeExito);
        screenshotAlert(carpetaScreenshots);
        DriverContext.quitDriver();
    }


}
