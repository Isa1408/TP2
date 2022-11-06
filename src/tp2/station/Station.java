package tp2.station;

public abstract class Station {
    private String nom;
    private int numDeLivraison;
    private int numDeBoite0;
    private int numDeBoite1;

    public Station (String nom){
        this.nom = nom;
    }

    public Station(String nom, int numDeLivraison, int numDeBoite0) {
        this.nom = nom;
        this.numDeLivraison = numDeLivraison;
        this.numDeBoite0 = numDeBoite0;
    }

    public Station(String nom, int numDeLivraison, int numDeBoite0, int numDeBoite1) {
        this.nom = nom;
        this.numDeLivraison = numDeLivraison;
        this.numDeBoite0 = numDeBoite0;
        this.numDeBoite1 = numDeBoite1;
    }

    //pas important
    public String toString(){
        return this.nom + this.numDeLivraison + this.numDeBoite0;
    }

    public String getNom() {
        return nom;
    }

    public int getNumDeLivraison() {
        return numDeLivraison;
    }

    public int getNumDeBoite0() {
        return numDeBoite0;
    }
}
