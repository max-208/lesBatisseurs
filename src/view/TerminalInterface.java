package view;

import java.util.*;
import model.*;

public class TerminalInterface implements VisualInterface {

    private ArrayList<Player> joueurs;

    public TerminalInterface(ArrayList<Player> joueurs){
        this.joueurs = joueurs;
    }  

    @Override
    public void afficherBatiment(ArrayList<IBuild> builds) {
        IBuild b1 = builds.get(0);
        String b1Nom,b1L1,b1L2,b1L3;
        if(b1 != null){
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
            b1Nom = String.format(" %-38s","\u001B[34m[" + b1.getId() + "]\u001B[0m " + b1.getNom())+ " \u001B[34m" + gear + travaille + complet + "\u001B[0m" ;
            b1L1 = String.format("%10s ","gain ecus") + ":" + String.format(" %-4s",b1.getEcus()) + String.format("%11s ","gain point") + ":" + String.format(" %-4s",b1.getGain());
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
            b1L2 =temp1 + temp2;
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
            b1L3 =  temp1 + temp2 ;
        } else {
            b1Nom= "///////////////////////////////////";
            b1L1 = "///////////////////////////////////";
            b1L2 = "///////////////////////////////////";
            b1L3 = "///////////////////////////////////";
        }
        IBuild b2 = builds.get(1);
        String b2Nom,b2L1,b2L2,b2L3;
        if(b2 != null){
            String gear = "  ";
            if(b2.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b2.getEstChantier()){
                travaille = "⚒";
            }
            String complet = " ";
            if(b2.getEstComplet()){
                complet = "⛊";
            }// "\u001B[34m["  "]\u001B[0m "
            b2Nom = String.format(" %-38s","\u001B[34m[" + b2.getId() + "]\u001B[0m " + b2.getNom())+ " \u001B[34m" + gear + travaille + complet + "\u001B[0m" ;
            b2L1 = String.format("%10s ","gain ecus") + ":" + String.format(" %-4s",b2.getEcus()) + String.format("%11s ","gain point") + ":" + String.format(" %-4s",b2.getGain());
            String temp1,temp2;
            if(b2.getWorkedPierre()>=b2.getCoutPierre() || b2.getEstComplet()){
                temp1 = "\u001B[32m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b2.getWorkedPierre() + "/" + b2.getCoutPierre()) + "\u001B[0m";
            } else {
                temp1 =  "\u001B[31m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b2.getWorkedPierre() + "/" + b2.getCoutPierre())+ "\u001B[0m";
            }
            if(b2.getWorkedBois() >= b2.getCoutBois() || b2.getEstComplet()){
                temp2 = "\u001B[32m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b2.getWorkedBois() + "/" + b2.getCoutBois())+ "\u001B[0m";
            } else{
                temp2 = "\u001B[31m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b2.getWorkedBois() + "/" + b2.getCoutBois())+ "\u001B[0m";
            }
            b2L2 =temp1 + temp2;
            if(b2.getWorkedSavoir()>=b2.getCoutSavoir() || b2.getEstComplet()){
                temp1 = "\u001B[32m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b2.getWorkedSavoir() + "/" + b2.getCoutSavoir()) + "\u001B[0m";
            } else {
                temp1 =  "\u001B[31m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b2.getWorkedSavoir() + "/" + b2.getCoutSavoir()) + "\u001B[0m";
            }
            if(b2.getWorkedTuile() >= b2.getCoutTuile() || b2.getEstComplet()){
                temp2 = "\u001B[32m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b2.getWorkedTuile() + "/" + b2.getCoutTuile()) + "\u001B[0m";
            } else{
                temp2 = "\u001B[31m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b2.getWorkedTuile() + "/" + b2.getCoutTuile()) + "\u001B[0m";
            }
            b2L3 =  temp1 + temp2 ;
        } else {
            b2Nom= "///////////////////////////////////";
            b2L1 = "///////////////////////////////////";
            b2L2 = "///////////////////////////////////";
            b2L3 = "///////////////////////////////////";
        }
        IBuild b3= builds.get(2);
        String b3Nom,b3L1,b3L2,b3L3;
        if(b3 != null){
            String gear = "  ";
            if(b3.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b3.getEstChantier()){
                travaille = "⚒";
            }
            String complet = " ";
            if(b3.getEstComplet()){
                complet = "⛊";
            }
            b3Nom = String.format(" %-38s","\u001B[34m[" + b3.getId() + "]\u001B[0m " + b3.getNom())+ " \u001B[34m" + gear + travaille + complet + "\u001B[0m" ;
            b3L1 = String.format("%10s ","gain ecus") + ":" + String.format(" %-4s",b3.getEcus()) + String.format("%11s ","gain point") + ":" + String.format(" %-4s",b3.getGain());
            String temp1,temp2;
            if(b3.getWorkedPierre()>=b3.getCoutPierre() || b3.getEstComplet()){
                temp1 = "\u001B[32m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b3.getWorkedPierre() + "/" + b3.getCoutPierre()) + "\u001B[0m";
            } else {
                temp1 =  "\u001B[31m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b3.getWorkedPierre() + "/" + b3.getCoutPierre())+ "\u001B[0m";
            }
            if(b3.getWorkedBois() >= b3.getCoutBois() || b3.getEstComplet()){
                temp2 = "\u001B[32m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b3.getWorkedBois() + "/" + b3.getCoutBois())+ "\u001B[0m";
            } else{
                temp2 = "\u001B[31m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b3.getWorkedBois() + "/" + b3.getCoutBois())+ "\u001B[0m";
            }
            b3L2 =temp1 + temp2;
            if(b3.getWorkedSavoir()>=b3.getCoutSavoir() || b3.getEstComplet()){
                temp1 = "\u001B[32m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b3.getWorkedSavoir() + "/" + b3.getCoutSavoir()) + "\u001B[0m";
            } else {
                temp1 =  "\u001B[31m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b3.getWorkedSavoir() + "/" + b3.getCoutSavoir()) + "\u001B[0m";
            }
            if(b3.getWorkedTuile() >= b3.getCoutTuile() || b3.getEstComplet()){
                temp2 = "\u001B[32m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b3.getWorkedTuile() + "/" + b3.getCoutTuile()) + "\u001B[0m";
            } else{
                temp2 = "\u001B[31m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b3.getWorkedTuile() + "/" + b3.getCoutTuile()) + "\u001B[0m";
            }
            b3L3 =  temp1 + temp2 ;
        } else {
            b3Nom= "///////////////////////////////////";
            b3L1 = "///////////////////////////////////";
            b3L2 = "///////////////////////////////////";
            b3L3 = "///////////////////////////////////";
        }
        IBuild b4 = builds.get(3);
        String b4Nom,b4L1,b4L2,b4L3;
        if(b4 != null){
            String gear = "  ";
            if(b4.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b4.getEstChantier()){
                travaille = "⚒";
            }
            String complet = " ";
            if(b4.getEstComplet()){
                complet = "⛊";
            }
            b4Nom = String.format(" %-38s","\u001B[34m[" + b4.getId() + "]\u001B[0m " + b4.getNom())+ " \u001B[34m" + gear + travaille + complet + "\u001B[0m" ;
            b4L1 = String.format("%10s ","gain ecus") + ":" + String.format(" %-4s",b4.getEcus()) + String.format("%11s ","gain point") + ":" + String.format(" %-4s",b4.getGain());
            String temp1,temp2;
            if(b4.getWorkedPierre()>=b4.getCoutPierre() || b4.getEstComplet()){
                temp1 = "\u001B[32m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b4.getWorkedPierre() + "/" + b4.getCoutPierre()) + "\u001B[0m";
            } else {
                temp1 =  "\u001B[31m" + String.format("%10s ","pierre") + ":" + String.format(" %-4s",b4.getWorkedPierre() + "/" + b4.getCoutPierre())+ "\u001B[0m";
            }
            if(b4.getWorkedBois() >= b4.getCoutBois() || b4.getEstComplet()){
                temp2 = "\u001B[32m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b4.getWorkedBois() + "/" + b4.getCoutBois())+ "\u001B[0m";
            } else{
                temp2 = "\u001B[31m" + String.format("%11s ","bois") + ":" + String.format(" %-4s",b4.getWorkedBois() + "/" + b4.getCoutBois())+ "\u001B[0m";
            }
            b4L2 =temp1 + temp2;
            if(b4.getWorkedSavoir()>=b4.getCoutSavoir() || b4.getEstComplet()){
                temp1 = "\u001B[32m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b4.getWorkedSavoir() + "/" + b4.getCoutSavoir()) + "\u001B[0m";
            } else {
                temp1 =  "\u001B[31m" + String.format("%10s ","savoir") + ":" + String.format(" %-4s",b4.getWorkedSavoir() + "/" + b4.getCoutSavoir()) + "\u001B[0m";
            }
            if(b4.getWorkedTuile() >= b4.getCoutTuile() || b4.getEstComplet()){
                temp2 = "\u001B[32m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b4.getWorkedTuile() + "/" + b4.getCoutTuile()) + "\u001B[0m";
            } else{
                temp2 = "\u001B[31m" + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b4.getWorkedTuile() + "/" + b4.getCoutTuile()) + "\u001B[0m";
            }
            b4L3 =  temp1 + temp2 ;
        } else {
            b4Nom= "///////////////////////////////////";
            b4L1 = "///////////////////////////////////";
            b4L2 = "///////////////////////////////////";
            b4L3 = "///////////////////////////////////";
        }
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("|                                    [afficher batiments]                                     |");
        System.out.println("|       ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮       |");
        System.out.println("|       | " +           b1Nom             + " | | " +           b2Nom             + " |       |");
        System.out.println("|    ╱| | " +           b1L1              + " | | " +           b2L1              + " | |╲    |");
        System.out.println("|   ╱ | | " +           b1L2              + " | | " +           b2L2              + " | | ╲   |");
        System.out.println("|  ╱  | | " +           b1L3              + " | | " +           b2L3              + " | |  ╲  |");
        System.out.println("| ╱ L | ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯ | R ╲ |");
        System.out.println("| ╲   | ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮ |   ╱ |");
        System.out.println("|  ╲  | | " +           b3Nom             + " | | " +           b4Nom             + " | |  ╱  |");
        System.out.println("|   ╲ | | " +           b3L1              + " | | " +           b4L1              + " | | ╱   |");
        System.out.println("|    ╲| | " +           b3L2              + " | | " +           b4L2              + " | |╱    |");
        System.out.println("|       | " +           b3L3              + " | | " +           b4L3              + " |       |");
        System.out.println("|       ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯       |");
        System.out.println("|       [ legende: \u001B[34m[0]\u001B[0m id de la carte  ,  \u001B[34m⚙\u001B[0m  machine  ,  \u001B[34m⚒\u001B[0m  en chantier  ,  \u001B[34m⛊\u001B[0m  complet ]      |");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────────────╯");
    }
    
    @Override
    public void afficherOuvriers(ArrayList<IBuilder> builders) {
        IBuilder b1 = builders.get(0);
        String b1Nom,b1L1,b1L2,b1L3;
        if(b1 != null){
            String gear = "  ";
            if(b1.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b1.getEstOccupe()){
                travaille = "⚒";
            }
            b1Nom = String.format(" %-39s","\u001B[34m[" + b1.getId() + "]\u001B[0m " + b1.getType())+ " \u001B[34m" + gear + travaille + "\u001B[0m" ;
            b1L1 = String.format("%10s ","prix ecus") + ":" + String.format(" %-4s",b1.getPrix()) + "                  ";
            b1L2 = String.format("%10s ","pierre") + ":" + String.format(" %-4s",b1.getProdPierre()) + String.format("%11s ","bois") + ":" + String.format(" %-4s",b1.getProdBois());
            b1L3 = String.format("%10s ","savoir") + ":" + String.format(" %-4s",b1.getProdSavoir() ) + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b1.getProdTuile());
        } else {
            b1Nom= "///////////////////////////////////";
            b1L1 = "///////////////////////////////////";
            b1L2 = "///////////////////////////////////";
            b1L3 = "///////////////////////////////////";
        }
        IBuilder b2 = builders.get(1);
        String b2Nom,b2L1,b2L2,b2L3;
        if(b2 != null){
            String gear = "  ";
            if(b2.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b2.getEstOccupe()){
                travaille = "⚒";
            }
            b2Nom = String.format(" %-39s","\u001B[34m[" + b2.getId() + "]\u001B[0m " + b2.getType())+ " \u001B[34m" + gear + travaille + "\u001B[0m" ;
            b2L1 = String.format("%10s ","prix ecus") + ":" + String.format(" %-4s",b2.getPrix()) + "                  ";
            b2L2 = String.format("%10s ","pierre") + ":" + String.format(" %-4s",b2.getProdPierre()) + String.format("%11s ","bois") + ":" + String.format(" %-4s",b2.getProdBois());
            b2L3 = String.format("%10s ","savoir") + ":" + String.format(" %-4s",b2.getProdSavoir() ) + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b2.getProdTuile());
        } else {
            b2Nom= "///////////////////////////////////";
            b2L1 = "///////////////////////////////////";
            b2L2 = "///////////////////////////////////";
            b2L3 = "///////////////////////////////////";
        }
        IBuilder b3 = builders.get(2);
        String b3Nom,b3L1,b3L2,b3L3;
        if(b3 != null){
            String gear = "  ";
            if(b3.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b3.getEstOccupe()){
                travaille = "⚒";
            }
            b3Nom = String.format(" %-39s","\u001B[34m[" + b3.getId() + "]\u001B[0m " + b3.getType())+ " \u001B[34m" + gear + travaille + "\u001B[0m" ;
            b3L1 = String.format("%10s ","prix ecus") + ":" + String.format(" %-4s",b3.getPrix()) + "                  ";
            b3L2 = String.format("%10s ","pierre") + ":" + String.format(" %-4s",b3.getProdPierre()) + String.format("%11s ","bois") + ":" + String.format(" %-4s",b3.getProdBois());
            b3L3 = String.format("%10s ","savoir") + ":" + String.format(" %-4s",b3.getProdSavoir() ) + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b3.getProdTuile());
        } else {
            b3Nom= "///////////////////////////////////";
            b3L1 = "///////////////////////////////////";
            b3L2 = "///////////////////////////////////";
            b3L3 = "///////////////////////////////////";
        }
        IBuilder b4 = builders.get(3);
        String b4Nom,b4L1,b4L2,b4L3;
        if(b4 != null){
            String gear = "  ";
            if(b4.getEstMachine()){
                gear = "⚙ ";
            }
            String travaille = " ";
            if(b4.getEstOccupe()){
                travaille = "⚒";
            }
            b4Nom = String.format(" %-39s","\u001B[34m[" + b4.getId() + "]\u001B[0m " + b4.getType())+ " \u001B[34m" + gear + travaille + "\u001B[0m" ;
            b4L1 = String.format("%10s ","prix ecus") + ":" + String.format(" %-4s",b4.getPrix())  + "                  ";
            b4L2 = String.format("%10s ","pierre") + ":" + String.format(" %-4s",b4.getProdPierre()) + String.format("%11s ","bois") + ":" + String.format(" %-4s",b4.getProdBois());
            b4L3 = String.format("%10s ","savoir") + ":" + String.format(" %-4s",b4.getProdSavoir() ) + String.format("%11s ","tuile") + ":" + String.format(" %-4s",b4.getProdTuile());
        } else {
            b4Nom= "///////////////////////////////////";
            b4L1 = "///////////////////////////////////";
            b4L2 = "///////////////////////////////////";
            b4L3 = "///////////////////////////////////";
        }
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("|                                    [afficher batisseurs]                                    |");
        System.out.println("|       ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮       |");
        System.out.println("|       | " +           b1Nom             + " | | " +           b2Nom             + " |       |");
        System.out.println("|    ╱| | " +           b1L1              + " | | " +           b2L1              + " | |╲    |");
        System.out.println("|   ╱ | | " +           b1L2              + " | | " +           b2L2              + " | | ╲   |");
        System.out.println("|  ╱  | | " +           b1L3              + " | | " +           b2L3              + " | |  ╲  |");
        System.out.println("| ╱ L | ╰─────────────────────────────────────╯ ╰─────────────────────────────────────╯ | R ╲ |");
        System.out.println("| ╲   | ╭─────────────────────────────────────╮ ╭─────────────────────────────────────╮ |   ╱ |");
        System.out.println("|  ╲  | | " +           b3Nom             + " | | " +           b4Nom             + " | |  ╱  |");
        System.out.println("|   ╲ | | " +           b3L1              + " | | " +           b4L1              + " | | ╱   |");
        System.out.println("|    ╲| | " +           b3L2              + " | | " +           b4L2              + " | |╱    |");
        System.out.println("|       | " +           b3L3              + " | | " +           b4L3              + " |       |");
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
    public void textReplyPrompt(ArrayList<String> texteAConfirmer) {
        System.out.println("\u001B[34m╭─────────────────────────────────────────────────────────────────────────────────────────────╮\u001B[0m");
        Iterator<String> it = texteAConfirmer.iterator();
        while(it.hasNext()){
            System.out.println("\u001B[34m|\u001B[0m " +                    String.format("%-91s", it.next())                             + " \u001B[34m|\u001B[0m");
        }
        System.out.println("\u001B[34m|\u001B[33m " +                    String.format("%-91s", "Veuillez entrer votre réponse ci-dessous")                             + " \u001B[34m|\u001B[0m");
        System.out.println("\u001B[34m╰─────────────────────────────────────────────────────────────────────────────────────────────╯\u001B[0m");
    }

    @Override
    public void updateTopBar() {

        Player j1 = new Player(PlayerType.Human);
        String j1L1,j1L2,j1L3,j1L4,j1L5;
        if(j1.getType() != PlayerType.None){
            j1L1 = String.format("%3s ",j1.getEcus()) + "ecus     ";
            j1L2 = String.format("%3s ",j1.getPointVictoire()) + "victoire ";
            j1L3 = String.format("%3s ",j1.getAction())  + "actions  ";
            j1L4 = String.format("%3s ",j1.cards.getNbBuilds())  + "batiments";
            j1L5 = String.format("%3s ",j1.cards.getNbBuilds())  + "ouvriers ";
        } else {
            j1L1 = "/////////////";
            j1L2 = "/////////////";
            j1L3 = "/////////////";
            j1L4 = "/////////////";
            j1L5 = "/////////////";
        }

        Player j2 = new Player(PlayerType.Human);
        String j2L1,j2L2,j2L3,j2L4,j2L5;
        if(j2.getType()  != PlayerType.None){
            
            j2L1 = String.format("%3s ",j2.getEcus()) + "ecus     ";
            j2L2 = String.format("%3s ",j2.getPointVictoire()) + "victoire ";
            j2L3 = String.format("%3s ",j2.getAction()) + "actions  ";
            j2L4 = String.format("%3s ",j2.cards.getNbBuilds())  + "batiments";
            j2L5 = String.format("%3s ",j2.cards.getNbBuilds())  + "ouvriers ";
        } else {
            j2L1 = "/////////////";
            j2L2 = "/////////////";
            j2L3 = "/////////////";
            j2L4 = "/////////////";
            j2L5 = "/////////////";
        }
        
        Player j3 = new Player(PlayerType.Auto);
        String j3L1,j3L2,j3L3,j3L4,j3L5;
        if(j3.getType()  != PlayerType.None){
            j3L1 = String.format("%3s ",j3.getEcus()) + "ecus     ";
            j3L2 = String.format("%3s ",j3.getPointVictoire()) + "victoire ";
            j3L3 = String.format("%3s ",j3.getAction()) + "actions  ";
            j3L4 = String.format("%3s ",j3.cards.getNbBuilds())  + "batiments";
            j3L5 = String.format("%3s ",j3.cards.getNbBuilds())  + "ouvriers ";
        } else {
            j3L1 = "/////////////";
            j3L2 = "/////////////";
            j3L3 = "/////////////";
            j3L4 = "/////////////";
            j3L5 = "/////////////";
        }
        
        Player j4 = new Player(PlayerType.None);
        String j4L1,j4L2,j4L3,j4L4,j4L5;
        if(j4.getType() != PlayerType.None){
            j4L1 = String.format("%3s ",j4.getEcus()) + "ecus     ";
            j4L2 = String.format("%3s ",j4.getPointVictoire()) + "p victoire ";
            j4L3 = String.format("%3s ",j4.getAction()) + "actions  ";
            j4L4 = String.format("%3s ",j4.cards.getNbBuilds())  + "batiments";
            j4L5 = String.format("%3s ",j4.cards.getNbBuilds())  + "ouvriers ";
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
        
        // \u001B[34m[A]\u001B[0m
        System.out.println("╭────────────────────────╮ ╭───────────────╮╭───────────────╮╭───────────────╮╭───────────────╮");
        System.out.println("| " +       t1       + " | |     *j1*      ||      j2       ||      j3       ||      j4       |");
        System.out.println("| " +       t2       + " | |               ||               ||               ||               |");
        System.out.println("| " +       t3       + " | | " + j1L1  + " || " + j2L1  + " || " + j3L1  + " || " + j4L1  + " |");
        System.out.println("| " +       t4       + " | | " + j1L2  + " || " + j2L2  + " || " + j3L2  + " || " + j4L2  + " |");
        System.out.println("| " +       t5       + " | | " + j1L3  + " || " + j2L3  + " || " + j3L3  + " || " + j4L3  + " |");
        System.out.println("| " +       t6       + " | | " + j1L4  + " || " + j2L4  + " || " + j3L4  + " || " + j4L4  + " |");
        System.out.println("| " +       t7       + " | | " + j1L5  + " || " + j2L5  + " || " + j3L5  + " || " + j4L5  + " |");
        System.out.println("╰────────────────────────╯ ╰───────────────╯╰───────────────╯╰───────────────╯╰───────────────╯");
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

}