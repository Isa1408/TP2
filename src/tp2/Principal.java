package tp2;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = LireFichier.listeString(); //il affiche la
            // premiere ligne pour le fichier
        Usine usine = new Usine(liste);
        int debutMontant = usine.debutMontant;
        int montantFinal = usine.finMontant;
        int montantActuel = usine.montantActuel;
        int nbrTours = usine.nbrToursTest;


        do{

            //scanner pour connaitre la prochaine etape que l utilisateur
                // veut faire

            Usine.setteurDeProduitStationsParLesFournisseurs(); //set les boites des stations
                // qui sont en lien direct avec le fournisseur (a revoir)
            Usine.afficherEtatUsine();//afficher etat de l usine

            usine.setMontantActuel(montantActuel); //set le montant actuel
            System.out.println(usine.montantActuel + "$"); //afficher le
            // montant actuel
            nbrTours++;
            usine.setNbrTours(nbrTours); //set le nombre de tours
            System.out.println();
        }while (usine.getNbrTours() < 16); //until montantActuel <
        // montantFinale || utilisateur a dit f




        //Usine.afficherEtatUsine(usine);

//        System.out.println(Arrays.toString(DescriptionStations.values()));
//        System.out.println(DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.getBoite().toString());



    }
}
