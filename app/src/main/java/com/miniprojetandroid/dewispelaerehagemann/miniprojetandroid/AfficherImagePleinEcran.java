package com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

import static java.security.AccessController.getContext;

public class AfficherImagePleinEcran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_image_plein_ecran);
        Intent intent = getIntent();
        String imagepath=intent.getStringExtra(AfficherListe.IMAGEPATH);

        InputStream adresseImg=null;
        try {
            adresseImg = getAssets().open(imagepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(adresseImg);
        //viewHolder.image.setImageBitmap(bitmap);
    }
}
