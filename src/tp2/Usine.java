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
        DescriptionStations descriptionStationsDeLivraison = trouverDescriptionStations(stationDeLivraison, stationActuel);
        if ((nbrToursTest % nbrToursNecessaires == 0) && nbrToursTest != 0) {
            if (numDeBoiteOuLivrer == 0) {
                stationDeLivraison.setProduitDansBoites1(stationActuel.getProduit());
                if(descriptionStationsDeLivraison != null){
                    descriptionStationsDeLivraison.getBoite().setQteActuelProduit1(1);
                }
            } else if (numDeBoiteOuLivrer == 1) {
                if(descriptionStationsDeLivraison != null){
                    descriptionStationsDeLivraison.getBoite().setQteActuelProduit2(1);
                }
                stationDeLivraison.setProduitDansBoites2(stationActuel.getProduit());
            }
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
                            station.getProduitDansBoites2()).getBoite().getQteActuelProduit2();
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
                            station.getProduitDansBoites2()).getBoite().getQteActuelProduit2();
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

