package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoixJoursActivity extends AppCompatActivity {

    View Jour1= findViewById(R.id.jour1);
    View Jour2= findViewById(R.id.jour2);
    View Jour3= findViewById(R.id.jour3);
    View Jour4= findViewById(R.id.jour4);
    View Jour5= findViewById(R.id.jour5);
    View Jour6= findViewById(R.id.jour6);
    View Jour7= findViewById(R.id.jour7);
    int jour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_jours);
        //test caro
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

        Intent messageVersRecetteActivity = new Intent();
        messageVersRecetteActivity.setClass(this, RecetteActivity.class);
        messageVersRecetteActivity.putExtra("numero jour", jour);
        startActivity(messageVersRecetteActivity);

    }
}


