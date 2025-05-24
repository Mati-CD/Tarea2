package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link ReunionPresencial}.
 * Se encarga de verificar el comportamiento de las reuniones presenciales,
 * incluyendo la gestión de sala, modalidad y métodos heredados desde {@code Reunion}.
 */
class ReunionPresencialTest {

    private ReunionPresencial reunionPresencial;
    private Empleado organizador;
    private Date fecha;

    /**
     * Configura un escenario de prueba antes de cada test, con una reunión presencial de tipo técnica.
     */
    @BeforeEach
    void setUp() {
        fecha = new Date();
        organizador = new Empleado("123", "Gómez", "Juan", "juan.gomez@empresa.com");
        reunionPresencial = new ReunionPresencial(fecha, organizador, tipoReunion.TECNICA);
    }

    /**
     * Verifica que {@code getLugar()} retorne correctamente "Sala: null"
     * cuando no se ha definido ninguna sala.
     */
    @Test
    void testGetLugarConSalaNoEstablecida() {
        assertEquals("Sala: null", reunionPresencial.getLugar(), "Debería retornar 'Sala: null' si no se ha definido una sala");
    }

    /**
     * Verifica que {@code getLugar()} retorne correctamente la sala establecida.
     */
    @Test
    void testGetLugarConSalaEstablecida() {
        String salaEsperada = "Sala 101";
        reunionPresencial.setSala(salaEsperada);
        assertEquals("Sala: " + salaEsperada, reunionPresencial.getLugar(), "El lugar debería incluir el nombre de la sala establecida");
    }

    /**
     * Verifica que los métodos {@code setSala()} y {@code getSala()} funcionen correctamente.
     */
    @Test
    void testGetSetSala() {
        String salaEsperada = "Sala 202";
        reunionPresencial.setSala(salaEsperada);
        assertEquals(salaEsperada, reunionPresencial.getSala(), "La sala debería ser la misma que se estableció");
    }

    /**
     * Verifica que la representación textual de la reunión incluya la indicación de modalidad presencial.
     */
    @Test
    void testToStringContieneModalidadPresencial() {
        String resultado = reunionPresencial.toString();
        assertTrue(resultado.contains("Modalidad: Presencial"), "El toString debería indicar que la modalidad es presencial");
    }

    /**
     * Verifica que los métodos heredados desde {@code Reunion} se ejecutan sin errores.
     */
    @Test
    void testMetodosDeReunionFuncionan() {
        assertDoesNotThrow(() -> reunionPresencial.iniciar(), "El método iniciar() no debería lanzar excepciones");
        assertDoesNotThrow(() -> reunionPresencial.finalizar(), "El método finalizar() no debería lanzar excepciones");
        assertDoesNotThrow(() -> reunionPresencial.calcularTiempoReal(), "El método calcularTiempoReal() no debería lanzar excepciones");
    }
}
