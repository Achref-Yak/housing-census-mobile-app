package com.snit.snitressenement.ui.main.MissionData;
import com.snit.snitressenement.ui.main.Fragments.Immeublier;
import com.snit.snitressenement.ui.main.Services.ImmeublierService;
import com.snit.snitressenement.ui.main.Services.MissionService;
import com.snit.snitressenement.ui.main.Services.ServiceBuilder;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImmeublierDataManager {
    private ImmeublierDataManager ourInstance = null;
    private ImmeubleModel mImmeublier;
    public String TF;

    public ImmeublierDataManager(String TF) {
        this.TF = TF;
    }

    public  ImmeublierDataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new ImmeublierDataManager(TF);
            ourInstance.initializeImmeubles();

        }
        return ourInstance;
    }


    private void initializeImmeubles() {
        //Identifiant GET


        ImmeublierService ImmeublierService = ServiceBuilder.buildService(ImmeublierService.class);
        Call<ImmeubleModel> ImmeubleCall = ImmeublierService.getImmeuble(1);

        ImmeubleCall.enqueue(new Callback<ImmeubleModel>() {
            @Override
            public void onResponse(Call<ImmeubleModel> request, Response<ImmeubleModel> response) {

                mImmeublier = response.body();


            }
            @Override
            public void onFailure(Call<ImmeubleModel> call, Throwable t) {
                //error
            }
        });




    }

    public ImmeubleModel getImmeuble(){
        return mImmeublier;
    }
}
