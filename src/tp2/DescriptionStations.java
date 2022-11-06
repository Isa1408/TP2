package tp2;

public enum DescriptionStations {
  FOURNISSEUR_ACANTHITE("Fournisseur", 2, Produit.ACANTHITE, 1),
  FOURNISSEUR_CASSITERITE("Fournisseur", 7, Produit.CASSITERITE, 1),
  FOURNISSEUR_CHALCOCITE("Fournisseur", 3, Produit.CHALCOCITE, 1),
  FOURNISSEUR_CHARBON("Fournisseur", 1, Produit.CHARBON, 1),
  MOULIN_ACANTHITE("Moulin", 3,
          new Boite(Produit.ACANTHITE, 1), Produit.POUDRE_ACANTHITE, 1),
  MOULIN_CASSITERRITE("Moulin", 7,
          new Boite(Produit.CASSITERITE, 1), Produit.POUDRE_CASSITERITE, 1),
  MOULIN_CHALCOCITE("Moulin", 3,
          new Boite(Produit.CHALCOCITE, 1), Produit.POUDRE_CHALCOCITE, 1),
  FOURNAISE_ACANTHITE("Fournaise", 4,
          new Boite(Produit.ACANTHITE, 1),
          Produit.LITHARGE, 1),
  FOURNAISE_POUDRE_ACANTHITE("Fournaise", 4,
          new Boite(Produit.POUDRE_ACANTHITE, 1),
          Produit.LITHARGE, 2),
  FOURNAISE_LINGOTS_CUIVRE("Fournaise", 4,
          new Boite(Produit.LINGOT_CUIVRE, 7, Produit.LINGOT_ETAIN, 1),
          Produit.LITHARGE, 2),
  FOURNAISE_GRILLAGE_LITHARGE("Fournaise de grillage", 14,
          new Boite(Produit.LITHARGE, 1, Produit.COKE, 1),
          Produit.OXYDE_ARGENT, 1),
  FOURNAISE_GRILLAGE_CASSITERITE("Fournaise de grillage", 12,
          new Boite(Produit.CASSITERITE, 1, Produit.COKE, 1),
          Produit.OXYDE_ETAIN, 1),
  FOURNAISE_GRILLAGE_POUDRE_CASSITERITE("Fournaise de grillage", 12,
          new Boite(Produit.POUDRE_CASSITERITE, 1, Produit.COKE, 1),
          Produit.OXYDE_ETAIN, 2),
  FOURNAISE_GRILLAGE_CHALCOCITE("Fournaise de grillage", 13,
          new Boite(Produit.CHALCOCITE, 1, Produit.COKE, 1),
          Produit.OXYDE_CUIVRE, 1),
  FOURNAISE_GRILLAGE_POUDRE_CHALCOCITE("Fournaise de grillage", 13,
          new Boite(Produit.POUDRE_CHALCOCITE, 1, Produit.COKE, 1),
          Produit.OXYDE_CUIVRE, 2),
  FOURNAISE_COUPELLATION_OXYDE_ARGENT("Fournaise de coupellation", 10,
          new Boite(Produit.OXYDE_ARGENT, 1),
          Produit.LINGOT_ARGENT, 1),
  FOURNAISE_COUPELLATION_OXYDE_ETAIN("Fournaise de coupellation", 2,
          new Boite(Produit.OXYDE_ETAIN, 1),
          Produit.LINGOT_ETAIN, 1),
  FOURNAISE_COUPELLATION_OXYDE_CUIVRE("Fournaise de coupellation", 3,
          new Boite(Produit.OXYDE_CUIVRE, 1),
          Produit.LINGOT_CUIVRE, 1),
  TOURAILLE_CHARBON("Touraille", 20,
          new Boite(Produit.CHARBON, 1),
          Produit.COKE, 1),
  //VENDEUR("Vendeur", new Boite(Produit))
  ;
  public String nomMachine;
  public int nbrTours;
  public Boite boite;
  public Produit livre;
  public int nbrProduitLivre;

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
}
