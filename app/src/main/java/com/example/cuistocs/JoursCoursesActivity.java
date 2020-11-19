package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

//CETTE PAGE PERMET DE SELECTIONNER PLUSIEURS JOURS : ON AFFICHERA ALORS LA LISTE DE COURSE NECESSAIRES DE CES JOURS. ON POURRA ALORS ALLER FAIRE LES COURSES.
public class JoursCoursesActivity extends AppCompatActivity {
    //définition des premiers et derniers jours
    public int PremierJourSeekbar;
    public int DernierJourSeekbar;
    public SeekBar barrePremierJour;

    //affiche le jour qui correspond à la selection
    public TextView AfficherDernierJourCourses;
    public TextView AfficherPremierJourCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jours_courses2);

        DernierJourSeekbar=0;
        PremierJourSeekbar=0;

        //récupérer le dernier jour pour lesquels il faut faire les course et l'afficher
        SeekBar barreDernierJour = findViewById(R.id.seekBarDernierJour);
        //récupérer le premier jour pour lesquels il faut faire les course et l'afficher
        barrePremierJour = findViewById(R.id.seekBarPremierJour);

        //affichage de la barre
        barrePremierJour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int PremierJour, boolean b) {

                //affiche le premier jour à coté de la barre
                PremierJourSeekbar=PremierJour;
                AfficherPremierJourCourses = findViewById(R.id.textViewAfficherPremierJour);
                AfficherPremierJourCourses.setText(Integer.toString(PremierJour));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //affichage de la deuxieme barre
        barreDernierJour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int DernierJour, boolean b) {
                DernierJourSeekbar=DernierJour;

                //affiche le dernier jour à coté de la barre
                AfficherDernierJourCourses = findViewById(R.id.textViewAfficherDernierJour);
                AfficherDernierJourCourses.setText(Integer.toString(DernierJour));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //on aura besoin du nombre d'invités par jour pour faire les courses,
        //pour l'instant on set le nombre d'invités à 1 par défaut via un sharedpreferences
        SharedPreferences invites = getSharedPreferences("nombreinvites", MODE_PRIVATE);
        SharedPreferences.Editor editor = invites.edit();
        for (int i = PremierJourSeekbar; i <= DernierJourSeekbar; i++) {
            editor.putInt("r" + i, 1);
        }
        editor.commit();
    }

    //transmettre le premier jour et le dernier jour pour lesquels il faut faire les courses a l'activité liste de courses et passer à cette activité
    public void validerJoursdeCourse(View view) {
        if (PremierJourSeekbar>DernierJourSeekbar) {
            Toast.makeText(getApplicationContext(), "Attention, vos jours ne sont pas cohérents !", Toast.LENGTH_SHORT).show();
        }
        else {
            //le bouton validation permet de passer à l'activité suivante qui affiche les jours voulus
            Intent versListeDeCourses = new Intent();
            versListeDeCourses.setClass(this, ListeDeCoursesActivity.class);
            versListeDeCourses.putExtra("PremierJourCourses", PremierJourSeekbar);
            versListeDeCourses.putExtra("DernierJourCourses", DernierJourSeekbar);
            startActivity(versListeDeCourses);
        }
    }
}