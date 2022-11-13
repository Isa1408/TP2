package tp2.station.machine;

import tp2.Produit;

public class FournaiseDeCoupellation extends Machine {
    public FournaiseDeCoupellation(String nom, int numStation, int numBoite,
                                   Produit [] produitDansBoites) {
        super(nom, numStation, numBoite, produitDansBoites);
        super.setProduitDansBoites(produitDansBoites);
        this.produitDansBoites = produitDansBoites;
    }

//    public FournaiseDeCoupellation(String nom, Produit produit, int numStation,
//                                   int numBoite) {
//        super(nom, numStation, numBoite);
//        this.produit = produit;
//    }
}
