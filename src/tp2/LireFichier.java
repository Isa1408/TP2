package tp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Représente la classe qui va manipuler le fichier d'entré.
 *
 * @Author Bruno Malenfant
 * @Author Isabelle Tamas
 */
public class LireFichier {
    /**
     * Demander à l'utilisateur le nom du fichier.
     *
     * @return le nom du fichier saisi
     */
    public static String demanderNomFichier(){
        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez le nom du fichier contenant le niveau : ");
        String nomFichierEntrees = clavier.next();

        return nomFichierEntrees;
    }

    /**
     * Lit le fichier d'entrée.
     *
     * @return le fichier demandé
     */
    public static Scanner lireFichier(){
        String nomFichierEntree = demanderNomFichier();
        Scanner fichier = null;

        try {
            fichier = new Scanner(new File( nomFichierEntree));
        } catch (FileNotFoundException e) {
            System.err.println("Erreur");
            System.exit(-1);
        }
        return fichier;
    }

    /**
     * Parcoure le fichier et place chaque caractère dans un
     * <code>Arraylist</code>.
     *
     * @return un <code>Arraylist</code> de type <code>String</code>
     */
    public static ArrayList<String> listeString(){
        Scanner fichier = lireFichier();
        String courant = "";
        fichier.useDelimiter("\n");
        ArrayList<String> liste = new ArrayList<String>();
        while(fichier.hasNext()){
            courant = fichier.next();
            if (!courant.equals("\n"))
                liste.add(courant);
        }
        return liste;
    }

}
