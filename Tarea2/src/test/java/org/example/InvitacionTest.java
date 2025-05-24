package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Invitacion.
 * Se verifican el constructor, getters, método enviarInvitacion y toString.
 */
class InvitacionTest {
    private Invitacion invitacion;
    private Instant horaPrueba;

    /**
     * Se ejecuta antes de cada prueba.
     * Inicializa una instancia de Invitacion con la hora actual.
     */
    @BeforeEach
    void setUp() {
        horaPrueba = Instant.now();
        invitacion = new Invitacion(horaPrueba);
    }

    /**
     * Verifica que el constructor de Invitacion inicializa correctamente el objeto.
     */
    @Test
    void testConstructor() {
        assertNotNull(invitacion, "La invitación no debería ser null");
        assertEquals(horaPrueba, invitacion.getHora(), "La hora asignada no coincide con la esperada");
    }

    /**
     * Prueba el método getHora para asegurar que retorna correctamente la hora de la invitación.
     */
    @Test
    void testGetHora() {
        assertEquals(horaPrueba, invitacion.getHora(), "getHora debe devolver la hora exacta asignada");
    }

    /**
     * Verifica que el método enviarInvitacion invoca el método invitar() del objeto Invitable.
     * Se usa una clase mock interna para simular el comportamiento.
     */
    @Test
    void testEnviarInvitacion() {
        // Implementación de prueba para la interfaz Invitable
        class InvitableMock implements Invitable {
            private boolean fueInvitado = false;

            @Override
            public void invitar() {
                fueInvitado = true;
            }

            public boolean fueInvitado() {
                return fueInvitado;
            }
        }

        InvitableMock invitadoMock = new InvitableMock();
        invitacion.enviarInvitacion(invitadoMock);
        assertTrue(invitadoMock.fueInvitado(), "El método invitar() no fue llamado correctamente");
    }

    /**
     * Verifica que el método toString incluye la información de la hora.
     */
    @Test
    void testToString() {
        String resultado = invitacion.toString();
        assertTrue(resultado.contains("Hora invitación: "), "toString debe contener el texto 'Hora invitación: '");
        assertTrue(resultado.contains(horaPrueba.toString()), "toString debe incluir la hora exacta");
    }

    /**
     * Verifica que el método enviarInvitacion lanza una excepción si se pasa null.
     */
    @Test
    void testEnviarInvitacionConNull() {
        assertThrows(NullPointerException.class, () -> {
            invitacion.enviarInvitacion(null);
        }, "Debe lanzar NullPointerException al intentar invitar a un objeto null");
    }
}
