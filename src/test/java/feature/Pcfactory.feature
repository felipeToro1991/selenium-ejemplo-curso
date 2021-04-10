Feature: Proceso cotizacion PC gamer

  @Navegador
  Scenario: Cotizacion de productos Pcfactory
    Given el usuario ingresa a la pagina de PCFactory "https://www.pcfactory.cl/"
    And el usuario busca y selecciona el producto

      | TipoProducto     | nombreProducto                                                      |
      | Procesador       | CPU Core i9-10900K 3.7GHz 20MB (1200)                               |
      | Audifono Gamer   | Audífono SoundBlaster H3                                            |
      | Memoria Ram      | DDR4 8GB 2666MHz Value RAM                                          |
      | Fuente de poder  | Fuente Poder 750W Focus GX Plus 80Plus Gold Full Modular            |
      | Gabinete         | Gabinete E-ATX Winbot                                               |
      | Placa Madre      | M/B AMD TRX40-XE ROG Strix Gaming (TRX4)                            |
      | Monitor Gamer    | Monitor Gamer 23,6" KG241Q-P, Panel TN, 144 Hz, 1ms, FreeSync, HDMI |
      | Mouse Gamer      | Mouse Gamer G604 Lightspeed Wireless-Bluetooth Negro                |
      | Teclado Gamer    | Teclado Gamer Centurion Mecánico                                    |
      | SSD              | Unidad SSD 1TB PCIe NVMe Gen4 M.2 SN850 Black                       |
      | Tarjeta de video | Video AMD Radeon RX 6900XT O16G ROG Strix LC                        |
      | Watercooling     | Watercooling SR36                                                   |
    Then se verifica que los productos se han agregado al carrito correctamente







