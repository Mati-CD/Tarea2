package org.example;

import java.util.ArrayList;

/**
 * Esta clase representa un departamento dentro de la empresa.
 * Cada departamento tiene un nombre y una lista de empleados asociados.
 */
public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    /**
     * Constructor del departamento.
     * Se inicializa con un nombre y una lista vacía de empleados.
     *
     * @param nombre nombre del departamento.
     */
    public Departamento(String nombre) {
        empleados = new ArrayList<>();
        this.nombre = nombre;
    }

    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado el empleado que se quiere agregar.
     */
    public void add(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Retorna cuántos empleados hay en el departamento.
     *
     * @return número de empleados registrados.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    // Getters

    /**
     * Devuelve el nombre del departamento.
     *
     * @return nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve una copia de la lista de empleados del departamento.
     *
     * @return lista de empleados.
     */
    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    // Setters

    /**
     * Cambia el nombre del departamento.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Reemplaza la lista de empleados por una nueva.
     *
     * @param empleados nueva lista de empleados.
     */
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = new ArrayList<>(empleados);
    }

    /**
     * Retorna un resumen del departamento con su nombre
     * y el total de empleados que tiene.
     *
     * @return resumen en texto.
     */
    @Override
    public String toString() {
        return "Departamento: " + nombre + " || Total de empleados: " + empleados.size();
    }
}



