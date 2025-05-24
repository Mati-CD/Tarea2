package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Nota nota = new Nota("Prueba manual");
        System.out.println("Contenido: " + nota.getContenido());
        System.out.println("Fecha: " + nota.getFechaCreacion());
        System.out.println("ToString: " + nota);

        // Verificación manual
        if (nota.getContenido().equals("Prueba manual")) {
            System.out.println("✓ Contenido correcto");
        } else {
            System.out.println("✗ Error en contenido");
        }
        */

        Empleado e1 = new Empleado("001", "Cerulo", "Pierluigi", "pcerulo2023@gmail.com");
        Empleado e2 = new Empleado("002", "Muñoz", "Carlos", "cmuñoz@gmail.com");
        Empleado e3 = new Empleado("003", "Vidal", "Javier", "jvidal@gmail.com");
        Empleado organizador = new Empleado("1", "Nova", "Miguel", "mnova@gmail.com");

        ReunionPresencial reunion = new ReunionPresencial(
                new Date(), Duration.ofHours(1), organizador, TipoReunion.TECNICA, "A9"
        );

        reunion.registrarInvitados(e1);
        reunion.registrarInvitados(e2);
        reunion.registrarInvitados(e3);

        reunion.iniciar();

        LocalTime horaInicio = LocalTime.of(10, 0);

        reunion.registrarInvitados(e1);
        reunion.registrarInvitados(e2);
        reunion.registrarInvitados(e3);

        reunion.registrarAsistencia(e1, LocalTime.of(9,55), horaInicio);
        reunion.registrarAsistencia(e2, LocalTime.of(10,5), horaInicio);


        System.out.println("LLego a la hora: " + reunion.obtenerAsistencias());
        System.out.println("LLego tarde: " + reunion.obtenerRetrasos());
        System.out.println("No llego: " + reunion.obtenerAusencias());
    }
}