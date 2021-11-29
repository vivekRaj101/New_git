package com.listener;

import com.model.Setting;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface SettingApiInterface {

    @POST("settings")
    Call<List<Setting>> getSetting();
}
