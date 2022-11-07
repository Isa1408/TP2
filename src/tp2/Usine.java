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
        int[] tabTemp = null;
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
                    tabTemp = descriptionLivraisons(leReste,
                        numDeStationLivraison,
                            numDeBoiteLivraison);

//                    listeDeStations.add(new Fournisseur("fou" +
//                            " " + typeDeFournisseur,
//                            Produit.valueOf(typeDeFournisseurMaj),
//                            tabTemp[0], tabTemp[1]));

                    listeDeStations.add(new Fournisseur("fou",
                            Produit.valueOf(typeDeFournisseurMaj),
                            tabTemp[0], tabTemp[1]));
                    break;
                case "mmo":
                    tabTemp = descriptionLivraisons(leReste,
                        numDeStationLivraison, numDeBoiteLivraison);

                    listeDeStations.add(new Moulin("mmo",
                            tabTemp[0], tabTemp[1]));
                    break;
                case "mfo":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);

                    listeDeStations.add(new Fournaise("mfo",
                            tabTemp[0], tabTemp[1]));
                    break;
                case "mfg":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);

                    listeDeStations.add(new FournaiseDeGrillage("mfg ",
                            tabTemp[0], tabTemp[1]));
                    break;
                case "mfc":
                    tabTemp = descriptionLivraisons(leReste,
                            numDeStationLivraison, numDeBoiteLivraison);

                    listeDeStations.add(new FournaiseDeCoupellation(
                            "mfc",
                            tabTemp[0], tabTemp[1]));
                    break;
                case "mto":
                    tabTemp = descriptionLivraisons(leReste,
                        numDeStationLivraison,
                             numDeBoiteLivraison);

                    listeDeStations.add(new Touraille("mto",
                            tabTemp[0], tabTemp[1]));
                    break;
                case "ven":
                    listeDeStations.add(new Vendeur("ven"));
                    break;
            }
        }
        //System.out.println(listeDeStations);
        return listeDeStations;
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


        for (int i = 0; i < usine.listeDeStations.size(); i++) {
            //usine.listeDeStations.get(i).toString();
            Station station = usine.listeDeStations.get(i);

           // System.out.println(station.getNom().toString());

            if(station.getNom().toString().equals("fou")){
                //listeDeFournisseurs = new ArrayList<>();
                Fournisseur fou = (Fournisseur) usine.listeDeStations.get(i);
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

                if (listeDeFournisseurs != null){
                    for (int j = 0; j < listeDeFournisseurs.size(); j++) {
                        Fournisseur fournisseur1 = listeDeFournisseurs.get(j);
                        if (fournisseur1.getNumDeLivraison() == i){
                            machine = new Machine(station.getNom(),
                                    fournisseur1.getProduit(),
                                    station.getNumDeLivraison(), station.getNumDeBoite());
                            System.out.println(machine.toString());
                        }
                    }
                }

                //System.out.println(machine.toString());
                System.out.println(i + " : " + station.getNom() + "(" +
                        "[niveau]" + ") ");
            }

            //System.out.println(i + " : " + station.getNom() );
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
