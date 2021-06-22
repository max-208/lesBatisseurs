package view;

import java.util.*;
import model.*;

/**
 * l'interface terminale pour les terminals modernes
 */
public class TerminalInterface implements VisualInterface {

    /**
     * la liste des joueurs
     */
    private ArrayList<Player> joueurs;

    /**
     * le constructeur de TerminalInterface
     * @param joueurs la liste des joueurs
     */
    public TerminalInterface(ArrayList<Player> joueurs){
        this.joueurs = joueurs;
    }  

    @Override
    public void afficherBatiment(ArrayList<IBuild> builds) {
        
        String[] Nom = new String[6];
        String[] L1  = new String[6];
        String[] L2  = new String[6];
        String[] L3  = new String[6];
        for(int i = 0; i < 6 ; i++){
            if(builds != null && builds.size()>i && builds.get(i) != null){
                IBuild b1 = builds.get(i);
                String gear = "  ";
                if(b1.getEstMachine()){
                    gear = "⚙ ";
                }
                String travaille = " ";
                if(b1.getEstChantier()){
                    travaille = "⚒";
                }
                String complet = " ";
                if(b1.getEstComplet()){
                    complet = "⛊";
                }
                Nom[i] = String.format(" %-38s","\u001B[34m[" + b1.getId() + "]\u001B[0m " + b1.getNom())+ " \u001B[34m" + gear + travaille + complet + "\u001B[0m" ;
                L1[i] = String.format("%10s ","gain ecus") + ":" + String.format(" %-4s",b1.getEcus()) + String.format("%11s ","gain point") + ":" + String.format(" %-4s",b1.getGain());
                String temp1,temp2;
                if(b1.getWorkedPierre()>=b1.getCoutPierre() || b1.getEstComplet()){
                    temp1 = "\u001B[32m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b1.getWorkedPierre() + "/" + b1.getCoutPierre()) + "\u001B[0m";
                } else {
                    temp1 =  "\u001B[31m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b1.getWorkedPierre() + "/" + b1.getCoutPierre())+ "\u001B[0m";
                }
                if(b1.getWorkedBois() >= b1.getCoutBois() || b1.getEstComplet()){
                    temp2 = "\u001B[32m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b1.getWorkedBois() + "/" + b1.getCoutBois())+ "\u001B[0m";
                } else{
                    temp2 = "\u001B[31m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b1.getWorkedBois() + "/" + b1.getCoutBois())+ "\u001B[0m";
                }
                L2[i] =temp1 + temp2;
                if(b1.getWorkedSavoir()>=b1.getCoutSavoir() || b1.getEstComplet()){
                    temp1 = "\u001B[32m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b1.getWorkedSavoir() + "/" + b1.getCoutSavoir()) + "\u001B[0m";
                } else {
                    temp1 =  "\u001B[31m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b1.getWorkedSavoir() + "/" + b1.getCoutSavoir()) + "\u001B[0m";
                }
                if(b1.getWorkedTuile() >= b1.getCoutTuile() || b1.getEstComplet()){
                    temp2 = "\u001B[32m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b1.getWorkedTuile() + "/" + b1.getCoutTuile()) + "\u001B[0m";
                } else{
                    temp2 = "\u001B[31m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b1.getWorkedTuile() + "/" + b1.getCoutTuile()) + "\u001B[0m";
                }
                L3[i] =  temp1 + temp2 ;
            } else {
                Nom[i]= "///////////////////////////////////";
                L1[i] = "///////////////////////////////////";
                L2[i] = "///////////////////////////////////";
                L3[i] = "///////////////////////////////////";
            }
        }
        
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("|                                    [afficher batiments]                                     |");
        System.out.println("|       ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮       |");
        System.out.println("|       | " +           Nom[0]            + " | | " +          Nom[1]             + " |       |");
        System.out.println("|       | " +           L1[0]             + " | | " +          L1[1]              + " |       |");
        System.out.println("|       | " +           L2[0]             + " | | " +          L2[1]              + " |       |");
        System.out.println("|       | " +           L3[0]             + " | | " +          L3[1]              + " |       |");
        System.out.println("|    ╱| ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯ |╲    |");
        System.out.println("|   ╱ | ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮ | ╲   |");
        System.out.println("|  ╱  | | " +          Nom[2]             + " | | " +          Nom[3]             + " | |  ╲  |");
        System.out.println("| ╱ L | | " +          L1[2]              + " | | " +          L1[3]              + " | | R ╲ |");
        System.out.println("| ╲   | | " +          L2[2]              + " | | " +          L2[3]              + " | |   ╱ |");
        System.out.println("|  ╲  | | " +          L3[2]              + " | | " +          L3[3]              + " | |  ╱  |");
        System.out.println("|   ╲ | ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯ | ╱   |");
        System.out.println("|    ╲| ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮ |╱    |");
        System.out.println("|       | " +          Nom[4]             + " | | " +          Nom[5]             + " |       |");
        System.out.println("|       | " +          L1[4]              + " | | " +          L1[5]              + " |       |");
        System.out.println("|       | " +          L2[4]              + " | | " +          L2[5]              + " |       |");
        System.out.println("|       | " +          L3[4]              + " | | " +          L3[5]              + " |       |");
        System.out.println("|       ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯       |");
        System.out.println("|       [ legende: \u001B[34m[0]\u001B[0m id de la carte  , \u001B[34m⚙\u001B[0m  machine  ,  \u001B[34m⚒\u001B[0m  en chantier  ,  \u001B[34m⛊\u001B[0m  complet ]       |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
    }
    
    @Override
    public void afficherOuvriers(ArrayList<IBuilder> builders) {

        
        String[] Nom = new String[6];
        String[] L1  = new String[6];
        String[] L2  = new String[6];
        String[] L3  = new String[6];
        for(int i = 0; i < 6 ; i++){
            if(builders != null && builders.size()>i && builders.get(i) != null){
                IBuilder b1 = builders.get(i);
                String gear = "  ";
                if(b1.getEstMachine()){
                    gear = "⚙ ";
                }
                String travaille = " ";
                if(b1.getEstOccupe()){
                    travaille = "⚒";
                }
                Nom[i] = String.format(" %-39s","\u001B[34m[" + b1.getId() + "]\u001B[0m " + b1.getType())+ " \u001B[34m" + gear + travaille + "\u001B[0m" ;
                L1[i]= String.format("%10s ","prix ecus") + ":" + String.format(" %-4s",b1.getPrix()) + "                  ";
                L2[i]= String.format("%10s ","pierre") + ":" + String.format(" %-4s",b1.getProdPierre()) + String.format("%11s ","bois") + ":" + String.format(" %-4s",b1.getProdBois());
                L3[i]= String.format("%10s ","savoir") + ":" + String.format(" %-4s",b1.getProdSavoir() ) + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b1.getProdTuile());
            } else {
                Nom[i] = "///////////////////////////////////";
                L1[i]  = "///////////////////////////////////";
                L2[i]  = "///////////////////////////////////";
                L3[i]  = "///////////////////////////////////";
            }
        }
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("|                                    [afficher batisseurs]                                    |");
        System.out.println("|       ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮       |");
        System.out.println("|       | " +           Nom[0]            + " | | " +          Nom[1]             + " |       |");
        System.out.println("|       | " +           L1[0]             + " | | " +          L1[1]              + " |       |");
        System.out.println("|       | " +           L2[0]             + " | | " +          L2[1]              + " |       |");
        System.out.println("|       | " +           L3[0]             + " | | " +          L3[1]              + " |       |");
        System.out.println("|    ╱| ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯ |╲    |");
        System.out.println("|   ╱ | ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮ | ╲   |");
        System.out.println("|  ╱  | | " +          Nom[2]             + " | | " +          Nom[3]             + " | |  ╲  |");
        System.out.println("| ╱ L | | " +          L1[2]              + " | | " +          L1[3]              + " | | R ╲ |");
        System.out.println("| ╲   | | " +          L2[2]              + " | | " +          L2[3]              + " | |   ╱ |");
        System.out.println("|  ╲  | | " +          L3[2]              + " | | " +          L3[3]              + " | |  ╱  |");
        System.out.println("|   ╲ | ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯ | ╱   |");
        System.out.println("|    ╲| ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮ |╱    |");
        System.out.println("|       | " +          Nom[4]             + " | | " +          Nom[5]             + " |       |");
        System.out.println("|       | " +          L1[4]              + " | | " +          L1[5]              + " |       |");
        System.out.println("|       | " +          L2[4]              + " | | " +          L2[5]              + " |       |");
        System.out.println("|       | " +          L3[4]              + " | | " +          L3[5]              + " |       |");
        System.out.println("|       ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯       |");
        System.out.println("|       [  legende:   \u001B[34m[0]\u001B[0m id de la carte   ,   \u001B[34m⚙\u001B[0m  machine   ,   \u001B[34m⚒\u001B[0m  en chantier        ]       |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
        
    }

    @Override
    public void infoPrompt(ArrayList<String> texteAConfirmer) {
        System.out.println("\u001B[34m╭─────────────────────────────────────────────────────────────────────────────────────────────╮\u001B[0m");
        Iterator<String> it = texteAConfirmer.iterator();
        System.out.println("\u001B[34m| \u001B[33m🛈 " +                    String.format("%-88s","Information")                             + " \u001B[34m|\u001B[0m");
        while(it.hasNext()){
            System.out.println("\u001B[34m|\u001B[0m " +                    String.format("%-91s", it.next())                             + " \u001B[34m|\u001B[0m");
        }
        System.out.println("\u001B[34m╰─────────────────────────────────────────────────────────────────────────────────────────────╯\u001B[0m");
    }
    @Override
    public void yesNoPrompt(ArrayList<String> texteAConfirmer) {
        System.out.println("\u001B[34m╭─────────────────────────────────────────────────────────────────────────────────────────────╮\u001B[0m");
        Iterator<String> it = texteAConfirmer.iterator();
        while(it.hasNext()){
            System.out.println("\u001B[34m|\u001B[0m " +                    String.format("%-91s", it.next())                             + " \u001B[34m|\u001B[0m");
        }
        System.out.println("\u001B[34m|\u001B[33m " +                    String.format("%-91s", "Confirmez vous cette action ? [O/n]")                             + " \u001B[34m|\u001B[0m");
        System.out.println("\u001B[34m╰─────────────────────────────────────────────────────────────────────────────────────────────╯\u001B[0m");
    }

    @Override
    public void textReplyPrompt(ArrayList<String> texteAConfirmer, int max) {
        System.out.println("\u001B[34m╭─────────────────────────────────────────────────────────────────────────────────────────────╮\u001B[0m");
        Iterator<String> it = texteAConfirmer.iterator();
        while(it.hasNext()){
            System.out.println("\u001B[34m|\u001B[0m " +                    String.format("%-91s", it.next())                             + " \u001B[34m|\u001B[0m");
        }
        System.out.println("\u001B[34m|\u001B[33m " +                    String.format("%-91s", "Veuillez entrer votre réponse ci-dessous, max : " + max)                             + " \u001B[34m|\u001B[0m");
        System.out.println("\u001B[34m╰─────────────────────────────────────────────────────────────────────────────────────────────╯\u001B[0m");
    }

    @Override
    public void updateTopBar(int currentId){

        Player j1 = this.joueurs.get(0);
        String j1L1,j1L2,j1L3,j1L4,j1L5;
        if(j1.getType() != PlayerType.None){
            j1L1 = String.format("%3s ",j1.getEcus()) + "ecus     ";
            j1L2 = String.format("%3s ",j1.getPointVictoire()) + "victoire ";
            j1L3 = String.format("%3s ",j1.getAction())  + "actions  ";
            j1L4 = String.format("%3s ",j1.cards.getNbBuilds())  + "batiments";
            j1L5 = String.format("%3s ",j1.cards.getNbBuilders())  + "ouvriers ";
        } else {
            j1L1 = "/////////////";
            j1L2 = "/////////////";
            j1L3 = "/////////////";
            j1L4 = "/////////////";
            j1L5 = "/////////////";
        }

        Player j2 = this.joueurs.get(1);
        String j2L1,j2L2,j2L3,j2L4,j2L5;
        if(j2.getType()  != PlayerType.None){
            
            j2L1 = String.format("%3s ",j2.getEcus()) + "ecus     ";
            j2L2 = String.format("%3s ",j2.getPointVictoire()) + "victoire ";
            j2L3 = String.format("%3s ",j2.getAction()) + "actions  ";
            j2L4 = String.format("%3s ",j2.cards.getNbBuilds())  + "batiments";
            j2L5 = String.format("%3s ",j2.cards.getNbBuilders())  + "ouvriers ";
        } else {
            j2L1 = "/////////////";
            j2L2 = "/////////////";
            j2L3 = "/////////////";
            j2L4 = "/////////////";
            j2L5 = "/////////////";
        }
        
        Player j3 = this.joueurs.get(2);
        String j3L1,j3L2,j3L3,j3L4,j3L5;
        if(j3.getType()  != PlayerType.None){
            j3L1 = String.format("%3s ",j3.getEcus()) + "ecus     ";
            j3L2 = String.format("%3s ",j3.getPointVictoire()) + "victoire ";
            j3L3 = String.format("%3s ",j3.getAction()) + "actions  ";
            j3L4 = String.format("%3s ",j3.cards.getNbBuilds())  + "batiments";
            j3L5 = String.format("%3s ",j3.cards.getNbBuilders())  + "ouvriers ";
        } else {
            j3L1 = "/////////////";
            j3L2 = "/////////////";
            j3L3 = "/////////////";
            j3L4 = "/////////////";
            j3L5 = "/////////////";
        }
        
        Player j4 = this.joueurs.get(3);
        String j4L1,j4L2,j4L3,j4L4,j4L5;
        if(j4.getType() != PlayerType.None){
            j4L1 = String.format("%3s ",j4.getEcus()) + "ecus     ";
            j4L2 = String.format("%3s ",j4.getPointVictoire()) + "victoire ";
            j4L3 = String.format("%3s ",j4.getAction()) + "actions  ";
            j4L4 = String.format("%3s ",j4.cards.getNbBuilds())  + "batiments";
            j4L5 = String.format("%3s ",j4.cards.getNbBuilders())  + "ouvriers ";
        } else {
            j4L1 = "/////////////";
            j4L2 = "/////////////";
            j4L3 = "/////////////";
            j4L4 = "/////////////";
            j4L5 = "/////////////";
        };
        String t1 = "\u001B[34m[A]\u001B[0m afficher ouvriers ";
        String t2 = "\u001B[34m[B]\u001B[0m afficher batiments";
        String t3 = "\u001B[34m[C]\u001B[0m ouvrir chantier   ";
        String t4 = "\u001B[34m[D]\u001B[0m recruter ouvrier  ";
        String t5 = "\u001B[34m[E]\u001B[0m envoyer travailler";
        String t6 = "\u001B[34m[F]\u001B[0m action -> ecu     ";
        String t7 = "\u001B[34m[G]\u001B[0m ecu -> action     ";
        String t8 = "\u001B[34m[H]\u001B[0m fin de tour       ";
        
        // \u001B[34m[A]\u001B[0m
        
		System.out.println("\n\n");
        System.out.println("╭────────────────────────╮ ╭───────────────╮╭───────────────╮╭───────────────╮╭───────────────╮");
        System.out.println("| " +       t1       + " | |      j1       ||      j2       ||      j3       ||      j4       |");
        System.out.println("| " +       t2       + " | |               ||               ||               ||               |");
        System.out.println("| " +       t3       + " | | " + j1L1  + " || " + j2L1  + " || " + j3L1  + " || " + j4L1  + " |");
        System.out.println("| " +       t4       + " | | " + j1L2  + " || " + j2L2  + " || " + j3L2  + " || " + j4L2  + " |");
        System.out.println("| " +       t5       + " | | " + j1L3  + " || " + j2L3  + " || " + j3L3  + " || " + j4L3  + " |");
        System.out.println("| " +       t6       + " | | " + j1L4  + " || " + j2L4  + " || " + j3L4  + " || " + j4L4  + " |");
        System.out.println("| " +       t7       + " | | " + j1L5  + " || " + j2L5  + " || " + j3L5  + " || " + j4L5  + " |");
        System.out.println("| " +       t8       + " | |               ||               ||               ||               |");
        System.out.println("╰────────────────────────╯ ╰───────────────╯╰───────────────╯╰───────────────╯╰───────────────╯");
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("|                                  [ c'est au tour de J" + (currentId+1) + " ! ]                                  |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");

    }

    @Override
    public void empty(){
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
    }

    @Override
    public void menu() {
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("| ╭─────────────────────────────────────────────────────────────────────────────────────────╮ |");
        System.out.println("| |                                                                                         | |");
        System.out.println("| |                                   [N] Nouvelle Partie                                   | |");
        System.out.println("| |                                                                                         | |");
        System.out.println("| ╰─────────────────────────────────────────────────────────────────────────────────────────╯ |");
        System.out.println("| ╭─────────────────────────────────────────────────────────────────────────────────────────╮ |");
        System.out.println("| |                                                                                         | |");
        System.out.println("| |                                    [C] Charger partie                                   | |");
        System.out.println("| |                                                                                         | |");
        System.out.println("| ╰─────────────────────────────────────────────────────────────────────────────────────────╯ |");
        System.out.println("| ╭─────────────────────────────────────────────────────────────────────────────────────────╮ |");
        System.out.println("| |                                                                                         | |");
        System.out.println("| |                                        [R] Regles                                       | |");
        System.out.println("| |                                                                                         | |");
        System.out.println("| ╰─────────────────────────────────────────────────────────────────────────────────────────╯ |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
        
    }

    @Override
    public void saveSelect() {
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("| [ B retour au menu ]                                                                        |");
        System.out.println("| ╭───────────────────────────────────────────╮ ╭───────────────────────────────────────────╮ |");
        System.out.println("| |                                           | |                                           | |");
        System.out.println("| |             [1]  sauvegarde 1             | |             [2]  sauvegarde 2             | |");
        System.out.println("| |                                           | |                                           | |");
        System.out.println("| ╰───────────────────────────────────────────╯ ╰───────────────────────────────────────────╯ |");
        System.out.println("| ╭───────────────────────────────────────────╮ ╭───────────────────────────────────────────╮ |");
        System.out.println("| |                                           | |                                           | |");
        System.out.println("| |             [3]  sauvegarde 3             | |             [4]  sauvegarde 4             | |");
        System.out.println("| |                                           | |                                           | |");
        System.out.println("| ╰───────────────────────────────────────────╯ ╰───────────────────────────────────────────╯ |");
        System.out.println("| ╭───────────────────────────────────────────╮ ╭───────────────────────────────────────────╮ |");
        System.out.println("| |                                           | |                                           | |");
        System.out.println("| |             [5]  sauvegarde 5             | |             [6]  sauvegarde 6             | |");
        System.out.println("| |                                           | |                                           | |");
        System.out.println("| ╰───────────────────────────────────────────╯ ╰───────────────────────────────────────────╯ |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
        
    }

    @Override
    public void regles() {
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("| [ B retour au menu ]                                                                        |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                        da rules                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("|                                                                                             |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
        
    }

}