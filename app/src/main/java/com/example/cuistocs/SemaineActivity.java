package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.Vector;

public class SemaineActivity extends AppCompatActivity {

    int numeroSemaine;
    Button semaine1;
    Button semaine2;
    Button semaine3;
    Button semaine4;

    //creation d'une matrice pour mettre à jour les boutons à débloquer au fur et à mesure
    public String[][] debloque;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaine);

        Button semaine1 = findViewById(R.id.boutonSemaine1);
        Button semaine2 = findViewById(R.id.boutonSemaine2);
        Button semaine3 = findViewById(R.id.boutonSemaine3);
        Button semaine4 = findViewById(R.id.boutonSemaine4);

        //initialement seul le bouton jour1 est débloqué
        debloque = new String[4][7];

        for (int semaine = 0; semaine < 4; semaine++) {
            for (int jourdelasemaine = 0; jourdelasemaine < 7; jourdelasemaine++) {
                debloque[semaine][jourdelasemaine] = "non";
            }
        }

        debloque[0][0] = "oui";

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


        //le bouton de la semaine est débloqué que si c'est la semaine 1 ou que le jour 7 de la semaine précédente est débloqué
        if (numeroSemaine == 0 | debloque[numeroSemaine-2][6].equals("oui")) {
            Intent versActiviteSemaine = new Intent();
            versActiviteSemaine.setClass(this, RecetteActivity.class);


            versActiviteSemaine.putExtra("indiceSemaine", numeroSemaine);
            startActivity(versActiviteSemaine);

        }

    }
}