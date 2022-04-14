package com.familyTravker.familytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.familyTravker.familytracker.OtpApi.OtpRequest;
import com.familyTravker.familytracker.OtpApi.OtpResponse;
import com.familyTravker.familytracker.OtpApi.OtpApiInstance;
import com.familyTravker.familytracker.model.SessionManagement;
import com.familyTravker.familytracker.view.HomeActivity;
import com.familyTravker.familytracker.view.OtpActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editText_number;
    Button button_login;
    SessionManagement sessionManagement;
    LottieAnimationView lottieAnimationView;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intviews();
    }

    private void intviews() {
        editText_number=findViewById(R.id.editText_phoneNumber);
        editText_number.setText("+880");
        button_login=findViewById(R.id.login_button);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText_number.getText().toString();
                userLogin(number);
                dialogBox();
            }
        });
    }

    private void dialogBox() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading);
        dialog.getWindow().setLayout(1000, 1000);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // dialog1.getWindow().setWindowAnimations(R.style.AnimationForDialog);
        lottieAnimationView=dialog.findViewById(R.id.animationView);
        dialog.show();
    }

    private void userLogin(String number) {
        OtpRequest loginRequest=new OtpRequest();
        loginRequest.setChild_user_number(number);

//+8801521451354
        Call<OtpResponse> loginResponseCall = OtpApiInstance.getLoginInterfaceApi().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<OtpResponse>() {
            @Override
            public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {

                if (response.isSuccessful())
                {
                    OtpResponse loginResponse=response.body();
                    if (loginResponse.getData()!=null)
                    {
                        dialog.cancel();
                        String message=loginResponse.getMessage();
                        Integer otpCode=loginResponse.getData();
                        Toast.makeText(getApplicationContext(),message ,Toast.LENGTH_LONG).show();
                        sessionManagement=new SessionManagement(LoginActivity.this);
                        sessionManagement.saveSession(loginRequest);
                        Intent intent=new Intent(getApplicationContext(), OtpActivity.class);
                        intent.putExtra("otp_code",otpCode);
                        intent.putExtra("user_number",number);
                        startActivity(intent);

                    }else
                    {
                        dialog.cancel();
                        String Errormessage=loginResponse.getMessage();
                        Toast.makeText(getApplicationContext(),Errormessage ,Toast.LENGTH_LONG).show();

                    }

                }
            }

            @Override
            public void onFailure(Call<OtpResponse> call, Throwable t) {
                dialog.cancel();
                Toast.makeText(getApplicationContext(),"Something went wrong." ,Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        chcksession();
    }

    private void chcksession() {
        sessionManagement=new SessionManagement(LoginActivity.this);
        String userNumber=sessionManagement.getSession();
        if (!userNumber.matches("IsLoggedIn"))
        {
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else
        {

        }
    }
}