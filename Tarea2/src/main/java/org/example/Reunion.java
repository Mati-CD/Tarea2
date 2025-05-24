package org.example;

import java.time.Instant;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    protected Date fecha;
    protected Instant horaInicio;
    protected Instant horaFinal;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected ArrayList<Empleado> Invitados;
    protected ArrayList<Empleado> Asistentes;
    protected ArrayList<Empleado> Ausentes;
    protected ArrayList<Empleado> Retrasos;
    protected Empleado organizador;
    protected tipoReunion tipo;

    protected Reunion(Date fecha,Empleado organizador, tipoReunion tipo){
        this.fecha = fecha;
        this.organizador = organizador;
        this.tipo = tipo;
        this.Asistentes = new ArrayList<>();
        this.Retrasos = new ArrayList<>();
        this.Invitados = new ArrayList<>();
    }

    public void registrarInvitados(Empleado empleado) {
        Invitados.add(empleado);
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

        for(Empleado invitado: Invitados) {
            if(!Asistentes.contains(invitado)) {
                Ausentes.add(invitado);
            }
        }

        return Ausentes;
    }

    public ArrayList<Empleado> obtenerRetrasos(){
        return new ArrayList<Empleado>(Retrasos);
    }

    public void setHoraPrevista(Instant horaPrevista){
        this.horaPrevista = horaPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista){
        this.duracionPrevista = duracionPrevista;
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
