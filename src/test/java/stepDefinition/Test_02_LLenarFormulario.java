package stepDefinition;

import bd.Consultas;
import constants.Navegador;
import cucumber.api.java.en.Given;
import drivers.DriverContext;
import org.ini4j.Ini;
import org.junit.Assert;
import page.BarraLateral;
import page.Form;
import page.Inicio;
import runner.Hooks;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

import static metodosEnvueltos.Metodos.getCurrentUrl;
import static metodosEnvueltos.Metodos.takeScreenshot;

public class Test_02_LLenarFormulario  {
    private String carpetaScreenshots = "Test_02";
    private String urlBD = "jdbc:mysql://127.0.0.1:3306/demoqa";
    private String userBD = "root";
    private String passBD = "admin";
    @Given("^El usuario navega hasta la pagina en donde se encuentra el formulario \"([^\"]*)\"$")
    public void el_usuario_navega_hasta_la_pagina_en_donde_se_encuentra_el_formulario(String url) throws Throwable {
        DriverContext.setUp(Navegador.Chrome,"https://demoqa.com");
        Inicio inicio = new Inicio();
        takeScreenshot(carpetaScreenshots);
        inicio.clickCardForms();
        takeScreenshot(carpetaScreenshots);
        BarraLateral barraLateral = new BarraLateral();
        barraLateral.clickSpanPracticeForm();
        takeScreenshot(carpetaScreenshots);
        Assert.assertEquals(getCurrentUrl(),url); // Se valida que se haya navegado correctamente al formulario
    }
    @Given("^se llena el formulario con los datos de la BASE DE DATOS$")
    public void se_llena_el_formulario_con_los_datos_de_la_BASE_DE_DATOS(){
        Consultas consultas = new Consultas();
        Map<String,String> datos = consultas.getDatosPersona();
        Form form = new Form();
        form.seleccionarGenero(datos.get("genero"));
        System.out.println("Se selecciona genero");
        form.rellenarFirstName(datos.get("nombre"));
        System.out.println("Se ingresa el nombre");
        form.rellenarLastName(datos.get("apellido"));
        System.out.println("Se ingresa el apellido");
        form.rellenarEmail(datos.get("email"));
        System.out.println("Se rellena el email");
        form.rellenarNumber(datos.get("numero"));
        System.out.println("Se ingresa el numero de telefono");
        form.rellenarBirth(datos.get("fechaNacimiento"));
        System.out.println("Se ingresa la fecha de nacimiento");
        form.rellenarDireccion(datos.get("direccion"));
        System.out.println("Se ingresa la direccion");
        form.seleccionarEstado(datos.get("estado"));

    }

    @Given("^subject con los siguientes datos:$")
    public void subject_con_los_siguientes_datos(List<String> arg1)  {
        Form form = new Form();
        for(String subject:arg1){
            form.ingresarSubject(subject);
        }
    }

    @Given("^hobbies con los siguientes datos:$")
    public void hobbies_con_los_siguientes_datos(List<String> arg1) throws InterruptedException {
        Form form = new Form();
        for (String hobbie: arg1){
            form.seleccionarHobbie(hobbie);
        }
        takeScreenshot(carpetaScreenshots);
        form.clickBotonSubmit();
        form.esperarModalContent();
        takeScreenshot(carpetaScreenshots); // Se agrega evidencia
        DriverContext.quitDriver();
    }
}
