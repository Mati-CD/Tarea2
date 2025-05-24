package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ReunionPresencialTest {

    private ReunionPresencial reunionPresencial;
    private Empleado organizador;
    private Date fecha;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        organizador = new Empleado("123", "Gómez", "Juan", "juan.gomez@empresa.com");
        reunionPresencial = new ReunionPresencial(fecha, organizador, tipoReunion.TECNICA);
    }

    @Test
    void testGetLugarConSalaNoEstablecida() {
        assertEquals("Sala: null", reunionPresencial.getLugar());
    }

    @Test
    void testGetLugarConSalaEstablecida() {
        String salaEsperada = "Sala 101";
        reunionPresencial.setSala(salaEsperada);
        assertEquals("Sala: " + salaEsperada, reunionPresencial.getLugar());
    }

    @Test
    void testGetSetSala() {
        String salaEsperada = "Sala 202";
        reunionPresencial.setSala(salaEsperada);
        assertEquals(salaEsperada, reunionPresencial.getSala());
    }

    @Test
    void testToStringContieneModalidadPresencial() {
        String resultado = reunionPresencial.toString();
        assertTrue(resultado.contains("Modalidad: Presencial"));
    }

    @Test
    void testMetodosDeReunionFuncionan() {
        // Probamos que los métodos heredados se pueden ejecutar sin errores
        assertDoesNotThrow(() -> reunionPresencial.iniciar());
        assertDoesNotThrow(() -> reunionPresencial.finalizar());
        assertDoesNotThrow(() -> reunionPresencial.calcularTiempoReal());
    }
}