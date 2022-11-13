package tp2.station.machine;
import tp2.Produit;
import tp2.station.Station;

import java.util.Arrays;

public class Machine extends Station {
    int compteurTour;
    int numStation;
//    int numBoite0;
//    int numBoite1;
    Produit produit;
    Produit [] produitDansBoites;

    public Machine(String nom, int numStation, int numBoite,
                   Produit [] produitDansBoites) {
        //super(nom);
        super(nom, numStation, numBoite);
        //this.produit = produit;
        this.numStation = numStation;
        this.produitDansBoites = produitDansBoites;
        //this.numBoite0 = numBoite0;
    }

//    public Machine(String nom, Produit produit, int numStation, int numBoite) {
//        //super(nom);
//        super(nom,numStation, numBoite);
//        this.produit = produit;
//        this.numStation = numStation;
//        //this.numBoite0 = numBoite0;
//    }

    @Override
    public String toString() {
        return "Machine{" +
                "numStation=" + numStation + ", numBoite="+ super.getNumDeBoite() +
                ", produit=" + Arrays.toString(super.getProduitDansBoites()) +
                '}';
    }

    //    public Machine(String nom, int numStation, int numBoite0, int numBoite1) {
//        //super(nom);
//        super(nom, numStation, numBoite0, numBoite1);
//        this.numStation = numStation;
//        //this.numBoite0 = numBoite0;
//    }

    @Override
    public Produit[] getProduitDansBoites() {
        return produitDansBoites;
    }

    public void setProduitDansBoites(Produit[] produitDansBoites) {
        super.setProduitDansBoites(produitDansBoites);
        this.produitDansBoites = produitDansBoites;
    }
    //pcq je l ai mit dans super
//    public void setProduit(Produit produit) {
//        this.produit = produit;
//    }
}
