package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class NotaTest {

    @Test
    void testCreacionNota() {
        // Arrange
        String contenidoEsperado = "Recordar enviar agenda previa";

        // Act
        Nota nota = new Nota(contenidoEsperado);

        // Assert
        assertEquals(contenidoEsperado, nota.getContenido(), "El contenido de la nota no coincide");
        assertNotNull(nota.getFechaCreacion(), "La fecha de creación no debería ser nula");

        // Verificar que la fecha de creación es reciente (con margen de 1 segundo)
        assertTrue(Math.abs(ChronoUnit.SECONDS.between(nota.getFechaCreacion(), LocalDateTime.now())) <= 1,
                "La fecha de creación debería ser aproximadamente ahora");
    }

    @Test
    void testGetContenido() {
        // Arrange
        String contenido = "Preparar presentación de marketing";
        Nota nota = new Nota(contenido);

        // Act & Assert
        assertEquals(contenido, nota.getContenido(), "El contenido obtenido no coincide con el esperado");
    }

    @Test
    void testGetFechaCreacion() {
        // Arrange
        LocalDateTime antes = LocalDateTime.now().minusSeconds(1);
        Nota nota = new Nota("Nota de prueba");

        // Act y Assert
        LocalDateTime fechaCreacion = nota.getFechaCreacion();
        assertNotNull(fechaCreacion, "La fecha de creación no debería ser nula");
        assertFalse(fechaCreacion.isBefore(antes), "La fecha de creación no debería ser anterior a la creación de la nota");
        assertTrue(fechaCreacion.isBefore(LocalDateTime.now().plusSeconds(1)),
                "La fecha de creación no debería ser mucho después del momento actual");
    }

    @Test
    void testToString() {
        // Arrange
        String contenido = "Revisar contrato con cliente";
        Nota nota = new Nota(contenido);

        // Act
        String resultado = nota.toString();

        // Assert
        assertTrue(resultado.startsWith("["), "El formato toString debería empezar con '['");
        assertTrue(resultado.contains(contenido), "El formato toString debería incluir el contenido");
        assertTrue(resultado.endsWith("] " + contenido), "El formato toString no coincide con el esperado");
    }

    @Test
    void testNotaVacia() {
        // Arrange y Act
        Nota nota = new Nota("");

        // Assert
        assertEquals("", nota.getContenido(), "El contenido de una nota vacía debería ser cadena vacía");
        assertNotNull(nota.getFechaCreacion(), "La fecha de creación no debería ser nula incluso con contenido vacío");
    }

    @Test
    void testNotaConNull() {
        // Act y Assert
        assertThrows(NullPointerException.class, () -> new Nota(null),
                "Debería lanzar NullPointerException con contenido nulo");
    }

    @Test
    void testNotaConFormatoLargo() {
        // Arrange
        String contenidoLargo = "Preparar los siguientes puntos para la reunión técnica:\n" +
                "1. Revisar avances del sprint actual\n" +
                "2. Planificar próximas tareas\n" +
                "3. Discutir problemas técnicos encontrados";

        // Act
        Nota nota = new Nota(contenidoLargo);

        // Assert
        assertEquals(contenidoLargo, nota.getContenido(), "El contenido largo no se almacenó correctamente");
        assertTrue(nota.toString().contains("1. Revisar avances"),
                "El toString debería incluir parte del contenido largo");
    }
}