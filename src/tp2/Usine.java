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
    int nbrTours;

   // private static final List<String> typesDeStations =
   //         Arrays.asList("fou","mmo","mfo","mfg","mfc","mto","ven");

    public Usine( ArrayList<String> liste) {
        this.debutMontant = Integer.parseInt(liste.get(0));
        this.finMontant = Integer.parseInt(liste.get(1));
        this.montantActuel = debutMontant;
        this.nbrTours = 0;
        creerListeStation(liste);
    }

    public static void creerListeStation(ArrayList<String> liste){
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
        listeDeStations = new ArrayList<>();
        listeDeFournisseurs = new ArrayList<>();
        listeDeMachines = new ArrayList<>();

        for (int i = 2; i < liste.size(); i++) {
            descriptionStation = liste.get(i);
            try {
                delimiterPremierMot = descriptionStation.indexOf(" ");
                nomStation = descriptionStation.substring(0,delimiterPremierMot);
                leReste = descriptionStation.substring(delimiterPremierMot);
                leReste = leReste.trim();
            } catch (StringIndexOutOfBoundsException e){
                nomStation = descriptionStation;
            }

            switch (nomStation){
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
                    Moulin moulin = new Moulin("mmo",
                            tabTemp[0], tabTemp[1]);

                    listeDeStations.add(moulin);
                    listeDeMachines.add(moulin);
                    break;
                case "mfo":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    Fournaise fournaise = new Fournaise("mfo",tabTemp[0],
                            tabTemp[1]);

                    listeDeStations.add(fournaise);
                    listeDeMachines.add(fournaise);
                    break;
                case "mfg":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    FournaiseDeGrillage fournaiseDeGrillage =
                            new FournaiseDeGrillage("mfg", tabTemp[0],
                                    tabTemp[1]);

                    listeDeStations.add(fournaiseDeGrillage);
                    listeDeMachines.add(fournaiseDeGrillage);
                    break;
                case "mfc":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);
                    FournaiseDeCoupellation fournaiseDeCoupellation =
                            new FournaiseDeCoupellation("mfc", tabTemp[0],
                                    tabTemp[1]);

                    listeDeStations.add(fournaiseDeCoupellation);
                    listeDeMachines.add(fournaiseDeCoupellation);
                    break;
                case "mto":
                    tabTemp = descriptionLivraisons(leReste,
                        numDeStationLivraison,
                             numDeBoiteLivraison);
                    Touraille touraille = new Touraille("mto",
                            tabTemp[0], tabTemp[1]);

                    listeDeStations.add(touraille);
                    listeDeMachines.add(touraille);

                    break;
                case "ven":
                    listeDeStations.add(new Vendeur("ven"));
                    break;
            }
        }
        System.out.println(listeDeStations);
    }

    public static int[] descriptionLivraisons(String leReste,
                                             int numDeStationLivraison,
                                             int numDeBoiteLivraison){
        leReste = leReste.trim();
        numDeStationLivraison =
                Integer.parseInt(leReste.substring(0,1));
        numDeBoiteLivraison =
                Integer.parseInt(leReste.substring(2));
        int tabTemp[] = {numDeStationLivraison, numDeBoiteLivraison};
        return tabTemp;
    }



    public static String afficherEtatUsine(Usine usine){
        String etatUsine = "";
        ArrayList<Fournisseur> listeDeFournisseurs = new ArrayList<>();
        Fournisseur fournisseur;
        Machine machine;
        ArrayList<Machine> listeDeMachines = new ArrayList<>();


        for (int i = 0; i < listeDeStations.size(); i++) {
            //usine.listeDeStations.get(i).toString();
            Station station = listeDeStations.get(i);

           // System.out.println(station.getNom().toString());

            if(station.getNom().toString().equals("fou")){
                //listeDeFournisseurs = new ArrayList<>();
                Fournisseur fou = (Fournisseur) listeDeStations.get(i);
                fournisseur = new Fournisseur(fou.getNom(),
                        fou.getProduit(), fou.getNumDeLivraison(), fou.getNumDeBoite());

                //ajouter les fournisseurs dans une liste
                listeDeFournisseurs.add(fournisseur);


                System.out.println(i + " : " + fou.getNom() + " F: 1 " +
                        fou.getProduit().nomAffichableSinguler + " (nbr de " +
                        "tours qu'il reste) " + "(" + fou.getNumDeLivraison() +
                        "," + fou.getNumDeBoite() + ")");

            } else if(station.getNom().toString().equals("ven")){
                System.out.println(i + " : " + station.getNom());
            }else {
                //Machine machine = (Machine) usine.listeDeStations.get(i);
//                machine = new Machine(station.getNom(),
//                        station.getNumDeLivraison(), station.getNumDeBoite());

                if (!listeDeFournisseurs.isEmpty()){
                    for (int j = 0; j < listeDeFournisseurs.size(); j++) {
                        Fournisseur fournisseur1 = listeDeFournisseurs.get(j);

                        //station.getNumDeLivraison() == i dans le if
                        //le comment ci-haut fonctionne pas
                        if (fournisseur1.getNumDeLivraison() == i){
                            switch (station.getNom()){
                                case "mmo":
                                    Moulin moulin = new Moulin("mmo",
                                            station.getNumDeLivraison(),
                                            station.getNumDeBoite());
                                    moulin.setProduit(fournisseur1.getProduit());
                                    listeDeMachines.add(moulin);
                                    break;
                                case "mfo":
                                    Fournaise fournaise = new Fournaise("mfo",
                                            station.getNumDeLivraison(),
                                            station.getNumDeBoite());
                                    fournaise.setProduit(fournisseur1.getProduit());
                                    listeDeMachines.add(fournaise);
                                    break;
                                case "mfg":
                                    FournaiseDeGrillage fournaiseDeGrillage =
                                            new FournaiseDeGrillage("mfg",
                                                    station.getNumDeLivraison(),
                                                    station.getNumDeBoite());
                                    fournaiseDeGrillage.setProduit(fournisseur1.getProduit());
                                    listeDeMachines.add(fournaiseDeGrillage);
                                    break;
                                case "mfc":
                                    FournaiseDeCoupellation fournaiseDeCoupellation =
                                            new FournaiseDeCoupellation("mfc",
                                                    station.getNumDeLivraison(),
                                                    station.getNumDeBoite());
                                    fournaiseDeCoupellation.setProduit(fournisseur1.getProduit());
                                    listeDeMachines.add(fournaiseDeCoupellation);
                                    break;
                                case "mto":
                                    Touraille touraille = new Touraille("mto",
                                            station.getNumDeLivraison(),
                                            station.getNumDeBoite());
                                    listeDeMachines.add(touraille);
                                    touraille.setProduit(fournisseur1.getProduit());
                                    break;
                            }
                            System.out.println(listeDeMachines);
//                            machine = new Machine(station.getNom(),
//                                    fournisseur1.getProduit(),
//                                    station.getNumDeLivraison(), station.getNumDeBoite());
//                            System.out.println(machine.toString());
                        }
                    }
                }

                //System.out.println(machine.toString());
                System.out.println(i + " : " + station.getNom() + "(" +
                        "[niveau]" + ") ");

            }
        }


        return etatUsine;
    }

    public int getDebutMontant() {
        return debutMontant;
    }

    public int getFinMontant() {
        return finMontant;
    }

    public int getMontantActuel() {
        return montantActuel;
    }

    public int getNbrTours() {
        return nbrTours;
    }

    public void setMontantActuel(int montantActuel) {
        this.montantActuel = montantActuel;
    }

    public void setNbrTours(int nbrTours) {
        this.nbrTours = nbrTours;
    }
}
