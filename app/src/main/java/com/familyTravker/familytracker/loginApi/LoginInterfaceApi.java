package com.familyTravker.familytracker.loginApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterfaceApi {
    @POST("User/SendOTP")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}
