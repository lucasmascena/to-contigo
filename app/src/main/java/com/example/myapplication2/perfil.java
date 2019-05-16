package com.example.myapplication2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.net.URI;

public class perfil extends AppCompatActivity {

    private ImageView imagem;
    private final int GALERIA_IMAGENS = 1;
    private final int PERMISSAO_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

    init();

    imagem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //foto
            startActivityForResult(Intent.createChooser(new Intent
                    (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).setType("image/*"),"Selecione sua imagem de perfil"),
                    GALERIA_IMAGENS);
        }
    });

    }

    public void irParaMenu (View view){

        Intent intentmenu = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentmenu);
    }

    private void init() {
        this.imagem = findViewById(R.id.imageFoto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == GALERIA_IMAGENS && resultCode == RESULT_OK) {

            Uri imageUri = data.getData();
            if (imageUri!=null){
                imagem.setImageURI(imageUri);
            }

        }



    }





}
