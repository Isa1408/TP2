package tp2.station.machine;

import tp2.Produit;

public class Fournaise extends Machine {
    // private Produit [] produitDansBoites;
    public Fournaise(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
        //  super.setProduitDansBoites(produitDansBoites);
        //   this.produitDansBoites = produitDansBoites;
    }

  /* @Override
    public void setProduitDansBoites1(Produit produit1) {
        this.produitDansBoites[0] = produit1;
    }

    @Override
    public void setProduitDansBoites2(Produit produit2) {
        this.produitDansBoites[1] = produit2;
    }*/

    //    public Fournaise(String nom, Produit produit, int numStation,
//                     int numBoite) {
//        super(nom, numStation, numBoite);
//        this.produit = produit;
//    }
}
