package view;

import java.util.ArrayList;

import model.IBuild;
import model.IBuilder;
import javax.swing.*;
import java.awt.*;

import controller.Listener;
import model.*;

public class GraphicalInterface extends JFrame implements VisualInterface  {

    private PlayerInfoPannel PlayerInfoPannel;
    private DisplayBuildPannel DisplayBuildPannel;
    private DisplayBuilderPannel DisplayBuilderPannel;
    private PromptPanel PromptPanel;
    private ReplyPrompt ReplyPrompt;
    public GraphicalInterface(ArrayList<Player> players, Listener al){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1750,900));
        this.PlayerInfoPannel = new PlayerInfoPannel(players, al);
        this.DisplayBuildPannel = new DisplayBuildPannel(al);
        this.DisplayBuilderPannel = new DisplayBuilderPannel(al);
        this.PromptPanel = new PromptPanel();
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
        this.DisplayBuildPannel.setVisible(false);

        contentPane.add(this.DisplayBuilderPannel);
        this.DisplayBuilderPannel.update(new ArrayList<IBuilder>());

        ReplyPrompt.setVisible(false);
        contentPane.add(ReplyPrompt);

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
    }
}