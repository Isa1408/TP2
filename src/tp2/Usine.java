package tp2;

import tp2.station.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usine {
    ArrayList<Station> listeDeStations;
    ArrayList<String> listeString;
    int debutMontant;
    int finMontant;
    int montantActuel;
    int nbrTours;

   // private static final List<String> typesDeStations =
   //         Arrays.asList("fou","mmo","mfo","mfg","mfc","mto","ven");

    public Usine( ArrayList<String> liste) {
        this.listeDeStations = filtrerListeString(liste);
        this.debutMontant = Integer.parseInt(liste.get(0));
        this.finMontant = Integer.parseInt(liste.get(1));
        this.montantActuel = debutMontant;
        this.nbrTours = 0;
    }

    public static ArrayList<Station> filtrerListeString(ArrayList<String> liste){
        ArrayList<Station> listeDeStations = new ArrayList<>();


        return listeDeStations;
    }

    public int getDebutMontant() {
        return debutMontant;
    }

    public int getFinMontant() {
        return finMontant;
    }

    public int getMontantActuel() {
        return montantActuel;
    }

    public int getNbrTours() {
        return nbrTours;
    }

    public void setMontantActuel(int montantActuel) {
        this.montantActuel = montantActuel;
    }

    public void setNbrTours(int nbrTours) {
        this.nbrTours = nbrTours;
    }
}
