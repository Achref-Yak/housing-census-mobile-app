package com.snit.snitressenement.ui.main.MissionData;
import com.google.gson.annotations.SerializedName;

public class Proprietaire {
    @SerializedName("Identite")
    private String Identite;
    @SerializedName("Nationalite")
    private String Nationalite;
    @SerializedName("QuotePar")
    private String QuotePar;

    public Proprietaire(String identite, String nationalite, String quotePar) {
        Identite = identite;
        Nationalite = nationalite;
        QuotePar = quotePar;
    }


    public String getIdentite() {
        return Identite;
    }

    public void setIdentite(String identite) {
        Identite = identite;
    }

    public String getNationalite() {
        return Nationalite;
    }

    public void setNationalite(String nationalite) {
        Nationalite = nationalite;
    }

    public String getQuotePar() {
        return QuotePar;
    }

    public void setQuotePar(String quotePar) {
        QuotePar = quotePar;
    }
}