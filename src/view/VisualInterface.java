package view;

import java.util.*;
import model.*;

public interface VisualInterface {
    void updateTopBar(int currentId);
    void afficherBatiment(ArrayList<IBuild> builds);
    void afficherOuvriers(ArrayList<IBuilder> builders);
    void infoPrompt(ArrayList<String> texteAConfirmer);
    void yesNoPrompt(ArrayList<String> texteAConfirmer);
    void textReplyPrompt(ArrayList<String> texteAConfirmer, int max);
    void empty();
    
}