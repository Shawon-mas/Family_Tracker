package com.familyTravker.familytracker.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.familyTravker.familytracker.OtpApi.OtpRequest;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";
    String SESSION_INFO = "IsLoggedIn";
    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveSession(OtpRequest loginRequest){
        String number=loginRequest.getChild_user_number();
        editor.putString(SESSION_KEY,number).commit();

    }
    public String getSession(){
        return sharedPreferences.getString(SESSION_KEY,SESSION_INFO);
    }
    public void removeSession(){
        editor.putString(SESSION_KEY,SESSION_INFO).commit();
    }
}
