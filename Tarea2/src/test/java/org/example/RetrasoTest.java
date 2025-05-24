package org.example;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    @Test
    void testConstructorAndGetters() {
        // Preparar datos de prueba
        Empleado empleado = new Empleado("E001", "García", "Ana", "ana@empresa.com");
        Instant horaRetraso = Instant.now();

        // Crear instancia
        Retraso retraso = new Retraso(empleado, LocalTime.of(9, 15), LocalTime.of(9, 0), horaRetraso);

        // Verificar valores
        assertEquals(empleado, retraso.getEmpleado()); // Metodo heredado
        assertEquals(horaRetraso, retraso.getHoraRetraso()); // Metodo propio
    }

    @Test
    void testSetHoraRetraso() {
        // Configuración inicial
        Retraso retraso = new Retraso(
                new Empleado("E002", "Martínez", "Carlos", "carlos@empresa.com"),
                LocalTime.of(10, 15),
                LocalTime.of(10, 0),
                Instant.now()
        );

        // Nueva hora de retraso
        Instant nuevaHora = Instant.now().plusSeconds(3600);
        retraso.setHoraRetraso(nuevaHora);

        // Verificación
        assertEquals(nuevaHora, retraso.getHoraRetraso());
    }

    @Test
    void testToString() {
        // Crear instancia con valores conocidos
        Instant horaFija = Instant.parse("2023-01-01T10:15:30Z");
        Retraso retraso = new Retraso(
                new Empleado("E003", "López", "María", "maria@empresa.com"),
                LocalTime.of(10, 15),
                LocalTime.of(10, 0),
                horaFija
        );

        // Verificar formato del toString
        String resultado = retraso.toString();
        assertTrue(resultado.contains("Hora (con retraso): "));
        assertTrue(resultado.contains("2023-01-01T10:15:30Z"));
    }

    @Test
    void testHerenciaAsistencia() {
        // Verificar comportamiento heredado
        Retraso retraso = new Retraso(
                new Empleado("E004", "Rodríguez", "Pedro", "pedro@empresa.com"),
                LocalTime.of(9, 10), // 10 minutos tarde
                LocalTime.of(9, 0),
                Instant.now()
        );

        // Verificar que es una instancia de Asistencia
        assertTrue(retraso instanceof Asistencia);
    }
}