package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AfficherRecette extends AppCompatActivity {
    //à faire : afficher en brut les éléments correspondants à la recette brute

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_recette);

        Intent deRecetteEffectuees = getIntent();
        String commentaire = deRecetteEffectuees.getStringExtra("commentaire");
        String note = deRecetteEffectuees.getStringExtra("note");
        String numero = deRecetteEffectuees.getStringExtra("numero");






    }
}