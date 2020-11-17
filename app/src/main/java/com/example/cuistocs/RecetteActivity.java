package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Vector;


public class RecetteActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public int points;

    Button boutonFini;
    Button boutonPasse;


    int numeroJour;
    int numeroSemaine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        //affecte les deux boutons
        boutonFini = findViewById(R.id.boutonFini);
        boutonPasse = findViewById(R.id.boutonPasse);

        //il faut insérer un sharedpreference et unif pour recuperer la valeur du score si stockée, ou bien initier points à 0


        // recuperation des entiers numeroSemaine et numeroJour qui servent à indexer les recettes dans la matrice des recettes

        //on récupère des deux activités précédentes les numéros du jour et de la semaine dans laquelle on est

        Intent messagedeChoixJoursActivity = getIntent();

        numeroJour = messagedeChoixJoursActivity.getIntExtra("numero jour", -1); //on recupere l entier nombre de point de l'activité principale

        Intent messagedeSemaineActivity=getIntent() ;
        numeroSemaine=messagedeSemaineActivity.getIntExtra("indiceSemaine",-1) ;


        SeekBar barre=findViewById(R.id.seekBar); // barre de choix du nombre d'invités
        barre.setOnSeekBarChangeListener(this);

        //////// accès à la matrice recette

        //Recette recette=matriceRecette[numeroSemaine][numeroJour];
       // int tempsDeCuisine=recette.getTempsdecuisine();
       // Vector<Ingredient> ingrédients=recette.getIngredients();
       // String instructions=recette.getInstructions();






    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView NbInvites =findViewById(R.id.NbInvites); //on affiche le nombre d'invités choisis
        NbInvites.setText(Integer.toString(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    void finRecette(View view) {

        // si bouton Fini clique : +1 point !

        if (view.equals(boutonFini)) {
            points += 1;
        }

        // si on n'est pas au dernier jour de la semaine, ca nous ramene a l'écran des jours
        if (numeroJour < 7) {
            Intent versEcranJour = new Intent();
            versEcranJour.setClass(this, ChoixJoursActivity.class);
            startActivity(versEcranJour);
            finish();
        }
        //si on est au dernier jour, ca nous ramene à l'écran semaine.
        if (numeroJour ==7) {
            Intent versEcranSemaine = new Intent();
            versEcranSemaine.setClass(this, SemaineActivity.class);
            startActivity(versEcranSemaine);
            finish();
        }
    }


}