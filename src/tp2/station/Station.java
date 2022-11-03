package tp2.station;

public abstract class Station {
    private String nom;

    public Station(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
