package com.snit.snitressenement.ui.main.Services;

import com.snit.snitressenement.ui.main.MissionData.Mission;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MissionService {
    @GET("missions")
    Call<List<Mission>> getMissions();
}
