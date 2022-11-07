package tp2.station;

import tp2.Produit;

public abstract class Station {
    private String nom;
    private int numDeLivraison;
    private int numDeBoite;
    private int numDeBoite1;
    private Produit produit;

    public Station (String nom){
        this.nom = nom;
    }

    public Station(String nom, int numDeLivraison,
                   int numDeBoite) {
        this.nom = nom;
        this.numDeLivraison = numDeLivraison;
        this.numDeBoite = numDeBoite;
    }

//    public Station(String nom, Produit produit, int numDeLivraison,
//                   int numDeBoite) {
//        this.nom = nom;
//        this.produit = produit;
//        this.numDeLivraison = numDeLivraison;
//        this.numDeBoite = numDeBoite;
//    }


//    public Station(String nom, int numDeLivraison, int numDeBoite, int numDeBoite1) {
//        this.nom = nom;
//        this.numDeLivraison = numDeLivraison;
//        this.numDeBoite = numDeBoite;
//        this.numDeBoite1 = numDeBoite1;
//    }

    //pas important
    public String toString(){
        return this.nom + this.numDeLivraison + this.numDeBoite;
    }

    public String getNom() {
        return nom;
    }

    public int getNumDeLivraison() {
        return numDeLivraison;
    }

    public int getNumDeBoite() {
        return numDeBoite;
    }

}
