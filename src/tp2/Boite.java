package tp2;

public class Boite {
    private Produit produit1;
    private Produit produit2;
    private int nbrProduit1Necessaire;
    private int nbrProduit2Necessaire;
    private int qteActuelProduit1;
    private int qteActuelProduit2;
    int compteurDeTours = -1;
    boolean complet = false;

    public Boite(int compteurDeTours) {
        this.compteurDeTours = compteurDeTours;
    }

    public Boite(Produit produit1, int nbrProduit1Necessaire) {
        this.produit1 = produit1;
        this.nbrProduit1Necessaire = nbrProduit1Necessaire;
    }

    public Boite(Produit produit1, int nbrProduit1Necessaire,
                 Produit produit2,
                 int nbrProduit2Necessaire) {
        this.produit1 = produit1;
        this.produit2 = produit2;
        this.nbrProduit1Necessaire = nbrProduit1Necessaire;
        this.nbrProduit2Necessaire = nbrProduit2Necessaire;
    }

    public int getNbrToursRestant(DescriptionStations descriptionStations){
       return descriptionStations.nbrTours - compteurDeTours;
    }

    public int getQteActuelProduit1() {
        return qteActuelProduit1;
    }

    public void setQteActuelProduit1(int qteActuelProduit1) {
        this.qteActuelProduit1 = this.qteActuelProduit1 + qteActuelProduit1;
    }

    public int getQteActuelProduit2() {
        return qteActuelProduit2;
    }

    public void setQteActuelProduit2(int qteActuelProduit2) {
        this.qteActuelProduit2 = this.qteActuelProduit2 + qteActuelProduit2;
    }

    public int getNbrProduit1Necessaire() {
        return nbrProduit1Necessaire;
    }

    public int getNbrProduit2Necessaire() {
        return nbrProduit2Necessaire;
    }

    public int getCompteurDeTours() {
        return compteurDeTours;
    }

    public void setCompteurDeTours(int compteurDeTours) {
        this.compteurDeTours = this.compteurDeTours + compteurDeTours;
    }

    public boolean isComplet() {
        return complet;
    }

    public void setComplet(boolean complet) {
        this.complet = complet;
    }

    //    public Boite(int boite1) {
//        this.boite1 = boite1;
//    }
//
//    public Boite(int boite1, int boite2) {
//        this.boite1 = boite1;
//        this.boite2 = boite2;
//    }
}
