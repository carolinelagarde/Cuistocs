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


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(125,"grammes","de chamignons blancs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi paquet","de gnocchis a poêler"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"gousses","d'ail"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","oignon"));
        lesIngredientsdelaRecette.add(new Ingredient(10,"cL","de crème fraîche semi-épaisse"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"très petit filet","de Paterelle"));


        livreRecettes.add(new Recette(11,"Gnocchis & champignons", 30, lesIngredientsdelaRecette,
                "1. Couper finement l'oignon et l'ail.\n" +
                        "2. Dans une casserole huilée, faire revenir d'abord les champignons avec un peu de persil .\n" +
                        "3. Une fois cuits, réserver-les sur une assiette. Cuire ensuite l'oignon puis l'ail ensemble.\n" +
                        "4. Ajouter les champignons dans la casserole, avec la crème fraîche et la Paterelle. Saler et poivrer.\n" +
                        "5. Poêler les gnocchis.\n" +
                        "6. Dresser l'assiette en ajoutant du persil et pour les plus gourmands du parmesan frais."));

        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(2,"tranches","de pain"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","avocat"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","mozarella"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","tomate"));


        livreRecettes.add(new Recette(12,"Croque-monsieur à l'avocat", 15, lesIngredientsdelaRecette,
                "1. Découpez votre avocat et votre tomate en morceaux. Coupez votre boule de mozzarella en tranches.\n" +
                        "2. Chauffez votre poêle à feu moyen.\n" +
                        "3. Beurrez légèrement un côté de vos deux tranches de pain.\n" +
                        "4. Placez dans un premier temps une tranche dans la poêle.\n" +
                        "5. Par-dessus, ajoutez l’avocat, la mozzarella et les morceaux de tomate.\n" +
                        "   Versez un peu d’huile d’olive et assaisonnez enfin de sel et de poivre.\n" +
                        "   Refermez le tout avec l'autre tranche\n" +
                        "6. Dès que le premier côté est doré (au bout de 2-3 minutes environ), retournez et laissez cuire 3 minutes de plus."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"","escalope de poulet"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","carotte"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","yaourt brassé"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"mL","de lait de coco"));
        lesIngredientsdelaRecette.add(new Ingredient(70,"g","de riz basmati"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pot","de pâte de cury vert"));
        lesIngredientsdelaRecette.add(new Ingredient(2, "cuillères à soupe", "de Nuoc Mam"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée", "de paprika"));
        lesIngredientsdelaRecette.add(new Ingredient(1, "cuillère à café", "de curry en poudre"));


        livreRecettes.add(new Recette(13,"Poulet curry coco", 30, lesIngredientsdelaRecette,
                "1. Couper les escalopes en lamelles et émincer l’oignon. Préparer une julienne de carottes.\n" +
                        "2. Dans un bol, mélanger le yaourt, nuoc mam, et une cuillerée à café de curry vert.\n" +
                        "   Badigeonner la viande de ce mélange et la laisser mariner dans un saladier le temps de préparer la suite.\n" +
                        "3. Dans un wok, faire revenir à feu moyen les oignons émincés et la julienne de carottes avec un filet d'huile d'olive pendant 5 minutes.\n" +
                        "   Ajouter les fines lamelles de poulet marinées dans le wok et les faire revenir avec les légumes 10 minutes, toujours à feu moyen.\n" +
                        "4. Pendant ce temps, cuire le riz basmati dans une casserole d’eau bouillante salée. Suivre les instructions du paquet.\n" +
                        "5. Arroser la viande et les légumes avec le lait de coco, ajouter une pincée de curry et une pincée de paprika et laisser mijoter 2 minutes dans le wok.\n" +
                        "6. Déposer quelques feuilles de coriandre fraîche ciselées sur le plat. Le poulet curry coco est délicieux avec un bon riz gluant."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(55,"grammes","Quinoa"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","concombre"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","avocat"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de blanc de poulet"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","yaourt nature epais"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","citron"));
        lesIngredientsdelaRecette.add(new Ingredient(1, "demi cuillère à café", "de vinaigre de vin"));
        lesIngredientsdelaRecette.add(new Ingredient(2, "feuilles", "de persil"));
        lesIngredientsdelaRecette.add(new Ingredient(2, "brins", "de ciboulette"));
        lesIngredientsdelaRecette.add(new Ingredient(2, "feuilles", "de menthe"));


        livreRecettes.add(new Recette(14,"Salade de Quinoa au poulet, concombre et avocat", 35, lesIngredientsdelaRecette,
                "1. Faire cuire le quinoa comme indiqué sur le paquet (par absorption comme du riz blanc), soit environ 15 min.\n" +
                        "2. Pendant ce temps, détailler le poulet, les concombres et l'avocat en dés d'1 ou 2 cm (selon votre goût).\n" +
                        "3. Y ajouter du persil plat et des feuilles de menthe hachés, mélanger sans trop écraser l'avocat.\n" +
                        "   Ajouter un filet de jus de citron, sel et/ou poivre.\n" +
                        "4. Préparer la sauce au yaourt en y ajoutant du sel, du poivre, la petite cuillèrede vinaigre et la ciboulette ciselée.\n" +
                        "5. Servir dans les assiettes un lit de quinoa tiédi ou refroidi selon les goûts et la saison, y déposer dessus le mélange poulet-concombre-avocat. Napper le tout de la sauce au yaourt."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"demi pot","de sauce tomate"));
        lesIngredientsdelaRecette.add(new Ingredient(200,"grammes","de viande hachée"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi sachet","de riz"));
        lesIngredientsdelaRecette.add(new Ingredient(1," deminboîtes","de haricots rouges"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi boîtes","de maïs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","poivron rouge"));
        lesIngredientsdelaRecette.add(new Ingredient(1, "pincée", "de chili"));


        livreRecettes.add(new Recette(15,"Chili con carne", 20, lesIngredientsdelaRecette,
                "1. couper le poivron en morceaux\n" +
                        "2. le faire cuire à feu doux pendant 15min\n" +
                        "3. faire cuire le riz\n" +
                        "4. quand les poivrons sont cuits, ajouter dans la casserole la viande hachée\n" +
                        "5. ajouter le maïs\n" +
                        "6. ajouter les haricots rouges\n" +
                        "7. ajouter la sauce tomate\n" +
                        "8. ajouter du chili\n" +
                        "9. quand le riz est cuit, mélanger le tout"));



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

