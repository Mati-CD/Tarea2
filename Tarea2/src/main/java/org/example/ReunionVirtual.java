package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Empleado organizador,
                          TipoReunion tipo,
                          Date fecha,
                          LocalDateTime horaPrevista,
                          Duration duracionPrevista,
                          String enlace) {
        super(organizador, tipo, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    @Override
    public String getLugar() {
        return "Enlace virtual: " + enlace;
    }

    // Getter y Setter
    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return super.toString() + " | Modalidad: Virtual";
    }
}
