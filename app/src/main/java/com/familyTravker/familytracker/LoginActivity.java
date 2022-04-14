package com.familyTravker.familytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.familyTravker.familytracker.loginApi.LoginRequest;
import com.familyTravker.familytracker.loginApi.LoginResponse;
import com.familyTravker.familytracker.loginApi.LoginUserApiInstance;
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
            }
        });
    }

    private void userLogin(String number) {
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setChild_user_number(number);

//+8801521451354
        Call<LoginResponse> loginResponseCall = LoginUserApiInstance.getLoginInterfaceApi().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful())
                {
                    LoginResponse loginResponse=response.body();
                    if (loginResponse.getData()!=null)
                    {
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

                    }

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

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