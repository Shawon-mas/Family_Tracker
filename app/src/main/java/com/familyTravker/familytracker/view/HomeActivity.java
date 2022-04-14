package com.familyTravker.familytracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.familyTravker.familytracker.LoginActivity;
import com.familyTravker.familytracker.R;
import com.familyTravker.familytracker.model.SessionManagement;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iniViews();
    }

    private void iniViews() {
        floatingActionButton=findViewById(R.id.fab_logout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
                finish();
            }
        });
    }

    private void logOut() {
        Toast.makeText(getApplicationContext(),"Will be back soon",Toast.LENGTH_LONG).show();
        SessionManagement sessionManagement=new SessionManagement(HomeActivity.this);
        sessionManagement.removeSession();

        Intent intent=new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}