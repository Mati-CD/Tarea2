package org.example;

import java.time.Duration;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String enlace) {
        super(fecha, duracionPrevista, organizador, tipo);
        this.enlace = enlace;
    }
}
