package tp2.station;
import tp2.Produit;

public class Fournisseur extends Station {
    public Fournisseur(String nom, Produit produit, int numStation,
                       int numBoite) {
        super(nom, numStation, numBoite);
        setProduit(produit);
    }
}
