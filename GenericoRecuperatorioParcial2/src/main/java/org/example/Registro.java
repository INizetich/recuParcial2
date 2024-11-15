package org.example;

import java.util.LinkedHashSet;
import java.util.Set;

public class Registro<T extends Participante> {
    private Set<T> participantes;

    public Registro() {
        this.participantes = new LinkedHashSet<>();
    }

    // Método para agregar un participante
    public boolean agregarParticipante(T participante) {
        if (participantes.add(participante)) {
            System.out.println("Participante agregado: " + participante);
            return true;
        } else {
            System.out.println("El participante ya está registrado: " + participante);
            return false;
        }
    }

    // Método para eliminar un participante
    public boolean eliminarParticipante(T participante) {
        if (participantes.remove(participante)) {
            System.out.println("Participante eliminado: " + participante);
            return true;
        } else {
            System.out.println("El participante no se encuentra en el registro.");
            return false;
        }
    }

    // Método para mostrar todos los participantes
    public void mostrarParticipantes() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes en el registro.");
        } else {
            System.out.println("Lista de participantes:");
            for (T participante : participantes) {
                System.out.println(participante);
            }
        }
    }

    // Método para obtener el conjunto de participantes
    public Set<T> getParticipantes() {
        return participantes;
    }
}
