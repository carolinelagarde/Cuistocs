package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Vector;

public class AfficherRecettesEffectueesActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
SharedPreferences sp;
SharedPreferences.Editor editor;
Vector<Ingredient> lesIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_recettes_effectuees);

        ///Récupération de la recette
        sp=getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        editor=sp.edit();
        Menu Menu=new Menu();
        int numeroRecette=sp.getInt("numeroRecette",0);
        Recette RecetteAAfficher=Menu.getRecetteAvecNumero(numeroRecette);
        SeekBar barre = findViewById(R.id.seekBar); // barre de choix du nombre d'invités
        barre.setOnSeekBarChangeListener(this); //listener barre du nombre d'invités



        //ajout des éléments sur le view

        int tempsDeCuisine = RecetteAAfficher.getTempsdecuisine();
        lesIngredients = RecetteAAfficher.getIngredients();
        String instructions = RecetteAAfficher.getInstructions();
        String Titre = RecetteAAfficher.getTitre();

        //import des view
        TextView ViewTempsDeCuisine = findViewById(R.id.tempsCuisine);
        LinearLayout ViewRecette = findViewById(R.id.Recette);
        TextView ViewTitre = findViewById(R.id.Titre);

        //modif des views
        ViewTempsDeCuisine.setText(Integer.toString(tempsDeCuisine));
        TextView ViewInstruction = new TextView(this);
        ViewInstruction.setText(instructions);
        ViewRecette.addView(ViewInstruction);
        ViewTitre.setText(Titre);

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView NbInvites = findViewById(R.id.NbInvites); //on affiche le nombre d'invités choisis
        NbInvites.setText(Integer.toString(progress));
        LinearLayout ListeIngredients=findViewById(R.id.Ingredients);
        ListeIngredients.removeAllViewsInLayout();
        for (int i = 0; i< lesIngredients.size(); i++){
            Ingredient ingredient= lesIngredients.get(i);
            String Quantite;
            Quantite = Integer.toString(ingredient.getQuantité(progress));
            String TexteIngredient=Quantite+" "+ingredient.getUnite()+" "+ingredient.getIngredient();
            TextView tv=new TextView(this);
            tv.setText(TexteIngredient);
            ListeIngredients.addView(tv);

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
