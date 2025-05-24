package org.example;

import java.time.Instant;

/**
 * Esta clase representa una invitación a una reunión.
 * Guarda la hora en que fue enviada y tiene un método para enviarla a un objeto que se pueda invitar.
 */
public class Invitacion {
    private Instant hora;

    /**
     * Constructor de la clase Invitacion.
     * Guarda la hora exacta en que se crea la invitación.
     *
     * @param hora instante en que se registra la invitación.
     */
    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    /**
     * Envía la invitación a un objeto que implemente la interfaz Invitable.
     *
     * @param invitado el objeto que va a recibir la invitación.
     */
    public void enviarInvitacion(Invitable invitado) {
        invitado.invitar();
    }

    // Getters

    /**
     * Devuelve la hora registrada de la invitación.
     *
     * @return hora como Instant.
     */
    public Instant getHora() {
        return hora;
    }

    // Setters

    /**
     * Permite actualizar la hora de la invitación.
     *
     * @param hora nueva hora como Instant.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Devuelve un resumen con la hora en que se creó o programó la invitación.
     *
     * @return texto con la hora.
     */
    @Override
    public String toString() {
        return "Hora invitación: " + hora;
    }
}
