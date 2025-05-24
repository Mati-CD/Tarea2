package org.example;

import java.util.Date;

/**
 * Clase que representa una reunión virtual.
 * Hereda de Reunion e incluye el enlace para conectarse a la reunión.
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de reunión virtual.
     *
     * @param fecha fecha y hora de la reunión.
     * @param organizador empleado que organiza la reunión.
     * @param tipo tipo de reunión (virtual, presencial, etc.).
     * @param enlace URL o enlace para acceder a la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Empleado organizador, tipoReunion tipo, String enlace) {
        super(fecha, organizador, tipo);
        this.enlace = enlace;
    }

    /**
     * Devuelve una descripción del lugar de la reunión (enlace virtual).
     *
     * @return texto con el enlace.
     */
    public String getLugar() {
        return "Enlace virtual: " + enlace;
    }

    // Getter y Setter

    /**
     * Devuelve el enlace de la reunión virtual.
     *
     * @return enlace como String.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Permite asignar o cambiar el enlace de la reunión virtual.
     *
     * @param enlace nuevo enlace.
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    /**
     * Extiende el toString de Reunion para indicar que la modalidad es virtual.
     *
     * @return resumen de la reunión incluyendo modalidad virtual.
     */
    @Override
    public String toString() {
        return super.toString() + " | Modalidad: Virtual";
    }
}
