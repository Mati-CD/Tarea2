package org.example;

import java.util.Date;

/**
 * Clase que representa una reunión presencial.
 * Hereda de Reunion e incluye el dato de la sala donde se realizará.
 */
public class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * Constructor de reunión presencial.
     *
     * @param fecha fecha y hora de la reunión.
     * @param organizador empleado que organiza la reunión.
     * @param tipo tipo de reunión (puede ser presencial, virtual, etc.).
     */
    public ReunionPresencial(Date fecha, Empleado organizador, tipoReunion tipo) {
        super(fecha, organizador, tipo);
    }

    /**
     * Devuelve una descripción del lugar (sala) donde será la reunión.
     *
     * @return texto con la sala asignada.
     */
    public String getLugar() {
        return "Sala: " + sala;
    }

    // Getter y Setter

    /**
     * Devuelve el nombre o identificador de la sala.
     *
     * @return sala como String.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Permite asignar o cambiar la sala de la reunión.
     *
     * @param sala nueva sala.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Extiende el toString de Reunion para indicar que la modalidad es presencial.
     *
     * @return resumen de la reunión incluyendo modalidad presencial.
     */
    @Override
    public String toString() {
        return super.toString() + " | Modalidad: Presencial";
    }
}
