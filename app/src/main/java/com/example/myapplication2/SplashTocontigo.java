package com.example.myapplication2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;


public class SplashTocontigo extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_tocontigo);

        Handler handler = new Handler();
        handler.postDelayed(this,2000);
    }

    @Override
    public void run() {
        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}
