package tp2.station;
import tp2.Produit;

public class Fournisseur extends Station {
    private Produit produit;
    private int numStation;
    private int numBoite;
    private Produit [] produitDansBoites;

    public Fournisseur(String nom, Produit produit, int numStation,
                       int numBoite, Produit [] produitDansBoites) {
        super(nom, numStation, numBoite);
        //super(nom, numStation, numBoite);
        this.produit = produit;
        this.produitDansBoites = produitDansBoites;
        //this.numStation = numStation;
        //this.numBoite = numBoite;
    }

    @Override
    public void setProduitDansBoites(Produit[] produitDansBoites) {
        this.produitDansBoites = produitDansBoites;
    }

    public Produit getProduit() {
        return produit;
    }

}
