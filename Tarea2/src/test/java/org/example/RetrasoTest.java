package org.example;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Retraso.
 * Verifica que el comportamiento y atributos de los retrasos de asistencia sean correctos,
 * incluyendo herencia desde la clase Asistencia.
 */
class RetrasoTest {

    /**
     * Verifica que el constructor inicializa correctamente los atributos
     * y que los métodos getter funcionan como se espera.
     */
    @Test
    void testConstructorAndGetters() {
        // Preparar datos de prueba
        Empleado empleado = new Empleado("E001", "García", "Ana", "ana@empresa.com");
        Instant horaRetraso = Instant.now();

        // Crear instancia de Retraso
        Retraso retraso = new Retraso(empleado, LocalTime.of(9, 15), LocalTime.of(9, 0), horaRetraso);

        // Validar que los valores fueron correctamente asignados
        assertEquals(empleado, retraso.getEmpleado(), "El empleado asociado no es el esperado");
        assertEquals(horaRetraso, retraso.getHoraRetraso(), "La hora de retraso no es la esperada");
    }

    /**
     * Verifica que se puede modificar la hora de retraso usando el setter.
     */
    @Test
    void testSetHoraRetraso() {
        // Crear instancia de Retraso con hora inicial
        Retraso retraso = new Retraso(
                new Empleado("E002", "Martínez", "Carlos", "carlos@empresa.com"),
                LocalTime.of(10, 15),
                LocalTime.of(10, 0),
                Instant.now()
        );

        // Nueva hora para actualizar
        Instant nuevaHora = Instant.now().plusSeconds(3600);
        retraso.setHoraRetraso(nuevaHora);

        // Verificación
        assertEquals(nuevaHora, retraso.getHoraRetraso(), "La hora de retraso no fue actualizada correctamente");
    }

    /**
     * Verifica que el método toString incluya la información relevante del objeto.
     */
    @Test
    void testToString() {
        // Instancia con datos fijos
        Instant horaFija = Instant.parse("2023-01-01T10:15:30Z");
        Retraso retraso = new Retraso(
                new Empleado("E003", "López", "María", "maria@empresa.com"),
                LocalTime.of(10, 15),
                LocalTime.of(10, 0),
                horaFija
        );

        // Validar contenido del toString
        String resultado = retraso.toString();
        assertTrue(resultado.contains("Hora (con retraso): "), "El toString debería incluir el texto 'Hora (con retraso): '");
        assertTrue(resultado.contains("2023-01-01T10:15:30Z"), "El toString debería incluir la hora fija esperada");
    }

    /**
     * Verifica que Retraso hereda correctamente de la clase Asistencia.
     */
    @Test
    void testHerenciaAsistencia() {
        Retraso retraso = new Retraso(
                new Empleado("E004", "Rodríguez", "Pedro", "pedro@empresa.com"),
                LocalTime.of(9, 10), // 10 minutos de retraso
                LocalTime.of(9, 0),
                Instant.now()
        );

        // Validar herencia
        assertTrue(retraso instanceof Asistencia, "Retraso debería ser una subclase de Asistencia");
    }
}
