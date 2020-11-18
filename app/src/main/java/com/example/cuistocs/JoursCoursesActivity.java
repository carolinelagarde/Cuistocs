package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class JoursCoursesActivity extends AppCompatActivity {
    public TextView AfficherDernierJourCourses;
    public TextView AfficherPremierJourCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jours_courses2);

        //récupérer le premier jour pour lesquels il faut faire les course et l'afficher
        SeekBar barrePremierJour = findViewById(R.id.seekBarPremierJour);

        barrePremierJour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int PremierJour, boolean b) {

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

        //récupérer le dernier jour pour lesquels il faut faire les course et l'afficher
        SeekBar barreDernierJour = findViewById(R.id.seekBarDernierJour);

        barreDernierJour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int DernierJour, boolean b) {

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
    }

    //transmettre le premier jour et le dernier jour pour lesquels il faut faire les courses a l'activité liste de courses et passer à cette activité
    public void validerJoursdeCourse(View view) {
        Intent versListeDeCourses = new Intent();
        versListeDeCourses.setClass(this, ListeDeCoursesActivity.class);
        versListeDeCourses.putExtra("PremierJourCourses",AfficherPremierJourCourses.getText().toString());
        versListeDeCourses.putExtra("DernierJourCourses",AfficherDernierJourCourses.getText().toString());
        startActivity(versListeDeCourses);
    }
}