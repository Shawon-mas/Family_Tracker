package com.familyTravker.familytracker.loginApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginUserApiInstance {
    private static String BASE_URL = "https://familytracker.noman-it.com/api/";
    private static Retrofit retrofit;


    private static Retrofit getRetrofitInstance() {


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static LoginInterfaceApi getLoginInterfaceApi() {
        LoginInterfaceApi loginInterfaceApi = getRetrofitInstance().create(LoginInterfaceApi.class);
        return loginInterfaceApi;
    }
}
