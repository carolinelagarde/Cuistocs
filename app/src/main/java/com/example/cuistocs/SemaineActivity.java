package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

//CETTE ACTIVITÉ PERMET D'ACCÉDER AUX BOUTONS JOURS A PARTIR DES 4 SEMAINES POSSIBLES, D'ACCEDER A LA
//LISTE DES COURSES ET AUX RECETTES EFFECTUEES
public class SemaineActivity extends AppCompatActivity {

    //le numero de la semaine sur lequel on clique
    int numeroSemaine;

    //noms des 4 boutons semaine
    Button semaine1;
    Button semaine2;
    Button semaine3;
    Button semaine4;

    //sp etat bouton
    SharedPreferences spCouleurBouton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaine);

        //donne les noms aux boutons
        semaine1 = findViewById(R.id.boutonSemaine1);
        semaine2 = findViewById(R.id.boutonSemaine2);
        semaine3 = findViewById(R.id.boutonSemaine3);
        semaine4 = findViewById(R.id.boutonSemaine4);

        //récupérer le score via le shared preferences
        SharedPreferences spPoints = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
        int scoreActuel=spPoints.getInt("nombrePoints",0);

        //affiche le score actuel
        TextView AfficherScoreActuel=findViewById(R.id.textViewScoreActuel);
        AfficherScoreActuel.setText("Votre score actuel est de "+scoreActuel+" points.");

        //Coloration des boutons

        String tag;
        spCouleurBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);

        tag="jour0semaine0";
        if (spCouleurBouton.contains(tag)){

                semaine1.setBackgroundColor(Color.parseColor("#DC0909"));
           }
        tag="jour0semaine1";
        if ((spCouleurBouton.contains(tag))){


                semaine2.setBackgroundColor(Color.parseColor("#DC0909"));
            }
        tag="jour0semaine2";
        if ((spCouleurBouton.contains(tag))) {


                semaine3.setBackgroundColor(Color.parseColor("#DC0909"));
            }
        tag="jour0semaine3";
        if ((spCouleurBouton.contains(tag))) {


                semaine4.setBackgroundColor(Color.parseColor("#DC0909"));
            }
        }


    //fonction appelée lorsqu'on clique sur un des boutons semaine
    public void ouvrirSemaine(View view) {

        if (view.equals(semaine1)) {
            numeroSemaine = 0;
        }
        else if (view.equals(semaine2)) {
            numeroSemaine = 1;
        }
        else if (view.equals(semaine3)) {
            numeroSemaine = 2;
        }
        else if (view.equals(semaine4)) {
            numeroSemaine = 3;
        }

        //garde en mémoire la semaine cliquée
        SharedPreferences spDate=getSharedPreferences("date",Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDate =spDate.edit();
        editorDate.putInt("numeroSemaine",numeroSemaine);
        editorDate.commit();


        //passe à l'activité qui affiche larecette uniquement si le bouton semaine est débloqué, i.e si c'est la première
        //semaine ou si le dernier jour de la semaine précédente est débloqué
        SharedPreferences spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        String tag="jour0semaine"+numeroSemaine;
        if (numeroSemaine==0 || spEtatBouton.contains(tag)){
            Intent versJour = new Intent();
            versJour.setClass(this, ChoixJoursActivity.class);
            startActivity(versJour);

        }}



               //fonction appelée si on clique sur le bouton recettes effectuées : envoie vers l'activité recettes effectuées
               public void ouvrirRecettesEffectuees (View view){
                   Intent versRecettesEffectuees = new Intent();
                   versRecettesEffectuees.setClass(this, RecettesEffectuees.class);
                   startActivity(versRecettesEffectuees);
               }

               //fonction appelée si on clique sur le bouton liste de courses : envoie vers l'activité liste de courses
               public void afficherJoursCourses (View view){
                   Intent messageVersJoursCoursesActivity = new Intent();
                   messageVersJoursCoursesActivity.setClass(this, JoursCoursesActivity.class);
                   startActivity(messageVersJoursCoursesActivity);
               }
    }