package com.snit.snitressenement.ui.main.MissionData;

import java.util.ArrayList;

public class PropListData {
    private String TF;
    private  String CodeImmeuble;
    private String Etat;

    public  ArrayList<Proprietaire> propList;


    public ArrayList<Proprietaire> getPropData(){
        Proprietaire m1 = new Proprietaire("12345","G1D15","1/2");
        Proprietaire m2 = new Proprietaire("12345","G1D15", "1/2");


        propList = new ArrayList<>();
        propList.add(m1);
        propList.add(m2);

        return propList;
    }


    public void AddtoList(String iden,String codeIm,String Etat){
        Proprietaire m = new Proprietaire(iden,codeIm,Etat);
        propList.add(m);

    }
}
