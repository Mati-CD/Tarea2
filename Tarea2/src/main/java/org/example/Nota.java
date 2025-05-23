package org.example;

import java.time.LocalDateTime;

public class Nota {
    private String contenido;
    private LocalDateTime fechaCreacion;

    public Nota(String contenido) {
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now(); // Hora local
    }

    // Getters
    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return "[" + fechaCreacion + "] " + contenido;
    }
}
