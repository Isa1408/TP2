package tp2.station.machine;

import tp2.Produit;

public class Touraille extends Machine {
    public Touraille(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
    }

    public Touraille(String nom, Produit produit, int numStation,
                     int numBoite) {
        super(nom, numStation, numBoite);
        this.produit = produit;
    }
}
