package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

public class ChoixJoursActivity extends AppCompatActivity {
    int numeroSemaine;

    View Jour1= findViewById(R.id.jour1);
    View Jour2= findViewById(R.id.jour2);
    View Jour3= findViewById(R.id.jour3);
    View Jour4= findViewById(R.id.jour4);
    View Jour5= findViewById(R.id.jour5);
    View Jour6= findViewById(R.id.jour6);
    View Jour7= findViewById(R.id.jour7);
    int jour;

    public SharedPreferences etatBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_jours);

        //recupere le numero de la semaine
        Intent messagedeSemaineActivity=getIntent() ;
        numeroSemaine=messagedeSemaineActivity.getIntExtra("indiceSemaine",-1);
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

        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");

        etatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = etatBouton.edit();
        Set<String> boutonDebloqueSet= new HashSet<>();
        boutonDebloqueSet.add("jour1semaine0");
        editor.putStringSet("boutonDebloque",boutonDebloqueSet);

        if (jour==0| etatBouton.getStringSet("boutonDebloque",defaultvalueset).contains("jour7semaine"+(numeroSemaine-1))) {

            //transmet a recette activity le numero du jour
            Intent messageVersRecetteActivity = new Intent();
            messageVersRecetteActivity.setClass(this, RecetteActivity.class);
            messageVersRecetteActivity.putExtra("numero jour", jour);

            startActivity(messageVersRecetteActivity);
        }

    }
}


