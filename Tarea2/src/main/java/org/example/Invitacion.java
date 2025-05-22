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


    public Instant getHora() {
        return hora;
    }
    public void setHora(Instant hora) {
        this.hora = hora;
    }
}
