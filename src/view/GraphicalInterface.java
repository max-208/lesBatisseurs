package view;

import java.util.ArrayList;

import model.IBuild;
import model.IBuilder;
import javax.swing.*;

import controller.Listener;
import model.*;

public class GraphicalInterface extends JFrame implements VisualInterface  {

    private PlayerInfoPannel playerInfoPannel;
    private DisplayCardPannel displayCardPannel;
    private PromptPanel promptPanel;
    public GraphicalInterface(ArrayList<Player> players, Listener al){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.playerInfoPannel = new PlayerInfoPannel(players, al);
        this.displayCardPannel = new DisplayCardPannel();
        this.promptPanel = new PromptPanel();
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(this.playerInfoPannel);
        contentPane.add(this.displayCardPannel);
        contentPane.add(this.promptPanel);
        this.setContentPane(contentPane);
        this.pack();
    }
    @Override
    public void afficherBatiment(ArrayList<IBuild> builds) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afficherOuvriers(ArrayList<IBuilder> builders) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void infoPrompt(ArrayList<String> texteAConfirmer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void yesNoPrompt(ArrayList<String> texteAConfirmer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void textReplyPrompt(ArrayList<String> texteAConfirmer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void updateTopBar(int currentId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void empty(){
        // TODO Auto-generated method stub
        
    }
}