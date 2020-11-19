package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class AccueilActivity extends AppCompatActivity {
    //lien entre le jour et la recette
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


    }

    public void versSemaine(View view) {

        Intent versSemaine=new Intent();
        versSemaine.setClass(this,SemaineActivity.class);
        startActivity(versSemaine);
    }

    public void versConfirmation(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Nouveau Défi");
        builder.setMessage("Voulez-vous vraiment recommencer le défi ?");
        builder.setPositiveButton("C'est parti !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //garde en mémoire les boutons déjà débloqués sous la forme d'un tag "jourXsemaineY"
                        SharedPreferences spEtatBouton;

                        spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editorEtatBouton = spEtatBouton.edit();
                        editorEtatBouton.clear();

                        editorEtatBouton.putString("jour0semaine0","boutondébloqué");
                        editorEtatBouton.commit();

                        Vector<Recette> LivreRecette = Menu.getMenu();

                        //on reinitialise les données rentrées des recettes
                        sharedPreferences = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        editor.clear().commit();

                        //on récupère ce qui va nous servir à faire le lien entre le jour et les recettes
                        sharedPreferences = getSharedPreferences("lien", Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();

                        //reset du lien
                        editor.clear();

                        for (int i=0;i<LivreRecette.size();i++) {
                            editor.putString(""+i+"",""+LivreRecette.get(i).getNumeroRecette()+"");
                            Log.i("recette",sharedPreferences.getString(""+i+"","erreur"));
                        }

                        editor.apply();
                        Log.i("définition du set","effectuée");

                        Intent versModeEmploi=new Intent(getApplicationContext(), ModeEmploiActivity.class);
                        Log.i("click","bouton cliqué");
                        startActivity(versModeEmploi);
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