package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class CommentRecetteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);
    }

    public void enregistrer(View view){   //on récupère la note que l'utilisateur entre dans la rating bar
        RatingBar rb=findViewById(R.id.ratingBar);
        float note= rb.getRating();
        Toast.makeText(this, "note:"+ note, Toast.LENGTH_SHORT).show();
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