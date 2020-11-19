package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
        //on récupère les recettes finies dans le fichier associé
        sharedPreferences = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);



              for (int i=1;i<30;i++) {
            String name = "r"+""+i+ ""+"finie";
            if (sharedPreferences.getBoolean(name, false)) {
                Menu menu=new Menu();
                Recette Recette=menu.getRecetteAvecNumero(i);
                Button button = new Button(getApplicationContext());
                button.setText(Recette.getTitre());
                button.setOnClickListener(this::onClick);
                button.setTag(Integer.toString(i));
                lay.addView(button);
            }
        }
    }
    public void onClick(View view) {
        Button boutonClique = (Button)view;
        //On passe vers l'affichage des recettes
        Intent versAfficherRecettesEffectuees = new Intent();
        versAfficherRecettesEffectuees.setClass(this, AfficherRecettesEffectueesActivity.class);
        //on transfere les données de la recette séléctionnée
        Button buttonClique= (Button)view;
        String numeroRecette=buttonClique.getTag().toString();
        versAfficherRecettesEffectuees.putExtra("numeroRecette",numeroRecette);
        startActivity(versAfficherRecettesEffectuees);
        Log.i("numrecette","ok");
    }

}