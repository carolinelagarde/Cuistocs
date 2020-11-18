package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class SemaineActivity extends AppCompatActivity {

    int numeroSemaine;
    Button semaine1;
    Button semaine2;
    Button semaine3;
    Button semaine4;

    //creation d'un vecteur pour mettre à jour les boutons à débloquer au fur et à mesure
    public SharedPreferences spEtatBouton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaine);

        //on cree en memoire de quoi garder si les boutons sont bloques ou non
        spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spEtatBouton.edit();

        Set<String> boutonDebloqueSet= new HashSet<>();
        boutonDebloqueSet.add("jour0semaine0");
        editor.putStringSet("boutonDebloque",boutonDebloqueSet);
        editor.commit();

        semaine1 = findViewById(R.id.boutonSemaine1);
        semaine2 = findViewById(R.id.boutonSemaine2);
        semaine3 = findViewById(R.id.boutonSemaine3);
        semaine4 = findViewById(R.id.boutonSemaine4);

    }

    public void ouvrirSemaine(View view) {

        if (view.equals(semaine1)) {
            numeroSemaine = 0;
            Log.i("boutonSemaineClique", "semaine 1 selectionnee");
        }
        else if (view.equals(semaine2)) {
            numeroSemaine = 1;
            Log.i("boutonSemaineClique", "semaine 2 selectionnee");
        }
        else if (view.equals(semaine3)) {
            numeroSemaine = 2;
            Log.i("boutonSemaineClique", "semaine 3 selectionnee");
        }
        else if (view.equals(semaine4)) {
            numeroSemaine = 3;
            Log.i("boutonSemaineClique", "semaine 4 selectionnee");
        }

        //avoir un StringSet neutre
        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");

        //passe à l'activité suivante que si les boutons sont débloqués
        if (numeroSemaine==0 || spEtatBouton.getStringSet("boutonDebloque",defaultvalueset).contains("jour6semaine"+(numeroSemaine-1))){

            Intent versJour = new Intent();
            versJour.setClass(this, ChoixJoursActivity.class);
            versJour.putExtra("indiceSemaine", numeroSemaine);
            startActivity(versJour);

        }

    }

    public void ouvrirRecettesEffectuees(View view) {
        Intent versRecettesEffectuees = new Intent();
        versRecettesEffectuees.setClass(this, RecettesEffectuees.class);

        startActivity(versRecettesEffectuees);
    }

    public void afficherJoursCourses(View view){
        Intent messageVersJoursCoursesActivity = new Intent();
        messageVersJoursCoursesActivity.setClass(this,JoursCoursesActivity.class);
        startActivity(messageVersJoursCoursesActivity);
    }
}