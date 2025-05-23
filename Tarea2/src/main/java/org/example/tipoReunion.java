package org.example;

public class tipoReunion {
    public enum Reuniones{
        TECNICA(1),
        MARKETING(2),
        OTRO(3);

        private int tiporeuniones;
        Reuniones(int tipo){this.tiporeuniones = tipo;}

        public int getTipo(){return tiporeuniones;}
    }
}
