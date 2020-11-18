package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class AfficherRecettesEffectueesActivity extends AppCompatActivity {
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_recettes_effectuees);
        sp=getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        editor=sp.edit();

        //Affichage Titre

    }
}