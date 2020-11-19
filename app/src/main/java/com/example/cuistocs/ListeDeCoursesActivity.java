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
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class ListeDeCoursesActivity extends AppCompatActivity {
    public int nombre;
    public int jourDebut;
    public int jourFin;
    public LinearLayout Liste;
    public SharedPreferences sp;

    public SharedPreferences nombreinvite;
    public SharedPreferences.Editor editeur;
    public SeekBar barre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_de_courses);

        construction();

    }

public void construction() {
    Intent depuisChoixJourCourse=getIntent();
    int jourDebut=depuisChoixJourCourse.getIntExtra("PremierJourCourses",0);
    int jourFin=depuisChoixJourCourse.getIntExtra("DernierJourCourses",0);



    TextView Periode=findViewById(R.id.Periode);
    Periode.setText(String.format("des recettes %1d à %2d!  pour 1 personne",jourDebut,jourFin));


    LinearLayout Liste=findViewById(R.id.Liste);
    SharedPreferences sp=getSharedPreferences("lien", Context.MODE_PRIVATE);
    Liste.removeAllViews();
    for (int i=jourDebut;i<=jourFin;i++){

        SharedPreferences nombreinvite = getSharedPreferences("nombreinvites",Context.MODE_PRIVATE);
        editeur = nombreinvite.edit();

        //récupération du titre et du texte
        TextView Titre=new TextView(this);
        Titre.setText(String.format("Recette %1d",i));
        Titre.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Medium);
        Titre.setTextColor(Color.parseColor("#AC0404"));
        Liste.addView(Titre);

        int RecetteNumber=Integer.valueOf(sp.getString(Integer.toString(i),"0"));

        Menu menu = new Menu();
        Recette RecetteEnCours=menu.getRecetteAvecNumero(RecetteNumber);

        Vector<Ingredient> Ingredients=RecetteEnCours.getIngredients();

        nombre= nombreinvite.getInt("r"+""+i+"",1);

        for (int index=0;index<Ingredients.size();index++){
            Ingredient Ingredient=Ingredients.get(index);
            String titreIngredient=Ingredient.getIngredient();
            int Quantite=Ingredient.getQuantité(nombre);
            String Unite=Ingredient.getUnite();

            TextView ListeDuJour=new TextView(getApplicationContext());
            ListeDuJour.setText(Integer.toString(Quantite)+" "+Unite+" "+titreIngredient);
            Liste.addView(ListeDuJour);



        }

        SeekBar barre =new SeekBar(this);
        barre.setMax(10);
        barre.setProgress(nombre);
        int finalI = i;
        barre.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int nb, boolean b) {
                nombre =nb;
                String key = "r" + finalI;
                editeur.putInt(key,nombre);
                editeur.commit();
                construction();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Liste.addView(barre);

        //on affiche le nombre de personnes
        TextView nombrepersonnes=new TextView(getApplicationContext());
        nombrepersonnes.setText("Pour un nombre de convives égal à : "+nombre);
        nombrepersonnes.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Medium);
        Liste.addView(nombrepersonnes);



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