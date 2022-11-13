package tp2;
import tp2.station.Station;

import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = lireFichier.listeString();
        Usine usine = new Usine(liste);
        //Usine.afficherEtatUsine(usine);
        Usine.setteurDeProduitStations();
//        System.out.println(Arrays.toString(DescriptionStations.values()));
//        System.out.println(DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.getBoite().toString());




//        System.out.println(DescriptionStations.FOURNAISE_ACANTHITE.getNbrTours());
//        DescriptionStations.FOURNAISE_ACANTHITE.diminuerNbrTours();
//        System.out.println(DescriptionStations.FOURNAISE_ACANTHITE.getNbrTours());
//        System.out.println(DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.getNbrProduitLivre());
//        DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.augQteFabriquee();
//        System.out.println(DescriptionStations.FOURNAISE_COUPELLATION_OXYDE_ARGENT.getNbrProduitLivre());



       //ArrayList<Station> listeDeStations = Usine.filtrerListeString(liste);

    }
}
