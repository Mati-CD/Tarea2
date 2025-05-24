package org.example;
import java.time.LocalTime;

public class Asistencia {
    private Empleado empleado;
    private boolean presente;
    private boolean tarde;
    private LocalTime llegada;

    public Asistencia(Empleado empleado, LocalTime horallegada , LocalTime horaInicioReunion){
        this.empleado = empleado;
        presente = true;
        llegada = horallegada;

        if(horallegada.isAfter(horaInicioReunion)){
            tarde=true;
        }else{
            tarde=false;
        }
    }

    public boolean getTipoAsistencia() {
        return tarde;
    }
    public boolean getPresente() {
        return presente;
    }

    // Getters
    public Empleado getEmpleado() {
        return empleado;
    }

    public LocalTime getLlegada() {
        return llegada;
    }

    // Setters
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public void setTarde(boolean tarde) {
        this.tarde = tarde;
    }

    public void setLlegada(LocalTime llegada) {
        this.llegada = llegada;
    }

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
