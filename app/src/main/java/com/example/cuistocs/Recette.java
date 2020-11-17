package com.example.cuistocs;

import java.util.Vector;

public class Recette {
    //titre
    private String titre;

    //ingrédients
    private Vector<Ingredient> lesIngredients;

    //les instructions
    private String instructions;

    //temps
    private int tempsdecuisine;

    // numéro recette
    private int numeroRecette;


    public Recette(int numeroRecette, String titre, int tempsdecuisine, Vector<Ingredient> lesIngredients, String instructions) {
        this.titre=titre;
        this.numeroRecette=numeroRecette;
        this.tempsdecuisine=tempsdecuisine;
        this.lesIngredients=lesIngredients;
        this.instructions=instructions;
    }


    //obtenir le titre de la recette
    public String getTitre() { return titre; }

    //obtenir les ingrédients avec ses quantités
    public Vector<Ingredient> getIngredients() { return lesIngredients; }

    //obtenir le temps de cuisine nécessaire
    public int getTempsdecuisine() { return tempsdecuisine; }

    //obtenir les instructions de cuisine
    public String getInstructions() { return instructions; }

    //obtenir numero de recette
    public int getNumeroRecette(){return numeroRecette;}
}


