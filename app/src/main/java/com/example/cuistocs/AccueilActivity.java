package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import java.util.Set;
import java.util.Vector;

public class AccueilActivity extends AppCompatActivity {
    SharedPreferences.Editor editor;
    SharedPreferences sp;
    Set<String> set;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

    }

    public void versSemaine(View view) {

    }

    public void versConfirmation(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Nouveau Défi");
        builder.setMessage("Voulez-vous vraiment recommencer le défi ?");
        builder.setPositiveButton("C'est parti !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Vector<Recette> LivreRecette = Menu.getMenu();


                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        for (int i=0;i<28;i++) {
                            set.add(""+LivreRecette.get(i).getNumeroRecette()+"");
                        }

                        editor.putStringSet("setOrdre",set);
                        editor.commit();
                        Log.i("définition du set","effectuée");

                        Intent versSemaine=new Intent(getApplicationContext(), SemaineActivity.class);
                        Log.i("click","bouton cliqué");
                        startActivity(versSemaine);
                        finish();

                    }
                });
        builder.setNegativeButton("Non, je continue le même !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent versSemaine=new Intent(getApplicationContext(), SemaineActivity.class);
                Log.i("click","bouton cliqué");
                startActivity(versSemaine);
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}