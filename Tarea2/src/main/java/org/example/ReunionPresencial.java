package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String sala) {
        super(fecha, duracionPrevista, organizador, tipo);
        this.sala = sala;
    }
    
    public String getSala() {
        return sala;
    }
}
