package org.example;

import java.util.Objects;

public class Torneo {
    private int idTorneo;
    private String nombreTorneo;
    private int añoRealizado;
    private int mesInicio;
    private int mesFin;


    public Torneo() {
        this.idTorneo = 0;
        this.nombreTorneo = "";
        this.añoRealizado = 0;
        this.mesInicio = 0;
        this.mesFin = 0;

    }
    public Torneo(int id, String nombre, int anio, int mesInicio, int mesFinalizacion) {
        this.idTorneo = id;
        this.nombreTorneo = nombre;
        this.añoRealizado = anio;
        this.mesInicio = mesInicio;
        this.mesFin = mesFinalizacion;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getAñoRealizado() {
        return añoRealizado;
    }

    public void setAñoRealizado(int añoRealizado) {
        this.añoRealizado = añoRealizado;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public void setMesFin(int mesFin) {
        this.mesFin = mesFin;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "idTorneo=" + idTorneo +
                ", nombreTorneo='" + nombreTorneo + '\'' +
                ", añoRealizado=" + añoRealizado +
                ", mesInicio=" + mesInicio +
                ", mesFin=" + mesFin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torneo torneo = (Torneo) o;
        return idTorneo == torneo.idTorneo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTorneo);
    }
}
