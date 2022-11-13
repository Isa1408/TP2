package tp2.station;

import tp2.Produit;

public abstract class Station {
    private String nom;
    private int numDeLivraison;
    private int numDeBoite;
//    private int numDeBoite1;
    private Produit produit;
    private Produit [] produitDansBoites;

    public Station (String nom, Produit [] produitDansBoites){
        this.nom = nom;
        this.produitDansBoites = produitDansBoites;
    }

    public Station(String nom, int numDeLivraison,
                   int numDeBoite) {
        this.nom = nom;
        this.numDeLivraison = numDeLivraison;
        this.numDeBoite = numDeBoite;
        this.produitDansBoites = produitDansBoites;
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

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Produit getProduit() {
        return produit;
    }

    public Produit[] getProduitDansBoites() {
        return produitDansBoites;
    }

//    public void setProduitDansBoites(Produit produit1, Produit produit2) {
//        this.produitDansBoites[0] = produit1;
//        this.produitDansBoites[1] = produit2;
//    }


    public void setProduitDansBoites(Produit[] produitDansBoites) {
        this.produitDansBoites = produitDansBoites;
    }

    public void setProduitDansBoites1(Produit produit1) {
        this.produitDansBoites[0] = produit1;
    }

    public void setProduitDansBoites2(Produit produit2) {
        this.produitDansBoites[1] = produit2;
    }

}
