package tp2.station.machine;

import tp2.Produit;

public class FournaiseDeGrillage extends Machine {
    public FournaiseDeGrillage(String nom, int numStation, int numBoite,
                               Produit [] produitDansBoites) {
        super(nom, numStation, numBoite, produitDansBoites);
        super.setProduitDansBoites(produitDansBoites);
        this.produitDansBoites = produitDansBoites;
    }

//    public FournaiseDeGrillage(String nom, Produit produit, int numStation,
//                               int numBoite) {
//        super(nom, numStation, numBoite);
//        this.produit = produit;
//    }
}
