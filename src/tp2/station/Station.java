package tp2.station;

import tp2.Produit;
import tp2.ProduitAVendre;

import java.util.ArrayList;

/**
 * Représente la classe qui créé les <code>Station</code>s.
 *
 * @Author Isabelle Tamas
 */
public abstract class Station {
    private String nom;
    private int numStation;
    private int numDeBoite;
    private Produit produit;
    private Produit [] produitDansBoites;
    ArrayList<ProduitAVendre> listeDeProduits;

    /**
     * Constructeur de <code>Station</code>.
     *
     * @param nom le nom de la <code>Station</code>
     */
    public Station (String nom){
        this.nom = nom;
        this.produitDansBoites = new Produit[2];
        this.listeDeProduits = new ArrayList<>();
    }

    /**
     * Constructeur de <code>Station</code>.
     *
     * @param nom le nom de la <code>Station</code>
     * @param numDeLivraison l'index de la <code>Station</code> de livraison
     * @param numDeBoite le numéro de la <code>Boite</code> de la
     *                   <code>Station</code> où il sera livré
     */
    public Station(String nom, int numDeLivraison,
                   int numDeBoite) {
        this.nom = nom;
        this.numStation = numDeLivraison;
        this.numDeBoite = numDeBoite;
        this.produitDansBoites = new Produit[2];
    }

    /**
     * Mettre les données importantes de la <code>Station</code> en type
     * <code>String</code>.
     *
     * @return le nom, l'index de la <code>Station</code> de livraison et le
     * numéro de la <code>Boite</code> de la <code>Station</code> de livraison
     */
    public String toString(){
        return this.nom + this.numStation + this.numDeBoite;
    }

    /**
     * Getteur du nom de la <code>Station</code>.
     *
     * @return le nom de la <code>Station</code>
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getteur du numéro de la <code>Station</code> de livraison.
     *
     * @return le numéro de la <code>Station</code> de livraison
     */
    public int getNumStation() {
        return numStation;
    }

    /**
     * Getteur du numéro de la <code>Boite</code> de la <code>Station</code> de
     * livraison.
     *
     * @return numéro de la <code>Boite</code> de la <code>Station</code> de
     * livraison
     */
    public int getNumDeBoite() {
        return numDeBoite;
    }

    /**
     * Setteur du <code>Produit</code>
     *
     * @param produit <code>Produit</code>
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * Getteur du <code>Produit</code>
     *
     * @return <code>Produit</code>
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * Getteur des <code>Produit</code>s dans les <code>Boite</code>s.
     *
     * @return tableau de <code>Produit</code>
     */
    public Produit[] getProduitDansBoites() {
        return produitDansBoites;
    }

    /**
     * Setteur des <code>Produit</code>s dans les <code>Boite</code>s.
     *
     * @param produitDansBoites tableau de <code>Produit</code>s
     */
    public void setProduitDansBoites(Produit[] produitDansBoites) {
        this.produitDansBoites = produitDansBoites;
    }

    /**
     * Getteur du <code>Produit</code> dans la <code>Boite</code> à l'indexe 0.
     *
     * @return <code>Produit</code>
     */
    public Produit getProduitDansBoites1() {
        return produitDansBoites[0];
    }

    /**
     * Getteur du <code>Produit</code> dans la <code>Boite</code> à l'indexe 1.
     *
     * @return <code>Produit</code>
     */
    public Produit getProduitDansBoites2() {
        return produitDansBoites[1];
    }

    /**
     * Setteur du <code>Produit</code> dans la <code>Boite</code> à l'indexe 0.
     *
     * @param produit1 <code>Produit</code>
     */
    public void setProduitDansBoites1(Produit produit1) {
        this.produitDansBoites[0] = produit1;
    }

    /**
     * Setteur du <code>Produit</code> dans la <code>Boite</code> à l'indexe 1.
     *
     * @param produit2 <code>Produit</code>
     */
    public void setProduitDansBoites2(Produit produit2) {
        this.produitDansBoites[1] = produit2;
    }

    /**
     * Getteur de la liste de <code>Produit</code>s.
     *
     * @return <code>Arraylist</code> de type <code>ProduitAVendre</code>
     */
    public ArrayList<ProduitAVendre> getListeDeProduits() {
        return listeDeProduits;
    }
}
