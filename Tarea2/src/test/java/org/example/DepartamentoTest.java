package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    private Departamento departamento;
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Desarrollo");
        empleado1 = new Empleado("E001", "García", "Ana", "ana@empresa.com");
        empleado2 = new Empleado("E002", "Martínez", "Carlos", "carlos@empresa.com");
    }

    @Test
    void testConstructor() {
        assertNotNull(departamento);
        assertEquals("Desarrollo", departamento.getNombre());
        assertTrue(departamento.getEmpleados().isEmpty());
    }

    @Test
    void testAddEmpleado() {
        departamento.add(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
        assertTrue(departamento.getEmpleados().contains(empleado1));

        departamento.add(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados());
        assertTrue(departamento.getEmpleados().contains(empleado2));
    }

    @Test
    void testObtenerCantidadEmpleados() {
        assertEquals(0, departamento.obtenerCantidadEmpleados());

        departamento.add(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados());

        departamento.add(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void testGetEmpleadosReturnsCopy() {
        departamento.add(empleado1);
        ArrayList<Empleado> copiaEmpleados = departamento.getEmpleados();

        // Modificar la copia no debería afectar al original
        copiaEmpleados.remove(0);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void testSetEmpleados() {
        ArrayList<Empleado> nuevosEmpleados = new ArrayList<>();
        nuevosEmpleados.add(empleado1);
        nuevosEmpleados.add(empleado2);

        departamento.setEmpleados(nuevosEmpleados);
        assertEquals(2, departamento.obtenerCantidadEmpleados());

        // Modificar la lista original no debería afectar al departamento
        nuevosEmpleados.remove(0);
        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void testSetNombre() {
        departamento.setNombre("Marketing");
        assertEquals("Marketing", departamento.getNombre());
    }

    @Test
    void testToString() {
        departamento.add(empleado1);
        String resultado = departamento.toString();

        assertTrue(resultado.contains("Departamento: Desarrollo"));
        assertTrue(resultado.contains("Total de empleados: 1"));

        departamento.add(empleado2);
        resultado = departamento.toString();
        assertTrue(resultado.contains("Total de empleados: 2"));
    }

    @Test
    void testSetNullEmpleados() {
        assertThrows(NullPointerException.class, () -> {
            departamento.setEmpleados(null);
        });
    }
}