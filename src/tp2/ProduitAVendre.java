package tp2;

/**
 * Représente la classe qui contient les méthodes pour la vente de
 * <code>Produit</code>s.
 *
 * @Author Isabelle Tamas
 */
public class ProduitAVendre {
    int qteProduit;
    Produit produit;

    /**
     * Calculer le prix de vente selon le nombre de <code>Produit</code>s.
     *
     * @return la valeur de la vente
     */
    public int calculerPrix(){
        int valeur;
        valeur = qteProduit * produit.valeur;

        return valeur;
    }

    /**
     * Constructeur de <code>ProduitAVendre</code>.
     *
     * @param qteProduit la quantité de <code>Produit</code>s
     * @param produit le <code>Produit</code>
     */
    public ProduitAVendre(int qteProduit, Produit produit) {
        this.qteProduit = qteProduit;
        this.produit = produit;
    }
}
