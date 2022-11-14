package tp2.station.machine;
import tp2.Produit;
import tp2.station.Station;

import java.util.Arrays;

public class Machine extends Station {
    int compteurTour;
    int numStation;
//    int numBoite0;
//    int numBoite1;
    //  Produit produit;
    // private Produit [] produitDansBoites;


    public Machine(String nom, int numStation, int numBoite) {
        //super(nom);
        super(nom, numStation, numBoite);
        //this.produit = produit;
        //this.numStation = numStation;
        //  this.produitDansBoites = produitDansBoites;
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
                "numStation=" + super.getNumStation() + ", numBoite="+ super.getNumDeBoite() +
                ", produit=" + Arrays.toString(super.getProduitDansBoites()) +
                '}';
    }

    //    public Machine(String nom, int numStation, int numBoite0, int numBoite1) {
//        //super(nom);
//        super(nom, numStation, numBoite0, numBoite1);
//        this.numStation = numStation;
//        //this.numBoite0 = numBoite0;
//    }

  /*  @Override
    public Produit[] getProduitDansBoites() {
        return produitDansBoites;
    }*/

    // public void setProduitDansBoites(Produit[] produitDansBoites) {
    // super.setProduitDansBoites(produitDansBoites);
    //    this.produitDansBoites = produitDansBoites;
    //  }

    //  @Override
  /*  public void setProduitDansBoites1(Produit produit1) {
        this.produitDansBoites[0] = produit1;
    }

   // @Override
    public void setProduitDansBoites2(Produit produit2) {
        this.produitDansBoites[1] = produit2;
    }*/
    //pcq je l ai mit dans super
//    public void setProduit(Produit produit) {
//        this.produit = produit;
//    }
}
