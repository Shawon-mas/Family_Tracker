package com.familyTravker.familytracker.OtpApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OtpInterfaceApi {
    @POST("User/SendOTP")
    Call<OtpResponse> userLogin(@Body OtpRequest loginRequest);
}
