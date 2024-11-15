package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GestionTorneo {
    private static TreeMap<Integer,Torneo> mapaTorneo = new TreeMap<>();


    // Método para agregar un torneo con validación
    public static void agregarTorneo(Torneo torneo) throws MesInvalidoException {
        validarMeses(torneo.getMesInicio(), torneo.getMesFin());
        if (!mapaTorneo.containsKey(torneo.getIdTorneo())) {
            mapaTorneo.put(torneo.getIdTorneo(), torneo);
            System.out.println("Torneo agregado: " + torneo);
        } else {
            System.out.println("Ya existe un torneo con el ID: " + torneo.getIdTorneo());
        }
    }

    // Método de validación de meses
    private static void validarMeses(int mesInicio, int mesFin) throws MesInvalidoException {
        if (mesInicio < 1 || mesInicio > 12) {
            throw new MesInvalidoException("El mes de inicio no puede ser menor que 1 ni mayor que 12.");
        }
        if (mesFin < 1 || mesFin > 12) {
            throw new MesInvalidoException("El mes de finalización no puede ser menor que 1 ni mayor que 12.");
        }
    }

    public static void mostrarTorneos() {
        if (mapaTorneo.isEmpty()) {
            System.out.println("No hay torneos registrados.");
        } else {
            System.out.println("Lista de torneos:");
            for (Torneo torneo : mapaTorneo.values()) {
                System.out.println(torneo);
            }
        }
    }
    public static void eliminarTorneo(int idTorneo) {
        if (mapaTorneo.containsKey(idTorneo)) {
            Torneo eliminado = mapaTorneo.remove(idTorneo);
            System.out.println("Torneo eliminado: " + eliminado);
        } else {
            System.out.println("No existe ningún torneo con el ID: " + idTorneo);
        }
    }


    public static TreeMap<Integer, Torneo> getMapaTorneo() {
        return mapaTorneo;
    }

    public static void setMapaTorneo(TreeMap<Integer, Torneo> mapaTorneo) {
        GestionTorneo.mapaTorneo = mapaTorneo;
    }
}
