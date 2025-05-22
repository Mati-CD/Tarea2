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


    public String getNombre() {
        return nombre;
    }
    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }
}
