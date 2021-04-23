@Navegador
Feature: demoQA


  Scenario: Se registra un nuevo usuario
    Given El usuario navega hasta la pagina de registro con url: "https://demoqa.com/register"
    And se registra con los siguientes datos:
    |nombre           |apellido          |usuario         |password             |
    |Robert           |Jhonson           |qdwe123qwe     |AAmarillo$$$123456   |
    Then se valida que se despliegue un mensaje que diga "User Register Successfully."
  Scenario: Se llena el formulario
    Given El usuario navega hasta la pagina en donde se encuentra el formulario "https://demoqa.com/automation-practice-form"
    And se llena el formulario con los datos de la BASE DE DATOS
    And subject con los siguientes datos:
      |Hindi|
      |Chemistry|
      |Maths|
    And hobbies con los siguientes datos:
      | Reading |
      | Music   |
  Scenario: Book Store
    Given el usuario navega hasta la pagina de BookStore con url "https://demoqa.com/books"
    And se realiza el login con los datos tomados desde la BD
    And se eligen los siguientes libros para añadirlos a la coleccion del usuario:
      |Git Pocket Guide|Learning JavaScript Design Patterns|Designing Evolvable Web APIs with ASP.NET|Speaking JavaScript|You Don't Know JS|
    And se validan los datos recopilados con la BD
    Then se genera un archivo excel en donde se guardan los datos de los libros recopilados


