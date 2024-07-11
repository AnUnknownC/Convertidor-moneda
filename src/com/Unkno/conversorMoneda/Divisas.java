package com.Unkno.conversorMoneda;

import java.util.HashMap;
import java.util.Map;

public class Divisas {
    private Map divisas = new HashMap();
    private Map nombres = new HashMap();

    public String buscarDivisa(String numero){
        return (String) divisas.get(numero);
    }

    public String buscarNombres(String divisa){
        return (String) nombres.get(divisa);
    }

    public Map getNombres() {
        return nombres;
    }

    public void iniciarDivisas(){
        divisas.put("1", "USD");
        divisas.put("2", "ARS");
        divisas.put("3", "BRL");
        divisas.put("4", "COP");
    }

    public void iniciarNombres(){
        nombres.put("1", "dolares");
        nombres.put("2", "pesos argentinos");
        nombres.put("3", "reales brasileños");
        nombres.put("4", "pesos colombianos");
    }
}
