package tp2.station;

import tp2.Produit;
import tp2.ProduitAVendre;

import java.util.ArrayList;

/**
 * Représente la classe qui créé les <code>Vendeur</code>s. Elle est une
 * sous-classe de la classe <code>Station</code>.
 *
 * @Author Isabelle Tamas
 */
public class Vendeur extends Station {
    ArrayList<ProduitAVendre> listeDeProduits;

    /**
     * Constructeur du <code>Vendeur</code>.
     *
     * @param nom le nom du <code>Vendeur</code>
     */
    public Vendeur(String nom) {
        super(nom);
        listeDeProduits = new ArrayList<>();
    }
}
