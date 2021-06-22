package view;

import java.util.ArrayList;
import model.IBuild;
import model.IBuilder;
import javax.swing.*;
import java.awt.*;
import controller.Listener;
import controller.MenuListener;
import model.*;

/**
 * la modelisation de l'interface graphique
 */
public class GraphicalInterface extends JFrame implements VisualInterface  {

    /**
     * le module d'affichage des infos sur les joueurs 
     */
    private PlayerInfoPannel PlayerInfoPannel;
    /**
     * le module d'affichage des batiments
     */
    private DisplayBuildPannel DisplayBuildPannel;
    /**
     * le module d'affichage des batisseurs
     */
    private DisplayBuilderPannel DisplayBuilderPannel;
    /**
     * le module d'affichage des infos
     */
    private PromptPanel PromptPanel;
    /**
     * le module d'affichage des reponses
     */
    private ReplyPrompt ReplyPrompt;
    /**
     * le module d'affichage du menu
     */
    private MenuInterface MenuInterface;
    /**
     * le constructeur de l'interface graphique
     * @param players les joueurs
     * @param al le listener qui réagis au action des joueurs
     * @param ml le listener du menu
     */
    public GraphicalInterface(ArrayList<Player> players, Listener al, MenuListener ml){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1750,900));
        this.PlayerInfoPannel = new PlayerInfoPannel(players, al);
        this.DisplayBuildPannel = new DisplayBuildPannel(al);
        this.DisplayBuilderPannel = new DisplayBuilderPannel(al);
        this.PromptPanel = new PromptPanel();
        this.MenuInterface = new MenuInterface(ml);
        this.ReplyPrompt = new ReplyPrompt(al);
        this.DisplayBuildPannel.setOpaque(false);
        this.DisplayBuilderPannel.setOpaque(false);
        this.ReplyPrompt.setOpaque(false);

        ContentPane contentPane = new ContentPane("data/images/wallpaper.jpg");
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
        contentPane.add(this.PlayerInfoPannel);

        contentPane.add(Box.createVerticalGlue());
        contentPane.add(this.DisplayBuildPannel);
        this.DisplayBuildPannel.update(new ArrayList<IBuild>());

        contentPane.add(this.DisplayBuilderPannel);
        this.DisplayBuilderPannel.update(new ArrayList<IBuilder>());

        contentPane.add(this.ReplyPrompt);
        contentPane.add(this.MenuInterface);

        contentPane.add(Box.createVerticalGlue());
        contentPane.add(this.PromptPanel);
        
        this.setContentPane(contentPane);
        

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }
    //new ImageIcon("data/images/wallpaper.jpg").getImage()

    @Override
    public void afficherBatiment(ArrayList<IBuild> builds) {
        this.DisplayBuildPannel.update(builds);
        this.DisplayBuildPannel.setVisible(true);
        this.DisplayBuilderPannel.setVisible(false);
        this.ReplyPrompt.setVisible(false);
    }

    @Override
    public void afficherOuvriers(ArrayList<IBuilder> builders) {
        this.DisplayBuilderPannel.update(builders);
        this.DisplayBuilderPannel.setVisible(true);
        this.DisplayBuildPannel.setVisible(false);
        this.ReplyPrompt.setVisible(false);
    }

    @Override
    public void infoPrompt(ArrayList<String> texteAConfirmer) {
        this.PromptPanel.update(texteAConfirmer);
    }

    @Override
    public void yesNoPrompt(ArrayList<String> texteAConfirmer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void textReplyPrompt(ArrayList<String> texteAConfirmer, int max) {
        this.ReplyPrompt.update(texteAConfirmer, max);
        this.DisplayBuilderPannel.setVisible(false);
        this.DisplayBuildPannel.setVisible(false);
        this.ReplyPrompt.setVisible(true);
    }

    @Override
    public void updateTopBar(int currentId) {
        this.PlayerInfoPannel.updatePlayerInfo(currentId);
    }

    @Override
    public void empty(){
        this.DisplayBuilderPannel.setVisible(false);
        this.DisplayBuildPannel.setVisible(false);
        this.ReplyPrompt.setVisible(false);
        this.PlayerInfoPannel.setVisible(true);
        this.PromptPanel.setVisible(true);
        this.MenuInterface.setVisible(false);
    }

    @Override
    public void menu() {
        this.DisplayBuilderPannel.setVisible(false);
        this.DisplayBuildPannel.setVisible(false);
        this.ReplyPrompt.setVisible(false);
        this.PlayerInfoPannel.setVisible(false);
        this.PromptPanel.setVisible(false);
        this.MenuInterface.setVisible(true);
        this.MenuInterface.menu();
    }

    @Override
    public void saveSelect() {
        this.DisplayBuilderPannel.setVisible(false);
        this.DisplayBuildPannel.setVisible(false);
        this.ReplyPrompt.setVisible(false);
        this.PlayerInfoPannel.setVisible(false);
        this.PromptPanel.setVisible(false);
        this.MenuInterface.setVisible(true);
        this.MenuInterface.selectionSauvegarde();
    }

    @Override
    public void regles() {
        this.DisplayBuilderPannel.setVisible(false);
        this.DisplayBuildPannel.setVisible(false);
        this.ReplyPrompt.setVisible(false);
        this.PlayerInfoPannel.setVisible(false);
        this.PromptPanel.setVisible(false);
        this.MenuInterface.setVisible(true);
        this.MenuInterface.regles();
    }
}