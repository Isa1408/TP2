package tp2.station.machine;
import tp2.Produit;

/**
 * Représente la classe qui créé les <code>FournaiseDeCoupellation</code>s. Elle
 * est une sous-classe de la classe <code>Machine</code>.
 *
 * @Author Isabelle Tamas
 */
public class FournaiseDeCoupellation extends Machine {
    /**
     * Constructeur de la <code>FournaiseDeCoupellation</code>.
     *
     * @param nom le nom de la <code>Station</code>
     * @param numStation le numéro de la <code>Station</code> de livraison
     * @param numBoite le numéro de la <code>Boite</code> de la
     *                 <code>Station</code> de livraison
     */
    public FournaiseDeCoupellation(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
    }
}
