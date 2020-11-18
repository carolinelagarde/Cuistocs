package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class ListeDeCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_de_courses);

        Intent depuisChoixJourCourse=getIntent();
        int jourDebut=depuisChoixJourCourse.getIntExtra("PremierJourCourses",0);
        int jourFin=depuisChoixJourCourse.getIntExtra("DernierJourCourses",0);


        TextView Periode=findViewById(R.id.Periode);
        LinearLayout Liste=findViewById(R.id.Liste);
        SharedPreferences sp=getSharedPreferences("", Context.MODE_PRIVATE);

        Periode.setText(String.format("des recettes %1d à %2d!pour 1 personne",jourDebut,jourFin));
        for (int i=jourDebut;i<=jourFin;i++){
            TextView Titre=new TextView(this);
            Titre.setText(String.format("Recette %1d",Integer.toString(i)));
            Liste.addView(Titre);

           int RecetteNumber=Integer.valueOf(sp.getString(Integer.toString(i),""));
           Recette RecetteEnCours=Menu.livreRecettes.get(RecetteNumber);
           Vector<Ingredient> Ingredients=RecetteEnCours.getIngredients();
           for (int index=0;index<Ingredients.size();index++){
               Ingredient Ingredient=Ingredients.get(index);
               String titreIngredient=Ingredient.getIngredient();
               int Quantite=Ingredient.getQuantité(1);
               String Unite=Ingredient.getUnite();

               TextView ListeDuJour=new TextView(this);
               ListeDuJour.setText(Integer.toString(Quantite)+" "+Unite+" "+titreIngredient);
               Liste.addView(ListeDuJour);

            }

        }
    }
}