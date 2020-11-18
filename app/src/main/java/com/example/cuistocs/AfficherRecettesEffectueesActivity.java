package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RatingBar;
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

        //Views
        SeekBar barreNbInvites = findViewById(R.id.seekBar); // barre de choix du nombre d'invités
        barreNbInvites.setOnSeekBarChangeListener(this); //listener barre du nombre d'invités
        RatingBar rb=findViewById(R.id.Note);
        TextView ViewTempsDeCuisine = findViewById(R.id.tempsCuisine);
        LinearLayout ViewRecette = findViewById(R.id.Recette);
        TextView ViewTitre = findViewById(R.id.Titre);
        LinearLayout ViewCommentaire=findViewById(R.id.Commentaire);

    //Initialisation du sp
        sp=getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        editor=sp.edit();

        ///Récupération de la recette
        Menu Menu=new Menu();
        Intent deRecettesEffectuees=getIntent();
        String numeroRecette=deRecettesEffectuees.getStringExtra("numeroRecette");
        Recette RecetteAAfficher=Menu.getRecetteAvecNumero(Integer.valueOf(numeroRecette));


        ///Récupération des commentaires et notes
        Float Note=sp.getFloat("r"+numeroRecette+"note",0);
        String Commentaire=sp.getString("r"+numeroRecette+"commentaire","non renseigné");

        //Recuperation des infos recette
        int tempsDeCuisine = RecetteAAfficher.getTempsdecuisine();
        lesIngredients = RecetteAAfficher.getIngredients();
        String instructions = RecetteAAfficher.getInstructions();
        String Titre = RecetteAAfficher.getTitre();


        //modif des views
        ViewTempsDeCuisine.setText(Integer.toString(tempsDeCuisine));
        TextView ViewInstruction = new TextView(this);
        ViewInstruction.setText(instructions);
        ViewRecette.addView(ViewInstruction);
        ViewTitre.setText(Titre);
        rb.setRating(Note);
        TextView TexteCommentaire=new TextView(this);
        TexteCommentaire.setText(Commentaire);
        ViewCommentaire.addView(TexteCommentaire);

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
