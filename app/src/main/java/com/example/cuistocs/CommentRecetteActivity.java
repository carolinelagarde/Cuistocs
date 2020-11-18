package com.example.cuistocs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

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
import android.content.ContentProvider;
import androidx.core.content.FileProvider;

public class CommentRecetteActivity extends AppCompatActivity {

    int numeroRecette;
    EditText commentaireRecetteEditText;  //la view où l'utiliateur rentre le commentaire de la recette
    String commentaireRecette;   //la string associée à ce commentaire
    Recette recetteEnCours;

    Set listeJoursDebloques;
    Set calendrierRecettes;
    SharedPreferences spSetOrdre;
    SharedPreferences spCaracteristiqueRecette;
    public SharedPreferences etatBouton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recette);

        spCaracteristiqueRecette=getSharedPreferences("fini",Context.MODE_PRIVATE);
        editor=spCaracteristiqueRecette.edit();

        recetteEnCours = getCurrentRecette(); //on recupere la recette en cours

    }

    public void enregistrer(View view) {   //on récupère la note que l'utilisateur entre dans la rating bar
        RatingBar rb = findViewById(R.id.ratingBar);

        float note = rb.getRating();  //on récupère la note que l'utilisateur entre dans la rating bar
        Toast.makeText(this, "note:" + note, Toast.LENGTH_SHORT).show(); //on montre à l'utilisateur la note qu'il a mise


        //on enregistre la note que l'utilisateur a associé à sa recette grace à un sharedPrefrences
        SharedPreferences sp = getSharedPreferences("memonote", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat("r" + numeroRecette + "note", note); //on met dans shared preferences la note avec l'étiquette correspondant au numero de recette
        editor.putString("r" + numeroRecette + "commentaire", commentaireRecette);
        editor.apply();

    }

    public void valider(View view) {
        Intent messageVersAccueilActivity = new Intent();
        // messageVersAccueilActivity.setClass(this, AccueilActivity.class);
        startActivity(messageVersAccueilActivity);   //on retourne à l'acitvité principale une fois que l'utilisateur a rentré le commentaire et la note
    }


///l'utilisateur peut partager la recette par sms s'il l'a bien aimée
    public void partageSMS(View view) {

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

    public Recette getCurrentRecette(){
        //Creation d'un valeur par defaut pour le sharedPreferences
        Set<String> defaultvalueset= new HashSet<>();
        defaultvalueset.add("");

        calendrierRecettes = spSetOrdre.getStringSet("setOrdre", defaultvalueset);

        //recuperation de l'indice du jour
        listeJoursDebloques = etatBouton.getStringSet("boutonDebloque", defaultvalueset);
        int nombreJoursDebloques = listeJoursDebloques.size();

        Object[] tableauJoursDebloques = listeJoursDebloques.toArray();

        return (Recette)tableauJoursDebloques[nombreJoursDebloques];

    }

    //on définit le bouton qui va aller ver l'appareil photo et l'imageView qui va afficher la photo
    Button btnPrendrePhoto;
    ImageView imgAffichePhoto;
    String photoPath=null;

    public void prendrePhoto(View view) {


        btnPrendrePhoto=findViewById(R.id.btnPrendrePhoto);

        //on crée un intent pour ouvri la fenêtre pour prendre la photo
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager())!= null) { //on vérifie que l'intent peut être crée
            //création d'un fichier pour la photo
            String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); //on aura la date précise de la photo
            File photoDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try{
                File photoFile= File.createTempFile("photo"+time,".jpg", photoDir);
                //on enregistre le chemin complet
                photoPath=photoFile.getAbsolutePath();
                //crée l'URI
                Uri photoUri= FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider",photoFile);
                //transfert uri vers l'intent pour enregistrer la photo dans un fichier temporaire
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                //on ouvre l'activité par rapport à l'intent
                startActivityForResult(intent,1);
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }


    }

    //retour de l'appareil photo après le startactivityforresult
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //vérifie le code de retour et l'état du retour ok
        if(requestCode==1 && resultCode==RESULT_OK) {
            //récupérer l'image
            Bitmap image= BitmapFactory.decodeFile(photoPath);
            //afficher l'image
            imgAffichePhoto.setImageBitmap(image);
        }

    }

}