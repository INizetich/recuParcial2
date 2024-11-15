package org.example;

import org.example.Arbitro;
import org.example.Equipo;
import org.example.Registro;

import java.util.Map;

public class OrganizacionDeportiva {
    private String nombre;
    private String pais;

    private Registro<Equipo> registroEquipos;
    private Registro<Arbitro> registroArbitros;

    public OrganizacionDeportiva() {
        this.nombre = "";
        this.pais = "";
        this.registroEquipos = new Registro<>();
        this.registroArbitros = new Registro<>();
    }

    public OrganizacionDeportiva(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.registroEquipos = new Registro<>();
        this.registroArbitros = new Registro<>();
    }

    // Métodos para acceder a los registros
    public Registro<Equipo> getRegistroEquipos() {
        return registroEquipos;
    }

    public Registro<Arbitro> getRegistroArbitros() {
        return registroArbitros;
    }

    // Métodos para agregar participantes
    public void agregarEquipo(Equipo equipo) {
        registroEquipos.agregarParticipante(equipo);
    }

    public void agregarArbitro(Arbitro arbitro) {
        registroArbitros.agregarParticipante(arbitro);
    }

    // Métodos para eliminar participantes por identificador único
    public void eliminarEquipoPorID(int id) {
        Equipo equipoAEliminar = null;
        for (Equipo equipo : registroEquipos.getParticipantes()) {
            if (equipo.getIdEquipo() == id) {
                equipoAEliminar = equipo;
                break;
            }
        }
        if (equipoAEliminar != null) {
            registroEquipos.eliminarParticipante(equipoAEliminar);
            System.out.println("Equipo eliminado correctamente.");
        } else {
            System.out.println("No existe ningún equipo con ese ID.");
        }
    }

    public void eliminarArbitroPorLegajo(int legajo) {
        Arbitro arbitroAEliminar = null;
        for (Arbitro arbitro : registroArbitros.getParticipantes()) {
            if (arbitro.getNumeroLegajo() == legajo) {
                arbitroAEliminar = arbitro;
                break;
            }
        }
        if (arbitroAEliminar != null) {
            registroArbitros.eliminarParticipante(arbitroAEliminar);
            System.out.println("Árbitro eliminado correctamente.");
        } else {
            System.out.println("No existe ningún árbitro con ese legajo.");
        }
    }

    // Métodos para torneos: delegación a GestionTorneo
    public void agregarTorneo(Torneo torneo) {
        GestionTorneo.agregarTorneo(torneo);
    }

    public void eliminarTorneoPorID(int idTorneo) {
        GestionTorneo.eliminarTorneo(idTorneo);
    }

    public void mostrarListaTorneos() {
        GestionTorneo.mostrarTorneos();
    }

    // Métodos para mostrar listas de participantes
    public void mostrarListaEquipos() {
        registroEquipos.mostrarParticipantes();
    }

    public void mostrarListaArbitros() {
        registroArbitros.mostrarParticipantes();
    }

    @Override
    public String toString() {
        return "OrganizacionDeportiva{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", listaEquipos=" + registroEquipos.getParticipantes() +
                ", listaArbitros=" + registroArbitros.getParticipantes() +
                ", torneos=" + GestionTorneo.getMapaTorneo().values() +
                '}';
    }
}
