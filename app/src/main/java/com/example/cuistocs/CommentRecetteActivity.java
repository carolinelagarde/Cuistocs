package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class CommentRecetteActivity extends AppCompatActivity {

    int numeroRecette;
    EditText commentaireRecetteEditText;  //la view où l'utiliateur rentre le commentaire de la recette
    String commentaireRecette;   //la string associée à ce commentaire


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);
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



    public void partageSMS(View view) {

        String messageSMS = String.format("Toi aussi découvre cette recette !\n"
                + recetteEnCours.getTitre() + "\n"
                + recetteEnCours.getIngredients() + "\n"
                + recetteEnCours.getTempsDeCuisine() + "\n"
                + recetteEnCours.getInstructions() + "\n");
        Intent versAppSMS = new Intent(Intent.ACTION_SENDTO);
        versAppSMS.setData(Uri.parse("smsto:"));
        versAppSMS.putExtra("sms_body", messageSMS);
        Intent choixAppSMS = Intent.createChooser(versAppSMS, "Partager la recette avec :");
        startActivity(choixAppSMS);
    }

}