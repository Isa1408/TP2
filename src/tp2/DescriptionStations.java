package tp2;

/**
 * Représente la classe Enum qui contient la description de toutes les
 * <code>Station</code>s.
 *
 * @Author Isabelle Tamas
 */
public enum DescriptionStations {
  FOURNISSEUR_ACANTHITE("fou", 2, Produit.ACANTHITE, 1, new Boite(0)),
  FOURNISSEUR_CASSITERITE("fou", 7, Produit.CASSITERITE, 1, new Boite(0)),
  FOURNISSEUR_CHALCOCITE("fou", 3, Produit.CHALCOCITE, 1, new Boite(0)),
  FOURNISSEUR_CHARBON("fou", 1, Produit.CHARBON, 1, new Boite(0)),
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
  ;
  public String nomMachine;
  public int nbrTours;
  public Boite boite;
  public Produit livre;
  public int nbrProduitLivre;
  public boolean nbrToursComplet = false;
  public int niveau = 0;
  public int nbrToursRestant;


  /**
   * Constructeur de <code>DescriptionStations</code> utilisé pour les
   * <code>Station</code>s de type <code>Fournisseur</code>.
   *
   * @param nomMachine le nom du <code>Fournisseur</code>
   * @param nbrTours le nombre de tours nécessaires à la livraison
   * @param livre le <code>Produit</code> livré
   * @param nbrProduitLivre le nombre de <code>Produit</code>s livrés
   * @param boite la <code>Boite</code>
   */
  DescriptionStations(String nomMachine, int nbrTours, Produit livre,
                      int nbrProduitLivre, Boite boite) {
    this.nomMachine = nomMachine;
    this.nbrTours = nbrTours;
    this.boite = boite;
    this.livre = livre;
    this.nbrProduitLivre = nbrProduitLivre;
  }

  /**
   * Constructeur de <code>DescriptionStations</code> utilisé pour les
   * <code>Station</code>s de type <code>Machine</code>.
   *
   * @param nomMachine le nom de la <code>Machine</code>
   * @param nbrTours le nombre de tours nécessaires à la livraison
   * @param boite la <code>Boite</code>
   * @param livre le <code>Produit</code> livré
   * @param nbrProduitLivre le nombre de <code>Produit</code>s livrés
   */
  DescriptionStations(String nomMachine, int nbrTours, Boite boite,
                      Produit livre, int nbrProduitLivre) {
    this.nomMachine = nomMachine;
    this.nbrTours = nbrTours;
    this.boite = boite;
    this.livre = livre;
    this.nbrProduitLivre = nbrProduitLivre;
  }

  /**
   * Getteur du niveau de la <code>Machine</code>.
   *
   * @return le niveau
   */
  public int getNiveau() {
    return niveau;
  }

  /**
   * Setteur du niveau de la <code>Machine</code>.
   *
   * @param niveau le niveau
   */
  public void setNiveau(int niveau) {
    this.niveau = this.niveau + niveau;
  }

  /**
   * Améliorer la <code>Machine</code> au niveau 1 et 2.
   *
   */
  public void ameliorerMachine(){
    diminuerNbrTours();
  }

  /**
   * Améliorer la <code>Machine</code> au niveau 3.
   *
   */
  public void ameliorerMachineNiv3(){
    augQteFabriquee();
  }

  /**
   * Diminuer le nombre de tours nécessaire pour une machine avant de livrer
   * son produit.
   *
   */
  public void diminuerNbrTours(){
    this.nbrTours--;
  }

  /**
   * Augmenter le nombre de <code>Produit</code>s fabriqués.
   *
   */
  public void augQteFabriquee(){
    this.nbrProduitLivre++;
  }

  /**
   * Retourne le nom de la <code>Machine</code>.
   *
   * @return le nom de la <code>Machine</code>
   */
  public String getNomMachine() {
    return nomMachine;
  }

  /**
   * Retourne le nombre de tours nécessaires à la livraison du
   * <code>Produit</code>.
   *
   * @return le nombre de tours
   */
  public int getNbrTours() {
    return nbrTours;
  }

  /**
   * Retourne la <code>Boite</code> de la <code>Machine</code>.
   *
   * @return la <code>Boite</code>
   */
  public Boite getBoite() {
    return boite;
  }

  /**
   * Retourne le <code>Produit</code> qui sera livré.
   *
   * @return le <code>Produit</code>
   */
  public Produit getLivre() {
    return livre;
  }

  /**
   * Retourne le nombre de <code>Produit</code>s qui seront livrés.
   *
   * @return le nombre de <code>Produit</code>s
   */
  public int getNbrProduitLivre() {
    return nbrProduitLivre;
  }

  /**
   * Retourne l'état de la <code>Station</code>. Savoir si elle contient le
   * nombre de tours nécessaires à la production.
   *
   * @return true si le nombre de tours à atteint le nombre de tours
   * nécessaires pour la livraison
   */
  public boolean isNbrToursComplet() {
    return nbrToursComplet;
  }

  /**
   * Setteur du nombre de tours.
   *
   * @param nbrToursComplet est égal au nombre de tours nécessaires
   */
  public void setNbrToursComplet(boolean nbrToursComplet) {
    this.nbrToursComplet = nbrToursComplet;
  }
}
