package tp2;

public class Boite {
//    private int boite1;
//    private int boite2;
    private Produit produit1;
    private Produit produit2;
    private int nbrProduit1;
    private int nbrProduit2;

    public Boite(Produit produit1, int nbrProduit1) {
        this.produit1 = produit1;
        this.nbrProduit1 = nbrProduit1;
    }

    public Boite(Produit produit1, int nbrProduit1, Produit produit2,
                 int nbrProduit2) {
        this.produit1 = produit1;
        this.produit2 = produit2;
        this.nbrProduit1 = nbrProduit1;
        this.nbrProduit2 = nbrProduit2;
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
