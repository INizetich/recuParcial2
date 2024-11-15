package org.example;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
      ///-------------------------------CREACION DE OBJETOS CON ATRIBUTOS HARDCODEADOS------------------------------------------
        Torneo torneo1 = new Torneo(1, "UEFA Champions League", 2024, 3, 5);
        Torneo torneo2 = new Torneo(2, "Mundial de clubes", 2024, 6, 8);
        Torneo torneo3 = new Torneo(3, "UEFA Europa League", 2024, 9, 10);

        //equipos
        Equipo equipo1 = new Equipo(1, "Real madrid", 35);
        Equipo equipo2 = new Equipo(2, "Barcelona", 15);
        Equipo equipo3 = new Equipo(3, "Paris Saint-Germain", 9);

        //árbitros
        Arbitro arbitro1 = new Arbitro(21945, "Néstor Pitana", "Primera División");
        Arbitro arbitro2 = new Arbitro(14851, "Pierluigi Collina", "Segunda División");
        Arbitro arbitro3 = new Arbitro(13045, "Darío Herrera", "Primera División");
///-----------------------------------------------------------------------------------------------------------------------------

        // Agregar torneos al mapa de torneos
        try {
            GestionTorneo.agregarTorneo(torneo1);
            GestionTorneo.agregarTorneo(torneo2);
            GestionTorneo.agregarTorneo(torneo3);
        } catch (MesInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar torneos

        GestionTorneo.mostrarTorneos();


        // Registro de equipos
        Registro<Equipo> registroEquipos = new Registro<>();
        registroEquipos.agregarParticipante(equipo1);
        registroEquipos.agregarParticipante(equipo2);
        registroEquipos.agregarParticipante(equipo3);

        // Mostrar equipos registrados
        System.out.println("\nEquipos registrados:");
        registroEquipos.mostrarParticipantes();



        // Registro de árbitros
        Registro<Arbitro> registroArbitros = new Registro<>();
        registroArbitros.agregarParticipante(arbitro1);
        registroArbitros.agregarParticipante(arbitro2);
        registroArbitros.agregarParticipante(arbitro3);

        // Mostrar árbitros registrados
        System.out.println("\nÁrbitros registrados:");
        registroArbitros.mostrarParticipantes();

        // Simular eliminación de un torneo
        System.out.println("\nEliminando el Torneo:"+torneo2.getNombreTorneo());
        GestionTorneo.eliminarTorneo(2);

        // Mostrar torneos después de la eliminación
        GestionTorneo.mostrarTorneos();

        // Serializar y guardar torneos en archivo JSON
        JSONArray jsonArray = GestionJSON.serializarMap(GestionTorneo.getMapaTorneo());
        JSONUtilities.GrabarJSON(jsonArray, "torneos.json");
        System.out.println("\nTorneos guardados en torneos.json.");

        // deserializar desde archivo
        try{
            JSONArray jsonArray1 = new JSONArray(JSONUtilities.leerArchivo("torneos.json"));
            TreeMap<Integer,Torneo> mapaDesererializado = GestionJSON.deserializarTreemap(jsonArray1);
            GestionTorneo.setMapaTorneo(mapaDesererializado);
        }catch (JSONException e){
            e.printStackTrace();
        }finally {
            GestionTorneo.mostrarTorneos();
        }



    }
}
