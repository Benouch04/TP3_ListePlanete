package com.example.tp3_listeplanete;

import java.util.ArrayList;

public class Data {
    private ArrayList<String> planetes;

    public Data() {
        installePlanetes();
    }

    public ArrayList<String> getPlanetesName() {
        return planetes;
    }

    public void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }
    private String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

    public String[] getTaillePlanetes() {
        return taillePlanetes;
    }
}


