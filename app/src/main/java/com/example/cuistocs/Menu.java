package com.example.cuistocs;

import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
//CETTE CLASSE PERMET DE RETROUVER LES RECETTES ENREGISTREES
public class Menu {
    public static Vector<Recette> livreRecettes;

//Le constructeur contient toutes les recettes
    public Menu(){
        livreRecettes=new Vector<>();

        Vector<Ingredient> lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(25,"g","mozarella"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","oeufs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"bouquet","ciboulette"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","sel"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","poivre"));

        livreRecettes.add(new Recette(true, 1,"Omelette ciboulette et mozzarella",10,lesIngredientsdelaRecette,"1) Coupez la mozzarella en 12 morceaux"+"/n"+"2) Cassez les oeufs et fouettez les avec le sel, le poivre et la ciboulette coupée finement"+"/n"+"3) Faire cuire les oeufs sur une poele pendant deux à trois minutes"+"/n"+"4) parsemez les oeufs de mozzarella, couvrez et laissez cuire 7 mn environ, à feu doux, sans y toucher, jusqu’à ce que l’omelette soit juste prise"));

      lesIngredientsdelaRecette=new Vector<>();


        lesIngredientsdelaRecette.add(new Ingredient(1,"","tortilla de blé"));
        lesIngredientsdelaRecette.add(new Ingredient(4,"","tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","champignon de Paris"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
        lesIngredientsdelaRecette.add(new Ingredient(5,"","tagliatelles de courgette"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"boule","mozarella"));

        livreRecettes.add(new Recette(true, 2,"Tortizza végétarienne",5,lesIngredientsdelaRecette,"1) Prechauffez le four a 210 degres /n 2) Coupez les tomates-cerises en deux, le champignon en lamelles, et la mozzarella en morceaux. /n"+ "3) Etalez le coulis de tomate sur toute la surface de la tortilla. /n 4) Répartissez-y les tomates-cerises, les lamelles de champignon, les tagliatelles de courgette, les morceaux de mozzarella et le fromage râpé. /n 5) Enfournez 13 min. Servez immédiatement."));

        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"filet","de saumon"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","de sauce soja"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"petite cuillère à café","de sucre"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"pincées","de poivre"));
        lesIngredientsdelaRecette.add(new Ingredient(8,"grammes","de beurre"));
        lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz"));

        livreRecettes.add(new Recette(false, 3,"Saumon Teriyaki",20,lesIngredientsdelaRecette, "1) Mélanger le soja, le sucre, et si vous avez, une touche de gingemmbre. /n 2)Mettre le saumon, avec quelques incisions dans un plat creux, verser la marinade dessus et laisser mariner 15 minutes. /n 3) Faire bouillir de l'eau pour le riz. 4)Verser le riz dans une casserole. /n 5)Verser la marinade dans une autre casserole avec le beurre, à feu doux, et mélanger jusqu'à avoir une sauce homogène. En même temps, faire cuire le saumon à la poêle 3 minutes de chaque côté. /n  6)Saler, poivrer. C'est prêt! Servir le saumon avec le riz et la sauce."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(3,"parts","de pâte à pizza"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"tranches","de jambon"));
        lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de parmesan"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","mozza di Buffala"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de sauce tomate"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi gousses","d'ail"));
        lesIngredientsdelaRecette.add(new Ingredient(3,"feuilles","de basilic"));

        livreRecettes.add(new Recette(false, 4,"Pizza rosso", 30, lesIngredientsdelaRecette, "1)Préchauffer le four. /n 2)Faire revenir l'ail découpé en petis morceaux quelques minutes. Pendant ce temps couper les tomates cerises en deux et étaler la pâte à pizza. /n 3)Incorporer l'ail avec la sauce tomate et un peu d'huile d'olive. /n 4)Déposer sur la pâte la sauce tomate préparée et les tomates cerises. Enfourner /n 5)Après 15 minutes de cuisson, serir la pizza en ayant déposé dessus la mozzarella découpée en morceaux et les feuilles de basilic."));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz à risotto"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s)","oignon"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"centilitres","de bouillon de volaille"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de parmesan"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à soupe","d'huile d'olive"));
        lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de beurre"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s) verre(s)","de vin blanc sec"));


        livreRecettes.add(new Recette(false, 5,"Risotto", 40, lesIngredientsdelaRecette, "1)Commencez par chauffer votre bouillon de volaille dans une première casserole. Pendant ce temps, pelez l'oignon, émincez-le finement et faites-le revenir à feu vif et à découvert, pendant quelques minutes (le temps de le colorer), dans une seconde casserole (assez grande, et de préférence anti-adhésive) avec l'huile d'olive et la moitié du beurre. Ajoutez ensuite le riz pour risotto et mélangez bien le tout, puis déglacez avec le vin blanc et faites le évaporer. /n 2)Pour une cuisson du riz parfaite, incorporez à l’aide d’une louche une partie du bouillon dans votre risotto. Laissez tout d'abord le riz bien absorber le bouillon, puis mélangez ensuite pendant plusieurs minutes pour que l'amidon se répande dans le risotto, et lui donne sa consistance moelleuse. En respectant la même procédure que précédemment, incorporez toujours de la même manière le reste de bouillon. /n 3)Une fois le riz parfaitement cuit (il doit être moelleux mais pas mou pour autant), ajoutez le beurre restant et la moitié du parmesan râpé. Salez et poivrez à votre convenance, et servez votre risotto bien chaud, en disposant l'autre moitié de parmesan de façon à ce que vos invités puissent le saupoudrer eux-même sur leur assiette.  /n ASTUCE: Vous ouvez agrémneter votre risotto avec des champignons par exemple que vous rajoutez après les avoir cuits en fin de cuisson." ));


        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de tomates cerises"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"quart(s)","d'oignon rouge"));
        lesIngredientsdelaRecette.add(new Ingredient(20,"grammes","de feta"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"tier(s)","de concombre"));
        lesIngredientsdelaRecette.add(new Ingredient(3,"","olives noires"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de vinaigre"));
        lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","d'huile d'olive"));


        livreRecettes.add(new Recette(true, 6,"Salade grecque", 15, lesIngredientsdelaRecette, "1)Lavez et coupez en quatre les tomates cerise. Nettoyez puis taillez le concombre en deux dans la longueur, puis en rondelles. Pelez, dégermez et émincez finement l’oignon rouge. Découpez la feta en cubes. Coupez en deux les olives noires, puis dénoyautez-les. /n 2)Dans un saladier, préparez la vinaigrette en mélangeant ensemble l’huile d’olive et le vinaigre de vin rouge. Saupoudrez d’herbes de Provence et assaisonnez de sel et de poivre, selon votre goût. Émulsionnez bien. /n 3)Ajoutez dans le saladier les olives noires dénoyautées, les cubes de feta, les tomates cerises, les rondelles de concombre et l’oignon rouge émincé. Remuez pour bien répartir la sauce dans toute la salade à la grecque. /n 4)C'est prêt! Servez et dégustez!"));

        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"","oeuf(s)"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"filet(s)","de poulet"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","petite salade verte"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"poignée(s)","de roquette"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","oignon doux"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de mimolette"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de yaourt ou fromage blanc"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de moutarde à l'ancienne"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de câpres"));



        livreRecettes.add(new Recette(false, 7,"Salade de poulet à la mimolette", 15, lesIngredientsdelaRecette, "1) Plongez les œufs dans une casserole d’eau bouillante et laissez-les cuire 8 mn. Passez-les aussitôt sous l’eau froide, roulez-les pour fendiller la coquille et laissez-les refroidir dans de l’eau froide. \n 2) Faites cuire les filets de poulet incisés et posés bien à plat dans une poêle huilée bien chaude, 3 à 4 mn de chaque côté, jusqu’à ce qu’ils soient dorés. Salez, poivrez, puis emballez-les aussitôt dans un papier alimentaire ou enfermez-les dans une boîte hermétique et laissez-les tiédir. \n 3) Rincez et essorez la salade et la roquette. Émincez finement l’oignon. Taillez la mimolette en fins copeaux. Mélangez le yaourt avec la moutarde, 3 c. à soupe d’huile d’olive, 1 pincée de sel et 1 pincée de poivre moulu, ajustez la consistance avec un peu d’eau pour obtenir une sauce crémeuse mais fluide. Écalez les œufs, coupez-les en quartiers, tranchez les filets de poulet en lanières. \n 4) Présentez les feuilles de salade et la roquette avec les lamelles de poulet, les copeaux de mimolette, les quartiers d’œufs durs, nappez de sauce et parsemez de câpres."));

        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(1,"","poivron(s) rouge(s)"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"","oignon jaune"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"gousse","d'ail"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de potrines fumées en tranches"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"cl","de crème végétale"));
        lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de pois chiches"));
        lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de petit pois surgelés"));
        lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de noix de cajous grillées"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","d'huile de cuisson"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à café","d'origan"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"pincée(s)","de paprika"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de concentré de tomates"));






        livreRecettes.add(new Recette(false, 8,"Poivrons et pois chiches au lard fumé", 10, lesIngredientsdelaRecette, "1) Rincez et essuyez les poivrons. Épépinez-les et coupez-les en lanières. Rincez et égouttez les pois chiches. Épluchez et émincez l’oignon. Épluchez et ciselez finement l’ail. \n 2) Dans une cocotte, faites chauffer l’huile, ajoutez l’oignon et les tranches de poitrine fumée coupées en morceaux. Laissez rissoler 3 mn en remuant jusqu’à ce que l’oignon soit translucide. Ajoutez les poivrons, l’origan et l’ail, laissez cuire encore 5 mn en remuant régulièrement. Ajoutez le concentré de tomate, la crème végétale, les pois chiches, les petits pois, 1 pincée de sel et le paprika. Couvrez et laissez mijoter à feu doux pendant 10 mn. \n 3) Servez avec des noix de cajou grillées concassées."));

        lesIngredientsdelaRecette=new Vector<>();

        lesIngredientsdelaRecette.add(new Ingredient(125,"grammes","de chamignons blancs"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi paquet","de gnocchis a poêler"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"gousses","d'ail"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"demi","oignon"));
        lesIngredientsdelaRecette.add(new Ingredient(10,"cL","de crème fraîche semi-épaisse"));
        lesIngredientsdelaRecette.add(new Ingredient(1,"très petit filet","de Paterelle"));


        livreRecettes.add(new Recette(true, 9,"Gnocchis & champignons", 30, lesIngredientsdelaRecette,
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


        livreRecettes.add(new Recette(true, 10,"Croque-monsieur à l'avocat", 15, lesIngredientsdelaRecette,
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


        livreRecettes.add(new Recette(false, 11,"Poulet curry coco", 30, lesIngredientsdelaRecette,
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


        livreRecettes.add(new Recette(false, 12,"Salade de Quinoa au poulet, concombre et avocat", 35, lesIngredientsdelaRecette,
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


        livreRecettes.add(new Recette(false, 13,"Chili con carne", 20, lesIngredientsdelaRecette,
                "1. couper le poivron en morceaux\n" +
                        "2. le faire cuire à feu doux pendant 15min\n" +
                        "3. faire cuire le riz\n" +
                        "4. quand les poivrons sont cuits, ajouter dans la casserole la viande hachée\n" +
                        "5. ajouter le maïs\n" +
                        "6. ajouter les haricots rouges\n" +
                        "7. ajouter la sauce tomate\n" +
                        "8. ajouter du chili\n" +
                        "9. quand le riz est cuit, mélanger le tout"));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de carottes"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de vachequirit"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de farine"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oeuf"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"cl","de lait"));
      lesIngredientsdelaRecette.add(new Ingredient(5, "brins", "de ciboulette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée", "de cumin en poudre"));


      livreRecettes.add(new Recette(true, 14,"Soufflés de carotte à la Vache-qui-Rit", 25, lesIngredientsdelaRecette,
              "1. Pelez les carottes, coupez-les en rondelles, puis faites-les cuire 15 mn à la vapeur. Réduisez-les en très fine purée avec un mixeur. Versez dans un saladier et laissez tiédir.\n" +
                      "2. Préchauffez le four th. 5 (150 °C).\n" +
                      "3. Préparez la béchamel : faites fondre les 40 g de beurre dans une petite casserole. \n Ajoutez la farine, laissez dorer à feu doux en remuant, puis ajoutez le lait. Salez, poivrez, ajoutez le cumin. \n Laissez cuire 10 mn à feu très doux en mélangeant. Hors du feu, ajoutez les portions de Vache-qui-Rit.\n" +
                      "4. Versez la béchamel dans la purée de carottes. Ajoutez les jaunes d’œufs. Mélangez parfaitement, puis ajoutez la ciboulette ciselée. Montez les blancs en neige. Incorporez-les délicatement à la purée de carotte et versez dans un plat à soufflé légèrement beurré. Faites cuire 25 mn au four et servez sans attendre."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de feta"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"brins","de coriandre"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"","oeufs"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"grammes","de beurre demi-sel"));
      lesIngredientsdelaRecette.add(new Ingredient(0,"","piment d'espelette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à café","d'huile d'olive'"));


      livreRecettes.add(new Recette(true, 15,"Brouillade feta-coriandre", 5, lesIngredientsdelaRecette,
              "1. Émiettez la feta. Rincez, effeuillez et ciselez la coriandre.\n" +
                      "2. Cassez les œufs dans un récipient et battez-les à la fourchette. Ajoutez du sel, du poivre et une pointe de piment d’Espelette.\n" +
                      "3. Faites chauffer le beurre et l’huile d’olive dans une casserole. Ajoutez les œufs et laissez cuire sur feu très doux pendant 5 à 6 mn en remuant avec une cuillère en bois : ils doivent rester crémeux. Hors du feu, incorporez la feta et la coriandre.\n" +
                      "4. Mélangez jusqu’à ce que le fromage ait fondu et servez bien chaud."));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(2,"entier","pomme de terre"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","roquefort"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"centilitres","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","fromage rapé"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"entier","oeuf"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"verre","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillière","crème fraiche"));



      livreRecettes.add(new Recette(true, 16,"Tarte aux pommes de terre et au roquefort ", 45, lesIngredientsdelaRecette, "Préchauffer le four à 200°C. \n Mettre les pommes de terre lavées mais non épluchées dans une casserole d'eau froide avec du sel. \n faire bouillir 10 mn, égoutter, couper en rondelles. \n Disposer les rondelles de pomme de terre sur la pâte en les faisant se chevaucher. \n Emietter le roquefort par dessus, saupoudrer de gruyère râpé. Dans un bol, mélanger l'oeuf battu, le lait et la crème. \n Verser cet appareil sur la tarte, poivrer à convenance. \n Mettre au four 25 à 30 min. \n Servir tiède avec une salade." ));



      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de riste d'aubergine"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"centillitres","creme liquide"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"centilitres","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","fromage rapé"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"plaques","pâtes à lasagne"));



      livreRecettes.add(new Recette(true, 17,"Lasagnes au riste d'aubergines", 30, lesIngredientsdelaRecette, "Dans un saladier, versez le riste d'aubergines, ajoutez le lait et la crème. \n Mélangez jusqu'à homogénéisation du mélange. \n Dans un plat, appliquez succesivement une plaque de lasagne et du mélange. \n N'oubliez pas d'en ajouter au dessus ! Tout au dessus, ajoutez le fromage. \n Placez au four préchauffé à 180 degrés pendant environ 30 minutes" ));




      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"entière","pâte brisée"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"entière","tomate"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","herbe de provence"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","moutarde"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillière","huile d'olive"));

      livreRecettes.add(new Recette(true, 18,"Tarte à la tomate et à la moutarde", 30, lesIngredientsdelaRecette, " Précuire la pâte (percée avec une fourchette) 5 min à 450 degrés farenheit (230°C). \n  Pendant ce temps, couper les tomates en rondelles de 3 mm d'épaisseur. \n Sortir la pâte précuite du four. badigeonner le fond de moutarde de Dijon (la classique fait l'affaire) ... \n en mettre suffisamment pour que le fond en pâte ne se voit plus. Disposer les tranches de tomates. \n faire plusieurs épaisseurs. Saupoudrer d'herbes de Provence + 2 pincées de sel. \n 1 cuillère à soupe d'huile d'olive.  \n Enfourner pour 20 min à 450 farenheit puis couvrir avec papier d'aluminium pour 20 min supplémentaires. \n Après ces 20 min, enlever le papier aluminium et laisser cuire encore 5 min porte du four ouverte. \n  Délicieux avec une salade verte." ));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(25,"g","de comté"));
      lesIngredientsdelaRecette.add(new Ingredient(8,"","oeufs"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"grosses noix","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuilleres a café","de paprika"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","sel"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","poivre"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"filet","d'huile d'olives"));

      livreRecettes.add(new Recette(true, 19,"Brouillade au comté et paprika fumé",10,lesIngredientsdelaRecette,
              "1. Coupez le comté en cubes. Battez les œufs avec le fromage, le paprika fumé, le sel et le poivre."+"/n"+
              "2. Faites chauffer l’huile d’olive avec le beurre dans une casserole. Ajoutez les œufs battus et laissez cuire 3 mn à feu moyen en mélangeant constamment, jusqu’à ce que les œufs soient pris sans être secs. Dégustez aussitôt."));


      lesIngredientsdelaRecette=new Vector<>();


      lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de couscous fin"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"bouquet","d'herbes mélangées"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","champignon de Paris"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","de curcuma"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de beurre"));

      livreRecettes.add(new Recette(true, 20,"Couscous express au curcuma et aux herbes",5,lesIngredientsdelaRecette,"1. Faites bouillir 1/2 litre d’eau. /n " +
              "2. Faites chauffer l’huile d’olive dans une grande casserole. Ajoutez la moitié du beurre, poivrez abondamment et ajoutez le curcuma. Mélangez 1 mn puis ajoutez le couscous et remuez encore 1 mn. Versez l’eau et salez. Couvrez et laissez cuire à feu très doux, 5 mn, en mélangeant de temps en temps. /n"+
              "3. Rincez les herbes et ciselez-les grossièrement, en éliminant les tiges les plus grosses. /n " +
              "4. Remuez le couscous pour l’aérer au bout des 5 mn de cuisson, ajoutez le reste de beurre et les herbes, sans cesser de remuer. Servez aussitôt, tiède ou à température ambiante."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(4,"","oeufs"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de pousses d'épinards"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"branches","de persil"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","petits suisses"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillères à café","de miel"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillères à soupe","de graines de courges"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillères à soupe","de vinaigre de cidre"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillères à soupe","d'huile"));



      livreRecettes.add(new Recette(true, 21,"Salade d’épinards au petit-suisse, graines de courge et œufs mollets",15,lesIngredientsdelaRecette, "1. Faites bouillir une casserole d’eau et plongez les œufs 6 mn. Sortez-les immédiatement et tapez-les pour les fendre, laissez-les refroidir dans un grand bol d’eau glacée. /n " +
              "2. Rincez les feuilles d’épinards et le persil, ciselez le persil, placez-les dans un saladier. /n" +
              "3. Mélangez les petits-suisses avec l’huile d’olive, le vinaigre, le miel, 1 pincée de sel et 1 pincée de poivre noir. Versez la sauce sur les feuilles d’épinards encore humides et le persil, puis mélangez. /n" +
              " 4. Répartissez dans les assiettes les feuilles d’épinards, 1 œuf mollet écalé et parsemez de graines de courge."));

      //recettes encore à modifier
      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(3,"parts","de pâte à pizza"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"tranches","de jambon"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de parmesan"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de tomates cerises"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi","mozza di Buffala"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de sauce tomate"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi gousses","d'ail"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"feuilles","de basilic"));

      livreRecettes.add(new Recette(false, 4,"Pizza rosso", 30, lesIngredientsdelaRecette, "1)Préchauffer le four. /n 2)Faire revenir l'ail découpé en petis morceaux quelques minutes. Pendant ce temps couper les tomates cerises en deux et étaler la pâte à pizza. /n 3)Incorporer l'ail avec la sauce tomate et un peu d'huile d'olive. /n 4)Déposer sur la pâte la sauce tomate préparée et les tomates cerises. Enfourner /n 5)Après 15 minutes de cuisson, serir la pizza en ayant déposé dessus la mozzarella découpée en morceaux et les feuilles de basilic."));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz à risotto"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s)","oignon"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"centilitres","de bouillon de volaille"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de parmesan"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à soupe","d'huile d'olive"));
      lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s) verre(s)","de vin blanc sec"));


      livreRecettes.add(new Recette(false, 5,"Risotto", 40, lesIngredientsdelaRecette, "1)Commencez par chauffer votre bouillon de volaille dans une première casserole. Pendant ce temps, pelez l'oignon, émincez-le finement et faites-le revenir à feu vif et à découvert, pendant quelques minutes (le temps de le colorer), dans une seconde casserole (assez grande, et de préférence anti-adhésive) avec l'huile d'olive et la moitié du beurre. Ajoutez ensuite le riz pour risotto et mélangez bien le tout, puis déglacez avec le vin blanc et faites le évaporer. /n 2)Pour une cuisson du riz parfaite, incorporez à l’aide d’une louche une partie du bouillon dans votre risotto. Laissez tout d'abord le riz bien absorber le bouillon, puis mélangez ensuite pendant plusieurs minutes pour que l'amidon se répande dans le risotto, et lui donne sa consistance moelleuse. En respectant la même procédure que précédemment, incorporez toujours de la même manière le reste de bouillon. /n 3)Une fois le riz parfaitement cuit (il doit être moelleux mais pas mou pour autant), ajoutez le beurre restant et la moitié du parmesan râpé. Salez et poivrez à votre convenance, et servez votre risotto bien chaud, en disposant l'autre moitié de parmesan de façon à ce que vos invités puissent le saupoudrer eux-même sur leur assiette.  /n ASTUCE: Vous ouvez agrémneter votre risotto avec des champignons par exemple que vous rajoutez après les avoir cuits en fin de cuisson." ));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de tomates cerises"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"quart(s)","d'oignon rouge"));
      lesIngredientsdelaRecette.add(new Ingredient(20,"grammes","de feta"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"tier(s)","de concombre"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"","olives noires"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de vinaigre"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","d'huile d'olive"));


      livreRecettes.add(new Recette(true, 6,"Salade grecque", 15, lesIngredientsdelaRecette, "1)Lavez et coupez en quatre les tomates cerise. Nettoyez puis taillez le concombre en deux dans la longueur, puis en rondelles. Pelez, dégermez et émincez finement l’oignon rouge. Découpez la feta en cubes. Coupez en deux les olives noires, puis dénoyautez-les. /n 2)Dans un saladier, préparez la vinaigrette en mélangeant ensemble l’huile d’olive et le vinaigre de vin rouge. Saupoudrez d’herbes de Provence et assaisonnez de sel et de poivre, selon votre goût. Émulsionnez bien. /n 3)Ajoutez dans le saladier les olives noires dénoyautées, les cubes de feta, les tomates cerises, les rondelles de concombre et l’oignon rouge émincé. Remuez pour bien répartir la sauce dans toute la salade à la grecque. /n 4)C'est prêt! Servez et dégustez!"));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"","oeuf(s)"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"filet(s)","de poulet"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","petite salade verte"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée(s)","de roquette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oignon doux"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de mimolette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de yaourt ou fromage blanc"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de moutarde à l'ancienne"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de câpres"));



      livreRecettes.add(new Recette(false, 7,"Salade de poulet à la mimolette", 15, lesIngredientsdelaRecette, "1) Plongez les œufs dans une casserole d’eau bouillante et laissez-les cuire 8 mn. Passez-les aussitôt sous l’eau froide, roulez-les pour fendiller la coquille et laissez-les refroidir dans de l’eau froide. \n 2) Faites cuire les filets de poulet incisés et posés bien à plat dans une poêle huilée bien chaude, 3 à 4 mn de chaque côté, jusqu’à ce qu’ils soient dorés. Salez, poivrez, puis emballez-les aussitôt dans un papier alimentaire ou enfermez-les dans une boîte hermétique et laissez-les tiédir. \n 3) Rincez et essorez la salade et la roquette. Émincez finement l’oignon. Taillez la mimolette en fins copeaux. Mélangez le yaourt avec la moutarde, 3 c. à soupe d’huile d’olive, 1 pincée de sel et 1 pincée de poivre moulu, ajustez la consistance avec un peu d’eau pour obtenir une sauce crémeuse mais fluide. Écalez les œufs, coupez-les en quartiers, tranchez les filets de poulet en lanières. \n 4) Présentez les feuilles de salade et la roquette avec les lamelles de poulet, les copeaux de mimolette, les quartiers d’œufs durs, nappez de sauce et parsemez de câpres."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"","poivron(s) rouge(s)"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oignon jaune"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"gousse","d'ail"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de potrines fumées en tranches"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"cl","de crème végétale"));
      lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de pois chiches"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de petit pois surgelés"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de noix de cajous grillées"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","d'huile de cuisson"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à café","d'origan"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée(s)","de paprika"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de concentré de tomates"));






      livreRecettes.add(new Recette(false, 8,"Poivrons et pois chiches au lard fumé", 10, lesIngredientsdelaRecette, "1) Rincez et essuyez les poivrons. Épépinez-les et coupez-les en lanières. Rincez et égouttez les pois chiches. Épluchez et émincez l’oignon. Épluchez et ciselez finement l’ail. \n 2) Dans une cocotte, faites chauffer l’huile, ajoutez l’oignon et les tranches de poitrine fumée coupées en morceaux. Laissez rissoler 3 mn en remuant jusqu’à ce que l’oignon soit translucide. Ajoutez les poivrons, l’origan et l’ail, laissez cuire encore 5 mn en remuant régulièrement. Ajoutez le concentré de tomate, la crème végétale, les pois chiches, les petits pois, 1 pincée de sel et le paprika. Couvrez et laissez mijoter à feu doux pendant 10 mn. \n 3) Servez avec des noix de cajou grillées concassées."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(125,"grammes","de chamignons blancs"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi paquet","de gnocchis a poêler"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"gousses","d'ail"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi","oignon"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"cL","de crème fraîche semi-épaisse"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"très petit filet","de Paterelle"));


      livreRecettes.add(new Recette(true, 9,"Gnocchis & champignons", 30, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(true, 10,"Croque-monsieur à l'avocat", 15, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(false, 11,"Poulet curry coco", 30, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(false, 12,"Salade de Quinoa au poulet, concombre et avocat", 35, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(false, 13,"Chili con carne", 20, lesIngredientsdelaRecette,
              "1. couper le poivron en morceaux\n" +
                      "2. le faire cuire à feu doux pendant 15min\n" +
                      "3. faire cuire le riz\n" +
                      "4. quand les poivrons sont cuits, ajouter dans la casserole la viande hachée\n" +
                      "5. ajouter le maïs\n" +
                      "6. ajouter les haricots rouges\n" +
                      "7. ajouter la sauce tomate\n" +
                      "8. ajouter du chili\n" +
                      "9. quand le riz est cuit, mélanger le tout"));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de carottes"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de vachequirit"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de farine"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oeuf"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"cl","de lait"));
      lesIngredientsdelaRecette.add(new Ingredient(5, "brins", "de ciboulette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée", "de cumin en poudre"));


      livreRecettes.add(new Recette(true, 14,"Soufflés de carotte à la Vache-qui-Rit", 25, lesIngredientsdelaRecette,
              "1. Pelez les carottes, coupez-les en rondelles, puis faites-les cuire 15 mn à la vapeur. Réduisez-les en très fine purée avec un mixeur. Versez dans un saladier et laissez tiédir.\n" +
                      "2. Préchauffez le four th. 5 (150 °C).\n" +
                      "3. Préparez la béchamel : faites fondre les 40 g de beurre dans une petite casserole. \n Ajoutez la farine, laissez dorer à feu doux en remuant, puis ajoutez le lait. Salez, poivrez, ajoutez le cumin. \n Laissez cuire 10 mn à feu très doux en mélangeant. Hors du feu, ajoutez les portions de Vache-qui-Rit.\n" +
                      "4. Versez la béchamel dans la purée de carottes. Ajoutez les jaunes d’œufs. Mélangez parfaitement, puis ajoutez la ciboulette ciselée. Montez les blancs en neige. Incorporez-les délicatement à la purée de carotte et versez dans un plat à soufflé légèrement beurré. Faites cuire 25 mn au four et servez sans attendre."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de feta"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"brins","de coriandre"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"","oeufs"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"grammes","de beurre demi-sel"));
      lesIngredientsdelaRecette.add(new Ingredient(0,"","piment d'espelette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à café","d'huile d'olive'"));


      livreRecettes.add(new Recette(true, 15,"Brouillade feta-coriandre", 5, lesIngredientsdelaRecette,
              "1. Émiettez la feta. Rincez, effeuillez et ciselez la coriandre.\n" +
                      "2. Cassez les œufs dans un récipient et battez-les à la fourchette. Ajoutez du sel, du poivre et une pointe de piment d’Espelette.\n" +
                      "3. Faites chauffer le beurre et l’huile d’olive dans une casserole. Ajoutez les œufs et laissez cuire sur feu très doux pendant 5 à 6 mn en remuant avec une cuillère en bois : ils doivent rester crémeux. Hors du feu, incorporez la feta et la coriandre.\n" +
                      "4. Mélangez jusqu’à ce que le fromage ait fondu et servez bien chaud."));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(2,"entier","pomme de terre"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","roquefort"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"centilitres","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","fromage rapé"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"entier","oeuf"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"verre","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillière","crème fraiche"));



      livreRecettes.add(new Recette(true, 16,"Tarte aux pommes de terre et au roquefort ", 45, lesIngredientsdelaRecette, "Préchauffer le four à 200°C. \n Mettre les pommes de terre lavées mais non épluchées dans une casserole d'eau froide avec du sel. \n faire bouillir 10 mn, égoutter, couper en rondelles. \n Disposer les rondelles de pomme de terre sur la pâte en les faisant se chevaucher. \n Emietter le roquefort par dessus, saupoudrer de gruyère râpé. Dans un bol, mélanger l'oeuf battu, le lait et la crème. \n Verser cet appareil sur la tarte, poivrer à convenance. \n Mettre au four 25 à 30 min. \n Servir tiède avec une salade." ));



      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de riste d'aubergine"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"centillitres","creme liquide"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"centilitres","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","fromage rapé"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"plaques","pâtes à lasagne"));



      livreRecettes.add(new Recette(true, 17,"Lasagnes au riste d'aubergines", 30, lesIngredientsdelaRecette, "Dans un saladier, versez le riste d'aubergines, ajoutez le lait et la crème. \n Mélangez jusqu'à homogénéisation du mélange. \n Dans un plat, appliquez succesivement une plaque de lasagne et du mélange. \n N'oubliez pas d'en ajouter au dessus ! Tout au dessus, ajoutez le fromage. \n Placez au four préchauffé à 180 degrés pendant environ 30 minutes" ));




      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"entière","pâte brisée"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"entière","tomate"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","herbe de provence"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","moutarde"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillière","huile d'olive"));

      livreRecettes.add(new Recette(true, 18,"Tarte à la tomate et à la moutarde", 30, lesIngredientsdelaRecette, " Précuire la pâte (percée avec une fourchette) 5 min à 450 degrés farenheit (230°C). \n  Pendant ce temps, couper les tomates en rondelles de 3 mm d'épaisseur. \n Sortir la pâte précuite du four. badigeonner le fond de moutarde de Dijon (la classique fait l'affaire) ... \n en mettre suffisamment pour que le fond en pâte ne se voit plus. Disposer les tranches de tomates. \n faire plusieurs épaisseurs. Saupoudrer d'herbes de Provence + 2 pincées de sel. \n 1 cuillère à soupe d'huile d'olive.  \n Enfourner pour 20 min à 450 farenheit puis couvrir avec papier d'aluminium pour 20 min supplémentaires. \n Après ces 20 min, enlever le papier aluminium et laisser cuire encore 5 min porte du four ouverte. \n  Délicieux avec une salade verte." ));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(25,"g","mozarella"));
      lesIngredientsdelaRecette.add(new Ingredient(4,"","oeufs"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"bouquet","ciboulette"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","sel"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","poivre"));

      livreRecettes.add(new Recette(true, 1,"Omelette ciboulette et mozzarella",10,lesIngredientsdelaRecette,"1) Coupez la mozzarella en 12 morceaux"+"/n"+"2) Cassez les oeufs et fouettez les avec le sel, le poivre et la ciboulette coupée finement"+"/n"+"3) Faire cuire les oeufs sur une poele pendant deux à trois minutes"+"/n"+"4) parsemez les oeufs de mozzarella, couvrez et laissez cuire 7 mn environ, à feu doux, sans y toucher, jusqu’à ce que l’omelette soit juste prise"));

      lesIngredientsdelaRecette=new Vector<>();


      lesIngredientsdelaRecette.add(new Ingredient(1,"","tortilla de blé"));
      lesIngredientsdelaRecette.add(new Ingredient(4,"","tomates cerises"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","champignon de Paris"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"cuilleres a soupe","huile"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"","tagliatelles de courgette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"boule","mozarella"));

      livreRecettes.add(new Recette(true, 2,"Tortizza végétarienne",5,lesIngredientsdelaRecette,"1) Prechauffez le four a 210 degres /n 2) Coupez les tomates-cerises en deux, le champignon en lamelles, et la mozzarella en morceaux. /n"+ "3) Etalez le coulis de tomate sur toute la surface de la tortilla. /n 4) Répartissez-y les tomates-cerises, les lamelles de champignon, les tagliatelles de courgette, les morceaux de mozzarella et le fromage râpé. /n 5) Enfournez 13 min. Servez immédiatement."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"filet","de saumon"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","de sauce soja"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"petite cuillère à café","de sucre"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"pincées","de poivre"));
      lesIngredientsdelaRecette.add(new Ingredient(8,"grammes","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz"));

      livreRecettes.add(new Recette(false, 3,"Saumon Teriyaki",20,lesIngredientsdelaRecette, "1) Mélanger le soja, le sucre, et si vous avez, une touche de gingemmbre. /n 2)Mettre le saumon, avec quelques incisions dans un plat creux, verser la marinade dessus et laisser mariner 15 minutes. /n 3) Faire bouillir de l'eau pour le riz. 4)Verser le riz dans une casserole. /n 5)Verser la marinade dans une autre casserole avec le beurre, à feu doux, et mélanger jusqu'à avoir une sauce homogène. En même temps, faire cuire le saumon à la poêle 3 minutes de chaque côté. /n  6)Saler, poivrer. C'est prêt! Servir le saumon avec le riz et la sauce."));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(3,"parts","de pâte à pizza"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"tranches","de jambon"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de parmesan"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de tomates cerises"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi","mozza di Buffala"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de sauce tomate"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi gousses","d'ail"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"feuilles","de basilic"));

      livreRecettes.add(new Recette(false, 4,"Pizza rosso", 30, lesIngredientsdelaRecette, "1)Préchauffer le four. /n 2)Faire revenir l'ail découpé en petis morceaux quelques minutes. Pendant ce temps couper les tomates cerises en deux et étaler la pâte à pizza. /n 3)Incorporer l'ail avec la sauce tomate et un peu d'huile d'olive. /n 4)Déposer sur la pâte la sauce tomate préparée et les tomates cerises. Enfourner /n 5)Après 15 minutes de cuisson, serir la pizza en ayant déposé dessus la mozzarella découpée en morceaux et les feuilles de basilic."));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(70,"grammes","de riz à risotto"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s)","oignon"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"centilitres","de bouillon de volaille"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de parmesan"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à soupe","d'huile d'olive"));
      lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi(s) verre(s)","de vin blanc sec"));


      livreRecettes.add(new Recette(false, 5,"Risotto", 40, lesIngredientsdelaRecette, "1)Commencez par chauffer votre bouillon de volaille dans une première casserole. Pendant ce temps, pelez l'oignon, émincez-le finement et faites-le revenir à feu vif et à découvert, pendant quelques minutes (le temps de le colorer), dans une seconde casserole (assez grande, et de préférence anti-adhésive) avec l'huile d'olive et la moitié du beurre. Ajoutez ensuite le riz pour risotto et mélangez bien le tout, puis déglacez avec le vin blanc et faites le évaporer. /n 2)Pour une cuisson du riz parfaite, incorporez à l’aide d’une louche une partie du bouillon dans votre risotto. Laissez tout d'abord le riz bien absorber le bouillon, puis mélangez ensuite pendant plusieurs minutes pour que l'amidon se répande dans le risotto, et lui donne sa consistance moelleuse. En respectant la même procédure que précédemment, incorporez toujours de la même manière le reste de bouillon. /n 3)Une fois le riz parfaitement cuit (il doit être moelleux mais pas mou pour autant), ajoutez le beurre restant et la moitié du parmesan râpé. Salez et poivrez à votre convenance, et servez votre risotto bien chaud, en disposant l'autre moitié de parmesan de façon à ce que vos invités puissent le saupoudrer eux-même sur leur assiette.  /n ASTUCE: Vous ouvez agrémneter votre risotto avec des champignons par exemple que vous rajoutez après les avoir cuits en fin de cuisson." ));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de tomates cerises"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"quart(s)","d'oignon rouge"));
      lesIngredientsdelaRecette.add(new Ingredient(20,"grammes","de feta"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"tier(s)","de concombre"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"","olives noires"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de vinaigre"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"cuillères à soupe","d'huile d'olive"));


      livreRecettes.add(new Recette(true, 6,"Salade grecque", 15, lesIngredientsdelaRecette, "1)Lavez et coupez en quatre les tomates cerise. Nettoyez puis taillez le concombre en deux dans la longueur, puis en rondelles. Pelez, dégermez et émincez finement l’oignon rouge. Découpez la feta en cubes. Coupez en deux les olives noires, puis dénoyautez-les. /n 2)Dans un saladier, préparez la vinaigrette en mélangeant ensemble l’huile d’olive et le vinaigre de vin rouge. Saupoudrez d’herbes de Provence et assaisonnez de sel et de poivre, selon votre goût. Émulsionnez bien. /n 3)Ajoutez dans le saladier les olives noires dénoyautées, les cubes de feta, les tomates cerises, les rondelles de concombre et l’oignon rouge émincé. Remuez pour bien répartir la sauce dans toute la salade à la grecque. /n 4)C'est prêt! Servez et dégustez!"));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"","oeuf(s)"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"filet(s)","de poulet"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","petite salade verte"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée(s)","de roquette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oignon doux"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de mimolette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de yaourt ou fromage blanc"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de moutarde à l'ancienne"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de câpres"));



      livreRecettes.add(new Recette(false, 7,"Salade de poulet à la mimolette", 15, lesIngredientsdelaRecette, "1) Plongez les œufs dans une casserole d’eau bouillante et laissez-les cuire 8 mn. Passez-les aussitôt sous l’eau froide, roulez-les pour fendiller la coquille et laissez-les refroidir dans de l’eau froide. \n 2) Faites cuire les filets de poulet incisés et posés bien à plat dans une poêle huilée bien chaude, 3 à 4 mn de chaque côté, jusqu’à ce qu’ils soient dorés. Salez, poivrez, puis emballez-les aussitôt dans un papier alimentaire ou enfermez-les dans une boîte hermétique et laissez-les tiédir. \n 3) Rincez et essorez la salade et la roquette. Émincez finement l’oignon. Taillez la mimolette en fins copeaux. Mélangez le yaourt avec la moutarde, 3 c. à soupe d’huile d’olive, 1 pincée de sel et 1 pincée de poivre moulu, ajustez la consistance avec un peu d’eau pour obtenir une sauce crémeuse mais fluide. Écalez les œufs, coupez-les en quartiers, tranchez les filets de poulet en lanières. \n 4) Présentez les feuilles de salade et la roquette avec les lamelles de poulet, les copeaux de mimolette, les quartiers d’œufs durs, nappez de sauce et parsemez de câpres."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"","poivron(s) rouge(s)"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oignon jaune"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"gousse","d'ail"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de potrines fumées en tranches"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"cl","de crème végétale"));
      lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de pois chiches"));
      lesIngredientsdelaRecette.add(new Ingredient(50,"grammes","de petit pois surgelés"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","de noix de cajous grillées"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","d'huile de cuisson"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à café","d'origan"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée(s)","de paprika"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère(s) à soupe","de concentré de tomates"));






      livreRecettes.add(new Recette(false, 8,"Poivrons et pois chiches au lard fumé", 10, lesIngredientsdelaRecette, "1) Rincez et essuyez les poivrons. Épépinez-les et coupez-les en lanières. Rincez et égouttez les pois chiches. Épluchez et émincez l’oignon. Épluchez et ciselez finement l’ail. \n 2) Dans une cocotte, faites chauffer l’huile, ajoutez l’oignon et les tranches de poitrine fumée coupées en morceaux. Laissez rissoler 3 mn en remuant jusqu’à ce que l’oignon soit translucide. Ajoutez les poivrons, l’origan et l’ail, laissez cuire encore 5 mn en remuant régulièrement. Ajoutez le concentré de tomate, la crème végétale, les pois chiches, les petits pois, 1 pincée de sel et le paprika. Couvrez et laissez mijoter à feu doux pendant 10 mn. \n 3) Servez avec des noix de cajou grillées concassées."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(125,"grammes","de chamignons blancs"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi paquet","de gnocchis a poêler"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"gousses","d'ail"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"demi","oignon"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"cL","de crème fraîche semi-épaisse"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"très petit filet","de Paterelle"));


      livreRecettes.add(new Recette(true, 9,"Gnocchis & champignons", 30, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(true, 10,"Croque-monsieur à l'avocat", 15, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(false, 11,"Poulet curry coco", 30, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(false, 12,"Salade de Quinoa au poulet, concombre et avocat", 35, lesIngredientsdelaRecette,
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


      livreRecettes.add(new Recette(false, 13,"Chili con carne", 20, lesIngredientsdelaRecette,
              "1. couper le poivron en morceaux\n" +
                      "2. le faire cuire à feu doux pendant 15min\n" +
                      "3. faire cuire le riz\n" +
                      "4. quand les poivrons sont cuits, ajouter dans la casserole la viande hachée\n" +
                      "5. ajouter le maïs\n" +
                      "6. ajouter les haricots rouges\n" +
                      "7. ajouter la sauce tomate\n" +
                      "8. ajouter du chili\n" +
                      "9. quand le riz est cuit, mélanger le tout"));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(100,"grammes","de carottes"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"portion","de vachequirit"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de beurre"));
      lesIngredientsdelaRecette.add(new Ingredient(10,"grammes","de farine"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"","oeuf"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"cl","de lait"));
      lesIngredientsdelaRecette.add(new Ingredient(5, "brins", "de ciboulette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée", "de cumin en poudre"));


      livreRecettes.add(new Recette(true, 14,"Soufflés de carotte à la Vache-qui-Rit", 25, lesIngredientsdelaRecette,
              "1. Pelez les carottes, coupez-les en rondelles, puis faites-les cuire 15 mn à la vapeur. Réduisez-les en très fine purée avec un mixeur. Versez dans un saladier et laissez tiédir.\n" +
                      "2. Préchauffez le four th. 5 (150 °C).\n" +
                      "3. Préparez la béchamel : faites fondre les 40 g de beurre dans une petite casserole. \n Ajoutez la farine, laissez dorer à feu doux en remuant, puis ajoutez le lait. Salez, poivrez, ajoutez le cumin. \n Laissez cuire 10 mn à feu très doux en mélangeant. Hors du feu, ajoutez les portions de Vache-qui-Rit.\n" +
                      "4. Versez la béchamel dans la purée de carottes. Ajoutez les jaunes d’œufs. Mélangez parfaitement, puis ajoutez la ciboulette ciselée. Montez les blancs en neige. Incorporez-les délicatement à la purée de carotte et versez dans un plat à soufflé légèrement beurré. Faites cuire 25 mn au four et servez sans attendre."));

      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(30,"grammes","de feta"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"brins","de coriandre"));
      lesIngredientsdelaRecette.add(new Ingredient(2,"","oeufs"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"grammes","de beurre demi-sel"));
      lesIngredientsdelaRecette.add(new Ingredient(0,"","piment d'espelette"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillère à café","d'huile d'olive'"));


      livreRecettes.add(new Recette(true, 15,"Brouillade feta-coriandre", 5, lesIngredientsdelaRecette,
              "1. Émiettez la feta. Rincez, effeuillez et ciselez la coriandre.\n" +
                      "2. Cassez les œufs dans un récipient et battez-les à la fourchette. Ajoutez du sel, du poivre et une pointe de piment d’Espelette.\n" +
                      "3. Faites chauffer le beurre et l’huile d’olive dans une casserole. Ajoutez les œufs et laissez cuire sur feu très doux pendant 5 à 6 mn en remuant avec une cuillère en bois : ils doivent rester crémeux. Hors du feu, incorporez la feta et la coriandre.\n" +
                      "4. Mélangez jusqu’à ce que le fromage ait fondu et servez bien chaud."));


      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(2,"entier","pomme de terre"));
      lesIngredientsdelaRecette.add(new Ingredient(25,"grammes","roquefort"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"centilitres","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","fromage rapé"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"entier","oeuf"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"verre","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillière","crème fraiche"));



      livreRecettes.add(new Recette(true, 16,"Tarte aux pommes de terre et au roquefort ", 45, lesIngredientsdelaRecette, "Préchauffer le four à 200°C. \n Mettre les pommes de terre lavées mais non épluchées dans une casserole d'eau froide avec du sel. \n faire bouillir 10 mn, égoutter, couper en rondelles. \n Disposer les rondelles de pomme de terre sur la pâte en les faisant se chevaucher. \n Emietter le roquefort par dessus, saupoudrer de gruyère râpé. Dans un bol, mélanger l'oeuf battu, le lait et la crème. \n Verser cet appareil sur la tarte, poivrer à convenance. \n Mettre au four 25 à 30 min. \n Servir tiède avec une salade." ));



      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(150,"grammes","de riste d'aubergine"));
      lesIngredientsdelaRecette.add(new Ingredient(5,"centillitres","creme liquide"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"centilitres","lait"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","fromage rapé"));
      lesIngredientsdelaRecette.add(new Ingredient(3,"plaques","pâtes à lasagne"));



      livreRecettes.add(new Recette(true, 17,"Lasagnes au riste d'aubergines", 30, lesIngredientsdelaRecette, "Dans un saladier, versez le riste d'aubergines, ajoutez le lait et la crème. \n Mélangez jusqu'à homogénéisation du mélange. \n Dans un plat, appliquez succesivement une plaque de lasagne et du mélange. \n N'oubliez pas d'en ajouter au dessus ! Tout au dessus, ajoutez le fromage. \n Placez au four préchauffé à 180 degrés pendant environ 30 minutes" ));




      lesIngredientsdelaRecette=new Vector<>();

      lesIngredientsdelaRecette.add(new Ingredient(1,"entière","pâte brisée"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"entière","tomate"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"pincée","herbe de provence"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"poignée","moutarde"));
      lesIngredientsdelaRecette.add(new Ingredient(1,"cuillière","huile d'olive"));

      livreRecettes.add(new Recette(true, 18,"Tarte à la tomate et à la moutarde", 30, lesIngredientsdelaRecette, " Précuire la pâte (percée avec une fourchette) 5 min à 450 degrés farenheit (230°C). \n  Pendant ce temps, couper les tomates en rondelles de 3 mm d'épaisseur. \n Sortir la pâte précuite du four. badigeonner le fond de moutarde de Dijon (la classique fait l'affaire) ... \n en mettre suffisamment pour que le fond en pâte ne se voit plus. Disposer les tranches de tomates. \n faire plusieurs épaisseurs. Saupoudrer d'herbes de Provence + 2 pincées de sel. \n 1 cuillère à soupe d'huile d'olive.  \n Enfourner pour 20 min à 450 farenheit puis couvrir avec papier d'aluminium pour 20 min supplémentaires. \n Après ces 20 min, enlever le papier aluminium et laisser cuire encore 5 min porte du four ouverte. \n  Délicieux avec une salade verte." ));

      // fin recettes doublon pour test


    }


//cette methode permet de récupérer le menu
    public static Vector<Recette> getMenu(){
        Menu test= new Menu();
        Vector<Recette> Menu=new Vector<>();
        for(int i=0;i<test.livreRecettes.size();i++) {
            Menu.add(test.livreRecettes.get(i));
        }
        Collections.shuffle(Menu);
        return Menu;
    }


//cette methode permet de récuperer le menu végé
    public static Vector<Recette> getMenuVege() {
      Menu test= new Menu();
      Vector<Recette> MenuVege=new Vector<>();
      Vector<Recette> MenuVegeFinal = new Vector<>();
      for(int i=0;i<test.livreRecettes.size();i++) {
        if (test.livreRecettes.get(i).isVegetarien()) {
          MenuVege.add(test.livreRecettes.get(i));
        }
      }
      Collections.shuffle(MenuVege);
      for (int i=0; i<28; i++) {
        MenuVegeFinal.add(MenuVege.elementAt(i));
      }
      return MenuVegeFinal;
    }


    public Recette getRecetteAvecNumero(int NumeroRecette) {
      Recette recetteNulle=livreRecettes.get(0);
      for (int i = 0; i < livreRecettes.size(); i++) {
        Recette RecetteATrouver = livreRecettes.get(i);

        int numRecette = RecetteATrouver.getNumeroRecette();
        if (numRecette == NumeroRecette) {
          return RecetteATrouver;
        }

      }
      return recetteNulle;
    }

}

