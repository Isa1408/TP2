package tp2;

import tp2.station.Fournisseur;
import tp2.station.Station;
import tp2.station.Vendeur;
import tp2.station.machine.*;
import java.util.ArrayList;

/**
 * Représente la classe <code>Usine</code>.
 *
 * @Author Isabelle Tamas
 */
public class Usine {
    static ArrayList<Station> listeDeStations;
    ArrayList<String> listeString;
    int debutMontant;
    int finMontant;
    static int montantActuel;
    static int nbrTours;

    /**
     * Constructeur d'<code>Usine</code>.
     *
     * @param liste de <code>Station</code>s de type <code>String</code>
     */
    public Usine(ArrayList<String> liste) {
        this.debutMontant = Integer.parseInt(liste.get(0));
        this.finMontant = Integer.parseInt(liste.get(1));
        this.montantActuel = debutMontant;
        this.nbrTours = 0;
        creerListeStation(liste);
    }

    /**
     * Création de la liste contenant toutes les <code>Station</code>s dans
     * l'<code>Usine</code>.
     *
     * @param liste de type <code>String</code>
     */
    public static void creerListeStation(ArrayList<String> liste) {
        String descriptionStation = "";
        String nomStation = "";
        String leReste = "";
        int delimiterPremierMot;
        int numDeStationLivraison = 0;
        int numDeBoiteLivraison = 0;
        String typeDeFournisseur = "";
        String typeDeFournisseurMaj = "";
        int[] tabTemp = null;
        listeDeStations = new ArrayList<>();

        for (int i = 2; i < liste.size(); i++) {
            descriptionStation = liste.get(i);
            try {
                delimiterPremierMot = descriptionStation.indexOf(" ");
                nomStation = descriptionStation.substring(0, delimiterPremierMot);
                leReste = descriptionStation.substring(delimiterPremierMot);
                leReste = leReste.trim();
            } catch (StringIndexOutOfBoundsException e) {
                nomStation = descriptionStation;
            }

            switch (nomStation) {
                case "fou":
                    typeDeFournisseur = leReste.substring(0,
                            leReste.indexOf(" "));
                    typeDeFournisseurMaj = typeDeFournisseur.toUpperCase();
                    leReste = leReste.substring(leReste.indexOf(" "));
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison,
                            numDeBoiteLivraison);

                    Fournisseur fournisseur = new Fournisseur("fou",
                            Produit.valueOf(typeDeFournisseurMaj),
                            tabTemp[0], tabTemp[1]);

                    listeDeStations.add(fournisseur);
                    break;
                case "mmo":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    Moulin moulin = new Moulin("mmo", tabTemp[0],
                            tabTemp[1]);

                    listeDeStations.add(moulin);
                    break;
                case "mfo":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    Fournaise fournaise = new Fournaise("mfo", tabTemp[0],
                            tabTemp[1]);

                    listeDeStations.add(fournaise);
                    break;
                case "mfg":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    FournaiseDeGrillage fournaiseDeGrillage =
                            new FournaiseDeGrillage("mfg", tabTemp[0],
                                    tabTemp[1]);

                    listeDeStations.add(fournaiseDeGrillage);
                    break;
                case "mfc":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    FournaiseDeCoupellation fournaiseDeCoupellation =
                            new FournaiseDeCoupellation("mfc", tabTemp[0],
                                    tabTemp[1]);

                    listeDeStations.add(fournaiseDeCoupellation);
                    break;
                case "mto":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison,
                            numDeBoiteLivraison);
                    Touraille touraille = new Touraille("mto", tabTemp[0],
                            tabTemp[1]);

                    listeDeStations.add(touraille);

                    break;
                case "ven":
                    listeDeStations.add(new Vendeur("ven"));
                    break;
            }
        }
    }

    /**
     * Retrouver les coordonnées de la livraison des produits de chaque
     * <code>Station</code>.
     *
     * @param leReste les coordonnées
     * @param numDeStationLivraison l'indexe de la <code>Station</code> de
     *                              livraison
     * @param numDeBoiteLivraison l'indexe de la <code>Boite</code> de livraison
     * @return un tableau de type <code>int</code>
     */
    public static int[] descriptionLivraisons(String leReste,
                                              int numDeStationLivraison,
                                              int numDeBoiteLivraison) {
        leReste = leReste.trim();
        numDeStationLivraison =
                Integer.parseInt(leReste.substring(0, 1));
        numDeBoiteLivraison =
                Integer.parseInt(leReste.substring(2));
        int tabTemp[] = {numDeStationLivraison, numDeBoiteLivraison};
        return tabTemp;
    }

    /**
     * Vérifier si la <code>Station</code> est un fournisseur.
     *
     */
    public static void setteurDeProduitStationsParLesFournisseurs() {
        int numDeLivraison;
        int numDeBoiteOuLivrer;
        Station stationDeLivraison;
        Station stationActuel;
        for (int i = 0; i < listeDeStations.size(); i++) {
            stationActuel = listeDeStations.get(i);
            numDeLivraison = stationActuel.getNumStation();
            numDeBoiteOuLivrer = stationActuel.getNumDeBoite();

            if (stationActuel.getNom().toString().equals("fou")) {
                stationDeLivraison = listeDeStations.get(numDeLivraison);

                Produit produitDuFournisseur = stationActuel.getProduit();
                actionDesFournisseurs(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, produitDuFournisseur);
            }
        }
    }

    /**
     * Définir les actions des <code>Fournisseur</code>s.
     *
     * @param numDeBoiteOuLivrer l'indexe de la <code>Boite</code> de livraison
     * @param stationDeLivraison l'indexe de la <code>Station</code> de
     *                           livraison
     * @param stationActuel la <code>Station</code> actuelle
     * @param produitDuFournisseur le <code>Produit</code> à livrer du
     *                             <code>Fournisseur</code>
     */
    private static void actionDesFournisseurs(int numDeBoiteOuLivrer,
                                              Station stationDeLivraison,
                                              Station stationActuel,
                                              Produit produitDuFournisseur) {
        int nbrToursNecessaires;
        DescriptionStations descriptionStations;
        switch (produitDuFournisseur.nomDescripteur) {
            case ("acanthite"):
                descriptionStations= DescriptionStations.FOURNISSEUR_ACANTHITE;
                nbrToursNecessaires = descriptionStations.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires, descriptionStations);
                break;
            case ("cassiterite"):
                descriptionStations =
                        DescriptionStations.FOURNISSEUR_CASSITERITE;
                nbrToursNecessaires = descriptionStations.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires, descriptionStations);
                break;
            case ("chalcocite"):
                descriptionStations =
                        DescriptionStations.FOURNISSEUR_CHALCOCITE;
                nbrToursNecessaires = descriptionStations.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires, descriptionStations);
                break;
            case ("charbon"):
                descriptionStations = DescriptionStations.FOURNISSEUR_CHARBON;
                nbrToursNecessaires = descriptionStations.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires, descriptionStations);
                break;
        }
    }

    /**
     * Vérifier si le nombre de tours actuel de la <code>Machine</code> est
     * suffisant pour la livraison.
     *
     * @param numDeBoiteOuLivrer l'indexe de la <code>Boite</code> de livraison
     * @param stationDeLivraison l'indexe de la <code>Station</code> de
     *                           livraison
     * @param stationActuel la <code>Station</code> actuelle
     * @param nbrToursNecessaires le nombre de tours nécessaires pour la
     *                            livraison
     * @param descriptionStations la <code>DescriptionStations</code> de la
     *                            <code>Station</code>
     */
    private static void validerLeNbrDeTours(int numDeBoiteOuLivrer,
                                            Station stationDeLivraison,
                                            Station stationActuel,
                                            int nbrToursNecessaires,
                                            DescriptionStations descriptionStations) {
        if(nbrTours != 0){
            descriptionStations.getBoite().setCompteurDeTours(1);
        }

        if (((nbrTours ) % nbrToursNecessaires == 0) && nbrTours != 0) {
            descriptionStations.getBoite().setCompteurDeTours(-descriptionStations.getBoite().getCompteurDeTours());
            livrerLesProduits(numDeBoiteOuLivrer, stationDeLivraison,
                    stationActuel, 1);
        }
    }

    /**
     * Livraison de <code>Produit</code> dans la <code>Boite</code> de la
     * <code>Station</code> correspondante.
     *
     * @param numDeBoiteOuLivrer l'indexe de la <code>Boite</code>
     * @param stationDeLivraison l'indexe de la <code>Station</code> de
     *                           livraison
     * @param stationActuel la <code>Station</code> actuelle dans la liste de
     *                     <code>Station</code>s
     * @param nbrProduitLivre le nombre de <code>Produit</code>s qui sont livrés
     */
    private static void livrerLesProduits(int numDeBoiteOuLivrer,
                                          Station stationDeLivraison,
                                          Station stationActuel,
                                          int nbrProduitLivre) {
        DescriptionStations descriptionStationsDeLivraison =
                trouverDescriptionStations(stationDeLivraison, stationActuel);
        if (numDeBoiteOuLivrer == 0) {
            stationDeLivraison.setProduitDansBoites1(stationActuel.getProduit());
            if(descriptionStationsDeLivraison != null){
                descriptionStationsDeLivraison.getBoite().setQteActuelProduit1(nbrProduitLivre);
            }
        } else if (numDeBoiteOuLivrer == 1) {
            if(descriptionStationsDeLivraison != null){
                descriptionStationsDeLivraison.getBoite().setQteActuelProduit2(nbrProduitLivre);
            }
            stationDeLivraison.setProduitDansBoites2(stationActuel.getProduit());
        }
    }

    /**
     * Déterminer la <code>Machine</code>
     *
     * @param stationDeLivraison la <code>Station</code> de livraison
     * @param stationActuel la <code>Station</code> actuelle
     * @return la <code>DescriptionStations</code> de la <code>Station</code>
     * de livraison
     */
    private static DescriptionStations trouverDescriptionStations(Station stationDeLivraison,
                                                                  Station stationActuel) {
        Produit produitALivrer;
        DescriptionStations descriptionStationsDeLivraison = null;

        switch (stationDeLivraison.getNom().toString()){
            case "mmo":
                produitALivrer = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "MOULIN_"+produitALivrer);
                break;
            case "mfo":
                produitALivrer = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_"+produitALivrer);
                break;
            case "mfg":
                produitALivrer = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_GRILLAGE_"+produitALivrer);
                break;
            case "mfc":
                produitALivrer = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_COUPELLATION_"+produitALivrer);
                break;
            case "mto":
                produitALivrer = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "TOURAILLE_"+produitALivrer);
                break;
            case "ven":
                if(stationActuel.getNom().equals("fou")){
                    livrerLesProduits(stationActuel.getNumDeBoite(), stationDeLivraison,
                            stationActuel
                            , 1,
                            stationDeLivraison.getProduitDansBoites1(),
                            stationActuel.getProduit());
                }
                break;
        }
        return descriptionStationsDeLivraison;
    }

    /**
     * Vérifier si la <code>Boite</code> de la <code>Station</code> est
     * complète en fonction du nombre de <code>Produit</code>s qu'elle
     * détient.
     *
     */
    public static void verifierSiBoiteEstComplet(){
        Station stationActuel;
        DescriptionStations descriptionStations;
        int nbrActuelProduits1;
        int nbrActuelProduits2;

        for (int i = 0; i < listeDeStations.size(); i++) {
            boolean boite1Complet = false;
            boolean boite2Complet = false;
            boolean boite2Existe = false;
            stationActuel = listeDeStations.get(i);

            if(!(stationActuel.getNom().toString().equals("fou")) &&
                    !(stationActuel.getNom().toString().equals("ven"))){
                verifierLExistanceDesBoites(stationActuel, boite1Complet,
                        boite2Complet, boite2Existe);
            }
        }
    }

    /**
     * Vérifier si la <code>Machine</code> contient deux <code>Boite</code>s
     * de recette.
     *
     * @param stationActuel la <code>Station</code> actuelle dans la liste
     * @param boite1Complet true si la <code>Boite</code> 1 est complète
     * @param boite2Complet true si la <code>Boite</code> 2 est complète
     * @param boite2Existe true si la <code>Boite</code> 2 existe
     */
    private static void verifierLExistanceDesBoites(Station stationActuel,
                                                    boolean boite1Complet,
                                                    boolean boite2Complet,
                                                    boolean boite2Existe) {
        int nbrActuelProduits1;
        DescriptionStations descriptionStations;
        int nbrActuelProduits2;
        try{
            descriptionStations = trouverDescriptionStations(stationActuel,
                    stationActuel.getProduitDansBoites1());
            nbrActuelProduits1 =
                    descriptionStations.getBoite().getQteActuelProduit1();

            if(descriptionStations == DescriptionStations.FOURNAISE_LINGOTS_CUIVRE
                    || stationActuel.getNom().equals("mfg")){
                nbrActuelProduits2 =
                        descriptionStations.getBoite().getQteActuelProduit2();
                boite2Existe = true;

                if(nbrActuelProduits2 >= descriptionStations.getBoite().getNbrProduit2Necessaire()){
                    boite2Complet = true;
                }else {
                    descriptionStations.getBoite().setComplet(false);
                }
            }

            boite1Complet = verifierSiBoite1Complet(boite1Complet,
                    nbrActuelProduits1, descriptionStations);
            verifierSiBoite2Existe(descriptionStations, boite1Complet,
                    boite2Complet, boite2Existe);
            verifierSiNbrToursNecessaire(stationActuel, descriptionStations,
                    boite2Existe);
        }catch (Exception e){

        }
    }

    /**
     * Vérifier si la première <code>Boite</code> est complète.
     *
     * @param boite1Complet true si la <code>Boite</code> est complète
     * @param nbrActuelProduits1 le nombre de <code>Produit</code>s
     * @param descriptionStations la <code>DescriptionStations</code>
     * @return true si la première <code>Boite</code> est complète
     */
    private static boolean verifierSiBoite1Complet(boolean boite1Complet,
                                                   int nbrActuelProduits1,
                                                   DescriptionStations descriptionStations) {
        if(nbrActuelProduits1 >=
                descriptionStations.getBoite().getNbrProduit1Necessaire()){
            boite1Complet = true;
        }else {
            descriptionStations.getBoite().setComplet(false);
        }
        return boite1Complet;
    }

    /**
     * Vérifier si le nombre de tours nécessaire est atteint par la
     * <code>Station</code>.
     *
     * @param stationActuel la <code>Station</code> actuelle
     * @param descriptionStations la <code>DescriptionStations</code>
     * @param boite2Existe true si la deuxième <code>Boite</code> existe
     */
    private static void verifierSiNbrToursNecessaire(Station stationActuel,
                                                     DescriptionStations descriptionStations,
                                                     boolean boite2Existe) {
        int nbrDeToursActuelDeLaMachine;
        int nbrDeToursNecessaire;
        Station stationDeLivraison;
        int numBoite;
        int nbrProduitLivre;

        DescriptionStations descriptionStationLivraison;
        nbrDeToursActuelDeLaMachine =
                descriptionStations.getBoite().getCompteurDeTours();
        nbrDeToursNecessaire = descriptionStations.nbrTours;

        if(nbrDeToursActuelDeLaMachine >= nbrDeToursNecessaire){
            stationDeLivraison =
                    listeDeStations.get(stationActuel.getNumStation());
            numBoite = stationActuel.getNumDeBoite();

            nbrProduitLivre = descriptionStations.getNbrProduitLivre();
            Produit produitALivrer =
                    descriptionStations.getLivre();

            livrerLesProduits(numBoite, stationDeLivraison, stationActuel
                    , nbrProduitLivre,
                    stationDeLivraison.getProduitDansBoites1(), produitALivrer);

            descriptionStations.getBoite().setCompteurDeTours(- nbrDeToursActuelDeLaMachine);
            descriptionStations.getBoite().setQteActuelProduit1(- descriptionStations.getBoite().getNbrProduit1Necessaire());
            if(boite2Existe){
                descriptionStations.getBoite().setQteActuelProduit2(- descriptionStations.getBoite().getNbrProduit2Necessaire());
           }
        }
    }

    /**
     * Vérifier si la deuxième <code>Boite</code> de la
     * <code>Machine</code> existe.
     *
     * @param descriptionStations la <code>DescriptionStations</code>
     * @param boite1Complet true si la première <code>Boite</code> est complète
     * @param boite2Complet true si la deuxième <code>Boite</code> est complète
     * @param boite2Existe true si la deuxième <code>Boite</code> existe
     */
    private static void verifierSiBoite2Existe(DescriptionStations descriptionStations,
                                               boolean boite1Complet,
                                               boolean boite2Complet,
                                               boolean boite2Existe) {
        if(boite2Existe){
            verifierBoitesCompletes(descriptionStations, boite1Complet, boite2Complet);
        }else {
            verifierBoite1Complete(descriptionStations, boite1Complet);
        }
    }

    /**
     * Vérifier si la première <code>Boite</code> existe.
     *
     * @param descriptionStations la <code>DescriptionStations</code>
     * @param boite1Complet true si la <code>Boite</code> est complète
     */
    private static void verifierBoite1Complete(DescriptionStations descriptionStations,
                                               boolean boite1Complet) {
        if(boite1Complet){
            descriptionStations.getBoite().setComplet(true);
            descriptionStations.getBoite().setCompteurDeTours(1);
        }
    }

    /**
     * Vérifier si les deux <code>Boite</code>s sont complètes.
     *
     * @param descriptionStations la <code>DescriptionStations</code>
     * @param boite1Complet true si la première <code>Boite</code> est complète
     * @param boite2Complet true si la deuxième <code>Boite</code> est complète
     */
    private static void verifierBoitesCompletes(DescriptionStations descriptionStations, boolean boite1Complet, boolean boite2Complet) {
        if(boite1Complet && boite2Complet){
            descriptionStations.getBoite().setComplet(true);
            descriptionStations.getBoite().setCompteurDeTours(1);
        }
    }

    /**
     * Livrer les <code>Produit</code>s aux endroits correspondants.
     *
     * @param numDeBoiteOuLivrer l'indexe de la <code>Boite</code> de livraison
     * @param stationDeLivraison l'indexe de la <code>Station</code> de
     *                           livraison
     * @param stationActuel la <code>Station</code> actuelle de la liste
     * @param nbrProduitLivre le nombre de <code>Produit</code>s qui sont livrés
     * @param produitBoite1 le <code>Produit</code> dans la première
     *                      <code>Boite</code>
     * @param produitALivrer le <code>Produit</code> à livrer
     */
    private static void livrerLesProduits(int numDeBoiteOuLivrer,
                                          Station stationDeLivraison,
                                          Station stationActuel,
                                          int nbrProduitLivre,
                                          Produit produitBoite1,
                                          Produit produitALivrer) {
        if(!stationDeLivraison.getNom().toString().equals("ven")){
            DescriptionStations descriptionStationsDeLivraison;
            if (produitBoite1 == null){
                descriptionStationsDeLivraison =
                        trouverDescriptionStations(stationDeLivraison, stationActuel,
                                produitALivrer);
            }else {
                descriptionStationsDeLivraison =
                        trouverDescriptionStations(stationDeLivraison, stationActuel,
                                produitBoite1);
            }

            if (numDeBoiteOuLivrer == 0) {
                stationDeLivraison.setProduitDansBoites1(produitALivrer);
                if(descriptionStationsDeLivraison != null){
                    descriptionStationsDeLivraison.getBoite().setQteActuelProduit1(nbrProduitLivre);
                }
            } else if (numDeBoiteOuLivrer == 1) {
                if(descriptionStationsDeLivraison != null){
                    descriptionStationsDeLivraison.getBoite().setQteActuelProduit2(nbrProduitLivre);
                }
                stationDeLivraison.setProduitDansBoites2(produitALivrer);
            }
        }else {
            ProduitAVendre produitAVendre =
                    new ProduitAVendre(nbrProduitLivre, produitALivrer);
            stationDeLivraison.getListeDeProduits().add(produitAVendre);
            montantActuel = montantActuel + produitAVendre.calculerPrix();
        }
    }

    /**
     * Spécifier la <code>DescriptionStations</code> de la <code>Station</code>.
     *
     * @param stationDeLivraison la <code>Station</code> de livraison
     * @param stationActuel la <code>Station</code> actuelle
     * @param produitBoite1 le <code>Produit</code> dans la première
     *                      <code>Boite</code>
     * @return la <code>DescriptionStations</code>
     */
    private static DescriptionStations trouverDescriptionStations(Station stationDeLivraison,
                                                                  Station stationActuel,
                                                                  Produit produitBoite1) {
        DescriptionStations descriptionStationsDeLivraison = null;

        switch (stationDeLivraison.getNom().toString()){
            case "mmo":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "MOULIN_"+produitBoite1);
                break;
            case "mfo":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_"+produitBoite1);
                break;
            case "mfg":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_GRILLAGE_"+produitBoite1);
                break;
            case "mfc":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_COUPELLATION_"+produitBoite1);
                break;
            case "mto":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "TOURAILLE_"+produitBoite1);
                break;
        }
        return descriptionStationsDeLivraison;
    }

    /**
     * Spécifier la <code>DescriptionStations</code> de la <code>Station</code>
     *
     * @param stationActuel la <code>Station</code> actuelle
     * @param produitDansBoite le <code>Produit</code> dans la <code>Boite</code>
     * @return la <code>DescriptionStations</code>
     */
    private static DescriptionStations trouverDescriptionStations(Station stationActuel,
                                                                  Produit produitDansBoite) {
        DescriptionStations descriptionStationsDeLivraison = null;

        switch (stationActuel.getNom().toString()){
            case "fou":
                descriptionStationsDeLivraison =
                        DescriptionStations.valueOf("FOURNISSEUR_"+
                                produitDansBoite);
                break;
            case "mmo":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "MOULIN_"+produitDansBoite);
                break;
            case "mfo":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_"+produitDansBoite);
                break;
            case "mfg":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_GRILLAGE_"+produitDansBoite);
                break;
            case "mfc":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_COUPELLATION_"+produitDansBoite);
                break;
            case "mto":
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "TOURAILLE_"+produitDansBoite);
                break;
        }
        return descriptionStationsDeLivraison;
    }

    /**
     * Afficher l'état actuel de la <code>Machine</code>.
     *
     */
    public static void afficherEtatUsine() {
        String etatUsine = "";
        Fournisseur fournisseur;
        Machine machine;
        boolean boite1Vide;
        boolean boite2Vide;
        DescriptionStations descriptionStations;

        for (int i = 0; i < listeDeStations.size(); i++) {
            Station station = listeDeStations.get(i);

            boite1Vide = false;
            boite2Vide =false;
            if (station.getNom().toString().equals("fou")) {
                Station fou = listeDeStations.get(i);
                descriptionStations = trouverDescriptionStations(fou,
                       fou.getProduit());
                System.out.println(i + " : " + fou.getNom() + " F: 1 " +
                        fou.getProduit().nomAffichableSinguler + " " +
                        descriptionStations.getBoite().getNbrToursRestant(descriptionStations)+
                        " (" + fou.getNumStation() +
                        "," + fou.getNumDeBoite() + ")");

            } else if (station.getNom().toString().equals("ven")) {
                System.out.println(i + " : " + station.getNom());
            } else {
                afficherLesMachines(boite1Vide, boite2Vide, i, station);
            }
        }
    }

    /**
     * Afficher les <code>Station</code>s qui sont des <code>Machine</code>s.
     *
     * @param boite1Vide true si la première <code>Boite</code> est vide
     * @param boite2Vide trus si la deuixème <code>Boite</code> est vide
     * @param i indexe de la <code>Station</code> actuelle dans la liste
     * @param station la <code>Station</code>
     */
    private static void afficherLesMachines(Boolean boite1Vide,
                                            Boolean boite2Vide, int i,
                                            Station station) {
        if (station.getNom().equals("mfo") || station.getNom().equals("mfg")){
            if(station.getNom().equals("mfo")){
                if(station.getProduitDansBoites1() != null){
                    if(station.getProduitDansBoites1().equals(Produit.LINGOT_CUIVRE)){
                        verifierLeContenuDesBoites(station, boite1Vide, boite2Vide,
                                i, station.getProduitDansBoites2());
                    }else {
                        afficherSelonLeContenuDesBoitesDeMFO(i, station);
                    }
                }else {
                    System.out.println(i + " : " + station.getNom() + "(0) " +
                            "B0" + ": vide");
                }
            }else {
                verifierLeContenuDesBoites(station, boite1Vide, boite2Vide, i,
                        station.getProduitDansBoites1());
            }
        }else {
            afficherLesAutresMachines(i, station);
        }
    }

    /**
     * Afficher les <code>Machine</code>s qui ne sont ni des mfo ni des mfg.
     *
     * @param i l'indexe de la <code>Station</code> dans la liste
     * @param station la <code>Station</code>
     */
    private static void afficherLesAutresMachines(int i, Station station) {
        int nbrProduits;
        DescriptionStations descriptionStations;
        if (station.getProduitDansBoites1() == null) {
            System.out.println(i + " : " + station.getNom() + "(0) " +
                    "B0" +
                    ": vide");
        } else {
            descriptionStations = trouverDescriptionStations(station,
                    station.getProduitDansBoites1());
            nbrProduits =
                    descriptionStations.getBoite().getQteActuelProduit1();

            System.out.println(i + " : " + station.getNom() + "(" +
                    descriptionStations.getNiveau() + ") " + "B0: " +
                    station.getProduitDansBoites1().toString(nbrProduits) +
                    " F: " +
                    descriptionStations.getLivre().toString(descriptionStations.getNbrProduitLivre())
                    + " " +
                    descriptionStations.getBoite().getNbrToursRestant(descriptionStations)
                    + " (" + station.getNumStation() + ","
                    + station.getNumDeBoite() + ")");
        }
    }

    /**
     * Afficher les <code>Machine</code>s qui sont des mfo.
     *
     * @param i l'indexe de la <code>Station</code> dans la liste
     * @param station la <code>Station</code>
     */
    private static void afficherSelonLeContenuDesBoitesDeMFO(int i,
                                                             Station station) {
        int nbrProduits;
        DescriptionStations descriptionStations;
        if(station.getProduitDansBoites1() == null){
            System.out.println(i + " : " + station.getNom() + "(" +
                    "0" + ") " + "B0: vide");
        }else{
            descriptionStations = trouverDescriptionStations(station,
                    station.getProduitDansBoites1());
            nbrProduits =
                    descriptionStations.getBoite().getQteActuelProduit1();
            System.out.println(i + " : " + station.getNom() + "(" +
                    descriptionStations.getNiveau() + ") " + "B0: " +
                    station.getProduitDansBoites1().toString(nbrProduits) +
                    " F: " +
                    descriptionStations.getLivre().toString(descriptionStations.getNbrProduitLivre())
                    + " " +
                    descriptionStations.getBoite().getNbrToursRestant(descriptionStations)
                    + " (" + station.getNumStation() + ","
                    + station.getNumDeBoite() + ")");
        }
    }

    /**
     * Vérifier le contenu des <code>Boite</code>s de la <code>Machine</code>
     * et l'afficher.
     *
     * @param station la <code>Station</code>
     * @param boite1Vide true si la première <code>Boite</code> est vide
     * @param boite2Vide true si la deuxième <code>Boite</code> est vide
     * @param i l'indexe de la <code>Station</code> dans la liste
     * @param station1 le <code>Produit</code> de la <code>Station</code>
     */
    private static void verifierLeContenuDesBoites(Station station,
                                                   Boolean boite1Vide,
                                                   Boolean boite2Vide,
                                                   int i, Produit station1) {
        int nbrProduits1;
        int nbrProduits2;
        DescriptionStations descriptionStations;
        if(station.getProduitDansBoites1() == null){
            boite1Vide = true;
        }
        if(station.getProduitDansBoites2() == null){
            boite2Vide = true;
        }
        if(boite2Vide && boite1Vide){
            System.out.println(i + " : " + station.getNom() + "(" +
                    "0" + ") " + "B0: vide B1: vide" );
        }
        if (boite1Vide && !boite2Vide){
            descriptionStations = trouverDescriptionStations(station,
                    station.getProduitDansBoites1());
            nbrProduits2 =
                    descriptionStations.getBoite().getQteActuelProduit2();
            System.out.println(i + " : " + station.getNom() + "(" +
                   descriptionStations.getNiveau() + ") " + "B0: vide" + " B1: "
                    + station.getProduitDansBoites2().toString(nbrProduits2));
        }
        if(boite2Vide && !boite1Vide){
            descriptionStations = trouverDescriptionStations(station,
                    station.getProduitDansBoites1());
            nbrProduits1 =
                    descriptionStations.getBoite().getQteActuelProduit1();
            System.out.println(i + " : " + station.getNom() + "(" +
                    descriptionStations.getNiveau() + ") " + "B0: "
                    + station.getProduitDansBoites1().toString(nbrProduits1) +
                    " B1: vide" );
        }
        if(!boite1Vide && !boite2Vide){
            descriptionStations = trouverDescriptionStations(station,
                    station.getProduitDansBoites1());
            nbrProduits1 =
                    descriptionStations.getBoite().getQteActuelProduit1();
            nbrProduits2 =
                    trouverDescriptionStations(station,
                            station.getProduitDansBoites1()).getBoite().getQteActuelProduit2();
            System.out.println(i + " : " + station.getNom() + "(" +
                    descriptionStations.getNiveau() + ") " + "B0: " +
                    station.getProduitDansBoites1().toString(nbrProduits1) +
                    " " +
                    " B1: " + station.getProduitDansBoites2().toString(nbrProduits2)
                    + " F: " +
                    descriptionStations.getLivre().toString(descriptionStations.getNbrProduitLivre())
                    + " "
                    + descriptionStations.getBoite().getNbrToursRestant(descriptionStations)
                    + " (" + station.getNumStation() + ","
                    + station.getNumDeBoite() + ")");
        }
    }

    /**
     * Getteur du montant au début.
     *
     * @return le montant
     */
    public int getDebutMontant() {
        return debutMontant;
    }

    /**
     * Getteur du montant final à atteindre.
     *
     * @return le montant final
     */
    public int getFinMontant() {
        return finMontant;
    }

    /**
     * Getteur du montant actuel de l'<code>Usine</code>.
     *
     * @return le montant actuel
     */
    public int getMontantActuel() {
        return montantActuel;
    }

    /**
     * Getteur du nombre de tours de l'<code>Usine</code>.
     *
     * @return le nombre de tours actuel
     */
    public int getNbrTours() {
        return nbrTours;
    }

    /**
     * Setteur du montant actuel de l'<code>Usine</code>.
     *
     * @param montantActuel le montant actuel
     */
    public void setMontantActuel(int montantActuel) {
        this.montantActuel = montantActuel;
    }

    /**
     * Setteur du nombre de tours de l'<code>Usine</code>.
     *
     * @param nbrTours le nouveau nombre de tours
     */
    public void setNbrTours(int nbrTours) {
        this.nbrTours = nbrTours;
    }
}

