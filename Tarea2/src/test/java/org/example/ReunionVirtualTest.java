package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ReunionVirtualTest {
    private ReunionVirtual reunionVirtual;
    private Empleado organizador;
    private Date fecha;
    private final String ENLACE_TEST = "https://meet.example.com/123";

    @BeforeEach
    void setUp() {
        fecha = new Date();
        organizador = new Empleado("E001", "Gómez", "Ana", "ana@empresa.com");

        // Crear instancia sin especificar el tipo de reunión
        // Asume que el constructor puede manejar null como tipo
        reunionVirtual = new ReunionVirtual(fecha, organizador, null);
        reunionVirtual.setEnlace(ENLACE_TEST);
    }

    @Test
    void testConstructorAndBasicProperties() {
        assertNotNull(reunionVirtual);
        assertEquals(fecha, reunionVirtual.getFecha());
        assertEquals(organizador, reunionVirtual.getOrganizador());
        assertEquals(ENLACE_TEST, reunionVirtual.getEnlace());
    }

    @Test
    void testGetLugar() {
        assertEquals("Enlace virtual: " + ENLACE_TEST, reunionVirtual.getLugar());
    }

    @Test
    void testSetEnlace() {
        String nuevoEnlace = "https://nueva-reunion.com/456";
        reunionVirtual.setEnlace(nuevoEnlace);
        assertEquals(nuevoEnlace, reunionVirtual.getEnlace());
    }

    @Test
    void testToString() {
        String resultado = reunionVirtual.toString();
        assertTrue(resultado.contains("Reunion{"));
        assertTrue(resultado.contains("Modalidad: Virtual"));
    }

    @Test
    void testRegistrarInvitados() {
        Empleado nuevoEmpleado = new Empleado("E002", "Pérez", "Juan", "juan@empresa.com");
        reunionVirtual.registrarInvitados(nuevoEmpleado);

        assertEquals(1, reunionVirtual.obtenerAusencias().size());
    }

    @Test
    void testIniciarYFinalizar() {
        reunionVirtual.iniciar();
        assertNotNull(reunionVirtual.getHoraInicio());

        reunionVirtual.finalizar();
        assertNotNull(reunionVirtual.getHoraFinal());

        assertTrue(reunionVirtual.calcularTiempoReal() >= 0);
    }
}