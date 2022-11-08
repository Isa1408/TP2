package tp2.station.machine;
import tp2.Produit;
import tp2.station.Station;

public class Machine extends Station {
    int compteurTour;
    int numStation;
    int numBoite0;
    int numBoite1;
    Produit produit;

    public Machine(String nom, int numStation, int numBoite) {
        //super(nom);
        super(nom,numStation, numBoite);
        //this.produit = produit;
        this.numStation = numStation;
        //this.numBoite0 = numBoite0;
    }

//    public Machine(String nom, Produit produit, int numStation, int numBoite) {
//        //super(nom);
//        super(nom,numStation, numBoite);
//        this.produit = produit;
//        this.numStation = numStation;
//        //this.numBoite0 = numBoite0;
//    }

    @Override
    public String toString() {
        return "Machine{" +
                "numStation=" + numStation + ", numBoite="+ super.getNumDeBoite() +
                ", produit=" + produit +
                '}';
    }

    //    public Machine(String nom, int numStation, int numBoite0, int numBoite1) {
//        //super(nom);
//        super(nom, numStation, numBoite0, numBoite1);
//        this.numStation = numStation;
//        //this.numBoite0 = numBoite0;
//    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
