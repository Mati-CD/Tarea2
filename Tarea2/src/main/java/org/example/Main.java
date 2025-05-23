package org.example;

public class Main {
    public static void main(String[] args) {
        Nota nota = new Nota("Prueba manual");
        System.out.println("Contenido: " + nota.getContenido());
        System.out.println("Fecha: " + nota.getFechaCreacion());
        System.out.println("ToString: " + nota);

        // Verificación manual
        if(nota.getContenido().equals("Prueba manual")) {
            System.out.println("✓ Contenido correcto");
        } else {
            System.out.println("✗ Error en contenido");
        }
    }

    // Probando clase Nota
}