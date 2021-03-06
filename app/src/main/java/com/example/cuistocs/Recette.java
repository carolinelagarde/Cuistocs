package com.example.cuistocs;

import java.util.Vector;


// CETTE CLASSE DEFINIT LES RECETTES. CHAQUE RECETTE EST CARACTERISEE PAR UN BOULÉEN DE UN NUMERO, SON TITRE, LE TEMPS DE PREPARATION, LE VECTEUR DES INGREDIENTS, INSTRUCTIONS.

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


    private boolean vegetarien;


    public Recette(boolean vegetarien, int numeroRecette, String titre, int tempsdecuisine, Vector<Ingredient> lesIngredients, String instructions) {
        this.titre = titre;
        this.numeroRecette = numeroRecette;
        this.tempsdecuisine = tempsdecuisine;
        this.lesIngredients = lesIngredients;
        this.instructions = instructions;
        this.vegetarien = vegetarien;
    }

    public Vector<Recette> livreRecettes;
    private Vector<Ingredient> lesIngredientsdelaRecette;

    //obtenir le titre de la recette
    public String getTitre() {
        return titre;
    }

    //obtenir les ingrédients avec ses quantités
    public Vector<Ingredient> getIngredients() {
        return lesIngredients;
    }

    //obtenir le temps de cuisine nécessaire
    public int getTempsdecuisine() {
        return tempsdecuisine;
    }

    //obtenir les instructions de cuisine
    public String getInstructions() {
        return instructions;
    }

    //obtenir numero de recette
    public int getNumeroRecette() {
        return numeroRecette;
    }

    //obtenir boolean vegetarien
    public boolean isVegetarien() { return vegetarien; }

}


