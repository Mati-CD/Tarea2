package org.example;
import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre) {
        empleados = new ArrayList<>();
        this.nombre = nombre;
    }

    public void add(Empleado empleado) {
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = new ArrayList<>(empleados);
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + " || Total de empleados: " + empleados.size();
    }
}
