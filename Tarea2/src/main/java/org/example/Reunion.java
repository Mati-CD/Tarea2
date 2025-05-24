package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase abstracta que representa una reunión.
 * Proporciona la estructura base para reuniones presenciales y/o virtuales.
 */
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
    protected ArrayList<Nota> notas;

    /**
     * Constructor para crear una nueva reunión.
     * @param fecha Fecha de la reunión
     * @param organizador Empleado que organiza la reunión
     * @param tipo Tipo de reunión (TECNICA, MARKETING, OTRO)
     */
    protected Reunion(Date fecha,Empleado organizador, tipoReunion tipo){
        this.fecha = fecha;
        this.organizador = organizador;
        this.tipo = tipo;
        this.Asistentes = new ArrayList<>();
        this.Retrasos = new ArrayList<>();
        this.Invitados = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    /**
     * Agrega una nota a la reunión.
     * @param contenido Texto de la nota a agregar
     */
    public void agregarNota(String contenido) {
        notas.add(new Nota(contenido));
    }

    /**
     * Registra un empleado como invitado a la reunión.
     * @param empleado Empleado a invitar
     */
    public void registrarInvitados(Empleado empleado) {
        Invitados.add(empleado);
    }

    /**
     * Registra la asistencia de un empleado a la reunión.
     *
     * @param empleado Empleado que asiste
     * @param horaLlegada Hora en que llegó el empleado
     * @param horaInicioReunion Hora programada de inicio de la reunión
     */
    public void registrarAsistencia(Empleado empleado, LocalTime horaLlegada, LocalTime horaInicioReunion) {
        Asistencia asistencia = new Asistencia(empleado, horaLlegada, horaInicioReunion);

        if(asistencia.getPresente() == true) {
            if(asistencia.getTipoAsistencia()) {
                Retrasos.add(empleado);
            }

            Asistentes.add(empleado);
        }
    }

    /**
     * Obtiene la lista de asistentes a la reunión.
     * @return Lista de empleados que asistieron
     */
    public ArrayList<Empleado> obtenerAsistencias(){
        return new ArrayList<Empleado>(Asistentes);
    }

    /**
     * Obtiene la lista de ausentes a la reunión.
     * @return Lista de empleados invitados que no asistieron
     */
    public ArrayList<Empleado> obtenerAusencias(){
        Ausentes = new ArrayList<>();

        for(Empleado invitado: Invitados) {
            if(!Asistentes.contains(invitado)) {
                Ausentes.add(invitado);
            }
        }

        return Ausentes;
    }

    /**
     * Obtiene la lista de empleados que llegaron tarde.
     * @return Lista de empleados con retraso
     */
    public ArrayList<Empleado> obtenerRetrasos(){
        return new ArrayList<Empleado>(Retrasos);
    }

    /**
     * Marca el inicio de la reunión registrando la hora actual.
     */
    public void iniciar(){
        this.horaInicio = Instant.now();
    }

    /**
     * Marca el final de la reunión registrando la hora actual.
     */
    public void finalizar(){
        this.horaFinal = Instant.now();
    }

    /**
     * Calcula el total de asistentes a la reunión.
     * @return Número total de asistentes
     */
    public int obtenerTotalAsistencia() {
        return Asistentes.size();
    }

    /**
     * Calcula el porcentaje de asistencia a la reunión.
     * @return Porcentaje de asistencia (0-100)
     */
    public float obtenerPorcentajeAsistencia() {
        return Asistentes.size() * 100 / Invitados.size();

    }

    /**
     * Calcula la duración real de la reunión en horas.
     * @return Duración en horas con decimales
     */
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

    /**
     * Genera un informe detallado de la reunión en formato de texto.
     * @return String con el informe formateado
     */
    public String generarInforme() {
        DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault());

        StringBuilder informe = new StringBuilder();
        informe.append("=== INFORME DE REUNIÓN ===\n\n");
        informe.append("Fecha: ").append(fechaFormatter.format(fecha.toInstant())).append("\n");
        informe.append("Hora prevista: ").append(horaFormatter.format(horaPrevista)).append("\n");
        informe.append("Hora de inicio: ").append(horaFormatter.format(horaInicio)).append("\n");
        informe.append("Hora de fin: ").append(horaFormatter.format(horaFinal)).append("\n");
        informe.append("Duración total: ").append(String.format("%.2f", calcularTiempoReal())).append(" horas\n");
        informe.append("Tipo de reunión: ").append(tipo.toString()).append("\n");

        if (this instanceof ReunionVirtual) {
            informe.append("Enlace: ").append(((ReunionVirtual) this).getEnlace()).append("\n");
        } else if (this instanceof ReunionPresencial) {
            informe.append("Sala: ").append(((ReunionPresencial) this).getSala()).append("\n");
        }

        informe.append("\n=== PARTICIPANTES ===\n");
        informe.append("Organizador: ").append(organizador.getNombre()).append(" ").append(organizador.getApellidos()).append("\n");
        informe.append("Total invitados: ").append(Invitados.size()).append("\n");

        informe.append("\nAsistentes (").append(Asistentes.size()).append("):\n");
        for (Empleado asistente : Asistentes) {
            informe.append("- ").append(asistente.getNombre()).append(" ").append(asistente.getApellidos());
            if (Retrasos.contains(asistente)) {
                informe.append(" (llegó tarde)");
            }
            informe.append("\n");
        }

        informe.append("\nAusentes (").append(obtenerAusencias().size()).append("):\n");
        for (Empleado ausente : obtenerAusencias()) {
            informe.append("- ").append(ausente.getNombre()).append(" ").append(ausente.getApellidos()).append("\n");
        }

        informe.append("\n=== NOTAS ===\n");
        if (notas.isEmpty()) {
            informe.append("No hay notas registradas.\n");
        } else {
            for (Nota nota : notas) {
                informe.append("- ").append(nota.getContenido()).append("\n");
            }
        }

        informe.append("\n=== ESTADÍSTICAS ===\n");
        informe.append("Porcentaje de asistencia: ").append(String.format("%.2f", obtenerPorcentajeAsistencia())).append("%\n");

        return informe.toString();
    }

    /**
     * Guarda el informe de la reunión en un archivo de texto.
     * @param nombreArchivo Ruta y nombre del archivo donde guardar el informe
     */
    public void guardarInformeEnArchivo(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(generarInforme());
            System.out.println("Informe guardado exitosamente en: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el informe: " + e.getMessage());
        }
    }
}

