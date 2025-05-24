package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ReunionVirtual.
 * <p>
 * Verifica creación, propiedades básicas, enlace, lugar, 
 * registro de invitados y control de tiempo de la reunión.
 * </p>
 */
class ReunionVirtualTest {
    private ReunionVirtual reunionVirtual;
    private Empleado organizador;
    private Date fecha;
    private final String ENLACE_TEST = "https://meet.example.com/123";

    /**
     * Configura los objetos necesarios antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        fecha = new Date();
        organizador = new Empleado("E001", "Gómez", "Ana", "ana@empresa.com");

        reunionVirtual = new ReunionVirtual(fecha, organizador, null);
        reunionVirtual.setEnlace(ENLACE_TEST);
    }

    /**
     * Prueba el constructor y propiedades básicas.
     */
    @Test
    void testConstructorAndBasicProperties() {
        assertNotNull(reunionVirtual);
        assertEquals(fecha, reunionVirtual.getFecha());
        assertEquals(organizador, reunionVirtual.getOrganizador());
        assertEquals(ENLACE_TEST, reunionVirtual.getEnlace());
    }

    /**
     * Prueba el método que obtiene el lugar de la reunión virtual.
     */
    @Test
    void testGetLugar() {
        assertEquals("Enlace virtual: " + ENLACE_TEST, reunionVirtual.getLugar());
    }

    /**
     * Prueba modificar el enlace de la reunión.
     */
    @Test
    void testSetEnlace() {
        String nuevoEnlace = "https://nueva-reunion.com/456";
        reunionVirtual.setEnlace(nuevoEnlace);
        assertEquals(nuevoEnlace, reunionVirtual.getEnlace());
    }

    /**
     * Prueba el método toString para incluir información esperada.
     */
    @Test
    void testToString() {
        String resultado = reunionVirtual.toString();
        assertTrue(resultado.contains("Reunion{"));
        assertTrue(resultado.contains("Modalidad: Virtual"));
    }

    /**
     * Prueba registrar invitados y verificar ausencias.
     */
    @Test
    void testRegistrarInvitados() {
        Empleado nuevoEmpleado = new Empleado("E002", "Pérez", "Juan", "juan@empresa.com");
        reunionVirtual.registrarInvitados(nuevoEmpleado);

        assertEquals(1, reunionVirtual.obtenerAusencias().size());
    }

    /**
     * Prueba iniciar y finalizar la reunión, y calcular duración.
     */
    @Test
    void testIniciarYFinalizar() {
        reunionVirtual.iniciar();
        assertNotNull(reunionVirtual.getHoraInicio());

        reunionVirtual.finalizar();
        assertNotNull(reunionVirtual.getHoraFinal());

        assertTrue(reunionVirtual.calcularTiempoReal() >= 0);
    }
}
