package com.familyTravker.familytracker.view;

import static com.familyTravker.familytracker.global.SharedPref.TOKEN_NAME;
import static com.familyTravker.familytracker.global.SharedPref.USERNUMBER_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.familyTravker.familytracker.LoginActivity;
import com.familyTravker.familytracker.LoginApi.LoginRequest;
import com.familyTravker.familytracker.LoginApi.LoginResponse;
import com.familyTravker.familytracker.LoginApi.LoginUserApiInstance;
import com.familyTravker.familytracker.OtpApi.OtpApiInstance;
import com.familyTravker.familytracker.OtpApi.OtpResponse;
import com.familyTravker.familytracker.R;
import com.familyTravker.familytracker.model.SessionManagement;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {
    OtpTextView pinView_otp;
    TextView textView_OtpsentNumber;
    Button button_verify;
    Integer getOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        intViws();
    }

    private void intViws() {
        pinView_otp=findViewById(R.id.otp_pin);
        textView_OtpsentNumber=findViewById(R.id.user_number);
        button_verify=findViewById(R.id.verify_button);
        String number=getIntent().getStringExtra("user_number");
        textView_OtpsentNumber.setText(number);

        pinView_otp.setOtpListener(new OTPListener() {
         @Override
         public void onInteractionListener() {

         }

         @Override
         public void onOTPComplete(String otp) {
               getOtp=Integer.valueOf(otp);
            /* Integer otpCode=getIntent().getIntExtra("otp_code",0);
             if (otp.equals(otpCode)){
                 Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                 startActivity(intent);

             }*/
            // Toast.makeText(getApplicationContext(), "The OTP is " + otp,  Toast.LENGTH_SHORT).show();

         }
     });
        button_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer otpCode=getIntent().getIntExtra("otp_code",0);
                if (getOtp.equals(otpCode))
                {
                    userLogin();


                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Otp",  Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void userLogin() {
        String number=getIntent().getStringExtra("user_number");
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setChild_user_number(number);
        Call<LoginResponse> loginResponseCall = LoginUserApiInstance.getLoLoginApi().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
            {
                if (response.isSuccessful())

                {
                    LoginResponse loginResponse=response.body();
                    if (loginResponse.getData()!=null)
                    {
                        Integer userId=loginResponse.getData().getChildUserId();
                        String token=loginResponse.getAccessToken();
                        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                        preferences.edit().putString(TOKEN_NAME,"Bearer "+token).apply();
                        // preferences.edit().putInt(USERNUMBER_ID, userId);
                        Log.d("id", String.valueOf(userId));
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);


                    }
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });


    }
}
/*
SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                        preferences.edit().putString(TOKEN_NAME,"Bearer "+token).apply();
                        preferences.edit().putString(USERNUMBER_NUMBER,number).apply();
                        preferences.edit().putInt(USERNUMBER_ID,id).apply();
 */