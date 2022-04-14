package com.familyTravker.familytracker.view;

import static com.familyTravker.familytracker.global.SharedPref.TOKEN_NAME;
import static com.familyTravker.familytracker.global.SharedPref.USERNUMBER_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.familyTravker.familytracker.LoginActivity;
import com.familyTravker.familytracker.R;
import com.familyTravker.familytracker.model.SessionManagement;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    FusedLocationProviderClient fusedLocationProvider;
    String lat;
    String lon;
    Button button_emercy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       /* SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String token = preferences.getString(TOKEN_NAME, null);
        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();*/
        fusedLocationProvider = LocationServices.getFusedLocationProviderClient(this);

        iniViews();
    }

    private void iniViews() {
        button_emercy=findViewById(R.id.emergency);
        button_emercy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),lat,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),lon,Toast.LENGTH_SHORT).show();
               /* Log.d("Latitude:",lat);
                Log.d("Longitude:",lon);*/
            }
        });

        floatingActionButton = findViewById(R.id.fab_logout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
                finish();
            }
        });
    }

    private void logOut() {
        Toast.makeText(getApplicationContext(), "Will be back soon", Toast.LENGTH_LONG).show();
        SessionManagement sessionManagement = new SessionManagement(HomeActivity.this);
        sessionManagement.removeSession();

        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {

        if (ActivityCompat.checkSelfPermission(HomeActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getChildLocation();
        } else {
            ActivityCompat.requestPermissions(HomeActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        super.onStart();
    }

    @SuppressLint("MissingPermission")
    private void getChildLocation() {
        //FusedLocationProviderClient fusedLocationProvider;
        LocationManager locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        fusedLocationProvider.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location=task.getResult();
                if (location!=null){
                    try
                    {
                        lat= String.valueOf(location.getLatitude());
                         lon= String.valueOf(location.getLongitude());

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
/*
fusedLocationProvider.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
              Location location=task.getResult();
              if (location!=null){
                  try {
                      Geocoder geocoder=new Geocoder(AffireCase.this,
                              Locale.getDefault());
                      List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                      textInputLayout9.getEditText().setText(Html.fromHtml(
                              "<font color='#6200EE'><br></font>"
                              +addresses.get(0).getAddressLine(0)
                      ));
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
            }
        });
 */