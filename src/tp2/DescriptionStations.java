package tp2;

public enum DescriptionStations {
  FOURNISSEUR_ACANTHITE("fou", 2, Produit.ACANTHITE, 1),
  FOURNISSEUR_CASSITERITE("fou", 7, Produit.CASSITERITE, 1),
  FOURNISSEUR_CHALCOCITE("fou", 3, Produit.CHALCOCITE, 1),
  FOURNISSEUR_CHARBON("fou", 1, Produit.CHARBON, 1),
  MOULIN_ACANTHITE("mmo", 3,
          new Boite(Produit.ACANTHITE, 1), Produit.POUDRE_ACANTHITE, 1),
  MOULIN_CASSITERRITE("mmo", 7,
          new Boite(Produit.CASSITERITE, 1), Produit.POUDRE_CASSITERITE, 1),
  MOULIN_CHALCOCITE("mmo", 3,
          new Boite(Produit.CHALCOCITE, 1), Produit.POUDRE_CHALCOCITE, 1),
  FOURNAISE_ACANTHITE("mfo", 4,
          new Boite(Produit.ACANTHITE, 1),
          Produit.LITHARGE, 1),
  FOURNAISE_POUDRE_ACANTHITE("mfo", 4,
          new Boite(Produit.POUDRE_ACANTHITE, 1),
          Produit.LITHARGE, 2),
  FOURNAISE_LINGOTS_CUIVRE("mfo", 4,
          new Boite(Produit.LINGOT_CUIVRE, 7, Produit.LINGOT_ETAIN, 1),
          Produit.LINGOT_BRONZE, 8),
  FOURNAISE_GRILLAGE_LITHARGE("mfg", 14,
          new Boite(Produit.LITHARGE, 1, Produit.COKE, 1),
          Produit.OXYDE_ARGENT, 1),
  FOURNAISE_GRILLAGE_CASSITERITE("mfg", 12,
          new Boite(Produit.CASSITERITE, 1, Produit.COKE, 1),
          Produit.OXYDE_ETAIN, 1),
  FOURNAISE_GRILLAGE_POUDRE_CASSITERITE("mfg", 12,
          new Boite(Produit.POUDRE_CASSITERITE, 1, Produit.COKE, 1),
          Produit.OXYDE_ETAIN, 2),
  FOURNAISE_GRILLAGE_CHALCOCITE("mfg", 13,
          new Boite(Produit.CHALCOCITE, 1, Produit.COKE, 1),
          Produit.OXYDE_CUIVRE, 1),
  FOURNAISE_GRILLAGE_POUDRE_CHALCOCITE("mfg", 13,
          new Boite(Produit.POUDRE_CHALCOCITE, 1, Produit.COKE, 1),
          Produit.OXYDE_CUIVRE, 2),
  FOURNAISE_COUPELLATION_OXYDE_ARGENT("mfc", 10,
          new Boite(Produit.OXYDE_ARGENT, 1),
          Produit.LINGOT_ARGENT, 1),
  FOURNAISE_COUPELLATION_OXYDE_ETAIN("mfc", 2,
          new Boite(Produit.OXYDE_ETAIN, 1),
          Produit.LINGOT_ETAIN, 1),
  FOURNAISE_COUPELLATION_OXYDE_CUIVRE("mfc", 3,
          new Boite(Produit.OXYDE_CUIVRE, 1),
          Produit.LINGOT_CUIVRE, 1),
  TOURAILLE_CHARBON("mto", 20,
          new Boite(Produit.CHARBON, 1),
          Produit.COKE, 1),
  //VENDEUR("ven", new Boite(Produit))
  ;
  public String nomMachine;
  public int nbrTours;
  public Boite boite;
  public Produit livre;
  public int nbrProduitLivre;
  public boolean nbrToursComplet = false;

  //pour le vendeur
  DescriptionStations(String nomMachine, Boite boite) {
    this.nomMachine = nomMachine;
    this.boite = boite;
  }

  //pour le fournisseur
  DescriptionStations(String nomMachine, int nbrTours, Produit livre, int nbrProduitLivre) {
    this.nomMachine = nomMachine;
    this.nbrTours = nbrTours;
    this.livre = livre;
    this.nbrProduitLivre = nbrProduitLivre;
  }

  //pour les types de machines
  DescriptionStations(String nomMachine, int nbrTours, Boite boite,
                      Produit livre, int nbrProduitLivre) {
    this.nomMachine = nomMachine;
    this.nbrTours = nbrTours;
    this.boite = boite;
    this.livre = livre;
    this.nbrProduitLivre = nbrProduitLivre;
  }

  public void diminuerNbrTours(){
    this.nbrTours--;
  }

  public void augQteFabriquee(){
    this.nbrProduitLivre++;
  }
  public String getNomMachine() {
    return nomMachine;
  }

  public int getNbrTours() {
    return nbrTours;
  }

  public Boite getBoite() {
    return boite;
  }

  public Produit getLivre() {
    return livre;
  }

  public int getNbrProduitLivre() {
    return nbrProduitLivre;
  }

  public boolean isNbrToursComplet() {
    return nbrToursComplet;
  }

  public void setNbrToursComplet(boolean nbrToursComplet) {
    this.nbrToursComplet = nbrToursComplet;
  }
}
