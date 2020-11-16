package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

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

    public void enregistrer(View view){
        RatingBar rb=findViewById(R.id.ratingBar);
        float note= rb.getRating();
        Toast.makeText(this, "note:"+ note, Toast.LENGTH_SHORT).show();
    }
}