package com.familyTravker.familytracker.LoginApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterfaceApi {
    @POST("User/Login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}

