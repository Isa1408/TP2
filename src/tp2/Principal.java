package tp2;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = lireFichier.listeString(); //il affiche la
            // premiere ligne pour le fichier
        Usine usine = new Usine(liste);
        int debutMontant = usine.debutMontant;
        int montantFinal = usine.finMontant;
        int montantActuel = usine.montantActuel;
        int nbrTours = usine.nbrToursTest;

        do{
            //afficher etat de l usine
            //scanner pour connaitre la prochaine etape que l utilisateur
                // veut faire

            Usine.setteurDeProduitStations(); //set les boites des stations
                // qui sont en lien direct avec le fournisseur (a revoir)

            usine.setMontantActuel(montantActuel); //set le montant actuel
            System.out.println(usine.montantActuel); //afficher le montant actuel
            nbrTours++;
            usine.setNbrTours(nbrTours); //set le nombre de tours
        }while (usine.getNbrTours() < 10);



        //Usine.afficherEtatUsine(usine);

//        System.out.println(Arrays.toString(DescriptionStations.values()));
//        System.out.println(DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.getBoite().toString());



    }
}
