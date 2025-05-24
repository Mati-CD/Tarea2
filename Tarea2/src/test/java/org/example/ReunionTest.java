package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    // Clase concreta para testing
    private static class ReunionConcreta extends Reunion {
        public ReunionConcreta(Date fecha, Empleado organizador, tipoReunion tipo) {
            super(fecha, organizador, tipo);
        }
    }

    private Reunion reunion;
    private Empleado organizador;

    @BeforeEach
    void setUp() {
        organizador = new Empleado("EMP-001", "Gómez", "Ana", "ana@empresa.com");
        reunion = new ReunionConcreta(
                new Date(),
                organizador,
                tipoReunion.TECNICA
        );

        // Configuración inicial para algunas pruebas
        reunion.setHoraPrevista(Instant.now().plus(Duration.ofHours(1)));
        reunion.setDuracionPrevista(Duration.ofHours(2));
    }

    @Test
    void testCreacionReunion() {
        assertNotNull(reunion);
        assertEquals(organizador, reunion.organizador);
        assertEquals(tipoReunion.TECNICA, reunion.tipo);
        assertNotNull(reunion.fecha);
    }

    @Test
    void testIniciarYFinalizarReunion() {
        reunion.iniciar();
        assertNotNull(reunion.horaInicio);
        // Pequeña pausa para asegurar diferencia de tiempo
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        reunion.finalizar();
        assertNotNull(reunion.horaFinal);
        assertTrue(reunion.horaFinal.isAfter(reunion.horaInicio));
    }

    @Test
    void testObtenerAsistenciasYAusencias() {
        Empleado empleado1 = new Empleado("EMP-002", "López", "Carlos", "carlos@empresa.com");
        Empleado empleado2 = new Empleado("EMP-003", "Martínez", "Luisa", "luisa@empresa.com");

        // Registrar invitados
        reunion.registrarInvitados(empleado1);
        reunion.registrarInvitados(empleado2);

<<<<<<< HEAD
        List<Empleado> asistentes = reunion.getAsistencia();
        List<Empleado> ausentes = reunion.getAusentes();
=======
        // Registrar asistencia (simulada)
        reunion.Asistentes.add(organizador);
        reunion.Asistentes.add(empleado1);

        List<Empleado> asistentes = reunion.obtenerAsistencias();
        List<Empleado> ausentes = reunion.obtenerAusencias();
>>>>>>> 02a58f0687f4f94d3a6b5740b819f327f19ff8a7

        assertEquals(2, asistentes.size());
        assertEquals(1, ausentes.size());
        assertTrue(asistentes.contains(organizador));
        assertTrue(ausentes.contains(empleado2));
    }

    @Test
    void testToString() {
        reunion.setDuracionPrevista(Duration.ofHours(2));
        String resultado = reunion.toString();

        assertTrue(resultado.contains("Reunion de tipo: TECNICA"));
        assertTrue(resultado.contains("Hora prevista: "));
        assertTrue(resultado.contains("Duracion prevista: PT2H"));
    }

    @Test
    void testSetHoraYDuracionPrevista() {
        Instant nuevaHora = Instant.now().plus(Duration.ofHours(3));
        Duration nuevaDuracion = Duration.ofMinutes(90);

        reunion.setHoraPrevista(nuevaHora);
        reunion.setDuracionPrevista(nuevaDuracion);

        assertEquals(nuevaHora, reunion.horaPrevista);
        assertEquals(nuevaDuracion, reunion.duracionPrevista);
    }
}
