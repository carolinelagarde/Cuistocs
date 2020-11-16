package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SemaineActivity extends AppCompatActivity {

    int numeroSemaine;
    Button semaine1;
    Button semaine2;
    Button semaine3;
    Button semaine4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaine);

        Button semaine1 = findViewById(R.id.boutonSemaine1);
        Button semaine2 = findViewById(R.id.boutonSemaine2);
        Button semaine3 = findViewById(R.id.boutonSemaine3);
        Button semaine4 = findViewById(R.id.boutonSemaine4);

    }

    public void ouvrirSemaine(View view) {
        if (view.equals(semaine1)) {
            numeroSemaine = 0;
            Log.i("boutonSemaineClique", "semaine 1 selectionnee");
        }
        if (view.equals(semaine2)) {
            numeroSemaine = 1;
            Log.i("boutonSemaineClique", "semaine 2 selectionnee");
        }
        if (view.equals(semaine3)) {
            numeroSemaine = 2;
            Log.i("boutonSemaineClique", "semaine 3 selectionnee");
        }
        if (view.equals(semaine4)) {
            numeroSemaine = 3;
            Log.i("boutonSemaineClique", "semaine 4 selectionnee");
        }

        /*
        Intent versAvtivitéSemaine = new Intent();
        versAvtivitéSemaine.setClass(this, ChoixJoursAtivity.class);

        versAvtivitéSemaine.putExtra("indiceSemaine", numeroSemaine);
        startActivity(versAvtivitéSemaine);
        */
    }

}