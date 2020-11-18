package com.example.cuistocs;

import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Menu {
    public static Vector<Recette> livreRecettes;


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

        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"filet","de saumon"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","de sauce soja"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"petite cuillère à café","de sucre"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"pincées","de poivre"));
        lesIngredientsdelaRecette.add(new Ingredient(8,"grammes","de beurre"));
        lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz"));

        livreRecettes.add(new Recette(3,"Saumon Teriyaki",20,lesIngredientsdelaRecette, "1) Mélanger le soja, le sucre, et si vous avez, une touche de gingemmbre. /n 2)Mettre le saumon, avec quelques incisions dans un plat creux, verser la marinade dessus et laisser mariner 15 minutes. /n 3) Faire bouillir de l'eau pour le riz. 4)Verser le riz dans une casserole. /n 5)Verser la marinade dans une autre casserole avec le beurre, à feu doux, et mélanger jusqu'à avoir une sauce homogène. En même temps, faire cuire le saumon à la poêle 3 minutes de chaque côté. /n  6)Saler, poivrer. C'est prêt! Servir le saumon avec le riz et la sauce."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(3,"parts","de pâte à pizza"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"tranches","de jambon"));
        lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de parmesan"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","mozza di Buffala"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de sauce tomate"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi gousses","d'ail"));
        lesIngredientsdelaRecette.add(new Ingredient(3,"feuilles","de basilic"));

        livreRecettes.add(new Recette(4,"Pizza rosso", 30, lesIngredientsdelaRecette, "1)Préchauffer le four. /n 2)Faire revenir l'ail découpé en petis morceaux quelques minutes. Pendant ce temps couper les tomates cerises en deux et étaler la pâte à pizza. /n 3)Incorporer l'ail avec la sauce tomate et un peu d'huile d'olive. /n 4)Déposer sur la pâte la sauce tomate préparée et les tomates cerises. Enfourner /n 5)Après 15 minutes de cuisson, serir la pizza en ayant déposé dessus la mozzarella découpée en morceaux et les feuilles de basilic."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz à risotto"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s)","oignon"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"centilitres","de bouillon de volaille"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de parmesan"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à soupe","d'huile d'olive"));
        lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de beurre"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s) verre(s)","de vin blanc sec"));


        livreRecettes.add(new Recette(5,"Risotto", 40, lesIngredientsdelaRecette, "1)Commencez par chauffer votre bouillon de volaille dans une première casserole. Pendant ce temps, pelez l'oignon, émincez-le finement et faites-le revenir à feu vif et à découvert, pendant quelques minutes (le temps de le colorer), dans une seconde casserole (assez grande, et de préférence anti-adhésive) avec l'huile d'olive et la moitié du beurre. Ajoutez ensuite le riz pour risotto et mélangez bien le tout, puis déglacez avec le vin blanc et faites le évaporer. /n 2)Pour une cuisson du riz parfaite, incorporez à l’aide d’une louche une partie du bouillon dans votre risotto. Laissez tout d'abord le riz bien absorber le bouillon, puis mélangez ensuite pendant plusieurs minutes pour que l'amidon se répande dans le risotto, et lui donne sa consistance moelleuse. En respectant la même procédure que précédemment, incorporez toujours de la même manière le reste de bouillon. /n 3)Une fois le riz parfaitement cuit (il doit être moelleux mais pas mou pour autant), ajoutez le beurre restant et la moitié du parmesan râpé. Salez et poivrez à votre convenance, et servez votre risotto bien chaud, en disposant l'autre moitié de parmesan de façon à ce que vos invités puissent le saupoudrer eux-même sur leur assiette.  /n ASTUCE: Vous ouvez agrémneter votre risotto avec des champignons par exemple que vous rajoutez après les avoir cuits en fin de cuisson." ));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"quart(s)","d'oignon rouge"));
        lesIngredientsdelaRecette.add(new Ingredient(20,"grammes","de feta"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"tier(s)","de concombre"));
        lesIngredientsdelaRecette.add(new Ingredient(3,"","olives noires"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de vinaigre"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","d'huile d'olive"));


        livreRecettes.add(new Recette(6,"Salade grecque", 15, lesIngredientsdelaRecette, "1)Lavez et coupez en quatre les tomates cerise. Nettoyez puis taillez le concombre en deux dans la longueur, puis en rondelles. Pelez, dégermez et émincez finement l’oignon rouge. Découpez la feta en cubes. Coupez en deux les olives noires, puis dénoyautez-les. /n 2)Dans un saladier, préparez la vinaigrette en mélangeant ensemble l’huile d’olive et le vinaigre de vin rouge. Saupoudrez d’herbes de Provence et assaisonnez de sel et de poivre, selon votre goût. Émulsionnez bien. /n 3)Ajoutez dans le saladier les olives noires dénoyautées, les cubes de feta, les tomates cerises, les rondelles de concombre et l’oignon rouge émincé. Remuez pour bien répartir la sauce dans toute la salade à la grecque. /n 4)C'est prêt! Servez et dégustez!"));




    }
    public static Vector<Recette> getMenu(){
        Menu test= new Menu();
        Vector<Recette> Menu=new Vector<>();
        for(int i=0;i<test.livreRecettes.size();i++) {
            Menu.add(test.livreRecettes.get(i));
        }
        Collections.shuffle(Menu);
        //for (int i=28;i<Menu.size();i++){
            //Menu.remove(i);
       // }
        return Menu;
    }



}

