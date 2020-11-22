package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Set;
//CETTE CLASSE PERMET D'AFFICHER LES RECETTES EFFECTUEES.
public class RecettesEffectuees extends AppCompatActivity {

//liste les recettes effectuées et permet de les réafficher

    //on va récupérer "caracteristiquesRecettes"
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    //on utilise un linearLayout
    LinearLayout carteLayout;
    LinearLayout layoutScrollView;


    //on définit une note minimale d'affichage
    RatingBar rbFiltreNote;
    float noteMinimale;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //on définit ici les variables précédement déclarées

        setContentView(R.layout.activity_recettes_effectuees);
        rbFiltreNote = findViewById(R.id.filtreNote);
        layoutScrollView = findViewById(R.id.layoutScrollView);
        sharedPreferences = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        noteMinimale = rbFiltreNote.getRating();

        //la methode afficher permet d'afficher les recettes effectuées

        afficher();
        listenerForRatingBar();
    }


    public void listenerForRatingBar() {
        rbFiltreNote.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                noteMinimale = rating;
                //on met à jour en cas de changement de note miniamle voulue
                afficher();
            }
        });
    }


    public void afficher() {

        layoutScrollView.removeAllViews();
        int parite = 0;

        for (int i=1;i<30;i++) {
            String name = "r"+""+i+ ""+"finie";
            noteMinimale = rbFiltreNote.getRating();

            //ajout texte pour le filtre de la note des recettes
            TextView textViewRb = findViewById(R.id.textViewRatingB);
            textViewRb.setText("Afficher les recettes ayant au moins " + noteMinimale + " étoiles");
            if (sharedPreferences.getBoolean(name, false)) {
                //récupération de la note
                float note = sharedPreferences.getFloat("r"+i+"note", -1);

                //contrainte de note
                if (note>=noteMinimale) {
                    parite++;
                    //ajout bouton
                    Menu menu=new Menu();
                    Recette Recette=menu.getRecetteAvecNumero(i);
                    Button button = new Button(getApplicationContext());
                    button.setText(Recette.getTitre());
                    button.setOnClickListener(this::onClick);
                    button.setTag(Integer.toString(i));

                    layoutScrollView.addView(button);

                    button.setBackgroundColor(Color.BLACK);
                    button.setTextColor(Color.WHITE);

                    //ajout textview vide pour permettre le scrolling de la scrollview
                    TextView espaceTextView = new TextView(this);
                    espaceTextView.setText("");
                    layoutScrollView.addView(espaceTextView);
                }

            }
        }
    }
    public void onClick(View view) {
        //permet d'afficher la recette choisie
        Button boutonClique = (Button)view;

        //On passe vers l'affichage des recettes
        Intent versAfficherRecettesEffectuees = new Intent();
        versAfficherRecettesEffectuees.setClass(this, AfficherRecettesEffectueesActivity.class);

        //on transfere les données de la recette séléctionnée
        Button buttonClique= (Button)view;

        String numeroRecette=buttonClique.getTag().toString();
        versAfficherRecettesEffectuees.putExtra("numeroRecette",numeroRecette);
        startActivity(versAfficherRecettesEffectuees);
        Log.i("numrecette","ok");
    }

}