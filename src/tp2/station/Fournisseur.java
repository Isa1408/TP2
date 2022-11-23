package tp2.station;
import tp2.Produit;

/**
 * Représente la classe qui créé les <code>Fournisseur</code>s. Elle est une
 * sous-classe de la classe <code>Station</code>.
 *
 * @Author Isabelle Tamas
 */
public class Fournisseur extends Station {

    /**
     * Constructeur du <code>Fournisseur</code>
     *
     * @param nom le nom de la <code>Station</code>
     * @param produit le <code>Produit</code> qu'il fournit
     * @param numStation le numéro de la <code>Station</code> de livraison
     * @param numBoite le numéro de la <code>Boite</code> de la
     *                 <code>Station</code> de livraison
     */
    public Fournisseur(String nom, Produit produit, int numStation,
                       int numBoite) {
        super(nom, numStation, numBoite);
        setProduit(produit);
    }
}
