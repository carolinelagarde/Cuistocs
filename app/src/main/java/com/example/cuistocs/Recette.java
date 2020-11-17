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

    /** creer une nouvelle recette
     *
     */

    public Recette(int numeroRecette, String titre, int tempsdecuisine, Vector<Ingredient> lesIngredients, String instructions) {
        this.titre=titre;
        this.numeroRecette=numeroRecette;
        this.tempsdecuisine=tempsdecuisine;
        this.lesIngredients=lesIngredients;
        this.instructions=instructions;
    }

    public Vector<Recette> livreRecettes;
    private Vector<Ingredient> lesIngredientsdelaRecette;

    private void livreRecettes() {


        lesIngredientsdelaRecette.add(new Ingredient(25,"g","mozarella"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","oeufs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"bouquet","ciboulette"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","sel"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","poivre"));

        livreRecettes.add(new Recette(1,"Omelette ciboulette et mozzarella",10,lesIngredientsdelaRecette,"1) Coupez la mozzarella en 12 morceaux"+"/n"+"2) Cassez les oeufs et fouettez les avec le sel, le poivre et la ciboulette coupée finement"+"/n"+"3) Faire cuire les oeufs sur une poele pendant deux à trois minutes"+"/n"+"4) parsemez les oeufs de mozzarella, couvrez et laissez cuire 7 mn environ, à feu doux, sans y toucher, jusqu’à ce que l’omelette soit juste prise"));

        livreRecettes=new Vector<Recette>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"","tortilla de blé"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","champignon de Paris"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(5,"","tagliatelles de courgette"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"boule","mozarella"));

        livreRecettes.add(new Recette(2,"Tortizza végétarienne",5,lesIngredientsdelaRecette,"1) Prechauffez le four a 210 degres /n 2) Coupez les tomates-cerises en deux, le champignon en lamelles, et la mozzarella en morceaux. /n"+ "3) Etalez le coulis de tomate sur toute la surface de la tortilla. /n 4) Répartissez-y les tomates-cerises, les lamelles de champignon, les tagliatelles de courgette, les morceaux de mozzarella et le fromage râpé. /n 5) Enfournez 13 min. Servez immédiatement."));

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


