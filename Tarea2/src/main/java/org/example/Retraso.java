package org.example;

import java.time.Instant;
import java.time.LocalTime;

public class Retraso extends Asistencia {
    private Instant hora;

    public Retraso(Empleado empleado, LocalTime horallegada , LocalTime horaInicio, Instant hora) {
        super(empleado, horallegada, horaInicio);
        this.hora = hora;
    }

    public Instant getHoraRetraso() {
        return hora;
    }

    public void setHoraRetraso(Instant hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Hora (con retraso): " + hora ;
    }
}

