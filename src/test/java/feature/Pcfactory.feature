Feature: Proceso cotizacion PC gamer

    @Navegador
    Scenario: Cotizacion de productos Pcfactory
      Given el usuario ingresa a la pagina de PCFactory "https://www.pcfactory.cl/"
      And el usuario busca el producto "Procesador"
      And el usuario seleciona el producto "CPU Core i9-10900K 3.7GHz 20MB (1200)"
      And agrega el producto al carrito
      Then el usuario busca el producto "Memoria Ram"





