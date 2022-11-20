package tp2;

public class ProduitAVendre {
    int qteProduit;
    Produit produit;

    public int calculerPrix(){
        int valeur;
        valeur = qteProduit * produit.valeur;

        return valeur;
    }

    public ProduitAVendre(int qteProduit, Produit produit) {
        this.qteProduit = qteProduit;
        this.produit = produit;
    }
}
