package com.snit.snitressenement.ui.main.MissionData;

import com.google.gson.annotations.SerializedName;

public class LocalModel {
    @SerializedName("CodeLocal")
    public String getCodeLocal() {
        return CodeLocal;
    }
    @SerializedName("CodeLocataire")
    public String getCodeLocataire() {
        return CodeLocataire;
    }
    @SerializedName("Etage")
    public String getEtage() {
        return Etage;
    }
    @SerializedName("Surface")
    public String getSurface() {
        return Surface;
    }
    @SerializedName("Nlocal")
    public String getNlocal() {
        return Nlocal;
    }
    @SerializedName("NomLocataire")
    public String getNomLocataire() {
        return NomLocataire;
    }
    @SerializedName("Batis")
    public String getBatis() {
        return Batis;
    }
    @SerializedName("nonBatis")
    public String getNonBatis() {
        return nonBatis;
    }
    @SerializedName("NatureDeLocal")
    public String getNatureDeLocal() {
        return NatureDeLocal;
    }
    @SerializedName("Usage")
    public String getUsage() {
        return Usage;
    }
    @SerializedName("valeurDeLocation")
    public String getValeurDeLocation() {
        return valeurDeLocation;
    }
    @SerializedName("NomDeFamilleOccupant")
    public String getNomDeFamilleOccupant() {
        return NomDeFamilleOccupant;
    }
    @SerializedName("Cuisine")
    public String getCuisine() {
        return Cuisine;
    }
    @SerializedName("SalleEau")
    public String getSalleEau() {
        return SalleEau;
    }
    @SerializedName("MoyenChaufage")
    public String getMoyenChaufage() {
        return MoyenChaufage;
    }
    @SerializedName("Eclarage")
    public String getEclarage() {
        return Eclarage;
    }
    @SerializedName("Ventilation")
    public String getVentilation() {
        return Ventilation;
    }
    @SerializedName("Humidite")
    public String getHumidite() {
        return Humidite;
    }

    private String CodeLocal;
    private String CodeLocataire;
    private String Etage;
    private String Surface;
    private String Nlocal;
    private String NomLocataire;
    private String Batis;
    private String nonBatis;
    private String NatureDeLocal;
    private String Usage;
    private String valeurDeLocation;
    private String NomDeFamilleOccupant;
    private String Cuisine;
    private String SalleEau;
    private String MoyenChaufage;
    private String Eclarage;
    private String Ventilation;
    private String Humidite;


    public LocalModel(String codeLocal, String codeLocataire, String etage, String surface, String nlocal, String nomLocataire, String batis, String nonBatis, String natureDeLocal, String usage, String valeurDeLocation, String nomDeFamilleOccupant, String cuisine, String salleEau, String moyenChaufage, String eclarage, String ventilation, String humidite) {
        this.CodeLocal = codeLocal;
        this.CodeLocataire = codeLocataire;
        this.Etage = etage;
        this.Surface = surface;
        this.Nlocal = nlocal;
        this.NomLocataire = nomLocataire;
        this.Batis = batis;
        this.nonBatis = nonBatis;
        this.NatureDeLocal = natureDeLocal;
        this.Usage = usage;
        this.valeurDeLocation = valeurDeLocation;
        this.NomDeFamilleOccupant = nomDeFamilleOccupant;
        this.Cuisine = cuisine;
        this.SalleEau = salleEau;
        this.MoyenChaufage = moyenChaufage;
        this.Eclarage = eclarage;
        this.Ventilation = ventilation;
        this.Humidite = humidite;
    }



}
