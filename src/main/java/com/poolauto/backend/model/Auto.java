package com.poolauto.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto {
    private String kenteken;
    private String merk;
    private String handelsbenaming;
    private String eerste_kleur;
    private String uitvoering;
    private String inrichting;
    private String zuinigheidslabel;
    private String brandstof_omschrijving;
    private String brandstofverbruik_gecombineerd;
    private String catalogusprijs;
    private String nettomaximumvermogen;
    private int datum_tenaamstelling;

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

    public String getCatalogusprijs() {
        return catalogusprijs;
    }

    public void setCatalogusprijs(String catalogusprijs) {
        this.catalogusprijs = catalogusprijs;
    }

    public String getBrandstofverbruik_gecombineerd() {
        return brandstofverbruik_gecombineerd;
    }

    public void setBrandstofverbruik_gecombineerd(String brandstofverbruik_gecombineerd) {
        this.brandstofverbruik_gecombineerd = brandstofverbruik_gecombineerd;
    }

    public String getNettomaximumvermogen() {
        return nettomaximumvermogen;
    }

    public void setNettomaximumvermogen(String nettomaximumvermogen) {
        this.nettomaximumvermogen = nettomaximumvermogen;
    }

    public int getDatum_tenaamstelling() {
        return datum_tenaamstelling;
    }

    public void setDatum_tenaamstelling(String datum_tenaamstelling) {
        this.datum_tenaamstelling = Integer.parseInt(datum_tenaamstelling);
    }

    @Override
    public String toString() {
        return '{' +
                "\"kenteken\"" + ":\"" + kenteken + "\"," +
                "\"merk\"" + ":\"" + merk + "\"," +
                "\"model\"" + ":\"" + handelsbenaming + "\"," +
                "\"kleur\"" + ":\"" + eerste_kleur + "\"," +
                "\"uitvoering\"" + ":\"" + uitvoering + "\"," +
                "\"inrichting\"" + ":\"" + inrichting + "\"," +
                "\"zuinigheidslabel\"" + ":\"" + zuinigheidslabel + "\"," +
                "\"brandstofomschrijving\"" + ":\"" + brandstof_omschrijving + "\"," +
                "\"verbruik" + ":\"" + brandstofverbruik_gecombineerd + "\"," +
                "\"cataloguswaarde\"" + ":\"" + catalogusprijs + "\"," +
                "\"nettomaximumvermogen\"" + ":\"" + nettomaximumvermogen +
                "\"}";
    }
    
}