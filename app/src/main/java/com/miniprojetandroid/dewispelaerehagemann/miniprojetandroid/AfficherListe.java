package com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AfficherListe extends AppCompatActivity {
    public static String IMAGEPATH ="ProjetMobileSemestre.NOM";



    public AfficherListe() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_liste);
        final ListView mListView = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        String nom=intent.getStringExtra(MainActivity.NOM);
        String prenom=intent.getStringExtra(MainActivity.PRENOM);
        afficherListe(nom, prenom, mListView);

        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long id) {
                Item item = (Item)parent.getItemAtPosition(position);
                Intent intent = new Intent(AfficherListe.this, AfficherImagePleinEcran.class);
                intent.putExtra(IMAGEPATH, item.getImagePath());

                AfficherListe.this.startActivity(intent);
            }
        });
    }

    private String [] CreateListeImage() throws IOException {
        AssetManager assetManage = this.getAssets();
        String [] listeAsset = assetManage.list("Images");
        return listeAsset;
    }

    private void afficherListe(String nom, String prenom, ListView mListView){
        List<Item> listeItem = new ArrayList<Item>();
        String [] listeAsset= new String[0];
        try {
            listeAsset = CreateListeImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String imageCourante : listeAsset){
            Item item = new Item(nom, prenom ,imageCourante);
            listeItem.add(item);
        }
        ItemAdapter itemA = new ItemAdapter(AfficherListe.this, listeItem);

        mListView.setAdapter(itemA);
    }






    }

