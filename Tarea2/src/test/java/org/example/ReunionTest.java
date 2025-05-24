package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase abstracta Reunion.
 * <p>
 * Se usa una clase interna concreta para poder instanciar
 * objetos de Reunion y hacer las pruebas.
 * </p>
 */
class ReunionTest {
    private Reunion reunion;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;
    private Date fecha;

    /**
     * Clase concreta para probar la clase abstracta Reunion.
     */
    private static class ReunionConcreta extends Reunion {
        public ReunionConcreta(Date fecha, Empleado organizador, tipoReunion tipo) {
            super(fecha, organizador, tipo);
        }
    }

    /**
     * Configura los objetos necesarios antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        fecha = new Date();
        organizador = new Empleado("1", "Gómez", "Juan", "juan@empresa.com");
        empleado1 = new Empleado("2", "Pérez", "María", "maria@empresa.com");
        empleado2 = new Empleado("3", "López", "Carlos", "carlos@empresa.com");

        reunion = new ReunionConcreta(fecha, organizador, tipoReunion.TECNICA);
    }
    /**
     * Prueba que el constructor inicializa correctamente los datos.
     */
    @Test
    void testConstructor() {
        assertNotNull(reunion);
        assertEquals(organizador, reunion.getOrganizador());
        assertEquals(tipoReunion.TECNICA, reunion.getTipo());
        assertEquals(fecha, reunion.getFecha());
        assertTrue(reunion.obtenerAsistencias().isEmpty());
        assertTrue(reunion.obtenerRetrasos().isEmpty());
    }

    /**
     * Prueba el registro de invitados y la actualización de ausencias.
     */
    @Test
    void testRegistrarInvitados() {
        reunion.registrarInvitados(empleado1);
        reunion.registrarInvitados(empleado2);

        assertEquals(2, reunion.obtenerAusencias().size());
    }

    /**
     * Prueba el registro de asistencia y detecta si hay retrasos.
     */
    @Test
    void testRegistrarAsistencia() {
        LocalTime horaInicioReunion = LocalTime.of(10, 0);

        reunion.registrarAsistencia(empleado1, LocalTime.of(9, 55), horaInicioReunion);
        assertEquals(1, reunion.obtenerAsistencias().size());
        assertEquals(0, reunion.obtenerRetrasos().size());

        reunion.registrarAsistencia(empleado2, LocalTime.of(10, 15), horaInicioReunion);
        assertEquals(2, reunion.obtenerAsistencias().size());
        assertEquals(1, reunion.obtenerRetrasos().size());
    }

    /**
     * Prueba que las ausencias se actualizan correctamente al registrar asistentes.
     */
    @Test
    void testObtenerAusencias() {
        reunion.registrarInvitados(empleado1);
        reunion.registrarInvitados(empleado2);

        assertEquals(2, reunion.obtenerAusencias().size());

        reunion.registrarAsistencia(empleado1, LocalTime.now(), LocalTime.now());
        assertEquals(1, reunion.obtenerAusencias().size());
    }

    /**
     * Prueba iniciar y finalizar la reunión, verificando que las horas se guarden.
     */
    @Test
    void testIniciarYFinalizar() {
        assertNull(reunion.getHoraInicio());
        assertNull(reunion.getHoraFinal());

        reunion.iniciar();
        Instant horaInicio = reunion.getHoraInicio();
        assertNotNull(horaInicio);

        reunion.finalizar();
        Instant horaFinal = reunion.getHoraFinal();
        assertNotNull(horaFinal);

        assertFalse(horaFinal.isBefore(horaInicio),
                "La hora final no debe ser anterior a la hora de inicio");
    }

    /**
     * Prueba el cálculo del porcentaje de asistencia.
     */
    @Test
    void testObtenerPorcentajeAsistencia() {
        reunion.registrarInvitados(empleado1);
        reunion.registrarInvitados(empleado2);

        assertEquals(0, reunion.obtenerPorcentajeAsistencia());

        reunion.registrarAsistencia(empleado1, LocalTime.now(), LocalTime.now());
        assertEquals(50, reunion.obtenerPorcentajeAsistencia());

        reunion.registrarAsistencia(empleado2, LocalTime.now(), LocalTime.now());
        assertEquals(100, reunion.obtenerPorcentajeAsistencia());
    }

    /**
     * Prueba que el porcentaje de asistencia lance error si no hay invitados,
     * y que funcione correctamente si hay invitados.
     */
    @Test
    void testPorcentajeAsistenciaSinInvitados() {
        assertThrows(ArithmeticException.class, () -> {
            reunion.obtenerPorcentajeAsistencia();
        });

        reunion.registrarInvitados(empleado1);
        assertEquals(0.0f, reunion.obtenerPorcentajeAsistencia(), 0.001f);

        reunion.registrarAsistencia(empleado1, LocalTime.now(), LocalTime.now());
        assertEquals(100.0f, reunion.obtenerPorcentajeAsistencia(), 0.001f);
    }

    /**
     * Prueba que el método toString contenga información relevante.
     */
    @Test
    void testToString() {
        reunion.registrarInvitados(empleado1);
        reunion.registrarInvitados(empleado2);
        reunion.registrarAsistencia(empleado1, LocalTime.now(), LocalTime.now());

        String str = reunion.toString();
        assertTrue(str.contains("TECNICA"));
        assertTrue(str.contains("invitados=2"));
        assertTrue(str.contains("asistentes=1"));
    }

    /**
     * Prueba los métodos getter y setter de organizador, tipo y hora inicio.
     */
    @Test
    void testGettersYSetters() {
        Empleado nuevoOrganizador = new Empleado("4", "Rodríguez", "Ana", "ana@empresa.com");
        reunion.setOrganizador(nuevoOrganizador);
        assertEquals(nuevoOrganizador, reunion.getOrganizador());

        reunion.setTipo(tipoReunion.MARKETING);
        assertEquals(tipoReunion.MARKETING, reunion.getTipo());

        Instant ahora = Instant.now();
        reunion.setHoraInicio(ahora);
        assertEquals(ahora, reunion.getHoraInicio());
    }

