package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public class RecetteActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    int points;
    //Boutons
    Button boutonFini;
    Button boutonPasse;
    Recette recette;

    //Menu pour accéder aux recettes
    Menu test;

    //récupération des recettes terminées : on va l'actualiser en cas de pression sur le bouton "fini"
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    int numeroJour;
    int numeroSemaine;
    int numeroRecette;
    String numeroRecetteActuel;
    int JourAbsoluActuel; //il vaut (numeroJour+1)*(numeroSemaine+1)

    Vector<Ingredient> lesIngredients;

    SharedPreferences etatBouton;
    SharedPreferences spPoints;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        //affecte les deux boutons
        boutonFini = findViewById(R.id.boutonFini);
        boutonPasse = findViewById(R.id.boutonPasse);


        /*on affecte à la variable points :
           - 0 si aucun point n'a été marqué
           - le nombre de points mémorisés en sharedPreferences si des points on deja ete marques
         */
        SharedPreferences spPoints = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
        if (spPoints.contains("nombrePoints")) {
            points = spPoints.getInt("nombrePoints", -1);
        } else { points = 0; }


        // recuperation des entiers numeroSemaine et numeroJour qui servent à indexer les recettes dans la matrice des recettes

        //on récupère des deux activités précédentes les numéros du jour et de la semaine dans laquelle on est

        Intent messagedeChoixJoursActivity = getIntent();

        numeroJour = messagedeChoixJoursActivity.getIntExtra("numero jour", -1);
        numeroSemaine = messagedeChoixJoursActivity.getIntExtra("numero semaine", -1);
        JourAbsoluActuel = (numeroJour+1)*(numeroSemaine+1);

        SeekBar barre = findViewById(R.id.seekBar); // barre de choix du nombre d'invités
        barre.setOnSeekBarChangeListener(this);


        //recuperation de la recette
        preferences = getSharedPreferences("lien", Context.MODE_PRIVATE);

        numeroRecetteActuel = preferences.getString(""+JourAbsoluActuel+"","1");
        Log.i("NumeroRecette",""+JourAbsoluActuel+"");

        Menu test= new Menu();
        recette = test.livreRecettes.get(Integer.valueOf(numeroRecetteActuel));

        //ajout des éléments
        int tempsDeCuisine = recette.getTempsdecuisine();
        lesIngredients = recette.getIngredients();
        String instructions = recette.getInstructions();
        String Titre = recette.getTitre();

        TextView ViewTempsDeCuisine = findViewById(R.id.tempsCuisine);
        LinearLayout ViewRecette = findViewById(R.id.Recette);
        TextView ViewTitre = findViewById(R.id.Titre);


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

    public void finRecette(View view) {

        numeroRecette=recette.getNumeroRecette();  //on récupère le numéro de la recette faite

        //on veut débloquer le bouton du jour suivant
        etatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorBouton = etatBouton.edit();

        Set<String> defaultvalueset = new HashSet<>();
        defaultvalueset.add("");


        Set<String> boutonDebloqueSet= etatBouton.getStringSet("boutonDebloque",defaultvalueset);
        boutonDebloqueSet.add("jour"+numeroJour+"semaine"+numeroSemaine);
        editorBouton.commit();

        //on indique que la recette est terminée
        sharedPreferences = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("r" + numeroRecette + "finie", true);
        editor.commit();
        Log.i("fait","vous avez fini la recette"+" "+ "" + numeroRecette+"");


        if (view.equals(boutonFini)) {

            points += 1;   // si bouton Fini clique : +1 point !



            ///on va enregistrer le fait que la recette a été faite et le score du joueur
            spPoints = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = spPoints.edit();
            editor.putInt("nombrePointsDejaGagnes", points);

            editor.apply();


            ///on veut aller à l'activité qui permet de commenter la recette, en transmettant à cette activité le numéro de la recette faite
            Intent versCommentRecetteActivity = new Intent();
            versCommentRecetteActivity.setClass(this, CommentRecetteActivity.class);
            versCommentRecetteActivity.putExtra("numero recette", recette.getNumeroRecette());
            versCommentRecetteActivity.putExtra("numero jour", numeroJour);
            versCommentRecetteActivity.putExtra("numero semaine", numeroSemaine);
            startActivity(versCommentRecetteActivity);

        }

        ///le joueur n'a pas fait la recette
        if (view.equals(boutonPasse)) {

            ///on enregistre le fait que le score du joueur n'a pas changé et que l'a recette n'a pas été faite
            spPoints = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = spPoints.edit();
            editor.putInt("nombrePointsDejaGagnes", points);
            editor.putBoolean("r" + numeroRecette + "finie", false);
            editor.apply();


            // si on n'est pas au dernier jour de la semaine, ca nous ramene a l'écran des jours
            if (numeroJour < 6) {
                Intent versEcranJour = new Intent();
                versEcranJour.setClass(this, ChoixJoursActivity.class);
                startActivity(versEcranJour);
                finish();
            }
            //si on est au dernier jour, ca nous ramene à l'écran semaine.
            if (numeroJour == 6) {
                Intent versEcranSemaine = new Intent();
                versEcranSemaine.setClass(this, SemaineActivity.class);
                startActivity(versEcranSemaine);
                finish();
            }
        }
    }


}
