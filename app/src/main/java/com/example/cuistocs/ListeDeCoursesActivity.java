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
//CETTE ACTIVITE PERMET D'AFFICHER LES INGREDIENTS A ACHETER EN FONCTION DES JOURS CHOISIS
public class ListeDeCoursesActivity extends AppCompatActivity {
    //nombre est le nombre de convives : c'est une variable courante
    public int nombre;
    //on recupère le jour début et fin de la précédente activité
    public int jourDebut;
    public int jourFin;


    //on définit le layout et les sharedpreferences nécessaires
    public LinearLayout Liste;
    public SharedPreferences sp;
    public SharedPreferences nombreinvite;
    public SharedPreferences.Editor editeur;
    public SeekBar barre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_de_courses);
        //appel de la méthode de construction
        construction();

    }

public void construction() {
    Intent depuisChoixJourCourse=getIntent();
    int jourDebut=depuisChoixJourCourse.getIntExtra("PremierJourCourses",0);
    int jourFin=depuisChoixJourCourse.getIntExtra("DernierJourCourses",0);



    TextView Periode=findViewById(R.id.Periode);
    Periode.setText(String.format("des recettes %1d à %2d!  pour 1 personne",jourDebut,jourFin));

    //déifinition des variables
    LinearLayout Liste=findViewById(R.id.Liste);
    SharedPreferences sp=getSharedPreferences("lien", Context.MODE_PRIVATE);

    //on enlève les views précédentes
    Liste.removeAllViews();

    //on affiche les ingredients jour par jour
    for (int i=jourDebut;i<=jourFin;i++){
        //on récupère le nombre d'invités pour chaque jour : par défaut, on prends 1 invité
        SharedPreferences nombreinvite = getSharedPreferences("nombreinvites",Context.MODE_PRIVATE);
        editeur = nombreinvite.edit();

        //affichage du titre
        TextView Titre=new TextView(this);
        Titre.setText(String.format("Ingrédients du jour %1d",i));
        Titre.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Medium);
        Titre.setTextColor(Color.parseColor("#AC0404"));
        Liste.addView(Titre);

        //récupération du numéro de recette ainsi que la recette à afficher
        int RecetteNumber=Integer.valueOf(sp.getString(Integer.toString(i),"0"));
        Menu menu = new Menu();
        Recette RecetteEnCours=menu.getRecetteAvecNumero(RecetteNumber);

        //on récupère les ingredients àa afficher
        Vector<Ingredient> Ingredients=RecetteEnCours.getIngredients();

        //on récupère le nombre d'invités dans le sharedpreferences
        nombre= nombreinvite.getInt("r"+""+i+"",1);


        //on affiche les ingredients un par un
        for (int index=0;index<Ingredients.size();index++){
            Ingredient Ingredient=Ingredients.get(index);
            String titreIngredient=Ingredient.getIngredient();
            int Quantite=Ingredient.getQuantité(nombre);
            String Unite=Ingredient.getUnite();

            TextView ListeDuJour=new TextView(getApplicationContext());
            ListeDuJour.setText(Integer.toString(Quantite)+" "+Unite+" "+titreIngredient);
            Liste.addView(ListeDuJour);
        }
        //on ajoute une seekbare pour régler le nombre de convives
        SeekBar barre =new SeekBar(this);
        barre.setMax(10);
        barre.setProgress(nombre);
        int finalI = i;
        barre.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int nb, boolean b) {
                //si on change le nombre de convives, on acutalise le nombre dans le sharedpreferences
                //on reconstruit alors la page
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
        nombrepersonnes.setText("Pour "+ nombre +" convives");
        nombrepersonnes.setTextAppearance(getApplicationContext(),android.R.style.TextAppearance_Medium);
        Liste.addView(nombrepersonnes);



    }



}

//on ajoute ici deux boutons qui permettent d'aller sur les pages de pépin et de miam locale
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