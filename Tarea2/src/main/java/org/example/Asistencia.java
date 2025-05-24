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

    public Empleado getEmpleado() {
        return empleado;
    }
}
