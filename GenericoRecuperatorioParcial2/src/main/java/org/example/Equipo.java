package org.example;

public class Equipo implements Participante{
    private int idEquipo;
       private String nombreEquipo;
       private int puntos;

       public Equipo() {
           this.idEquipo = 0;
           this.nombreEquipo = "";
           this.puntos = 0;
       }

    public Equipo(int idEquipo, String nombreEquipo, int puntos) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.puntos = puntos;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", puntos=" + puntos +
                '}';
    }



    @Override
    public String agregarAtorneo() {
        return "El equipo " + nombreEquipo + " ha sido añadido al torneo.";
    }

    @Override
    public String agregarPartidoTorneo() {
        return "El equipo " + nombreEquipo + " ha sido asignado a un partido del torneo.";
    }
    @Override
    public String suspenderParticipante() {
        return "El equipo " + nombreEquipo + " ha sido suspendido del torneo.";
    }
    }



