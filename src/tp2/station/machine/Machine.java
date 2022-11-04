package tp2.station.machine;
import tp2.station.Station;

public class Machine extends Station {
    int compteurTour;
    int numStation;
    int numBoite;

    public Machine(String nom, int numStation, int numBoite) {
        //super(nom);
        super(nom, numStation,numBoite);
        this.numStation = numStation;
        this.numBoite = numBoite;
    }
}
