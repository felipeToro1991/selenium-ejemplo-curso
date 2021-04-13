Feature: Proceso cotizacion PC gamer

    @Navegador
    Scenario: Cotizacion de productos Pcfactory
      Given usuario busca y selecciona el producto
      |procesador           |CPU Ryzen 5 3600X (AM4)                      |
      |placa madre AMD      |M/B AMD X570-P Prime (AM4)                   |
      |memoria ram PC       |DDR4 16GB 2400MHz Value RAM                  |
      |Refrigeracion        |Watercooling SR36                            |
      |disco duro SSD       |Unidad SSD 500GB PCIe NVMe M.2 SN750 Black   |
      |tarjeta de video     |Video AMD Radeon RX 6900XT O16G ROG Strix LC |
      |fuentes poder        |Fuente de Poder 650W 80Plus Bronze           |
      |gabinete             |Gabinete ATX Talos M1A                       |
      |monitor gamer        |Monitor Gamer 21,5" VP228HE 1 ms             |
      |teclado gamer        |Teclado Gamer K55 RGB Membrana Español USB   |
      |mouse gamer          |Mouse Gamer Rival 3 USB                      |
      |audifonos gamer      |Audífono Gamer GXT 450 Blizz RGB 7.1 Surround|
      #And se guarda la informacion del producto agregando a cotizacion
      #Then se valida el producto en cotizacion




