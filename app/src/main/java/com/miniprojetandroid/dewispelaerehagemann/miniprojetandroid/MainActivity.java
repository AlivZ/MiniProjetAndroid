package com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid.R;

public class MainActivity extends AppCompatActivity {
    public static String NOM ="ProjetMobileSemestre.NOM";
    public static String PRENOM ="ProjetMobileSemestre.PRENOM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void validerButton(View v){
        String nom= ((EditText)findViewById(R.id.editText_Nom)).getText().toString();
        String prenom= ((EditText)findViewById(R.id.editText_Prenom)).getText().toString();
        if(nom.equals("") || prenom.equals("")){
            Toast t=Toast.makeText(this, "Champs Vide", Toast.LENGTH_LONG);
            t.show();
        }
        else{
            Intent intent = new Intent(this, AfficherNomPrenom.class);
            intent.putExtra(NOM,nom);
            intent.putExtra(PRENOM,prenom);
            startActivity(intent);
        }
    }

    public void AfficherListeButton(View v){
        String nom= ((EditText)findViewById(R.id.editText_Nom)).getText().toString();
        String prenom= ((EditText)findViewById(R.id.editText_Prenom)).getText().toString();
        if(nom.equals("") || prenom.equals("")){
            Toast t=Toast.makeText(this, "Champs Vide", Toast.LENGTH_LONG);
            t.show();
        }
        else {
            Intent intent = new Intent(this, AfficherListe.class);
            intent.putExtra(NOM, nom);
            intent.putExtra(PRENOM, prenom);
            startActivity(intent);
        }

    }
}
