package tp2;
import tp2.station.Station;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = lireFichier.listeString();
        Usine usine = new Usine(liste);
        Usine.afficherEtatUsine(usine);



       //ArrayList<Station> listeDeStations = Usine.filtrerListeString(liste);

    }
}
