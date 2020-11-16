package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.SeekBar;
import android.widget.TextView;


public class RecetteActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    int numeroJour;
    int numeroSemaine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);
        Intent messagedeChoixJoursActivity = getIntent();

        numeroJour = messagedeChoixJoursActivity.getIntExtra("numero jour", -1); //on recupere l entier nombre de point de l'activité principale

        Intent messagedeSemaineActivity=getIntent() ;
        numeroSemaine=messagedeSemaineActivity.getIntExtra("indiceSemaine",-1) ;

        String[][] matriceRecette;
        TextView textViewRecette=findViewById(R.id.textView2);

        //textViewRecette.setText(matriceRecette[numeroSemaine][numeroJour]);

        SeekBar barre=findViewById(R.id.seekBar); // barre de choix du nombre d'invités
        barre.setOnSeekBarChangeListener(this);


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
}



