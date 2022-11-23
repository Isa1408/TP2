package tp2.station.machine;
import tp2.Produit;
import tp2.station.Station;

import java.util.Arrays;

/**
 * Représente la classe qui contient les caractéristiques de toutes les
 * <code>Machine</code>s. Elle est la super-classe des autres
 * <code>Machine</code>s et la sous-classe de la classe <code>Station</code>.
 *
 * @Author Isabelle Tamas
 */
public class Machine extends Station {
    int compteurTour;
    int numStation;

    /**
     * Constructeur de la <code>Machine</code>.
     *
     * @param nom le nom de la <code>Station</code>
     * @param numStation le numéro de la <code>Station</code> de livraison
     * @param numBoite le numéro de la <code>Boite</code> de la
     *                 <code>Station</code> de livraison
     */
    public Machine(String nom, int numStation, int numBoite) {
        super(nom, numStation, numBoite);
    }
}
