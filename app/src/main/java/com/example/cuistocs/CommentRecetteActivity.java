package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import android.content.ContentProvider;
import androidx.core.content.FileProvider;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.StorageTask.SnapshotBase;
import java.lang.Object;

//CETTE ACTIVITÉ PERMET DE COMMENTER, NOTER, PRENDRE UNE PHOTO DE SA RECETTE, ET L'ENVOYER PAR SMS
// PUIS ON EST RENVOYÉ A L'ACTIVITÉ SEMAINE
public class CommentRecetteActivity extends AppCompatActivity {

    //numero de la semaine juste réalisée
    int numeroRecette;

    //numero du jour et de la semaine de la recette
    int numeroJour;
    int numeroSemaine;

    //la view où l'utiliateur rentre le commentaire de la recette
    EditText Commentaire;

    //la string associée à ce commentaire
    String commentaireRecette;

    //la mémoire
    SharedPreferences spCaracteristiqueRecette;
    SharedPreferences.Editor editor;

    //donner sa note
    RatingBar rb;

    //de quoi stocker les photos
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);

        //on crée un Firebasestorage qui servira à enregistrer la photo prise et on récupère la référence de stockage
        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();

        //Recuperation des données : jour, semaine et numero de recette
        SharedPreferences spDate=getSharedPreferences("date",Context.MODE_PRIVATE);
        numeroJour=spDate.getInt("numeroJour",-1);
        numeroSemaine=spDate.getInt("numeroSemaine",-1);
        Intent deRecetteActivity = getIntent();
        numeroRecette= deRecetteActivity.getIntExtra("numero recette", -1);

        //Init du shared preferences pour les données de la recette
        spCaracteristiqueRecette = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        editor=spCaracteristiqueRecette.edit();
    }

    //fonction pour valider nos entrées
    public void valider(View view) {

        //enregistre la note et le commentaire (voir fonction ci-dessous)
        rb=findViewById(R.id.ratingBar);
        enregistrer(rb);

        //on retourne à l'acitvité semaine une fois que l'utilisateur a rentré le commentaire et la note
        Intent messageVersSemaineActivity = new Intent(getApplicationContext(),SemaineActivity.class);
        startActivity(messageVersSemaineActivity);

        //on ne peut pas revenir a l'écran commentaire apres
        finish();
    }

    //fonction d'enregistrer la note et le commentaire
    public void enregistrer(View view) {

        //on récupère la note que l'utilisateur entre dans la rating bar
        float note = rb.getRating();

        //on montre à l'utilisateur la note qu'il a mise
        Toast.makeText(this, "note:" + note, Toast.LENGTH_SHORT).show();

        //on enregistre la note que l'utilisateur a associé à sa recette grace à un sharedPrefrences
        editor.putFloat("r" + Integer.toString(numeroRecette) + "note", note);

        //on enregistre aussi le commentaire de l'utilisateur pour cette recette
        commentaireRecette=Commentaire.getText().toString();
        editor.putString("r" + Integer.toString(numeroRecette) + "commentaire", commentaireRecette);
        editor.apply();
    }

    ///l'utilisateur peut partager la recette par sms s'il l'a bien aimée
    public void partageSMS(View view) {

        //récupère numéro de la semaine puis la recette
        Intent deRecetteActivity = getIntent();
        numeroRecette= deRecetteActivity.getIntExtra("numero recette", -1);

        Menu menu = new Menu();
        Recette recetteEnCours = menu.livreRecettes.get(numeroRecette);

        //créé le sms
        Vector<Ingredient> Vecteuringredients = recetteEnCours.getIngredients();
        String corps = "";
        for (int i=0; i<Vecteuringredients.size();i++) {
            corps= corps + Vecteuringredients.get(i).getQuantité(1) +" " + Vecteuringredients.get(i).getUnite() + " " + Vecteuringredients.get(i).getIngredient() + "\n";
        }
        String messageSMS = String.format("Toi aussi découvre cette recette !\nLes quantités sont pour une personne. \n "
                + "Elle s'appelle " + recetteEnCours.getTitre() + "\n"
                + corps + "\n"
                + "Temps de préparation :" + recetteEnCours.getTempsdecuisine() + "minutes \n \n"
                + "Instructions : \n "
                + recetteEnCours.getInstructions() + "\n");

        //on envoie le sms
        Intent versAppSMS = new Intent(Intent.ACTION_SENDTO);
        versAppSMS.setData(Uri.parse("smsto:"));
        versAppSMS.putExtra("sms_body", messageSMS);
        Intent choixAppSMS = Intent.createChooser(versAppSMS, "Partager la recette avec :");
        startActivity(choixAppSMS);
    }

    //on définit l'imageView qui va afficher la photo
    ImageView imgAffichePhoto;
    String photoPath=null;

    //fonction de prendre la photo
    public void prendrePhoto(View view) {

        //on crée un intent pour ouvri la fenêtre pour prendre la photo
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager())!= null) { //on vérifie que l'intent peut être crée
            //création d'un fichier pour la photo
            String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); //on aura la date précise de la photo
            File photoDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try {
                File photoFile = File.createTempFile("photo" + time, ".jpg", photoDir);
                //on enregistre le chemin complet
                photoPath = photoFile.getAbsolutePath();
                //crée l'URI
                Uri photoUri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", photoFile);
                //transfert uri vers l'intent pour enregistrer la photo dans un fichier temporaire
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                //on ouvre l'activité par rapport à l'intent
                startActivityForResult(intent, 1);


                //on upload la photo dans firebase
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
                ref.putFile(Uri.parse(photoPath))
                       // .addOnSuccessListener(new OnSuccessListener() {
                            //public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                              //  progressDialog.dismiss();
                           // }
                      // })
                        .addOnFailureListener(new OnFailureListener() {
                            public void onFailure(Exception e) {
                                progressDialog.dismiss();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                        .getTotalByteCount());
                                progressDialog.setMessage("Uploaded" + (int)progress + "%");
                            }
                        });
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

        //retour de l'appareil photo après le startactivityforresult
        protected void onActivityResult(int requestCode,int resultCode,Intent data){
            imgAffichePhoto=findViewById(R.id.imageViewAfficherPhoto);
            super.onActivityResult(requestCode,resultCode,data);

            //vérifie le code de retour et l'état du retour ok
            if(requestCode==1 && resultCode==RESULT_OK) {
                //récupérer l'image
                Bitmap image= BitmapFactory.decodeFile(photoPath);
                //afficher l'image
                imgAffichePhoto.setImageBitmap(image);

                //pour transférer l'image à l'activité où on voit les recettes faites
               // Intent messageVersAfficherRecettesEffectueesActivity= new Intent(this, AfficherRecettesEffectueesActivity.class);
                //messageVersAfficherRecettesEffectueesActivity.putExtra("BitmapImage", image);
            }
        }
    }


