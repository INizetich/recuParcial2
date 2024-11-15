package org.example;

public class Arbitro implements Participante {
    private int numeroLegajo;
    private String nombreCompleto;
    private String categoria;


    public Arbitro() {
        this.numeroLegajo = 0;
        this.nombreCompleto = "";
        this.categoria = "";
    }

    public Arbitro(int   numeroLegajo, String nombreCompleto, String categoria) {
        this.numeroLegajo = numeroLegajo;
        this.nombreCompleto = nombreCompleto;
        this.categoria = categoria;
    }


    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "numeroLegajo='" + numeroLegajo + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }


    @Override
    public String agregarAtorneo() {
        return "El arbitro: "+nombreCompleto+ " a sido agregado al torneo";
    }

    @Override
    public String agregarPartidoTorneo() {
        return "El árbitro " + nombreCompleto + " ha sido asignado a un partido del torneo.";
    }

    @Override
    public String suspenderParticipante() {
        return "El árbitro " + nombreCompleto + " ha sido suspendido del torneo.";
    }
}
