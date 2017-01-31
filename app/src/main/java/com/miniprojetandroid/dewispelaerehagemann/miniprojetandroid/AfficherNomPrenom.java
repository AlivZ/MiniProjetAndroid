package com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid.R;

public class AfficherNomPrenom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_nom_prenom);
        Intent intent = getIntent();
        String nom=intent.getStringExtra(MainActivity.NOM);
        String prenom=intent.getStringExtra(MainActivity.PRENOM);
        ((TextView)findViewById(R.id.textView2)).setText(nom);
        ((TextView)findViewById(R.id.textView3)).setText(prenom);
    }
}
