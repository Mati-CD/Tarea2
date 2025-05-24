package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Empleado organizador,tipoReunion tipo, Date fecha,LocalDateTime horaPrevista, Duration duracionPrevista, String sala) {
        super(organizador, tipo, fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }

    @Override
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
}
