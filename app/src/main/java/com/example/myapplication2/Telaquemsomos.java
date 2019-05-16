package com.example.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Telaquemsomos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaquemsomos);
    }

    public void irParaMenu (View view){

        Intent intentmenu = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentmenu);
    }

    public void siteContribuir (View view) {
        Intent intentsite = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.br"));
        startActivity(intentsite);
    }

    public void youtubeVideo (View view) {
        Intent intentvideo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tPrXw0oEgrM"));
        startActivity(intentvideo);
    }



}

