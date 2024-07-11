# Conversor de Moneda

Este proyecto es una aplicación Java que permite obtener información de diferentes monedas utilizando la API de ExchangeRate-API. 

## Requisitos

- Java 11 o superior
- Biblioteca Gson
- Biblioteca HttpClient

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/conversor-moneda.git

   Navega al directorio del proyecto:

2. Navega al directorio del proyecto:
cd conversor-moneda

3. Asegúrate de tener las dependencias necesarias:
- Gson
- HttpClient (incluido en Java 11 y superior)


<h2>Uso</h2>
La clase Principal proporciona una interfaz para interactuar con el usuario y realizar conversiones de moneda.

Ejemplo de Uso
package com.Unkno.conversorMoneda;

import java.time.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("""
                ----Bienvenido a nuestro conversor de divisas----               
                Las divisas disponibles para hacer los cambios son: 
                1. Dolar 
                2. Peso argentino 
                3. Real brasileño 
                4. Peso colombiano
                Usando los numeros, escriba la divisa actual y la divisa a la que quiere cambiar con un guion entre ambos
                (Ejemplo: dolar - peso colombiano (1-4)):
                """);
        String[] eleccion = lector.nextLine().split("-");
        System.out.println("Escriba la cantidad que desea convertir: ");
        int cantidad = lector.nextInt();

        Divisas divisas = new Divisas();
        divisas.iniciarDivisas();

        MonedaAPI consulta = new MonedaAPI();
        MonedaInfo monedaInfo = consulta.buscarInfo(divisas.buscarDivisa(eleccion[0]));

        var valorOtraMoneda = cantidad * monedaInfo.getValorOtraMoneda(divisas.buscarDivisa(eleccion[1]));

        divisas.iniciarNombres();

        System.out.println("Los $"+cantidad+" "+divisas.buscarNombres(eleccion[0])+" equivalen a $"+valorOtraMoneda+ " "+divisas.buscarNombres(eleccion[1]));

        String dato = (String) (cantidad+" "+ divisas.buscarDivisa(eleccion[0])+ " a "+ valorOtraMoneda+ " "+ divisas.buscarDivisa(eleccion[1]));

        Archivo archivo = new Archivo();
        archivo.guardarArchivo(dato, LocalDateTime.now());
    }
}

<h2>Descripción del Código</h2>
Clase MonedaAPI
Esta clase contiene el método buscarInfo que realiza una solicitud HTTP a la API de ExchangeRate-API para obtener la información de la moneda.

Método buscarInfo:
- Parámetro: String moneda - El código de la moneda para la cual se desea obtener información.
- Retorna: Un objeto MonedaInfo que contiene la información de la moneda.
- Construye la URL de la solicitud utilizando el código de la moneda.
- Utiliza HttpClient para enviar la solicitud y obtener la respuesta.
- Utiliza Gson para convertir la respuesta JSON en un objeto MonedaInfo.

Clase MonedaInfo
Esta clase representa la información de la moneda obtenida de la API.
+ Atributos:
  - base_code: Código de la moneda base.
  - conversion_rates: Mapa que contiene las tasas de conversión.
  - time_last_update_utc: Fecha y hora de la última actualización.
  -  valorOtraMoneda: Valor de otra moneda específica.
+ Métodos:
  - buscarDivisa(String divisa): Devuelve la tasa de cambio para la divisa especificada.
  - getValorOtraMoneda(String OtraMoneda): Establece y devuelve el valor de otra moneda específica.
  - toString(): Devuelve una representación en cadena de la información de la moneda.

Clase Archivo
Esta clase maneja la creación y escritura en un archivo de texto para registrar las conversiones de moneda.

+ Método guardarArchivo:
  - Parámetros:
    * String dato - La información de la conversión de moneda a guardar.
    * LocalDateTime now - La fecha y hora actuales para registrar cuándo se realizó la conversión.
  - Funcionalidad: Escribe la información de la conversión en un archivo de texto llamado RegistroConversiones.txt.

Clase Divisas
Esta clase maneja la configuración y consulta de códigos y nombres de divisas.

+ Atributos:
  - Divisas: Mapa que contiene los códigos de las divisas.
  - Nombres: Mapa que contiene los nombres de las divisas.
+ Métodos:
  - buscarDivisa(String numero): Devuelve el código de la divisa para el número especificado.
  - buscarNombres(String divisa): Devuelve el nombre de la divisa para el código especificado.
  - getNombres(): Devuelve el mapa de nombres de las divisas.
  - iniciarDivisas(): Inicializa el mapa de códigos de divisas.
  - iniciarNombres(): Inicializa el mapa de nombres de divisas.

Clase Principal
Esta clase proporciona la interfaz principal para que el usuario interactúe con la aplicación.

+ Funcionalidad:
  - Solicita al usuario que seleccione las divisas y la cantidad a convertir.
  - Realiza la conversión de moneda utilizando MonedaAPI y MonedaInfo.
  - Muestra el resultado de la conversión.
  - Guarda el registro de la conversión en un archivo utilizando Archivo.
