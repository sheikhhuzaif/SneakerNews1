package com.example.sneakernews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class splash_activity extends AppCompatActivity {

    private static final String TAG = "splash_activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){
            Log.d(TAG, "onCreate: Hidding failed");
            
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent= new Intent(splash_activity.this, MainActivity.class);
                splash_activity.this.startActivity(mainIntent);
                splash_activity.this.finish();
            }
        }, 1500);
    }
}
