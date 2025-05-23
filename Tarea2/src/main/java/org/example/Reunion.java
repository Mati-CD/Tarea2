package org.example;

public abstract class Reunion {
    public Reunion(){}


    public String toString(){
        return "Reunion de tipo: " + tipo + "\n" +
               "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n";
    }
}
