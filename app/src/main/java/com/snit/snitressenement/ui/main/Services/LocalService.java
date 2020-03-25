package com.snit.snitressenement.ui.main.Services;

import com.snit.snitressenement.ui.main.MissionData.LocalModel;
import com.snit.snitressenement.ui.main.MissionData.Mission;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocalService {
    @GET("local")
    Call<LocalModel> getLocal();
}
