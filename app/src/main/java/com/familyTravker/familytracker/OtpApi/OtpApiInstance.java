package com.familyTravker.familytracker.OtpApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OtpApiInstance {
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

    public static OtpInterfaceApi getLoginInterfaceApi() {
        OtpInterfaceApi loginInterfaceApi = getRetrofitInstance().create(OtpInterfaceApi.class);
        return loginInterfaceApi;
    }
}
