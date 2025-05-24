package org.example;

import java.time.Instant;

public class Invitacion {
    private Instant hora;

    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    public void enviarInvitacion(Invitable invitado) {
        invitado.invitar();
    }

    // Getters
    public Instant getHora() {
        return hora;
    }

    // Setters
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Hora invitación: " + hora;
    }
}
