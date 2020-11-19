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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.StorageTask.SnapshotBase;
import java.lang.Object;

public class CommentRecetteActivity extends AppCompatActivity {

    int numeroRecette;
    int numeroJour;
    int numeroSemaine;
    EditText Commentaire; //la view où l'utiliateur rentre le commentaire de la recette
    String commentaireRecette;   //la string associée à ce commentaire


    SharedPreferences spCaracteristiqueRecette;
    SharedPreferences.Editor editor;
    RatingBar rb;

    Intent  messageVersAccueilActivity;




    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);


        //on crée un Firebasestorage qui servira à enregistrer la photo prise et on récupère la référence de stockage
        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();



        //Recuperation des données
        Intent deRecetteActivity = getIntent();
        SharedPreferences spDate=getSharedPreferences("date",Context.MODE_PRIVATE);
        numeroJour=spDate.getInt("numeroJour",-1);
        numeroSemaine=spDate.getInt("numeroSemaine",-1);
        numeroRecette= deRecetteActivity.getIntExtra("numero recette", -1);

        //Init du sp
        spCaracteristiqueRecette = getSharedPreferences("caracteristiquesRecette", Context.MODE_PRIVATE);
        editor=spCaracteristiqueRecette.edit();
    }

    public void enregistrer(View view) {   //on récupère la note que l'utilisateur entre dans la rating bar
        RatingBar rb = findViewById(R.id.ratingBar);

        float note = rb.getRating();  //on récupère la note que l'utilisateur entre dans la rating bar
        Toast.makeText(this, "note:" + note, Toast.LENGTH_SHORT).show(); //on montre à l'utilisateur la note qu'il a mise

        Commentaire=findViewById(R.id.Commentaire);
        commentaireRecette=Commentaire.getText().toString();

        //on enregistre la note que l'utilisateur a associé à sa recette grace à un sharedPrefrences

        editor.putFloat("r" + Integer.toString(numeroRecette) + "note", note); //on met dans shared preferences la note avec l'étiquette correspondant au numero de recette
        editor.putString("r" + Integer.toString(numeroRecette) + "commentaire", commentaireRecette);
        editor.apply();

    }

    public void valider(View view) {
        rb=findViewById(R.id.ratingBar);
        enregistrer(rb);
        messageVersAccueilActivity = new Intent();

        Intent messageVersAccueilActivity = new Intent();
        messageVersAccueilActivity.setClass(this, AccueilActivity.class);
        startActivity(messageVersAccueilActivity);   //on retourne à l'acitvité principale une fois que l'utilisateur a rentré le commentaire et la note
    }


///l'utilisateur peut partager la recette par sms s'il l'a bien aimée
    public void partageSMS(View view) {

        Intent deRecetteActivity = getIntent();

        //default value à -1 pour faciliter le debut si debug il y a. il faudra la definir à 0 apres
         numeroRecette= deRecetteActivity.getIntExtra("numero recette", -1);

        Menu menu = new Menu();
        Recette recetteEnCours = menu.livreRecettes.get(numeroRecette);

        String messageSMS = String.format("Toi aussi découvre cette recette !\n"
                + recetteEnCours.getTitre() + "\n"
                + recetteEnCours.getIngredients() + "\n"
                + recetteEnCours.getTempsdecuisine() + "\n"
                + recetteEnCours.getInstructions() + "\n");
        Intent versAppSMS = new Intent(Intent.ACTION_SENDTO);
        versAppSMS.setData(Uri.parse("smsto:"));
        versAppSMS.putExtra("sms_body", messageSMS);
        Intent choixAppSMS = Intent.createChooser(versAppSMS, "Partager la recette avec :");
        startActivity(choixAppSMS);
    }


    /*
    public static Recette getCurrentRecette(){
        //Creation d'un valeur par defaut pour le sharedPreferences
        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");



        //recuperation de l'indice du jour : je n'y arrive pas. Je prends donc la recette 1 (pour changer)



        Menu menu= new Menu();


        Recette CurrentRecette= menu.livreRecettes.get(1);
        return CurrentRecette;
    }

     */


    /*
    public Recette getCurrentRecette(int jour, int semaine){


        SharedPreferences etatBouton = getSharedPreferences("etatBouton", Context.MODE_PRIVATE);

        Set listeJoursDebloques;

        //Creation d'un valeur par defaut pour le sharedPreferences
        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");

        Menu menu = new Menu();
        Vector<Recette> livreRecettes = menu.livreRecettes;

        //recuperation de nombre de jours debloqués (donne une liste, et on recupere la taille de la liste des jours debloques)
        listeJoursDebloques = etatBouton.getStringSet("boutonDebloque", defaultvalueset);
        int nombreJoursDebloques = listeJoursDebloques.size();

        Object[] tableauJoursDebloques = listeJoursDebloques.toArray();

        return (Recette)tableauJoursDebloques[nombreJoursDebloques];

    }

    //on définit le bouton qui va aller ver l'appareil photo et l'imageView qui va afficher la photo
    Button btnPrendrePhoto;
    ImageView imgAffichePhoto;
    String photoPath=null;

     */
    //on définit l'imageView qui va afficher la photo

    ImageView imgAffichePhoto;
    String photoPath=null;


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


