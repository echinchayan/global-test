# Automatizacion con Selenium

El proyecto consiste en un ejemplo de automatización de pruebas web usando framework de automatización de pruebas basado en Selenium WebDriver que sirve como punto de partida en cualquier proyecto de automatización de pruebas web UI.

Este framework provee todas las funcionalidades necesarias para abordar la automatización de pruebas web con Selenium de una forma estándar, reduciendo tiempos de configuración y construcción, minimizando la curva de aprendizaje y el nivel técnico requerido para su uso.

A su vez, encapsula lógica en común y brinda un marco de trabajo fácilmente configurable y extendible según la necesidad de cada proyecto.

## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia local del proyecto en funcionamiento para propósitos de desarrollo y pruebas.

### Pre-requisitos 📋

Requisitos necesarios para el correcto funcionamiento del template y cómo instalarlos.

* Java
* IDE de preferencia como por ejemplo, [Eclipse IDE](https://www.eclipse.org/)
* JUnit5
* apache-maven-3.6.3


### Instalación 🔧

A continuación se describen los pasos para descargar e instalar el template en tu IDE de preferencia.

1. Descargar una copia o clonar el código del repositorio desde GitHub.
2. Importar el proyecto en el IDE, recordar hacerlo como proyecto de tipo “Maven project”.
3. Al finalizar la importación, el proyecta está listo para usarse.

## Automatización de Mercado Libre ⚙️

A continuación se presenta el feature realizado en cucumber para las pruebas automatizadas

### Primeros pasos


```cucumber
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
```

**Instrucciones para ejecutar**

* Clonar proyecto del github
* Importar las librerias maven
* Ejecutar por consola : mvn clean verify
* Luego que concluya generará reporte serenity
  SERENITY REPORTS
  [INFO]   - Full Report: file:///D:/Automatizacion/Final/tpido-cucumber/target/site/serenity/index.html

## Autores ✒️

* Erick Chinchayan

## Contacto 📢

erickc1902@gmail.com