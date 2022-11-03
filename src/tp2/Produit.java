package tp2;

public enum Produit {
    ACANTHITE( "acanthite", "acanthite", "acanthites", 68_510 ),
    CASSITERITE( "cassiterite", "cassitérite", "cassitérites", 1_750 ),
    CHALCOCITE( "chalcocite", "chalcocite", "chalcocites", 410 ),
    CHARBON( "charbon", "charbon", "charbons", 10 ),
    COKE( "coke", "coke", "cokes", 210 ),
    LINGOT_ARGENT( "lingotArgent", "lingot d'argent", "lingots d'argent", 69_000 ),
    LINGOT_BRONZE( "lingotBronze", "lingot de bronze", "lingots de bronze", 950 ),
    LINGOT_CUIVRE( "lingotCuivre", "lingot de cuivre", "lingots de cuivre", 780 ),
    LINGOT_ETAIN( "lingotEtain", "lingot d'étain", "lingots d'étain", 2_100 ),
    LITHARGE( "litharge", "litharge", "litharges", 68_550 ),
    OXYDE_ARGENT( "oxydeArgent", "oxyde d'argent", "oxydes d'argent", 68_900 ),
    OXYDE_CUIVRE( "oxydeCuivre", "oxyde de cuivre", "oxydes de cuivre", 750 ),
    OXYDE_ETAIN( "oxydeEtain", "oxyde d'étain", "oxydes d'étain", 2_080 ),
    POUDRE_ACANTHITE( "poudreAcanthite", "poudre d'acanthite", "pourdres d'acanthite", 137_080 ),
    POUDRE_CASSITERITE( "poudreCassiterite", "poudre de cassitérite", "pourdres de cassitérite", 3_640 ),
    POUDRE_CHALCOCITE( "poudreChalcocite", "poudre de chalcocite", "pourdres de chalcocite", 880 ),
    ;
    public String nomDescripteur;
    public String nomAffichableSinguler;
    public String nomAffichablePluriel;
    public int valeur;

    Produit(String nomDescripteur, String nomAffichableSinguler, String nomAffichablePluriel, int valeur ) {
        this.nomDescripteur = nomDescripteur;
        this.nomAffichableSinguler = nomAffichableSinguler;
        this.nomAffichablePluriel = nomAffichablePluriel;
        this.valeur = valeur;
    }

    public String toString( int quantite ) {
        return quantite + " " + ( ( 1 == quantite ) ? nomAffichableSinguler : nomAffichablePluriel );
    }
}
