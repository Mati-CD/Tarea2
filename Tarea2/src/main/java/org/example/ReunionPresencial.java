package org.example;

import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date fecha, Empleado organizador, tipoReunion tipo) {
        super(fecha, organizador, tipo);
    }


    public String getLugar() {
        return "Sala: " + sala;
    }

    // Getter y Setter
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return super.toString() + " | Modalidad: Presencial";
    }
}
