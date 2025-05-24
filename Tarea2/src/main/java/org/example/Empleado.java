package org.example;

/**
 * Esta clase representa a un empleado dentro de la empresa.
 * Guarda información básica como su ID, nombre, apellidos y correo electrónico.
 */
public class Empleado {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * Constructor del empleado.
     * Se inicializa con su ID, apellidos, nombre y correo.
     *
     * @param id identificador único del empleado.
     * @param apellidos apellidos del empleado.
     * @param nombre nombre del empleado.
     * @param correo correo electrónico del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters

    /**
     * Devuelve el ID del empleado.
     *
     * @return ID como string.
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve los apellidos del empleado.
     *
     * @return apellidos como string.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return nombre como string.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el correo electrónico del empleado.
     *
     * @return correo como string.
     */
    public String getCorreo() {
        return correo;
    }

    // Setters

    /**
     * Cambia el ID del empleado.
     *
     * @param id nuevo ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Cambia los apellidos del empleado.
     *
     * @param apellidos nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Cambia el nombre del empleado.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Cambia el correo del empleado.
     *
     * @param correo nuevo correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve un resumen del empleado con todos sus datos.
     *
     * @return cadena de texto con los datos del empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

