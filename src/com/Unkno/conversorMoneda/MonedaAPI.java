package com.Unkno.conversorMoneda;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonedaAPI {
    public MonedaInfo buscarInfo(String moneda){
        String key = "dd54e2aa19ca74bdc4538246";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/latest/"+moneda+"/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), MonedaInfo.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}