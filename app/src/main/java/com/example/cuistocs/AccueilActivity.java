package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    public void versConfirmation(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Nouveau Défi");
        builder.setMessage("Voulez-vous vraiment recommencer le défi ?");
        builder.setPositiveButton("C'est parti !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        genererMenu();
                    }
                });
        builder.setNegativeButton("Non, je continue le même !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void genererMenu(){

    }
}