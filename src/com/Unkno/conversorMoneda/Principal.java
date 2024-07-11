package com.Unkno.conversorMoneda;

import java.util.HashMap;
import java.util.Map;
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
                Escriba la divisa actual y la divisa a la que quiere cambiar con un guion entre ambos usando los numeros:
                """);
        String[] eleccion = lector.nextLine().split("-");
        System.out.println("Escriba la cantidad que desea convertir: ");
        int cantidad = lector.nextInt();

        Divisas divisas = new Divisas();
        divisas.iniciarDivisas();

        MonedaAPI consulta = new MonedaAPI();
        MonedaInfo monedaInfo = consulta.buscarInfo(divisas.buscarDivisa(eleccion[0]));

        //Valor de la divisa a cambiar
//        System.out.println(monedaInfo.buscarDivisa(divisas.buscarDivisa(eleccion[1])));
        var valorOtraMoneda = cantidad * monedaInfo.getValorOtraMoneda(divisas.buscarDivisa(eleccion[1]));

        divisas.iniciarNombres();

        System.out.println("Los $"+cantidad+" "+divisas.buscarNombres(eleccion[0])+" equivalen a $"+valorOtraMoneda+ " "+divisas.buscarNombres(eleccion[1]));
    }
}
