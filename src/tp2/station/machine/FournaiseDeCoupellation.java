package tp2.station.machine;

import tp2.Produit;

public class FournaiseDeCoupellation extends Machine {
    public FournaiseDeCoupellation(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
    }

    public FournaiseDeCoupellation(String nom, Produit produit, int numStation,
                                   int numBoite) {
        super(nom, numStation, numBoite);
        this.produit = produit;
    }
}
