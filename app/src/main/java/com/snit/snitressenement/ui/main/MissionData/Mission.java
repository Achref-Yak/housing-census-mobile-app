package com.snit.snitressenement.ui.main.MissionData;
import com.google.gson.annotations.SerializedName;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.snit.snitressenement.MissionActivity;
import com.snit.snitressenement.ui.main.Adapters.MissionListAdapter;
import com.snit.snitressenement.ui.main.Fragments.Immeublier;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    @SerializedName("CodeMission")
    private  String CodeMission;
    @SerializedName("TF")
    private String TF;
    @SerializedName("CodeImmeuble")
    private  String CodeImmeuble;
    @SerializedName("Etat")
    private Integer Etat;
    @SerializedName("Adresse")
    private String adresse;

    private  List<ImmeubleModel> mImmeublier;

    public Mission(String codeMission, String TF, String codeImmeuble, Integer etat, String adresse, List<ImmeubleModel> mImmeublier) {
        this.CodeMission = codeMission;
        this.TF = TF;
        this.CodeImmeuble = codeImmeuble;
        this.Etat = etat;
        this.adresse = adresse;
        this.mImmeublier = mImmeublier;
    }


    public String getCodeMission() {
        return CodeMission;
    }

    public void setCodeMission(String codeMission) {
        CodeMission = codeMission;
    }

    public String getTF() {
        return TF;
    }

    public void setTF(String TF) {
        this.TF = TF;
    }

    public String getCodeImmeuble() {
        return CodeImmeuble;
    }

    public void setCodeImmeuble(String codeImmeuble) {
        CodeImmeuble = codeImmeuble;
    }

    public Integer getEtat() {
        return Etat;
    }

    public void setEtat(Integer etat) {
        Etat = etat;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<ImmeubleModel> getmImmeublier() {
        return mImmeublier;
    }

    public void setmImmeublier(List<ImmeubleModel> mImmeublier) {
        this.mImmeublier = mImmeublier;
    }

    public void bla(){

    }

    public interface GestionMission {
        public void Evaluer( AdapterView<?> parent, int position);
    }
}
