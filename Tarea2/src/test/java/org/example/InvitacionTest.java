package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {
    private Invitacion invitacion;
    private Instant horaPrueba;

    @BeforeEach
    void setUp() {
        horaPrueba = Instant.now();
        invitacion = new Invitacion(horaPrueba);
    }

    @Test
    void testConstructor() {
        assertNotNull(invitacion);
        assertEquals(horaPrueba, invitacion.getHora());
    }

    @Test
    void testGetHora() {
        assertEquals(horaPrueba, invitacion.getHora());
    }

    @Test
    void testEnviarInvitacion() {
        // Implementación de prueba para Invitable
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
        assertTrue(invitadoMock.fueInvitado());
    }

    @Test
    void testToString() {
        String resultado = invitacion.toString();
        assertTrue(resultado.contains("Hora invitación: "));
        assertTrue(resultado.contains(horaPrueba.toString()));
    }

    @Test
    void testEnviarInvitacionConNull() {
        assertThrows(NullPointerException.class, () -> {
            invitacion.enviarInvitacion(null);
        });
    }
}