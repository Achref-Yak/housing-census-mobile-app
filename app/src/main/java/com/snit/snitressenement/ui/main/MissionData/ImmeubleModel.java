package com.snit.snitressenement.ui.main.MissionData;

public class ImmeubleModel {



    private String CodeImmeuble;
    private String TF;
    private String AdresseAdmin;
    private String GPS;
    private String Etat;
    private String NumeroOrdre;
    private String NConstruction;
    private String Plan;
    private String numImmeuble;
    private String numLocal;
    private String numEtage;

    private String PartieCommune;
    private String PartieMure;
    private String PartieBalcon;
    private String Terrase;
    private String Platon;
    private String Evactuation;
    private String Electrique;
    private String Gaz;
    private String Eau;

    private String numEtageBon;
    private String numEtageMoyen;
    private String numEtageRep;
    private String numEtageMR;

    public ImmeubleModel(String codeImmeuble, String TF, String adresseAdmin, String GPS, String etat, String numeroOrdre, String NConstruction, String plan, String numImmeuble, String numLocal, String numEtage, String partieCommune, String partieMure, String partieBalcon, String terrase, String platon, String evactuation, String electrique, String gaz, String eau, String numEtageBon, String numEtageMoyen, String numEtageRep, String numEtageMR) {
        CodeImmeuble = codeImmeuble;
        this.TF = TF;
        AdresseAdmin = adresseAdmin;
        this.GPS = GPS;
        Etat = etat;
        NumeroOrdre = numeroOrdre;
        this.NConstruction = NConstruction;
        Plan = plan;
        this.numImmeuble = numImmeuble;
        this.numLocal = numLocal;
        this.numEtage = numEtage;
        PartieCommune = partieCommune;
        PartieMure = partieMure;
        PartieBalcon = partieBalcon;
        Terrase = terrase;
        Platon = platon;
        Evactuation = evactuation;
        Electrique = electrique;
        Gaz = gaz;
        Eau = eau;
        this.numEtageBon = numEtageBon;
        this.numEtageMoyen = numEtageMoyen;
        this.numEtageRep = numEtageRep;
        this.numEtageMR = numEtageMR;
    }

    public String getCodeImmeuble() {
        return CodeImmeuble;
    }

    public void setCodeImmeuble(String codeImmeuble) {
        CodeImmeuble = codeImmeuble;
    }

    public String getTF() {
        return TF;
    }

    public void setTF(String TF) {
        this.TF = TF;
    }

    public String getAdresseAdmin() {
        return AdresseAdmin;
    }

    public void setAdresseAdmin(String adresseAdmin) {
        AdresseAdmin = adresseAdmin;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getNumeroOrdre() {
        return NumeroOrdre;
    }

    public void setNumeroOrdre(String numeroOrdre) {
        NumeroOrdre = numeroOrdre;
    }

    public String getNConstruction() {
        return NConstruction;
    }

    public void setNConstruction(String NConstruction) {
        this.NConstruction = NConstruction;
    }

    public String getPlan() {
        return Plan;
    }

    public void setPlan(String plan) {
        Plan = plan;
    }

    public String getNumImmeuble() {
        return numImmeuble;
    }

    public void setNumImmeuble(String numImmeuble) {
        this.numImmeuble = numImmeuble;
    }

    public String getNumLocal() {
        return numLocal;
    }

    public void setNumLocal(String numLocal) {
        this.numLocal = numLocal;
    }

    public String getNumEtage() {
        return numEtage;
    }

    public void setNumEtage(String numEtage) {
        this.numEtage = numEtage;
    }

    public String getPartieCommune() {
        return PartieCommune;
    }

    public void setPartieCommune(String partieCommune) {
        PartieCommune = partieCommune;
    }

    public String getPartieMure() {
        return PartieMure;
    }

    public void setPartieMure(String partieMure) {
        PartieMure = partieMure;
    }

    public String getPartieBalcon() {
        return PartieBalcon;
    }

    public void setPartieBalcon(String partieBalcon) {
        PartieBalcon = partieBalcon;
    }

    public String getTerrase() {
        return Terrase;
    }

    public void setTerrase(String terrase) {
        Terrase = terrase;
    }

    public String getPlaton() {
        return Platon;
    }

    public void setPlaton(String platon) {
        Platon = platon;
    }

    public String getEvactuation() {
        return Evactuation;
    }

    public void setEvactuation(String evactuation) {
        Evactuation = evactuation;
    }

    public String getElectrique() {
        return Electrique;
    }

    public void setElectrique(String electrique) {
        Electrique = electrique;
    }

    public String getGaz() {
        return Gaz;
    }

    public void setGaz(String gaz) {
        Gaz = gaz;
    }

    public String getEau() {
        return Eau;
    }

    public void setEau(String eau) {
        Eau = eau;
    }

    public String getNumEtageBon() {
        return numEtageBon;
    }

    public void setNumEtageBon(String numEtageBon) {
        this.numEtageBon = numEtageBon;
    }

    public String getNumEtageMoyen() {
        return numEtageMoyen;
    }

    public void setNumEtageMoyen(String numEtageMoyen) {
        this.numEtageMoyen = numEtageMoyen;
    }

    public String getNumEtageRep() {
        return numEtageRep;
    }

    public void setNumEtageRep(String numEtageRep) {
        this.numEtageRep = numEtageRep;
    }

    public String getNumEtageMR() {
        return numEtageMR;
    }

    public void setNumEtageMR(String numEtageMR) {
        this.numEtageMR = numEtageMR;
    }
}
