package org.example;

import java.time.LocalTime;

/**
 * Esta clase representa la asistencia de un empleado a una reunión.
 * Guarda si asistió, si llegó tarde y la hora exacta en que llegó.
 */
public class Asistencia {
    private Empleado empleado;
    private boolean presente;
    private boolean tarde;
    private LocalTime llegada;

    /**
     * Constructor de la clase Asistencia.
     * Se le pasa el empleado, la hora a la que llegó y la hora en que partía la reunión.
     * Si llegó después de que partía, se marca como tarde.
     *
     * @param empleado el empleado al que se le registra la asistencia.
     * @param horallegada la hora exacta en que llegó.
     * @param horaInicioReunion la hora oficial de inicio de la reunión.
     */
    public Asistencia(Empleado empleado, LocalTime horallegada , LocalTime horaInicioReunion){
        this.empleado = empleado;
        presente = true;
        llegada = horallegada;
        tarde = horallegada.isAfter(horaInicioReunion);
    }

    /**
     * Retorna si el empleado llegó tarde o no.
     *
     * @return true si llegó tarde, false si llegó puntual.
     */
    public boolean getTipoAsistencia() {
        return tarde;
    }

    /**
     * Retorna si el empleado estuvo presente.
     *
     * @return true si asistió, false si estuvo ausente.
     */
    public boolean getPresente() {
        return presente;
    }

    // Getters

    /**
     * Devuelve el empleado asociado a esta asistencia.
     *
     * @return el objeto Empleado.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Devuelve la hora en que llegó el empleado.
     *
     * @return hora de llegada.
     */
    public LocalTime getLlegada() {
        return llegada;
    }

    // Setters

    /**
     * Permite cambiar el empleado de esta asistencia.
     *
     * @param empleado nuevo empleado.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Cambia si el empleado estuvo presente o no.
     *
     * @param presente true si asistió, false si no.
     */
    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    /**
     * Cambia si el empleado fue marcado como tarde.
     *
     * @param tarde true si llegó tarde, false si fue puntual.
     */
    public void setTarde(boolean tarde) {
        this.tarde = tarde;
    }

    /**
     * Cambia la hora de llegada registrada.
     *
     * @param llegada nueva hora de llegada.
     */
    public void setLlegada(LocalTime llegada) {
        this.llegada = llegada;
    }

    /**
     * Devuelve un resumen de la asistencia, incluyendo el nombre del empleado,
     * si estuvo ausente, puntual o llegó tarde, y la hora de llegada.
     *
     * @return resumen en texto de la asistencia.
     */
    @Override
    public String toString() {
        String estado;
        if (!presente) {
            estado = "Ausente";
        } else if (tarde) {
            estado = "Tarde";
        } else {
            estado = "Puntual";
        }

        return "Asistencia{Empleado: " + empleado.getNombre() + ", Estado: " + estado + ", Hora llegada: " + llegada + "}";
    }
}

