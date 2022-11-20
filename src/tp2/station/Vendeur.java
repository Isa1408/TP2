package tp2.station;

import tp2.Produit;
import tp2.ProduitAVendre;

import java.util.ArrayList;

public class Vendeur extends Station {
    ArrayList<ProduitAVendre> listeDeProduits;
    public Vendeur(String nom) {
        super(nom);
        listeDeProduits = new ArrayList<>();
    }

//    public ArrayList<ProduitAVendre> getListeDeProduits() {
//        return listeDeProduits;
//    }
}
