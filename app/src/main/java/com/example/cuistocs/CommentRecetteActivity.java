package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class CommentRecetteActivity extends AppCompatActivity {

    int numeroRecette;
    int numeroJour;
    int numeroSemaine;
    EditText commentaireRecetteEditText;  //la view où l'utiliateur rentre le commentaire de la recette
    String commentaireRecette;   //la string associée à ce commentaire
    Recette recetteEnCours;

    Set listeJoursDebloques;
    Set calendrierRecettes;
    SharedPreferences spSetOrdre;
    SharedPreferences spCaracteristiqueRecette;
    public SharedPreferences etatBouton;

    //on définit le bouton qui va aller ver l'appareil photo et l'imageView qui va afficher la photo
    private Button btnPrendrePhoto;
    private ImageView imgAffichePhoto;
    Intent deRecetteActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);


        deRecetteActivity = getIntent();
        numeroJour = deRecetteActivity.getIntExtra("numero jour", -1);
        numeroSemaine = deRecetteActivity.getIntExtra("numero semaine", -1);
        spCaracteristiqueRecette=getSharedPreferences("fini",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spCaracteristiqueRecette.edit();


    }

    public void enregistrer(View view) {   //on récupère la note que l'utilisateur entre dans la rating bar
        RatingBar rb = findViewById(R.id.ratingBar);

        float note = rb.getRating();  //on récupère la note que l'utilisateur entre dans la rating bar
        Toast.makeText(this, "note:" + note, Toast.LENGTH_SHORT).show(); //on montre à l'utilisateur la note qu'il a mise


        //on enregistre la note que l'utilisateur a associé à sa recette grace à un sharedPrefrences
        SharedPreferences sp = getSharedPreferences("memonote", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat("r" + numeroRecette + "note", note); //on met dans shared preferences la note avec l'étiquette correspondant au numero de recette
        editor.putString("r" + numeroRecette + "commentaire", commentaireRecette);
        editor.apply();

    }

    public void valider(View view) {

        Intent messageVersAccueilActivity = new Intent();
        // messageVersAccueilActivity.setClass(this, AccueilActivity.class);
        startActivity(messageVersAccueilActivity);   //on retourne à l'acitvité principale une fois que l'utilisateur a rentré le commentaire et la note
    }


///l'utilisateur peut partager la recette par sms s'il l'a bien aimée
    public void partageSMS(View view) {

        int indiceJourTot = numeroSemaine*7+numeroJour;

        Menu menu = new Menu();
        Vector<Recette> livreRecettes = menu.livreRecettes;

        Recette recetteEnCours = livreRecettes.elementAt(numeroRecette);

        String messageSMS = String.format("Toi aussi découvre cette recette !\n"
                + recetteEnCours.getTitre() + "\n"
                + recetteEnCours.getIngredients() + "\n"
                + recetteEnCours.getTempsdecuisine() + "\n"
                + recetteEnCours.getInstructions() + "\n");
        Intent versAppSMS = new Intent(Intent.ACTION_SENDTO);
        versAppSMS.setData(Uri.parse("smsto:"));
        versAppSMS.putExtra("sms_body", messageSMS);
        Intent choixAppSMS = Intent.createChooser(versAppSMS, "Partager la recette avec :");
        startActivity(choixAppSMS);
    }


    /*
    public static Recette getCurrentRecette(){
        //Creation d'un valeur par defaut pour le sharedPreferences
        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");



        //recuperation de l'indice du jour : je n'y arrive pas. Je prends donc la recette 1 (pour changer)



        Menu menu= new Menu();


        Recette CurrentRecette= menu.livreRecettes.get(1);
        return CurrentRecette;
    }

     */


    /*
    public Recette getCurrentRecette(int jour, int semaine){


        SharedPreferences etatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);

        Set listeJoursDebloques;

        //Creation d'un valeur par defaut pour le sharedPreferences
        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");

        Menu menu = new Menu();
        Vector<Recette> livreRecettes = menu.livreRecettes;

        //recuperation de nombre de jours debloqués (donne une liste, et on recupere la taille de la liste des jours debloques)
        listeJoursDebloques = etatBouton.getStringSet("boutonDebloque", defaultvalueset);
        int nombreJoursDebloques = listeJoursDebloques.size();

        Object[] tableauJoursDebloques = listeJoursDebloques.toArray();

        return (Recette)tableauJoursDebloques[nombreJoursDebloques];

    }

    public void prendrePhoto(View view) {
        btnPrendrePhoto=findViewById(R.id.btnPrendrePhoto);
    }

     */
}