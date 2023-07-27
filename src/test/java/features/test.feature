Feature: Ver el PDF dentro de la página de Banistmo


  Scenario: Navegar hasta encontrar el PDF
    Given El usuario esta en el sitio en la seccion de empresa
    When Hace click en las opciones necesarias para llegar al PDF
    Then Debe mostrar el PDF