package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.Set;

public class RecettesEffectuees extends AppCompatActivity {
//liste les recettes effectuées et permet de les réafficher


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LinearLayout carteLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recettes_effectuees);

        afficher();

        }



    public void afficher() {
        LinearLayout lay = findViewById(R.id.recetteseffectuees);
        lay.removeAllViews();

        for (int i=0;i<30;i++) {
            String name = "r"+""+i+ ""+"finie";
            if (sharedPreferences.contains(name)) {

                Button button = new Button(getApplicationContext());
                button.setText("Recette" + Integer.toString(i));
                button.setOnClickListener((View.OnClickListener) this);
                button.setTag(Integer.toString(i));
                lay.addView(button);

            } else {
                break;
            }
        }
    }
    public void onClick(View view) {
        Button boutonClique = (Button)view;
        //On passe vers l'affichage des recettes
        Intent versAfficherRecette = new Intent();
        versAfficherRecette.setClass(this, RecetteActivity.class);
        //on transfere les données de la recette séléctionnée

        startActivity(versAfficherRecette);
    }

}