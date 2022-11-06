package tp2.station.machine;
import tp2.station.Station;

public class Machine extends Station {
    int compteurTour;
    int numStation;
    int numBoite0;
    int numBoite1;

    public Machine(String nom, int numStation, int numBoite0) {
        //super(nom);
        super(nom, numStation, numBoite0);
        this.numStation = numStation;
        //this.numBoite0 = numBoite0;
    }

    public Machine(String nom, int numStation, int numBoite0, int numBoite1) {
        //super(nom);
        super(nom, numStation, numBoite0, numBoite1);
        this.numStation = numStation;
        //this.numBoite0 = numBoite0;
    }
}
