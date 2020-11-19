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

//CETTE ACTIVITÉ EST LA PAGE D'ACCUEIL DE L'APPLICATION QUI PERMET DE REINITIALISER LE DEFI OU DE LE CONTINUER
public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    }

    //fonction du bouton "je continue mon défi" qui envoie directement à l'activité semaine
    public void versSemaine(View view) {

        Intent versSemaine=new Intent();
        versSemaine.setClass(this,SemaineActivity.class);
        startActivity(versSemaine);
    }

    //fonction du bouton "je commence le défi" : comme sa réinitialise le défi, demande confirmation
    public void versConfirmation(View view) {

        //demande la confirmation ou non via un alerte dialogue builder
        AlertDialog.Builder builderRecommencer = new AlertDialog.Builder(this);
        builderRecommencer.setCancelable(false);
        builderRecommencer.setTitle("Nouveau Défi");
        builderRecommencer.setMessage("Voulez-vous vraiment recommencer le défi ?");
        builderRecommencer.setPositiveButton("C'est parti !", new DialogInterface.OnClickListener() {

            //on a cliqué sur recommencer le défi : on initialise toutes les données
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //ce shared preferences garde en mémoire les boutons déjà débloqués sous la forme d'un tag "jourXsemaineY"
                        SharedPreferences spEtatBouton;
                        spEtatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editorEtatBouton = spEtatBouton.edit();

                        //on réinitialise : tous les boutons sont initialement bloqués sauf le bouton du 1er jour
                        editorEtatBouton.clear();
                        editorEtatBouton.putString("jour0semaine0","boutondébloqué");
                        editorEtatBouton.commit();

                        //on reinitialise
                        spEtatBouton = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
                        spEtatBouton.edit().clear().commit();


                        //demande si vege ou non dans un builder
                        AlertDialog.Builder builderVege = new AlertDialog.Builder(builderRecommencer.getContext());
                        builderVege.setCancelable(false);
                        builderVege.setTitle("Defi végétarien");
                        builderVege.setMessage("Veux-tu essayer le mode végétarien ?");
                        builderVege.setPositiveButton("Oui, je veux sauver la planète", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        //on créé un ensemble de recettes
                                        Vector<Recette> LivreRecette = Menu.getMenuVege();

                                        //on réinitialise les données des recettes effectuées
                                        SharedPreferences sharedPreferences = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.clear().commit();

                                        //ce shared preferences permet de faire le lien entre le jour et les recettes :
                                        // à chaque jour est assigné une recette pour tout le défi
                                        sharedPreferences = getSharedPreferences("lien", Context.MODE_PRIVATE);
                                        editor = sharedPreferences.edit();

                                        //réinitialisation du lien
                                        editor.clear();

                                        //création du nouveau lien aléatoire
                                        for (int i = 0; i < LivreRecette.size(); i++) {
                                            editor.putString("" + i + "", "" + LivreRecette.get(i).getNumeroRecette() + "");
                                            Log.i("recette", sharedPreferences.getString("" + i + "", "erreur"));
                                        }
                                        editor.apply();

                                        //on passe à l'activité mode d'emploi
                                        Intent versModeEmploi = new Intent(getApplicationContext(), ModeEmploiActivity.class);
                                        startActivity(versModeEmploi);
                                        finish();

                                    }

                                });

                            builderVege.setNegativeButton("Non, je trie déjà mes déchets", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //on créé un ensemble de recettes
                                            Vector<Recette> LivreRecette = Menu.getMenu();

                                            //on réinitialise les données des recettes effectuées
                                            SharedPreferences sharedPreferences = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.clear().commit();

                                            //ce shared preferences permet de faire le lien entre le jour et les recettes :
                                            // à chaque jour est assigné une recette pour tout le défi
                                            sharedPreferences = getSharedPreferences("lien", Context.MODE_PRIVATE);
                                            editor = sharedPreferences.edit();

                                            //réinitialisation du lien
                                            editor.clear();

                                            //création du nouveau lien aléatoire
                                            for (int i=0;i<LivreRecette.size();i++) {
                                                editor.putString(""+i+"",""+LivreRecette.get(i).getNumeroRecette()+"");
                                                Log.i("recette",sharedPreferences.getString(""+i+"","erreur"));
                                            }
                                            editor.apply();

                                            //on passe à l'activité mode d'emploi
                                            Intent versModeEmploi=new Intent(getApplicationContext(), ModeEmploiActivity.class);
                                            startActivity(versModeEmploi);
                                            finish();

                                        }
                                    });

                        AlertDialog dialogVege = builderVege.create();
                        dialogVege.show();



                    }
                });

                //finalement l'utilisateur clique sur continuer le meme défi : il est envoyé directement à l'activité semaine
                builderRecommencer.setNegativeButton("Non, je continue le même !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent versSemaine=new Intent(getApplicationContext(), SemaineActivity.class);
                        startActivity(versSemaine);
                        finish();
                    }
                });

                AlertDialog dialogRecommencer = builderRecommencer.create();
                dialogRecommencer.show();
    }


}