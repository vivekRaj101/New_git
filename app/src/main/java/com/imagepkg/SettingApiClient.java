package com.imagepkg;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SettingApiClient {

    public static final String TAG="MainCategoryClient";

    public static Retrofit retrofit=null;
    public static final String BASE_URL="https://livedio.in/manish/Fitness/api/";

    public static Retrofit getSetting(){

        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient(){
        OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
        addHeader(okHttpClient);
        return okHttpClient.build();
    }

    public static void addHeader(OkHttpClient.Builder okHttpClient){
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("app_id", "livideoreversevideo")
                        .addHeader("country", "IN")
                        .addHeader("dversion", "Samsung")
                        .addHeader("identity", "NA")
                        .addHeader("launchcount", "1")
                        .addHeader("osversion", "23")
                        .addHeader("screen", "XHDPI")
                        .addHeader("version", "2")
                        .addHeader("os", "1")
                        .build();
                return chain.proceed(request);
            }
        });
    }

   /* .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();*/
}
