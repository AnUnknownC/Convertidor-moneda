package com.Unkno.conversorMoneda;

import java.util.Map;

public class MonedaInfo {
    private String base_code;
    private Map conversion_rates;
    private String time_last_update_utc;
    private double valorOtraMoneda;

    public double buscarDivisa(String divisa){
        return (double) conversion_rates.get(divisa);
    }

    public double getValorOtraMoneda(String OtraMoneda) {
        valorOtraMoneda = (double) conversion_rates.get(OtraMoneda);
        return valorOtraMoneda;
    }

    @Override
    public String toString() {
        return  "{base_code='" + base_code + '\'' +
                ", conversion_rates='" + conversion_rates + '\'' +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                '}';
    }
}
