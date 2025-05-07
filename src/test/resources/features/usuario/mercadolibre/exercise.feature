Feature: Take home challenge

  Scenario Outline: Mercado Libre
    Given cargamos la pagina mercado libre
    And seleccionamos pais Mexico
    When ingresamos en filtro de busqueda el producto <producto> y el boton Buscar
    And seleccionamos filtro Nuevo
    And filtrar location CDMX
    And ordenar de MAYOR a MENOR
    Then Obtiene resultados y muestra en consola
    Examples:
      | producto       |
      | "playstation5" |
