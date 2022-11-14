package tp2.station;

import tp2.Produit;

public abstract class Station {
    private String nom;
    private int numStation;
    private int numDeBoite;
    private Produit produit;
    private Produit [] produitDansBoites;

    public Station (String nom){
        this.nom = nom;
        this.produitDansBoites = new Produit[2];
    }

    public Station(String nom, int numDeLivraison,
                   int numDeBoite) {
        this.nom = nom;
        this.numStation = numDeLivraison;
        this.numDeBoite = numDeBoite;
        this.produitDansBoites = new Produit[2];
    }

    //pas important
    public String toString(){
        return this.nom + this.numStation + this.numDeBoite;
    }

    public String getNom() {
        return nom;
    }

    public int getNumStation() {
        return numStation;
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

    public void setProduitDansBoites(Produit[] produitDansBoites) {
        this.produitDansBoites = produitDansBoites;
    }

    public Produit getProduitDansBoites1() {
        return produitDansBoites[0];
    }
    public Produit getProduitDansBoites2() {
        return produitDansBoites[1];
    }

    public void setProduitDansBoites1(Produit produit1) {
        this.produitDansBoites[0] = produit1;
    }

    public void setProduitDansBoites2(Produit produit2) {
        this.produitDansBoites[1] = produit2;
    }

}
