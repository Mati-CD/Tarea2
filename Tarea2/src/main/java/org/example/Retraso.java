package org.example;

import java.time.Instant;
import java.time.LocalTime;

/**
 * Esta clase representa un caso específico de asistencia en el que el empleado llega con retraso.
 * Hereda de la clase Asistencia e incluye un campo adicional para guardar la hora exacta del retraso (en formato Instant).
 */
public class Retraso extends Asistencia {
    private Instant hora;

    /**
     * Constructor para crear una asistencia con retraso.
     *
     * @param empleado empleado que llegó tarde.
     * @param horallegada hora local de llegada del empleado.
     * @param horaInicio hora local en que comenzaba la reunión.
     * @param hora hora exacta del retraso (formato Instant, para mayor precisión).
     */
    public Retraso(Empleado empleado, LocalTime horallegada, LocalTime horaInicio, Instant hora) {
        super(empleado, horallegada, horaInicio);
        this.hora = hora;
    }

    /**
     * Devuelve la hora exacta en que se registró el retraso.
     *
     * @return hora como Instant.
     */
    public Instant getHoraRetraso() {
        return hora;
    }

    /**
     * Permite modificar la hora registrada del retraso.
     *
     * @param hora nueva hora del retraso.
     */
    public void setHoraRetraso(Instant hora) {
        this.hora = hora;
    }

    /**
     * Devuelve una representación simple con la hora en que se registró el retraso.
     *
     * @return texto con la hora.
     */
    @Override
    public String toString() {
        return "Hora (con retraso): " + hora;
    }
}


