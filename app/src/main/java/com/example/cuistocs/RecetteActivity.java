package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.TextView;


public class RecetteActivity extends AppCompatActivity {

    int numeroJour;
    int numeroSemaine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);
        Intent messagedeChoixJoursActivity = getIntent();

        numeroJour = messagedeChoixJoursActivity.getIntExtra("numero jour", -1); //on recupere l entier nombre de point de l'activité principale

        Intent messagedeSemaineActivity=getIntent() ;
        numeroSemaine=messagedeSemaineActivity.getIntExtra("indiceSemaine",-1) ;

        String[][] matriceRecette;
        TextView textViewRecette=findViewById(R.id.textView2);

        //textViewRecette.setText(matriceRecette[numeroSemaine][numeroJour]);




    }
    }



