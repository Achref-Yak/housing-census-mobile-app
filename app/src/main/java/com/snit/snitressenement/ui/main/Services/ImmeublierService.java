package com.snit.snitressenement.ui.main.Services;

import com.snit.snitressenement.ui.main.MissionData.ImmeubleModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImmeublierService {
    @GET("immeuble/{tf}")
    Call<ImmeubleModel> getImmeuble(@Query("tf") int id);
}
