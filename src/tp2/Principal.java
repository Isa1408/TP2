package tp2;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = LireFichier.listeString(); //il affiche la
            // premiere ligne pour le fichier
        Usine usine = new Usine(liste);
        int debutMontant = usine.debutMontant;
        int montantFinal = usine.finMontant;
        int montantActuel = usine.montantActuel;
        int nbrTours = usine.nbrTours;
        String commande;
        Boolean mauvaisChar;
        String premierChar;
        int entree;


        do{

            //scanner pour connaitre la prochaine etape que l utilisateur
                // veut faire

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
//                                nbrTours = nbrTours + entree;
//                                usine.setNbrTours(nbrTours);
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
                }
            }while (mauvaisChar);



        }while (usine.montantActuel < montantFinal && !premierChar.equals("f"));





        //Usine.afficherEtatUsine(usine);

//        System.out.println(Arrays.toString(DescriptionStations.values()));
//        System.out.println(DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.getBoite().toString());



    }
}
