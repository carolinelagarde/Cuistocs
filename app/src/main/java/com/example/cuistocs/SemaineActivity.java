package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class SemaineActivity extends AppCompatActivity {

    int numeroSemaine;
    Button semaine1;
    Button semaine2;
    Button semaine3;
    Button semaine4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaine);

        semaine1 = findViewById(R.id.boutonSemaine1);
        semaine2 = findViewById(R.id.boutonSemaine2);
        semaine3 = findViewById(R.id.boutonSemaine3);
        semaine4 = findViewById(R.id.boutonSemaine4);

        //affiche le score actuel
        TextView AfficherScoreActuel=findViewById(R.id.textViewScoreActuel);
        //récupérer le score
        SharedPreferences spPoints = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
        int scoreActuel=spPoints.getInt("nombrePointsDejaGagnes",0);
        AfficherScoreActuel.setText("Votre score actuel est de "+scoreActuel+" points.");


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

        //retient dans quelle semaine on est
        SharedPreferences spDate=getSharedPreferences("date",Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDate =spDate.edit();

        editorDate.putInt("numeroSemaine",numeroSemaine);
        editorDate.commit();


        //passe à l'activité suivante que si les boutons sont débloqués
        SharedPreferences spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        String tag="jour0semaine"+numeroSemaine;
        Log.i("numerosemaine",Integer.toString(numeroSemaine));
        if (numeroSemaine==0 || spEtatBouton.contains(tag)){

            Intent versJour = new Intent();
            versJour.setClass(this, ChoixJoursActivity.class);
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