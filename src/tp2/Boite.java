package tp2;

/**
 * Représente la classe qui créé les <code>Boite</code>s.
 *
 * @Author Isabelle Tamas
 */
public class Boite {
    private Produit produit1;
    private Produit produit2;
    private int nbrProduit1Necessaire;
    private int nbrProduit2Necessaire;
    private int qteActuelProduit1;
    private int qteActuelProduit2;
    int compteurDeTours = -1;
    boolean complet = false;

    /**
     * Constructeur de <code>Boite</code>.
     *
     * @param compteurDeTours un compteur de tours
     */
    public Boite(int compteurDeTours) {
        this.compteurDeTours = compteurDeTours;
    }

    /**
     * Constructeur de <code>Boite</code>.
     *
     * @param produit1 un <code>Produit</code>
     * @param nbrProduit1Necessaire le nombre de <code>Produit</code>s
     *                              nécessaires
     */
    public Boite(Produit produit1, int nbrProduit1Necessaire) {
        this.produit1 = produit1;
        this.nbrProduit1Necessaire = nbrProduit1Necessaire;
    }

    /**
     * Constructeur de <code>Boite</code>.
     *
     * @param produit1 un <code>Produit</code>
     * @param nbrProduit1Necessaire le nombre de <code>Produit</code>s
     *                              nécessaires
     * @param produit2 un deuxième <code>Produit</code>
     * @param nbrProduit2Necessaire le nombre de <code>Produit</code>s
     *                              nécessaires
     */
    public Boite(Produit produit1, int nbrProduit1Necessaire,
                 Produit produit2,
                 int nbrProduit2Necessaire) {
        this.produit1 = produit1;
        this.produit2 = produit2;
        this.nbrProduit1Necessaire = nbrProduit1Necessaire;
        this.nbrProduit2Necessaire = nbrProduit2Necessaire;
    }

    /**
     * Getteur du nombre de tours restant pour la livraison.
     *
     * @param descriptionStations une <code>DescriptionStations</code>
     * @return le nombre de tours qui restent avant de faire la livraison
     */
    public int getNbrToursRestant(DescriptionStations descriptionStations){
       return descriptionStations.nbrTours - compteurDeTours;
    }

    /**
     * Getteur de la quantité de <code>Produit</code>s dans la première
     * <code>Boite</code>.
     *
     * @return la quantité de <code>Produit</code>s
     */
    public int getQteActuelProduit1() {
        return qteActuelProduit1;
    }

    /**
     * Setteur de la quantité de <code>Produit</code>s dans la première
     * <code>Boite</code>.
     *
     * @param qteActuelProduit1 la nouvelle quantité de <code>Produit</code>s
     */
    public void setQteActuelProduit1(int qteActuelProduit1) {
        this.qteActuelProduit1 = this.qteActuelProduit1 + qteActuelProduit1;
    }

    /**
     * Getteur de la quantité de <code>Produit</code>s dans la deuxième
     * <code>Boite</code>.
     *
     * @return la quantité de <code>Produit</code>s
     */
    public int getQteActuelProduit2() {
        return qteActuelProduit2;
    }

    /**
     * Setteur de la quantité de <code>Produit</code>s dans la deuxième
     * <code>Boite</code>.
     *
     * @param qteActuelProduit2 la nouvelle quantité de <code>Produit</code>s
     */
    public void setQteActuelProduit2(int qteActuelProduit2) {
        this.qteActuelProduit2 = this.qteActuelProduit2 + qteActuelProduit2;
    }

    /**
     * Getteur du nombre de <code>Produit</code>s nécessaires dans la
     * première <code>Boite</code>.
     *
     * @return le nombre de <code>Produit</code>s nécessaires
     */
    public int getNbrProduit1Necessaire() {
        return nbrProduit1Necessaire;
    }

    /**
     * Getteur du nombre de <code>Produit</code>s nécessaires dans la
     * deuxième <code>Boite</code>.
     *
     * @return le nombre de <code>Produit</code>s nécessaires
     */
    public int getNbrProduit2Necessaire() {
        return nbrProduit2Necessaire;
    }

    /**
     * Getteur du compteur de tours.
     *
     * @return le nombre de tours
     */
    public int getCompteurDeTours() {
        return compteurDeTours;
    }

    /**
     * Setteur du compteur de tours.
     *
     * @param compteurDeTours le nouveau nombre de tours
     */
    public void setCompteurDeTours(int compteurDeTours) {
        this.compteurDeTours = this.compteurDeTours + compteurDeTours;
    }

    /**
     * Savoir si la <code>Boite</code> contient les <code>Produits</code>
     * nécessaires à la production.
     *
     * @return true si la <code>Boite</code> contient les
     * <code>Produits</code> nécessaires à la production
     */
    public boolean isComplet() {
        return complet;
    }

    /**
     * Setteur de la <code>Boite</code>.
     *
     * @param complet true si la <code>Boite</code> contient les
     * <code>Produits</code> nécessaires à la production
     */
    public void setComplet(boolean complet) {
        this.complet = complet;
    }
}
