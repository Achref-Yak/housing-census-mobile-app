package com.snit.snitressenement.ui.main.MissionData;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Adapter;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.Adapters.MissionListAdapter;
import com.snit.snitressenement.ui.main.Fragments.Immeublier;
import com.snit.snitressenement.ui.main.Fragments.Missions;
import com.snit.snitressenement.ui.main.Services.ImmeublierService;
import com.snit.snitressenement.ui.main.Services.MissionService;
import com.snit.snitressenement.ui.main.Services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MissionDataManager {
    private  MissionDataManager ourInstance = null;
    private String mEtat;
    private String mTF;
    private String mCodeImmeuble;
    private String mAdresse;
    private String mCodeMission;

    public MissionListAdapter adapter;


    private List<Mission> missions = new ArrayList<>();

    public MissionDataManager(MissionListAdapter adapter) {
        this.adapter = adapter;
    }

    public  MissionDataManager getInstance() {
        if (ourInstance == null) {

            ourInstance = new MissionDataManager(adapter);
            ourInstance.initializeMissions();

        }
        return ourInstance;
    }

    private void initializeMissions() {
        //Identifiant GET
        List<Immeublier> mImmeublier = new ArrayList<>();



        MissionService missionService = ServiceBuilder.buildService(MissionService.class);
        Call<List<Mission>> MissionCall = missionService.getMissions();

        MissionCall.enqueue(new Callback<List<Mission>>() {
            @Override
            public void onResponse(Call<List<Mission>> request, Response<List<Mission>> response) {
                System.out.println("success");
                for (Mission missionBody : response.body()) {
                    //List<ImmeubleModel> immeubles = ImmeublierDataManager.getInstance().getImmeubles();
                    // missionBody.setmImmeublier(immeubles);
                    System.out.println(missionBody.getCodeMission());
                    missions.add(missionBody);
                }
                adapter.UpdateAdapter(missions);
            }

            @Override
            public void onFailure(Call<List<Mission>> call, Throwable t) {
                System.out.println("error : " + t);
            }
        });

        //mCourses.add(initializeCourse1());

    }



    public List<Mission> getMissions() {
        return missions;
    }




}
