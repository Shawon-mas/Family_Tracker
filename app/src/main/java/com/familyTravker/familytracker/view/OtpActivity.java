package com.familyTravker.familytracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.familyTravker.familytracker.R;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

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
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Otp",  Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}