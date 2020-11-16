package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class RecetteActivity extends AppCompatActivity {

    public int points;

    Button boutonFait;
    Button boutonJoker;

    int numeroJour;
    int numeroSemaine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        //il faut insérer un sharedpreference et unif pour recuperer la valeur du score si stockée, ou bien initier points à 0


        // recuperation des entiers numeroSemaine et numeroJour qui servent à indexer les recettes dans la matrice des recettes
        Intent messagedeChoixJoursActivity = getIntent();
        numeroJour = messagedeChoixJoursActivity.getIntExtra("numero jour", -1); //on recupere l entier nombre de point de l'activité principale
        Intent messagedeSemaineActivity=getIntent() ;
        numeroSemaine=messagedeSemaineActivity.getIntExtra("indiceSemaine",-1) ;

        String[][] matriceRecette;
        TextView textViewRecette=findViewById(R.id.titreRecette);

        //textViewRecette.setText(matriceRecette[numeroSemaine][numeroJour]);
    }

    void finRecette(View view) {
        if (view.equals(boutonFait)) {
            points += 1;
        }
        if (numeroJour < 7) {
            Intent versEcranJour = new Intent();
            versEcranJour.setClass(this, ChoixJoursActivity.class);
            startActivity(versEcranJour);
            finish();
        }
        if (numeroJour ==7) {
            Intent versEcranSemaine = new Intent();
            versEcranSemaine.setClass(this, SemaineActivity.class);
            startActivity(versEcranSemaine);
            finish();
        }
    }


}