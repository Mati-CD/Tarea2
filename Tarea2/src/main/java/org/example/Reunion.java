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

    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFinal = Instant.now();
    }

    public int obtenerTotalAsistencia() {
        return Asistentes.size();
    }

    public float obtenerPorcentajeAsistencia() {
        return Asistentes.size() * 100 / Invitados.size();

    }

    public float calcularTiempoReal(){
        Duration duracion = Duration.between(horaInicio,horaFinal);
        float minutosTotales = duracion.toMinutes();
        float horas = minutosTotales/60;
        return(horas);
    }

    // Getters
    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraFinal() {
        return horaFinal;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public Empleado getOrganizador() {
        return organizador;
    }

    public tipoReunion getTipo() {
        return tipo;
    }

    // Setters
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(Instant horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public void setTipo(tipoReunion tipo) {
        this.tipo = tipo;
    }

    public void setHoraPrevista(Instant horaPrevista){
        this.horaPrevista = horaPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista){
        this.duracionPrevista = duracionPrevista;
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "tipo=" + tipo +
                ", fecha=" + fecha +
                ", organizador=" + organizador.getNombre() +
                ", invitados=" + Invitados.size() +
                ", asistentes=" + Asistentes.size() +
                ", retrasos=" + Retrasos.size() +
                "}";
    }
}
