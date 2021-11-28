package com.apps24.myapplication2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.listener.JsonPlaceHolder;
import com.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiActivity extends AppCompatActivity {

    private TextView textViewResult;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_activity);

        textViewResult = findViewById(R.id.txt_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

//        Call<List<POST>> call = JsonPlaceHolder.getPosts();
        Call<List<Post>> call = jsonPlaceHolder.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("code "+response.code());
                    Log.d("TAG", "onResponse: result..1"+response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post:posts){
                    String content ="";
                    content +="ID: "+post.getiD()+"\n";
                    content +="User ID: "+post.getUserID()+"\n";
                    content +="Title: "+post.getTitle()+"\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("TAG", "onResponse: result..1"+t.getMessage());

                textViewResult.setText(t.getMessage());
            }
        });
    }
}
