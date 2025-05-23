package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    protected Date fecha;
    protected Instant horaInicio;
    protected Instant horaFinal;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected ArrayList<Empleado> Asistentes;
    protected ArrayList<Empleado> Ausentes;

    protected Reunion(Date fecha, Duration duracionPrevista){
        this.fecha = fecha;
        this.duracionPrevista = duracionPrevista;
    }

    public ArrayList<Empleado> getAsitencia(){
        return new ArrayList<Empleado>(Asistentes);
    }

    public ArrayList<Empleado> getAusentes(){
        return new ArrayList<Empleado>(Ausentes);
    }


    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFinal = Instant.now();
    }

    public float calcularTiempoReal(){
        Duration duracion = Duration.between(horaInicio,horaFinal);
        float minutosTotales = duracion.toMinutes();
        float horas = minutosTotales/60;
        return(horas);
    }


    public String toString(){
        return "Reunion de tipo: " + tipo + "\n" +
               "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n";
    }
}
