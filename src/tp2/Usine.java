package tp2;

import tp2.station.Fournisseur;
import tp2.station.Station;
import tp2.station.Vendeur;
import tp2.station.machine.*;
import java.util.ArrayList;

public class Usine {
    ArrayList<Station> listeDeStations;
    ArrayList<String> listeString;
    int debutMontant;
    int finMontant;
    int montantActuel;
    int nbrTours;

   // private static final List<String> typesDeStations =
   //         Arrays.asList("fou","mmo","mfo","mfg","mfc","mto","ven");

    public Usine( ArrayList<String> liste) {
        this.debutMontant = Integer.parseInt(liste.get(0));
        this.finMontant = Integer.parseInt(liste.get(1));
        this.listeDeStations = filtrerListeString(liste);
        this.montantActuel = debutMontant;
        this.nbrTours = 0;
    }

    public static ArrayList<Station> filtrerListeString(ArrayList<String> liste){
        String descriptionStation = ""; //tout la description de la statition
        String nomStation = ""; //juste le premier mot
        String leReste = ""; //tout ce qui vient apres le premier mot
        int delimiterPremierMot; //sera l index du premier espace pour
        // delimiter le premier mot
        int numDeStationLivraison = 0;
        int numDeBoiteLivraison = 0;
        String typeDeFournisseur = "";
        String typeDeFournisseurMaj = "";
        ArrayList<Station> listeDeStations = new ArrayList<>();

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
                    leReste = leReste.trim();
                    numDeStationLivraison =
                            Integer.parseInt(leReste.substring(0,1));
                    leReste = leReste.trim();
                    numDeBoiteLivraison =
                            Integer.parseInt(leReste.substring(0,1));

                    listeDeStations.add(new Fournisseur("Fournisseur" +
                            " " + typeDeFournisseur,
                            Produit.valueOf(typeDeFournisseurMaj),
                            numDeStationLivraison,
                            numDeBoiteLivraison));
                    break;
                case "mmo":
                    leReste = leReste.trim();
                    numDeStationLivraison =
                            Integer.parseInt(leReste.substring(0,1));
                    leReste = leReste.trim();
                    numDeBoiteLivraison =
                            Integer.parseInt(leReste.substring(0,1));

                    listeDeStations.add(new Moulin("Moulin",
                            numDeStationLivraison, numDeBoiteLivraison ));
                    break;
                case "mfo":
                    leReste = leReste.trim();
                    numDeStationLivraison =
                            Integer.parseInt(leReste.substring(0,1));
                    leReste = leReste.trim();
                    numDeBoiteLivraison =
                            Integer.parseInt(leReste.substring(0,1));

                    listeDeStations.add(new Fournaise("Fournaise",
                            numDeStationLivraison, numDeBoiteLivraison));
                    break;
                case "mfg":
                    leReste = leReste.trim();
                    numDeStationLivraison =
                            Integer.parseInt(leReste.substring(0,1));
                    leReste = leReste.trim();
                    numDeBoiteLivraison =
                            Integer.parseInt(leReste.substring(0,1));

                    listeDeStations.add(new FournaiseDeGrillage("Fournaise " +
                            "de grillage", numDeStationLivraison,
                            numDeBoiteLivraison));
                    break;
                case "mfc":
                    leReste = leReste.trim();
                    numDeStationLivraison =
                            Integer.parseInt(leReste.substring(0,1));
                    leReste = leReste.trim();
                    numDeBoiteLivraison =
                            Integer.parseInt(leReste.substring(0,1));

                    listeDeStations.add(new FournaiseDeCoupellation(
                            "Fournaise de coupellation",
                            numDeStationLivraison, numDeBoiteLivraison));
                    break;
                case "mto":
                    leReste = leReste.trim();
                    numDeStationLivraison =
                            Integer.parseInt(leReste.substring(0,1));
                    leReste = leReste.trim();
                    numDeBoiteLivraison =
                            Integer.parseInt(leReste.substring(0,1));

                    listeDeStations.add(new Touraille("Touraille",
                            numDeStationLivraison, numDeBoiteLivraison));
                    break;
                case "ven":
                    listeDeStations.add(new Vendeur("Vendeur"));
                    break;
            }
        }
        System.out.println(listeDeStations);
        return listeDeStations;
    }

    public static void descriptionLivraisons(String leReste,
                                             int numDeStationLivraison,
                                             int numDeBoiteLivraison){
        leReste = leReste.trim();
        numDeStationLivraison =
                Integer.parseInt(leReste.substring(0,1));
        leReste = leReste.trim();
        numDeBoiteLivraison =
                Integer.parseInt(leReste.substring(0,1));
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
