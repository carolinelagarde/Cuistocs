package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

//CETTE ACTIVITÉ PERMET D'ACCEDER AUX BOUTONS JOURS QUI SONT DÉBLOQUÉS OU NON SELON
//L'AVANCEMENT DE L'UTILISATEUR
//ON ACCEDE AINSI AUX DIFFERENTES RECETTES
public class ChoixJoursActivity extends AppCompatActivity {

    //nom des boutons
    Button Jour1;
    Button Jour2;
    Button Jour3;
    Button Jour4;
    Button Jour5;
    Button Jour6;
    Button Jour7;

    //numero de la semaine cliquée et du jour cliqué
    int numeroSemaine;
    int jour;

    //shared preferences qui garde en mémoire les boutons débloqués
    SharedPreferences spEtatBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_jours);

        //affecte les boutons
        Jour1 = findViewById(R.id.jour1);
        Jour2 = findViewById(R.id.jour2);
        Jour3 = findViewById(R.id.jour3);
        Jour4 = findViewById(R.id.jour4);
        Jour5 = findViewById(R.id.jour5);
        Jour6 = findViewById(R.id.jour6);
        Jour7 = findViewById(R.id.jour7);


        //récupère le numéro de la semaine qui est en mémoire
        SharedPreferences spDate=getSharedPreferences("date",Context.MODE_PRIVATE);
        numeroSemaine=spDate.getInt("numeroSemaine",-1);

        //grisage des boutons comment améliorer ce code pour éviter les répétitions ? comment faire pour R.id.Jour+int ?
        spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        String tag="jour"+1+"semaine"+numeroSemaine;
            if (!(spEtatBouton.contains(tag))){
                Jour1.setBackgroundColor(Color.parseColor("#ACA3A3"));
            }
            tag="jour"+2+"semaine"+numeroSemaine;
        if (!(spEtatBouton.contains(tag))){
            Jour2.setBackgroundColor(Color.parseColor("#ACA3A3"));
        }
        tag="jour"+3+"semaine"+numeroSemaine;
        if (!(spEtatBouton.contains(tag))){
            Jour3.setBackgroundColor(Color.parseColor("#ACA3A3"));
        }
        tag="jour"+4+"semaine"+numeroSemaine;
        if (!(spEtatBouton.contains(tag))){
            Jour4.setBackgroundColor(Color.parseColor("#ACA3A3"));
        }
         tag="jour"+5+"semaine"+numeroSemaine;
        if (!(spEtatBouton.contains(tag))){
            Jour5.setBackgroundColor(Color.parseColor("#ACA3A3"));
        }
         tag="jour"+6+"semaine"+numeroSemaine;
        if (!(spEtatBouton.contains(tag))){
            Jour6.setBackgroundColor(Color.parseColor("#ACA3A3"));
        }
        tag="jour"+7+"semaine"+numeroSemaine;
        if (!(spEtatBouton.contains(tag))){
            Jour7.setBackgroundColor(Color.parseColor("#ACA3A3"));
        }
        }



        //fonction appelée quand on clique sur un bouton jour
    public void allerVersRecetteActivity(View view) {

        //affecte le numéro du jour cliqué à jour
        Button boutonClique=(Button)view;
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

        //garde en mémoire dans quel jour on est
        SharedPreferences spDate=getSharedPreferences("date",Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDate=spDate.edit();
        editorDate.putInt("numeroJour",jour);
        editorDate.commit();

        //debloque et mène à la recette que si le jour a été développé, i.e si c'est le 1er jour d'une semaine
        //car le bouton semaine à déjà été développé ou si le bouton est marqué comme débloqué dans la mémoire
        spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        String tag="jour"+jour+"semaine"+numeroSemaine;
        if (jour == 0 || spEtatBouton.contains(tag)) {
            Intent messageVersRecetteActivity = new Intent();
            messageVersRecetteActivity.setClass(this, RecetteActivity.class);
            startActivity(messageVersRecetteActivity);
        }
    }
}


