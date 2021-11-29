package com.apps24.myapplication2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.SettingApiAdapter;
import com.imagepkg.SettingApiClient;
import com.listener.SettingApiInterface;
import com.model.Setting;

import java.security.PublicKey;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingApiActivity extends AppCompatActivity {

    public RecyclerView setting_recview;
    public SettingApiClient settingApiClient = new SettingApiClient();
    public SettingApiAdapter settingApiAdapter = new SettingApiAdapter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
       setting_recview = findViewById(R.id.setting_recview);
       setting_recview.setAdapter(settingApiAdapter);
       setting_recview.setLayoutManager(new LinearLayoutManager(this));

       SettingApiInterface settingApiInterface = settingApiClient.getSetting().create(SettingApiInterface.class);

       Call<List<Setting>> listCall = settingApiInterface.getSetting();
       listCall.enqueue(new Callback<List<Setting>>() {
           @Override
           public void onResponse(Call<List<Setting>> call, Response<List<Setting>> response) {

               Log.d("TAG", "onResponse: ResponseCode "+response.body());
               settingApiAdapter.settingList(response.body());
               settingApiAdapter.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<List<Setting>> call, Throwable t) {
               Log.d("TAG", "onResponse: ResponseCode "+t);

               Toast.makeText( SettingApiActivity.this, "Data Failed", Toast.LENGTH_SHORT).show();
           }
       });
        }
}
