package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.TreeMap;

public class GestionJSON {

    public static JSONObject serializarTorneo(Torneo torneo) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("IdTorneo", torneo.getIdTorneo());
        jsonObject.put("nombreTorneo", torneo.getNombreTorneo());
        jsonObject.put("añoRealizado", torneo.getAñoRealizado());
        jsonObject.put("mesInicio", torneo.getMesInicio());
        jsonObject.put("mesFin", torneo.getMesFin());
        return jsonObject;
    }

    public static JSONArray serializarMap(TreeMap<Integer, Torneo> torneos) {
        JSONArray jsonArray = new JSONArray();

        try {
            for (Torneo torneo : torneos.values()) {
                JSONObject jsonObject = serializarTorneo(torneo);
                jsonArray.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static Torneo deserializarTorneo(JSONObject jsonObject) {
        Torneo torneo = new Torneo();

        torneo.setIdTorneo(jsonObject.getInt("IdTorneo"));
        torneo.setNombreTorneo(jsonObject.getString("nombreTorneo"));
        torneo.setAñoRealizado(jsonObject.getInt("añoRealizado"));
        torneo.setMesInicio(jsonObject.getInt("mesInicio"));
        torneo.setMesFin(jsonObject.getInt("mesFin"));

        return torneo;
    }


    public static TreeMap<Integer, Torneo> deserializarTreemap(JSONArray jsonArray) {
        JSONTokener jsonTokener = JSONUtilities.leerArchivo("torneos.json");
        jsonArray = new JSONArray(jsonTokener);
        TreeMap<Integer, Torneo> treemap = new TreeMap<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Torneo torneo = deserializarTorneo(jsonObject);
                treemap.put(torneo.getIdTorneo(), torneo);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return treemap;
    }
}


