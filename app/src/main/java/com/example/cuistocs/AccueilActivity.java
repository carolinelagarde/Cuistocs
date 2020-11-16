package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

    }

    public void versSemaine(View view) {
        Intent versSemaine=new Intent(this, SemaineActivity.class);
        Log.i("click","bouton cliqué");
        startActivity(versSemaine);
        finish();
    }
}