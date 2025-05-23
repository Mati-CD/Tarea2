package org.example;

public enum TipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);

    private final int queTipo;

    TipoReunion(int queTipo) {
        this.queTipo = queTipo;
    }

    public int getTipo(){
        return queTipo;
    }
}
