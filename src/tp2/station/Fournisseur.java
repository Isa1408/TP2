package tp2.station;
import tp2.Produit;

public class Fournisseur extends Station {
    private Produit produit;
    private int numStation;
    private int numBoite;

    public Fournisseur(String nom, Produit produit, int numStation, int numBoite) {
        super(nom);
        //super(nom, numStation, numBoite);
        this.produit = produit;
        this.numStation = numStation;
        this.numBoite = numBoite;
    }
}
