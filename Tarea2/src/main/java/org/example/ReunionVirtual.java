package org.example;

import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Empleado organizador, tipoReunion tipo) {
        super(fecha, organizador, tipo);
        this.enlace = enlace;
    }

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