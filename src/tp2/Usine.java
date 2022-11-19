package tp2;

import tp2.station.Fournisseur;
import tp2.station.Station;
import tp2.station.Vendeur;
import tp2.station.machine.*;
import java.util.ArrayList;

public class Usine {
    static ArrayList<Station> listeDeStations;
    ArrayList<String> listeString;
    static ArrayList<Fournisseur> listeDeFournisseurs;
    static ArrayList<Machine> listeDeMachines;
    int debutMontant;
    int finMontant;
    int montantActuel;
    static int nbrToursTest;

    // private static final List<String> typesDeStations =
    //         Arrays.asList("fou","mmo","mfo","mfg","mfc","mto","ven");

    public Usine(ArrayList<String> liste) {
        this.debutMontant = Integer.parseInt(liste.get(0));
        this.finMontant = Integer.parseInt(liste.get(1));
        this.montantActuel = debutMontant;
        this.nbrToursTest = 0;
        creerListeStation(liste);
    }

    public static void creerListeStation(ArrayList<String> liste) {
        String descriptionStation = ""; //tout la description de la statition
        String nomStation = ""; //juste le premier mot
        String leReste = ""; //tout ce qui vient apres le premier mot
        int delimiterPremierMot; //sera l index du premier espace pour
        // delimiter le premier mot
        int numDeStationLivraison = 0;
        int numDeBoiteLivraison = 0;
        String typeDeFournisseur = "";
        String typeDeFournisseurMaj = "";
        int[] tabTemp = null;
        //  Produit [] produitDansBoites = new Produit[2];
        listeDeStations = new ArrayList<>();
        listeDeFournisseurs = new ArrayList<>();
        listeDeMachines = new ArrayList<>();

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
                    listeDeFournisseurs.add(fournisseur);
                    break;
                case "mmo":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    Moulin moulin = new Moulin("mmo", tabTemp[0], tabTemp[1]);

                    listeDeStations.add(moulin);
                    listeDeMachines.add(moulin);
                    break;
                case "mfo":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    Fournaise fournaise = new Fournaise("mfo", tabTemp[0], tabTemp[1]);

                    listeDeStations.add(fournaise);
                    listeDeMachines.add(fournaise);
                    break;
                case "mfg":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    FournaiseDeGrillage fournaiseDeGrillage =
                            new FournaiseDeGrillage("mfg", tabTemp[0], tabTemp[1]);

                    listeDeStations.add(fournaiseDeGrillage);
                    listeDeMachines.add(fournaiseDeGrillage);
                    break;
                case "mfc":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    FournaiseDeCoupellation fournaiseDeCoupellation =
                            new FournaiseDeCoupellation("mfc", tabTemp[0], tabTemp[1]);

                    listeDeStations.add(fournaiseDeCoupellation);
                    listeDeMachines.add(fournaiseDeCoupellation);
                    break;
                case "mto":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison,
                            numDeBoiteLivraison);
                    Touraille touraille = new Touraille("mto", tabTemp[0], tabTemp[1]);

                    listeDeStations.add(touraille);
                    listeDeMachines.add(touraille);

                    break;
                case "ven":
                    listeDeStations.add(new Vendeur("ven"));
                    break;
            }
        }
        //System.out.println("la liste de stations: "+listeDeStations);
    }

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

    //les actions des fournisseurs
    // (setteurDeProduitStationsParLesFournisseurs, actionDesFournisseurs,
    // validerLeNbrDeTours, trouverDescriptionStations(station, station))
    public static void setteurDeProduitStationsParLesFournisseurs() {
        int numDeLivraison; //quelle stationDeLivraison
        int numDeBoiteOuLivrer; //dans quelle boite on livre le produit (0,1)
        Station stationDeLivraison;
        Station stationActuel;
        for (int i = 0; i < listeDeStations.size(); i++) {
            stationActuel = listeDeStations.get(i);
            numDeLivraison = stationActuel.getNumStation();
            numDeBoiteOuLivrer = stationActuel.getNumDeBoite();
            //il faut recueillir les fournisseurs en premier
            if (stationActuel.getNom().toString().equals("fou")) {
                stationDeLivraison = listeDeStations.get(numDeLivraison);

                Produit produitDuFournisseur = stationActuel.getProduit();
                actionDesFournisseurs(numDeBoiteOuLivrer, stationDeLivraison, stationActuel, produitDuFournisseur);
            }
        }
    }
    private static void actionDesFournisseurs(int numDeBoiteOuLivrer, Station stationDeLivraison, Station stationActuel, Produit produitDuFournisseur) {
        int nbrToursNecessaires;
        switch (produitDuFournisseur.nomDescripteur) {
            case ("acanthite"):
                nbrToursNecessaires =
                        DescriptionStations.FOURNISSEUR_ACANTHITE.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires);
                break;
            case ("cassiterite"):
                nbrToursNecessaires =
                        DescriptionStations.FOURNISSEUR_CASSITERITE.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires);
                break;
            case ("chalcocite"):
                nbrToursNecessaires =
                        DescriptionStations.FOURNISSEUR_CHALCOCITE.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires);
                break;
            case ("charbon"):
                nbrToursNecessaires =
                        DescriptionStations.FOURNISSEUR_CHARBON.getNbrTours();
                validerLeNbrDeTours(numDeBoiteOuLivrer, stationDeLivraison,
                        stationActuel, nbrToursNecessaires);
                break;
        }
    }

    private static void validerLeNbrDeTours(int numDeBoiteOuLivrer,
                                            Station stationDeLivraison,
                                            Station stationActuel,
                                            int nbrToursNecessaires) {
        if ((nbrToursTest % nbrToursNecessaires == 0) && nbrToursTest != 0) {

            livrerLesProduits(numDeBoiteOuLivrer, stationDeLivraison,
                    stationActuel, 1);
        }
    }

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

    private static DescriptionStations trouverDescriptionStations(Station stationDeLivraison, Station stationActuel) {
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
        }
        return descriptionStationsDeLivraison;
    }

    public static void verifierSiBoiteEstComplet(){
        Station stationActuel;
        DescriptionStations descriptionStations; //pour trouver l enum de
        // descriptionStations grace au premier produit (station actuelle)
        int nbrActuelProduits1;
        int nbrActuelProduits2;


        for (int i = 0; i < listeDeStations.size(); i++) {
            boolean boite1Complet = false;
            boolean boite2Complet = false;
            boolean boite2Existe = false;
            stationActuel = listeDeStations.get(i);

            if(!(stationActuel.getNom().toString().equals("fou"))){
                try{
                    descriptionStations = trouverDescriptionStations(stationActuel,
                            stationActuel.getProduitDansBoites1());
                    nbrActuelProduits1 =
                            descriptionStations.getBoite().getQteActuelProduit1();

                    //get boite2 des machines qui ont deux boites
                    if(descriptionStations == DescriptionStations.FOURNAISE_LINGOTS_CUIVRE
                            || stationActuel.getNom().equals("mfg")){
                        nbrActuelProduits2 =
                                descriptionStations.getBoite().getQteActuelProduit2();
                        boite2Existe = true;

                        //je veux savoir si la boite 2 est complete
                        if(nbrActuelProduits2 >= descriptionStations.getBoite().getNbrProduit2Necessaire()){
                            boite2Complet = true;
                        }else {
                            descriptionStations.getBoite().setComplet(false);
                        }
                    }

                    // je veux savoir si la boite 1 est complete
                    if(nbrActuelProduits1 >= descriptionStations.getBoite().getNbrProduit1Necessaire()){
                        boite1Complet = true;
                    }else {
                        descriptionStations.getBoite().setComplet(false);
                    }

                    if(boite2Existe){
                        if(boite1Complet && boite2Complet){
                            //TODO commencer le comptage du nbr de tours
                            descriptionStations.getBoite().setComplet(true);
                            descriptionStations.getBoite().setCompteurDeTours(1);
                        }
                    }else {
                        if(boite1Complet){
                            //TODO commencer le comptage du nbr de tours
                            descriptionStations.getBoite().setComplet(true);
                            descriptionStations.getBoite().setCompteurDeTours(1);
                        }
                    }

                    //TODO valider si mon nbr de tours pour chaque machine est
                    // equivalent aux nbr de tours necessaires
                    int nbrDeToursActuelDeLaMachine;
                    int nbrDeToursNecessaire;
                    Station stationDeLivraison;
                    int numBoite;
                    int nbrProduitLivre;
                    //Produit produitLivre;
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
                                descriptionStations.getLivre(); // pas bon
                        // pour la methode pcq c le produit de boite 2

                        livrerLesProduits(numBoite, stationDeLivraison, stationActuel
                                , nbrProduitLivre,
                                stationDeLivraison.getProduitDansBoites1(), produitALivrer);
                        //TODO set le nbr de tours a 0
                        descriptionStations.getBoite().setCompteurDeTours(- nbrDeToursActuelDeLaMachine);
                        descriptionStations.getBoite().setQteActuelProduit1(- descriptionStations.getBoite().getNbrProduit1Necessaire());
                        if(boite2Existe){
                            descriptionStations.getBoite().setQteActuelProduit2(- descriptionStations.getBoite().getNbrProduit2Necessaire());
                        }

                    }
                }catch (Exception e){
                   // System.out.println("boite est null");
                }

            }
        }
    }

    private static void livrerLesProduits(int numDeBoiteOuLivrer,
                                          Station stationDeLivraison,
                                          Station stationActuel,
                                          int nbrProduitLivre,
                                          Produit produitBoite1,
                                          Produit produitALivrer) {
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
    }

    private static DescriptionStations trouverDescriptionStations(Station stationDeLivraison, Station stationActuel, Produit produitBoite1) {
        //Produit produitALivrer;
        DescriptionStations descriptionStationsDeLivraison = null;

        switch (stationDeLivraison.getNom().toString()){
            case "mmo":
                //produitBoite1 = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "MOULIN_"+produitBoite1);
                break;
            case "mfo":
                //produitBoite1 = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_"+produitBoite1);
                break;
            case "mfg":
                //produitBoite1 = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_GRILLAGE_"+produitBoite1);
                break;
            case "mfc":
                //produitBoite1 = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "FOURNAISE_COUPELLATION_"+produitBoite1);
                break;
            case "mto":
                //produitBoite1 = stationActuel.getProduit();
                descriptionStationsDeLivraison = DescriptionStations.valueOf(
                        "TOURAILLE_"+produitBoite1);
                break;
        }
        return descriptionStationsDeLivraison;
    }
    //pour l affichage
    private static DescriptionStations trouverDescriptionStations(Station stationActuel, Produit produitDansBoite) {
        DescriptionStations descriptionStationsDeLivraison = null;

        switch (stationActuel.getNom().toString()){
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

    // affichage de l usine( afficherEtatUsine, afficherLesMachines,
    // afficherLesAutresMachines, afficherSelonLeContenuDesBoitesDeMFO,
    // verifierLeContenuDesBoites )
    public static void afficherEtatUsine() {
        String etatUsine = "";
        Fournisseur fournisseur;
        Machine machine;
        boolean boite1Vide;
        boolean boite2Vide;

        for (int i = 0; i < listeDeStations.size(); i++) {
            Station station = listeDeStations.get(i);

            boite1Vide = false;
            boite2Vide =false;
            if (station.getNom().toString().equals("fou")) {
                Station fou = listeDeStations.get(i);
                System.out.println(i + " : " + fou.getNom() + " F: 1 " +
                        fou.getProduit().nomAffichableSinguler + " (nbr de " +
                        "tours qu'il reste) " + "(" + fou.getNumStation() +
                        "," + fou.getNumDeBoite() + ")");

            } else if (station.getNom().toString().equals("ven")) {
                System.out.println(i + " : " + station.getNom());
            } else {
                afficherLesMachines(boite1Vide, boite2Vide, i, station);
            }
        }
    }

    private static void afficherLesMachines(Boolean boite1Vide, Boolean boite2Vide, int i, Station station) {
        if (station.getNom().equals("mfo") || station.getNom().equals("mfg")){
            if(station.getNom().equals("mfo")){
                if(station.getProduitDansBoites1().equals(Produit.LINGOT_CUIVRE)){
                    verifierLeContenuDesBoites(station, boite1Vide, boite2Vide, i, station.getProduitDansBoites2());
                }else {
                    afficherSelonLeContenuDesBoitesDeMFO(i, station);
                }
            }else {
                verifierLeContenuDesBoites(station, boite1Vide, boite2Vide, i, station.getProduitDansBoites1());
            }
        }else {
            afficherLesAutresMachines(i, station);
        }
    }

    private static void afficherLesAutresMachines(int i, Station station) {
        int nbrProduits;
        if(station.getProduitDansBoites1() == null ){
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + "B0: vide");
        }else{
           nbrProduits =
                   trouverDescriptionStations(station, station.getProduitDansBoites1()).getBoite().getQteActuelProduit1();
           System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + "B0: " +
                   station.getProduitDansBoites1().toString(nbrProduits));
        }
    }

    private static void afficherSelonLeContenuDesBoitesDeMFO(int i, Station station) {
        int nbrProduits;
        if(station.getProduitDansBoites1() == null){
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + "B0: vide");
        }else{
            nbrProduits =
                    trouverDescriptionStations(station, station.getProduitDansBoites1()).getBoite().getQteActuelProduit1();
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + "B0: " +
                    station.getProduitDansBoites1().toString(nbrProduits));
        }
    }

    private static void verifierLeContenuDesBoites(Station station,
                                                   Boolean boite1Vide,
                                                   Boolean boite2Vide,
                                                   int i, Produit station1) {
        int nbrProduits1;
        int nbrProduits2;
        if(station.getProduitDansBoites1() == null){
            boite1Vide = true;
        }
        if(station.getProduitDansBoites2() == null){
            boite2Vide = true;
        }
        if(boite2Vide && boite1Vide){
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + " B0: vide B1: vide" );
        }
        if (boite1Vide && !boite2Vide){
            nbrProduits2 =
                    trouverDescriptionStations(station,
                            station.getProduitDansBoites1()).getBoite().getQteActuelProduit2();
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + " B0: vide" +
                    " B1: " + station.getProduitDansBoites2().toString(nbrProduits2));
        }
        if(boite2Vide && !boite1Vide){
            nbrProduits1 =
                    trouverDescriptionStations(station,
                            station.getProduitDansBoites1()).getBoite().getQteActuelProduit1();
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + " B0: " + station.getProduitDansBoites1().toString(nbrProduits1) +
                    " B1: vide" );
        }
        if(!boite1Vide && !boite2Vide){
            nbrProduits1 =
                    trouverDescriptionStations(station,
                            station.getProduitDansBoites1()).getBoite().getQteActuelProduit1();
            nbrProduits2 =
                    trouverDescriptionStations(station,
                            station.getProduitDansBoites1()).getBoite().getQteActuelProduit2();
            System.out.println(i + " : " + station.getNom() + "(" +
                    "[niveau]" + ") " + " B0: " +
                    station.getProduitDansBoites1().toString(nbrProduits1) +
                    " B1: " + station.getProduitDansBoites2().toString(nbrProduits2));
        }
    }

    public int getDebutMontant () {
            return debutMontant;
        }

        public int getFinMontant () {
            return finMontant;
        }

        public int getMontantActuel () {
            return montantActuel;
        }

        public int getNbrTours () {
            return nbrToursTest;
        }

        public void setMontantActuel ( int montantActuel){
            this.montantActuel = montantActuel;
        }

        public void setNbrTours ( int nbrTours){
            this.nbrToursTest = nbrTours;
        }
    }

