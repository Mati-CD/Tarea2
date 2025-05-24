package org.example;

public enum tipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);

    private final int queTipo;

    tipoReunion(int queTipo) {
        this.queTipo = queTipo;
    }

    public int getTipo(){
        return queTipo;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
