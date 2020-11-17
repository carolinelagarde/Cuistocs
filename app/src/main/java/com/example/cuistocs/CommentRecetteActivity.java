package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.Vector;

public class CommentRecetteActivity extends AppCompatActivity {
    String titre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);
        Intent messagedeRecetteActivity=getIntent();
        titre= messagedeRecetteActivity.getStringExtra("titre recette");

    }

    public void enregistrer(View view){   //on récupère la note que l'utilisateur entre dans la rating bar
        RatingBar rb=findViewById(R.id.ratingBar);
        float note= rb.getRating();
        Vector<Pair> NotesdesRecettes = new Vector<>();
        Toast.makeText(this, "note:"+ note, Toast.LENGTH_SHORT).show();


        //on enregistre la note que l'utilisateur a associé à sa recette
        SharedPreferences sp=getSharedPreferences("memonote", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        int numeroRecette=0;
        String rating=Integer.toString(numeroRecette);
        editor.putFloat(rating, note);  //on met dans shared preferences la note avec l'étiquette correspondant au numero de recette
        editor.apply();

    }
}