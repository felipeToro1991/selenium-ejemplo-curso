package stepDefinition;

import bd.Consultas;
import constants.Navegador;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.it.Ma;
import drivers.DriverContext;
import excel.AccionesExcel;
import gherkin.lexer.Th;
import org.junit.Assert;
import page.Book;
import page.Inicio;
import page.Login;
import runner.Hooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static metodosEnvueltos.Metodos.getCurrentUrl;
import static metodosEnvueltos.Metodos.takeScreenshot;

public class Test_03_BookStore  {
    private String carpetaScreenshots = "Test_03";
    static List<Map<String,String>> todosLosLibros = new ArrayList();
    @Given("^el usuario navega hasta la pagina de BookStore con url \"([^\"]*)\"$")
    public void el_usuario_navega_hasta_la_pagina_de_BookStore_con_url(String url) throws InterruptedException {
        DriverContext.setUp(Navegador.Chrome,"https://demoqa.com");
        Inicio inicio = new Inicio();
        takeScreenshot(carpetaScreenshots);
        inicio.clickCardBookStore();
        Assert.assertEquals(getCurrentUrl(),url);
        takeScreenshot(carpetaScreenshots);
        System.out.println("Se navega exitosamente a la url: "+ url);
    }

    @Given("^se realiza el login con los datos tomados desde la BD$")
    public void se_realiza_el_login_con_los_datos_tomados_desde_la_BD() throws InterruptedException {
        Consultas consultas = new Consultas();
        Map<String,String> credenciales = consultas.obtenerCredencialesDB();
        Book book = new Book();
        book.clickBotonLogin();
        Login login = new Login();
        login.rellenarUserName(credenciales.get("user"));
        login.rellenarPassword(credenciales.get("pass"));
        takeScreenshot(carpetaScreenshots);
        login.clickBotonLogin();
        Assert.assertEquals(credenciales.get("user"),book.obtenerUsuarioConectado());
        System.out.println("Se accede correctamente como usuario: "+credenciales.get("user"));
    }

    @Given("^se eligen los siguientes libros para añadirlos a la coleccion del usuario:$")
    public void se_eligen_los_siguientes_libros_para_añadirlos_a_la_coleccion_del_usuario(List<String> libros) throws InterruptedException {


        Book book = new Book();
        for (String libro: libros){
            Map<String,String> datosLibros = new HashMap<String, String>();
            book.seleccionarLibroSegunTitulo(libro);
            datosLibros.put("isbn",book.obtenerISBN());
            datosLibros.put("title",book.obtenerTitle());
            datosLibros.put("subTitle",book.obtenerSubTitle());
            datosLibros.put("author",book.obtenerAuthor());
            datosLibros.put("publisher",book.obtenerPublisher());
            datosLibros.put("pages",book.obtenerPages());
            datosLibros.put("website",book.obtenerWebsite());
            todosLosLibros.add(datosLibros);
            book.anadirALaColeccion();
            book.aceptarAlertaDeLibroAgregado();
            book.volverABookStore();
        }
        book.irAPerfil();
        //Se añade evidencia de que se agregan los libros al perfil
        Thread.sleep(1000);
        takeScreenshot(carpetaScreenshots);

    }
    @Given("^se validan los datos recopilados con la BD$")
    public void se_validan_los_datos_recopilados_con_la_BD(){
        Consultas consultas = new Consultas();
        List<String> isbnBD = consultas.obtenerISBN(); //se obtienen los isbn de la base de datos
        for (Map<String,String> datosLibro:todosLosLibros){

            if (isbnBD.contains(datosLibro.get("isbn"))){
                System.out.println("Libro: "+ datosLibro.get("title") + ". Validado correctamente con la BD");
            }
            else Assert.fail();
        }
    }

    @Then("^se genera un archivo excel en donde se guardan los datos de los libros recopilados$")
    public void se_genera_un_archivo_excel_en_donde_se_guardan_los_datos_de_los_libros_recopilados() {
        AccionesExcel accionesExcel = new AccionesExcel();
        accionesExcel.crearNuevoExcel("Libros","Libros agregados", new String[]{"Titulo", "Autor", "ISBN","Publisher","Total de paginas","Website"});

        for (Map<String,String> libros:todosLosLibros){
            String titulo = libros.get("title");
            String autor = libros.get("author");
            String isbn = libros.get("isbn");
            String publisher = libros.get("publisher");
            String pages = libros.get("pages");
            String website = libros.get("website");
            accionesExcel.agregarLineaExcel("Libros", new String[]{titulo,autor,isbn,publisher,pages,website});
        }
        System.out.println("Se genera excel con datos de los libros recopilados");
        DriverContext.quitDriver();
    }



}
