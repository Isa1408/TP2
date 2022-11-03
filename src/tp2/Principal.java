package tp2;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> liste = lireFichier.listeString();
        Usine usine = new Usine(liste);
        System.out.println(liste);
        System.out.println(liste.get(0));;
        System.out.println(liste.get(1));

        System.out.println();
    }
}
