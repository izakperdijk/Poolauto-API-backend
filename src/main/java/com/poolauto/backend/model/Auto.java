package com.poolauto.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto {
    private String kenteken;
    private String merk;
    private String handelsbenaming; // model?
    private String type;
    private String eerste_kleur;
    private String uitvoering;
    private String inrichting;
    private String zuinigheidslabel;
    private String brandstof_omschrijving;

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getHandelsbenaming() {
        return handelsbenaming;
    }

    public void setHandelsbenaming(String handelsbenaming) {
        this.handelsbenaming = handelsbenaming;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getEerste_kleur() {
        return eerste_kleur;
    }

    public void setEerste_kleur(String eerste_kleur) {
        this.eerste_kleur = eerste_kleur;
    }

    public String getZuinigheidslabel() {
        return zuinigheidslabel;
    }

    public void setZuinigheidslabel(String zuinigheidslabel) {
        this.zuinigheidslabel = zuinigheidslabel;
    }

    public String getUitvoering() {
        return uitvoering;
    }

    public void setUitvoering(String uitvoering) {
        this.uitvoering = uitvoering;
    }

    public String getInrichting() {
        return inrichting;
    }

    public void setInrichting(String inrichting) {
        this.inrichting = inrichting;
    }

    public String getBrandstof_omschrijving() {
        return brandstof_omschrijving;
    }

    public void setBrandstof_omschrijving(String brandstof_omschrijving) {
        this.brandstof_omschrijving = brandstof_omschrijving;
    }

    @Override
    public String toString() {
        return '{' +
                "\"kenteken\"" + ":\"" + kenteken + "\"," +
                "\"merk\"" + ":\"" + merk + "\"," +
                "\"model\"" + ":\"" + handelsbenaming + "\"," +
                "\"type\"" + ":\"" + type + "\"," +
                "\"kleur\"" + ":\"" + eerste_kleur + "\"," +
                "\"uitvoering\"" + ":\"" + uitvoering + "\"," +
                "\"inrichting\"" + ":\"" + inrichting + "\"," +
                "\"zuinigheidslabel\"" + ":\"" + zuinigheidslabel + "\"," +
                "\"brandstofomschrijving\"" + ":\"" + brandstof_omschrijving +
                "\"}";
    }
    
}