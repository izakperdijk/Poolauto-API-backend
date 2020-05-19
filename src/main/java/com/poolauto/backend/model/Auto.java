package com.poolauto.backend.model;

import static com.poolauto.backend.utility.Util.capitalizeWord;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto {

    private String kenteken;
    private String merk = "";
    private String handelsbenaming = "";
    private String eerste_kleur = "";
    private String uitvoering = "";
    private String inrichting = "";
    private String zuinigheidslabel = "";
    private String brandstof_omschrijving = "";
    private String brandstofverbruik_gecombineerd = "";
    private String catalogusprijs = "";
    private String nettomaximumvermogen = "";
    private String datum_tenaamstelling = "";

    @Override
    public String toString() {
        return '{' +
                "\"kenteken\"" + ":\"" + kenteken + "\"," +
                "\"merk\"" + ":\"" + capitalizeWord(merk) + "\"," +
                "\"model\"" + ":\"" + capitalizeWord(handelsbenaming) + "\"," +
                "\"kleur\"" + ":\"" + capitalizeWord(eerste_kleur) + "\"," +
                "\"uitvoering\"" + ":\"" + uitvoering + "\"," +
                "\"inrichting\"" + ":\"" + capitalizeWord(inrichting) + "\"," +
                "\"zuinigheidslabel\"" + ":\"" + zuinigheidslabel + "\"," +
                "\"brandstofomschrijving\"" + ":\"" + capitalizeWord(brandstof_omschrijving) + "\"," +
                "\"verbruik\"" + ":\"" + brandstofverbruik_gecombineerd + "\"," +
                "\"cataloguswaarde\"" + ":\"" + catalogusprijs + "\"," +
                "\"nettomaximumvermogen\"" + ":\"" + nettomaximumvermogen +
                "\"}";
    }

}
