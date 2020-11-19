package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class ChoixJoursActivity extends AppCompatActivity {

    Button Jour1;
    Button Jour2;
    Button Jour3;
    Button Jour4;
    Button Jour5;
    Button Jour6;
    Button Jour7;
    int jour;

    int numeroSemaine;

    SharedPreferences spEtatBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_jours);
        Jour1 = findViewById(R.id.jour1);
        Jour2 = findViewById(R.id.jour2);
        Jour3 = findViewById(R.id.jour3);
        Jour4 = findViewById(R.id.jour4);
        Jour5 = findViewById(R.id.jour5);
        Jour6 = findViewById(R.id.jour6);
        Jour7 = findViewById(R.id.jour7);

        //recupere le numero de la semaine
        Intent messagedeSemaineActivity = getIntent();
        numeroSemaine = messagedeSemaineActivity.getIntExtra("indiceSemaine", -1);
    }


    public void allerVersRecetteActivity(View view) {

        if (view.equals(Jour1)) {
            jour = 0;
        } else if (view.equals(Jour2)) {
            jour = 1;
        } else if (view.equals(Jour3)) {
            jour = 2;
        } else if (view.equals(Jour4)) {
            jour = 3;
        } else if (view.equals(Jour5)) {
            jour = 4;
        } else if (view.equals(Jour6)) {
            jour = 5;
        } else if (view.equals(Jour7)) {
            jour = 6;
        }

        //debloque le jour que si le jour précédent a été développé

        spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);

        String tag="jour"+jour+"semaine"+numeroSemaine;
        if (jour == 0 || spEtatBouton.contains(tag)) {
            Intent messageVersRecetteActivity = new Intent();
            messageVersRecetteActivity.setClass(this, RecetteActivity.class);
            messageVersRecetteActivity.putExtra("numero jour", jour);
            startActivity(messageVersRecetteActivity);
        }
    }
}


