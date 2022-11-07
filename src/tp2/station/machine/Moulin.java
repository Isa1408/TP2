package tp2.station.machine;

import tp2.Produit;

public class Moulin extends Machine {
    public Moulin(String nom, Produit produit, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
        this.produit = produit;
    }

    //pour filtrer liste string
    public Moulin(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
    }
}
