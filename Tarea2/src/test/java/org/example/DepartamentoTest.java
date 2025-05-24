package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Departamento.
 * Se utilizan pruebas para verificar el comportamiento esperado
 * en la gestión de empleados y nombre del departamento.
 */
class DepartamentoTest {
    private Departamento departamento;
    private Empleado empleado1;
    private Empleado empleado2;

    /**
     * Inicializa un departamento y dos empleados antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        departamento = new Departamento("Desarrollo");
        empleado1 = new Empleado("E001", "García", "Ana", "ana@empresa.com");
        empleado2 = new Empleado("E002", "Martínez", "Carlos", "carlos@empresa.com");
    }

    /**
     * Verifica que el constructor del departamento funciona correctamente.
     * Se espera que el nombre sea el dado y que la lista de empleados esté vacía.
     */
    @Test
    void testConstructor() {
        assertNotNull(departamento);
        assertEquals("Desarrollo", departamento.getNombre());
        assertTrue(departamento.getEmpleados().isEmpty());
    }

    /**
     * Prueba la adición de empleados al departamento.
     * Verifica que el número de empleados y el contenido de la lista sean correctos.
     */
    @Test
    void testAddEmpleado() {
        departamento.add(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
        assertTrue(departamento.getEmpleados().contains(empleado1));

        departamento.add(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados());
        assertTrue(departamento.getEmpleados().contains(empleado2));
    }

    /**
     * Verifica que el método para obtener la cantidad de empleados funciona correctamente.
     */
    @Test
    void testObtenerCantidadEmpleados() {
        assertEquals(0, departamento.obtenerCantidadEmpleados());

        departamento.add(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados());

        departamento.add(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    /**
     * Asegura que el método getEmpleados devuelve una copia de la lista original.
     * Modificar la copia no debe afectar al estado interno del objeto.
     */
    @Test
    void testGetEmpleadosReturnsCopy() {
        departamento.add(empleado1);
        ArrayList<Empleado> copiaEmpleados = departamento.getEmpleados();

        // Modificar la copia no debería afectar al original
        copiaEmpleados.remove(0);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
    }

    /**
     * Verifica que el método setEmpleados asigna correctamente una nueva lista de empleados
     * y que dicha asignación es defensiva (no se ve afectada por cambios externos).
     */
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

    /**
     * Prueba el método setNombre para cambiar el nombre del departamento.
     */
    @Test
    void testSetNombre() {
        departamento.setNombre("Marketing");
        assertEquals("Marketing", departamento.getNombre());
    }

    /**
     * Verifica que el método toString produce una representación adecuada del estado del objeto.
     */
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

    /**
     * Verifica que setEmpleados lanza una excepción si se le pasa null como parámetro.
     */
    @Test
    void testSetNullEmpleados() {
        assertThrows(NullPointerException.class, () -> {
            departamento.setEmpleados(null);
        });
    }
}
