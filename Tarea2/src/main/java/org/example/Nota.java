package org.example;

import java.time.LocalDateTime;

public class Nota {
    private String contenido;
    private LocalDateTime fechaCreacion;
    
    public Nota(String contenido) {
        if (contenido == null) {
            throw new NullPointerException("El contenido no puede ser null");
        }
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now(); // Hora local
    }
    
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
