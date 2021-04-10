Feature: Proceso cotizacion PC gamer

  @Navegador
  Scenario: Cotizacion de productos Pcfactory
    Given el usuario ingresa a la pagina de PCFactory "https://www.pcfactory.cl/"
    And el usuario busca el producto

      | TipoProducto     |
      | Procesador       |
      | Audifono Gamer   |
      | Memoria Ram      |
      | Fuente de poder  |
      | Gabinete         |
      | Placa Madre      |
      | Monitor Gamer    |
      | Mouse Gamer      |
      | Teclado Gamer    |
      | Memoria SSD      |
      | Tarjeta de video |
      | Watercooling     |

    And el usuario seleciona el producto
      | nombreProducto                                                      |
      | CPU Core i9-10900K 3.7GHz 20MB (1200)                               |
      | Audífono SoundBlaster H3                                            |
      | DDR4 8GB 2666MHz Value RAM                                          |
      | Fuente Poder 750W Focus GX Plus 80Plus Gold Full Modular            |
      | Gabinete E-ATX Winbot                                               |
      | M/B AMD TRX40-XE ROG Strix Gaming (TRX4)                            |
      | Monitor Gamer 23,6" KG241Q-P, Panel TN, 144 Hz, 1ms, FreeSync, HDMI |
      | Mouse Gamer G604 Lightspeed Wireless-Bluetooth Negro                |
      | Teclado Gamer G513  RGB Lightsync USB Mecánico Español              |
      | Unidad SSD 1TB PCIe NVMe Gen4 M.2 SN850 Black                       |
      | Video AMD Radeon RX 6900XT O16G ROG Strix LC                        |
      | Watercooling SR36                                                   |
    And se valida que el producto sea el correcto






