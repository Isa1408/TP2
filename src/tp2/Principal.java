package tp2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Représente la classe principale.
 *
 * @Author Isabelle Tamas
 */
public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = LireFichier.listeString();
        Usine usine = new Usine(liste);
        int debutMontant = usine.debutMontant;
        int montantFinal = usine.finMontant;
        int montantActuel = usine.montantActuel;
        int nbrTours = usine.nbrTours;
        String commande;
        Boolean mauvaisChar;
        Boolean ameliorer = false;
        String premierChar;
        int entree;
        String produit;
        Boolean ameliorationFait;


        do{
            Usine.setteurDeProduitStationsParLesFournisseurs(); //set les boites des stations
                // qui sont en lien direct avec le fournisseur (a revoir)
            //System.out.println(Usine.listeDeStations);
            Usine.verifierSiBoiteEstComplet();
            Usine.afficherEtatUsine();//afficher etat de l usine

            //usine.setMontantActuel(montantActuel); //set le montant actuel
            System.out.println(usine.montantActuel + "$"); //afficher le
            // montant actuel
            nbrTours++;
            usine.setNbrTours(nbrTours); //set le nombre de tours
            System.out.println();

            do{
                mauvaisChar = false;
                Scanner clavier = new Scanner(System.in);
                System.out.print("=>");
                commande = clavier.nextLine();

                premierChar = commande.substring(0,1);

                if(!premierChar.equals("s") && !premierChar.equals("a") && !premierChar.equals("f")){
                    mauvaisChar = true;
                }
                if(!mauvaisChar){
                    if(premierChar.equals("s")){
                        try{
                            commande = commande.substring(1).trim();
                            if(!commande.equals("")){
                                entree = Integer.parseInt(commande);
                                for (int i = 0; i < entree -1; i++) {
                                    Usine.setteurDeProduitStationsParLesFournisseurs();
                                    Usine.verifierSiBoiteEstComplet();
                                    nbrTours++;
                                    usine.setNbrTours(nbrTours);
                                }
                            }
                        }catch (NumberFormatException e){
                            mauvaisChar = true;
                            System.out.println("Format invalide!");
                        }
                    }
                    if(premierChar.equals("a")){
                        try{
                            commande = commande.substring(1).trim();
                            if(!commande.equals("")){
                                entree = Integer.parseInt(commande);
                                mauvaisChar = true; //pour amelioration

                                try {
                                    DescriptionStations descriptionStations = null;
                                    produit =
                                            Usine.listeDeStations.get(entree).getProduitDansBoites1().toString();

                                    descriptionStations = getDescriptionStations(entree, produit, descriptionStations);
                                    if(descriptionStations != null && Usine.montantActuel >= 400){
                                        ameliorationFait = false;
                                        if(descriptionStations.getNiveau() < 2){
                                            if(descriptionStations.getNiveau() == 0){
                                                descriptionStations.setNiveau(1);
                                                descriptionStations.ameliorerMachine();
                                                Usine.montantActuel =
                                                        Usine.montantActuel - 400;
                                                ameliorationFait = true;
                                            }
                                            if(descriptionStations.getNiveau() == 1
                                                    && Usine.montantActuel >= 800
                                                    && !ameliorationFait){
                                                descriptionStations.setNiveau(1);
                                                descriptionStations.ameliorerMachine();
                                                Usine.montantActuel =
                                                        Usine.montantActuel - 800;
                                                ameliorationFait = true;
                                            }
                                        }
                                        if(descriptionStations.getNiveau() == 2
                                                && Usine.montantActuel >= 1600
                                                && !ameliorationFait){
                                            descriptionStations.setNiveau(1);
                                            descriptionStations.ameliorerMachineNiv3();
                                            Usine.montantActuel =
                                                    Usine.montantActuel - 1600;
                                        }
                                    }
                                }catch (Exception e){
                                    System.out.println("Vous ne pouvez pas " +
                                            "encore améliorer la machine.");
                                }
                            }else {
                                mauvaisChar = true;
                                System.out.println("Format de l'amélioration " +
                                        "invalide!");
                            }

                        }catch (NumberFormatException e){
                            mauvaisChar = true;
                            System.out.println("Format invalide!");
                        }
                    }
                }
            }while (mauvaisChar);



        }while (usine.montantActuel < montantFinal && !premierChar.equals("f"));

        if(premierChar.equals("f")){
            System.out.println("--fin de la partie--");
            System.out.println(Usine.montantActuel + "$");
            System.out.println("Nombre de tours : " + Usine.nbrTours);
        }



    }

    private static DescriptionStations getDescriptionStations(int entree, String produit, DescriptionStations descriptionStations) {
        switch (Usine.listeDeStations.get(entree).getNom().toString()){
            case "mmo":
                descriptionStations = DescriptionStations.valueOf(
                        "MOULIN_"+ produit);
                break;
            case "mfo":
                descriptionStations = DescriptionStations.valueOf(
                        "FOURNAISE_"+ produit);
                break;
            case "mfg":
                descriptionStations = DescriptionStations.valueOf(
                        "FOURNAISE_GRILLAGE_"+ produit);
                break;
            case "mfc":
                descriptionStations = DescriptionStations.valueOf(
                        "FOURNAISE_COUPELLATION_"+ produit);
                break;
            case "mto":
                descriptionStations = DescriptionStations.valueOf(
                        "TOURAILLE_"+ produit);
                break;
        }
        return descriptionStations;
    }
}
