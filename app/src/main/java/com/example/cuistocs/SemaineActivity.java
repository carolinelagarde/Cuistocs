package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class SemaineActivity extends AppCompatActivity {

    int numeroSemaine;
    Button semaine1;
    Button semaine2;
    Button semaine3;
    Button semaine4;

    //creation d'un vecteur pour mettre à jour les boutons à débloquer au fur et à mesure
    public SharedPreferences etatBouton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaine);

        //on cree en memoire de quoi garder si les boutons sont bloques ou non
        etatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = etatBouton.edit();

        Set<String> boutonDebloqueSet= new HashSet<>();
        boutonDebloqueSet.add("jour1semaine0");
        editor.putStringSet("boutonDebloque",boutonDebloqueSet);

        Button semaine1 = findViewById(R.id.boutonSemaine1);
        Button semaine2 = findViewById(R.id.boutonSemaine2);
        Button semaine3 = findViewById(R.id.boutonSemaine3);
        Button semaine4 = findViewById(R.id.boutonSemaine4);

    }

    public void ouvrirSemaine(View view) {

        if (view.equals(semaine1)) {
            numeroSemaine = 0;
            Log.i("boutonSemaineClique", "semaine 1 selectionnee");
        }
        if (view.equals(semaine2)) {
            numeroSemaine = 1;
            Log.i("boutonSemaineClique", "semaine 2 selectionnee");
        }
        if (view.equals(semaine3)) {
            numeroSemaine = 2;
            Log.i("boutonSemaineClique", "semaine 3 selectionnee");
        }
        if (view.equals(semaine4)) {
            numeroSemaine = 3;
            Log.i("boutonSemaineClique", "semaine 4 selectionnee");
        }


        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");

        //passe à l'activité suivante que si les boutons sont débloqués
        if (numeroSemaine==0 | etatBouton.getStringSet("boutonDebloque",defaultvalueset).contains("jour7semaine"+(numeroSemaine-1))){

            Intent versJour = new Intent();
            versJour.setClass(this, ChoixJoursActivity.class);
            versJour.putExtra("indiceSemaine", numeroSemaine);
            startActivity(versJour);

        }

    }
}