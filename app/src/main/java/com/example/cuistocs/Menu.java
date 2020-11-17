package com.example.cuistocs;

import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Menu {
    private static Vector<Recette> livreRecettes;

    Set listeJoursDebloques;
    Set calendrierRecettes;
    SharedPreferences spSetOrdre;
    public SharedPreferences etatBouton;



    public Menu(){
        livreRecettes=new Vector<>();

        Vector<Ingredient> lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(25,"g","mozarella"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","oeufs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"bouquet","ciboulette"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","sel"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","poivre"));

        livreRecettes.add(new Recette(1,"Omelette ciboulette et mozzarella",10,lesIngredientsdelaRecette,"1) Coupez la mozzarella en 12 morceaux"+"/n"+"2) Cassez les oeufs et fouettez les avec le sel, le poivre et la ciboulette coupée finement"+"/n"+"3) Faire cuire les oeufs sur une poele pendant deux à trois minutes"+"/n"+"4) parsemez les oeufs de mozzarella, couvrez et laissez cuire 7 mn environ, à feu doux, sans y toucher, jusqu’à ce que l’omelette soit juste prise"));

      lesIngredientsdelaRecette=new Vector<>();


        lesIngredientsdelaRecette.add(new Ingredient(1,"","tortilla de blé"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","champignon de Paris"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(5,"","tagliatelles de courgette"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"boule","mozarella"));

        livreRecettes.add(new Recette(2,"Tortizza végétarienne",5,lesIngredientsdelaRecette,"1) Prechauffez le four a 210 degres /n 2) Coupez les tomates-cerises en deux, le champignon en lamelles, et la mozzarella en morceaux. /n"+ "3) Etalez le coulis de tomate sur toute la surface de la tortilla. /n 4) Répartissez-y les tomates-cerises, les lamelles de champignon, les tagliatelles de courgette, les morceaux de mozzarella et le fromage râpé. /n 5) Enfournez 13 min. Servez immédiatement."));


}
    public static Vector<Recette> getMenu(){
        Vector<Recette> Menu=new Vector<>(livreRecettes.size());
        Collections.copy(Menu,livreRecettes);
        Collections.shuffle(Menu);
        for (int i=28;i<Menu.size();i++){
            Menu.remove(i);
        }
        return Menu;
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

        return (Recette) tableauJoursDebloques[nombreJoursDebloques];

    }

}

