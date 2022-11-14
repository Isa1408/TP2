package tp2.station.machine;
import tp2.Produit;
import tp2.station.Station;

import java.util.Arrays;

public class Machine extends Station {
    int compteurTour;
    int numStation;

    public Machine(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
    }

    @Override
    public String toString() {
        return "Machine{" +
                "numStation=" + super.getNumStation() + ", numBoite="+ super.getNumDeBoite() +
                ", produit=" + Arrays.toString(super.getProduitDansBoites()) +
                '}';
    }
}
