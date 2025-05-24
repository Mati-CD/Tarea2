package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase de pruebas unitarias para la clase Nota.
 * Se verifica el correcto funcionamiento del constructor, los métodos de acceso,
 * el método toString, y el comportamiento ante entradas inválidas.
 */
class NotaTest {

    /**
     * Verifica que una Nota se crea correctamente con contenido y que se asigna una fecha de creación reciente.
     */
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

    /**
     * Prueba que el método getContenido devuelve el contenido correcto.
     */
    @Test
    void testGetContenido() {
        // Arrange
        String contenido = "Preparar presentación de marketing";
        Nota nota = new Nota(contenido);

        // Act & Assert
        assertEquals(contenido, nota.getContenido(), "El contenido obtenido no coincide con el esperado");
    }

    /**
     * Verifica que getFechaCreacion retorna una fecha válida cercana al momento de creación del objeto.
     */
    @Test
    void testGetFechaCreacion() {
        // Arrange
        LocalDateTime antes = LocalDateTime.now().minusSeconds(1);
        Nota nota = new Nota("Nota de prueba");

        // Act y Assert
        LocalDateTime fechaCreacion = nota.getFechaCreacion();
        assertNotNull(fechaCreacion, "La fecha de creación no debería ser nula");
        assertFalse(fechaCreacion.isBefore(antes),
                "La fecha de creación no debería ser anterior a la creación de la nota");
        assertTrue(fechaCreacion.isBefore(LocalDateTime.now().plusSeconds(1)),
                "La fecha de creación no debería ser mucho después del momento actual");
    }

    /**
     * Prueba que el método toString tiene el formato correcto, incluyendo la fecha y el contenido.
     */
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

    /**
     * Verifica que se puede crear una nota con contenido vacío y que se asigna una fecha de creación.
     */
    @Test
    void testNotaVacia() {
        // Arrange y Act
        Nota nota = new Nota("");

        // Assert
        assertEquals("", nota.getContenido(), "El contenido de una nota vacía debería ser cadena vacía");
        assertNotNull(nota.getFechaCreacion(), "La fecha de creación no debería ser nula incluso con contenido vacío");
    }

    /**
     * Verifica que el constructor lanza una NullPointerException al pasar contenido nulo.
     */
    @Test
    void testNotaConNull() {
        // Act y Assert
        assertThrows(NullPointerException.class, () -> new Nota(null),
                "Debería lanzar NullPointerException con contenido nulo");
    }

    /**
     * Prueba que el contenido largo se guarda correctamente y que el método toString lo incluye adecuadamente.
     */
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
