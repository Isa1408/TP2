package tp2.station;

public abstract class Station {
    private String nom;
    private int numDeLivraison;
    private int numDeBoite;

//    public Station(String nom, int numDeLivraison, int numDeBoite) {
//        this.nom = nom;
//        this.numDeLivraison = numDeLivraison;
//        this.numDeBoite = numDeBoite;
//    }

    public Station (String nom){
        this.nom = nom;
    }

    //pas important
    public String toString(){
        return this.nom + this.numDeLivraison + this.numDeBoite;
    }

    public String getNom() {
        return nom;
    }
}
