package com.example.cuistocs;

public class Ingredient {
    //donne les quantités
    private int quantite;

    //donne l'unité de l'aliment
    private String unite;

    //donne le nom de l'ingredient
    private String ingredient;

    public Ingredient(int quantite, String unite, String ingredient) {
        this.quantite=quantite;
        this.unite=unite;
        this.ingredient=ingredient;
    }

    //obtenir la quantité nécessaire d'un ingrédient
    public int getQuantite() {return quantite;}

    //obtenir l'unité de l'ingrédient
    public String getUnite() {return unite;}

    //obtenir le nom de l'ingrédient
    public String getIngredient() {return ingredient;}

    //modifier les quantités des ingrédients en fonction du nombre d'invité entré
    public void quantitepourinvites(int nbInvites) {
        quantite=quantite*nbInvites;
    }

}


