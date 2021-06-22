package view;

import java.util.*;
import model.*;
/**
 * l'interface visuelle et ce qu'elle doit implementer
 */
public interface VisualInterface {
    /**
     * met a jour et affiche la barre du haut.
     * @param currentId l'id du joueur actuellement en train de jouer
     */
    void updateTopBar(int currentId);
    /**
     * afficher une liste de batiments
     * @param builds les batiments a afficher
     */
    void afficherBatiment(ArrayList<IBuild> builds);
    /**
     * afficher une liste d'ouvriers
     * @param builders les ouvriers a afficher
     */
    void afficherOuvriers(ArrayList<IBuilder> builders);
    /**
     * affiche une info
     * @param texteAConfirmer texte a afficher
     */
    void infoPrompt(ArrayList<String> texteAConfirmer);
    /**
     * affiche une action a valider (inutilisé)
     * @param texteAConfirmer action a valider
     */
    void yesNoPrompt(ArrayList<String> texteAConfirmer); //non utilisé
    /**
     * affiche une quantité a entrer
     * @param texteAConfirmer le texte a confirmer
     * @param max la quantité maximale
     */
    void textReplyPrompt(ArrayList<String> texteAConfirmer, int max);
    /**
     * affiche un ecran vide
     */
    void empty();
    /**
     * affiche le menu
     */
    void menu();
    /**
     * affiche la selection de sauvegarde
     */
    void saveSelect();
    /**
     * affiche les regles
     */
    void regles();
}