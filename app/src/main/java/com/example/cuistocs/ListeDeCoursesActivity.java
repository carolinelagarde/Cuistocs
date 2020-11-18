package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
        SharedPreferences sp=getSharedPreferences("lien", Context.MODE_PRIVATE);

        Periode.setText(String.format("des recettes %1d à %2d!pour 1 personne",jourDebut,jourFin));
        for (int i=jourDebut;i<=jourFin;i++){
            TextView Titre=new TextView(this);
            Titre.setText(String.format("Recette %1d",i));
            Titre.setTextAppearance(this,android.R.style.TextAppearance_Medium);
            Titre.setTextColor(Color.parseColor("#AC0404"));
            Liste.addView(Titre);

           int RecetteNumber=Integer.valueOf(sp.getString(Integer.toString(i),"0"));
           Menu menu = new Menu();
           Recette RecetteEnCours=menu.getRecetteAvecNumero(RecetteNumber);
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

    public void commanderPepin(View view) {
        String url = "https://impact.cs-campus.fr/pepin";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, url);
        startActivity(intent);
    }

    public void commandeMiamLocale(View view) {
        String url = "https://www.lamiamlocale.fr";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, url);
        startActivity(intent);
    }
}