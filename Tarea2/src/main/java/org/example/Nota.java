package org.example;

import java.time.LocalDateTime;

/**
 * Esta clase representa una nota que puede estar asociada, por ejemplo, a una reunión o a un empleado.
 * Guarda el contenido de la nota y la fecha/hora en que fue creada.
 */
public class Nota {
    private String contenido;
    private LocalDateTime fechaCreacion;

    /**
     * Constructor que crea una nueva nota con el contenido dado.
     * La fecha de creación se establece automáticamente al momento actual.
     *
     * @param contenido texto de la nota. No puede ser null.
     */
    public Nota(String contenido) {
        if (contenido == null) {
            throw new NullPointerException("El contenido no puede ser null");
        }
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now(); // Hora local
    }

    // Getters

    /**
     * Devuelve el contenido de la nota.
     *
     * @return texto de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Devuelve la fecha y hora en que se creó la nota.
     *
     * @return fecha de creación como LocalDateTime.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    // Setters

    /**
     * Permite modificar el contenido de la nota.
     *
     * @param contenido nuevo texto.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Permite actualizar la fecha de creación (no se recomienda salvo casos especiales).
     *
     * @param fechaCreacion nueva fecha de creación.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Devuelve un resumen en texto con la fecha de creación y el contenido de la nota.
     *
     * @return texto de la nota con su timestamp.
     */
    @Override
    public String toString() {
        return "[" + fechaCreacion + "] " + contenido;
    }
}
