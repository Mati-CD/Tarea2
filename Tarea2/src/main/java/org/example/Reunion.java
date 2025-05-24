package org.example;

import java.time.Instant;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    private Date fecha;
    private Instant horaInicio;
    private Instant horaFinal;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private ArrayList<Empleado> Asistentes;
    private ArrayList<Empleado> Ausentes;
    private ArrayList<Empleado> invitados;
    private ArrayList<Empleado> Retrasos;
    private TipoReunion tipo;
    private Empleado organizador;

    public Reunion(Date fecha, Duration duracionPrevista, Empleado organizador, TipoReunion tipo){
        this.fecha = fecha;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
        this.organizador = organizador;
        this.Asistentes = new ArrayList<>();
        this.Retrasos = new ArrayList<>();
        this.invitados = new ArrayList<>();
    }

    public void registrarInvitados(Empleado empleado) {
        invitados.add(empleado);
    }

    public void registrarAsistencia(Empleado empleado, LocalTime horaLlegada, LocalTime horaInicioReunion) {
        Asistencia asistencia = new Asistencia(empleado, horaLlegada, horaInicioReunion);

        if(asistencia.getPresente() == true) {
            if(asistencia.getTipoAsistencia()) {
                Retrasos.add(empleado);
            }

            Asistentes.add(empleado);
        }
    }

    public ArrayList<Empleado> obtenerAsistencias(){
        return new ArrayList<Empleado>(Asistentes);
    }

    public ArrayList<Empleado> obtenerAusencias(){
        Ausentes = new ArrayList<>();

        for(Empleado invitado: invitados) {
            if(!Asistentes.contains(invitado)) {
                Ausentes.add(invitado);
            }
        }

        return Ausentes;
    }

    public ArrayList<Empleado> obtenerRetrasos(){
        return new ArrayList<Empleado>(Retrasos);
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
