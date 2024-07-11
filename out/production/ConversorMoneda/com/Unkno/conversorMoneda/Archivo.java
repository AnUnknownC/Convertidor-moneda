package com.Unkno.conversorMoneda;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Archivo{

    public void guardarArchivo(String dato, LocalDateTime now) {
        try {
            FileWriter escritor = new FileWriter("RegistroConversiones.txt");
            escritor.write(now+" = "+dato);
            escritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
