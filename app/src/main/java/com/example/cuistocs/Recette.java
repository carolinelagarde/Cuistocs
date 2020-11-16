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

    /** creer une nouvelle recette
     *
     */

    public Recette(String titre, int tempsdecuisine, Vector<Ingredient> lesIngredients, String instructions) {
        this.titre=titre;
        this.tempsdecuisine=tempsdecuisine;
        this.lesIngredients=lesIngredients;
        this.instructions=instructions;
    }

    private Vector<Recette> livreRecettes;
    private Vector<Ingredient> lesIngredientsdelaRecette;

    public void livreRecettes() {
        livreRecettes=new Vector<Recette>();

        lesIngredientsdelaRecette.add(new Ingredient(25,"g","mozarella"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","oeufs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"bouquet","ciboulette"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","sel"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","poivre"));

        livreRecettes.add(new Recette("Omelette ciboulette et mozzarella",10,lesIngredientsdelaRecette,"1) Coupez la mozzarella en 12 morceaux"+"/n"+"2) Cassez les oeufs et fouettez les avec le sel, le poivre et la ciboulette coupée finement"+"/n"+"3) Faire cuire les oeufs sur une poele pendant deux à trois minutes"+"/n"+"4) parsemez les oeufs de mozzarella, couvrez et laissez cuire 7 mn environ, à feu doux, sans y toucher, jusqu’à ce que l’omelette soit juste prise"));
    }

    //obtenir le titre de la recette
    public String getTitre() { return titre; }

    //obtenir les ingrédients avec ses quantités
    public Vector<Ingredient> getIngredients() { return lesIngredients; }

    //obtenir le temps de cuisine nécessaire
    public int getTempsdecuisine() { return tempsdecuisine; }

    //obtenir les instructions de cuisine
    public String getInstructions() { return instructions; }
}


