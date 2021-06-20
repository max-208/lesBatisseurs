package view;

import javax.swing.*;

import controller.Listener;
import java.awt.*;
import java.util.*;
import model.*;

public class PlayerInfoPannel extends JPanel{
    private ArrayList<Player> players;
    private JButton A;
    private JButton B;
    private JButton C;
    private JButton D;
    private JButton E;
    private JButton F;
    private JButton G;
    private JButton H;
    private JLabel[] L;
    public PlayerInfoPannel(ArrayList<Player> players, Listener al){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.players = players;
        A = new JButton();
        B = new JButton();
        C = new JButton();
        D = new JButton();
        E = new JButton();
        F = new JButton();
        G = new JButton();
        H = new JButton();
        A.setText("afficher ouvriers ");
        B.setText("afficher batiments");
        C.setText("ouvrir chantier   ");
        D.setText("recruter ouvrier  ");
        E.setText("envoyer travailler");
        F.setText("action -> ecu     ");
        G.setText("ecu -> action     ");
        H.setText("fin de tour       ");
        A.setMinimumSize(new Dimension(100, 40));
        B.setMinimumSize(new Dimension(100, 40));
        C.setMinimumSize(new Dimension(100, 40));
        D.setMinimumSize(new Dimension(100, 40));
        E.setMinimumSize(new Dimension(100, 40));
        F.setMinimumSize(new Dimension(100, 40));
        G.setMinimumSize(new Dimension(100, 40));
        H.setMinimumSize(new Dimension(100, 40));
        A.addActionListener(al);
        B.addActionListener(al);
        C.addActionListener(al);
        D.addActionListener(al);
        E.addActionListener(al);
        F.addActionListener(al);
        G.addActionListener(al);
        H.addActionListener(al);
        A.setActionCommand("A");
        B.setActionCommand("B");
        C.setActionCommand("C");
        D.setActionCommand("D");
        E.setActionCommand("E");
        F.setActionCommand("F");
        G.setActionCommand("G");
        H.setActionCommand("H");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(A);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(B);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(C);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(D);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(E);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(F);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(G);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(H);
        buttonPanel.add(Box.createHorizontalGlue());
        L = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            L[i] = new JLabel();
            L[i].setOpaque(true);
        }
        this.updatePlayerInfo(0);
        
        JPanel playerGeneralPannel = new JPanel();
        playerGeneralPannel.add(Box.createHorizontalGlue());
        playerGeneralPannel.setLayout(new BoxLayout(playerGeneralPannel, BoxLayout.X_AXIS));
        for (int i = 0; i < 4; i++) {
            if(this.players.get(i).getType()!=PlayerType.None){
                JPanel playerPanel = new JPanel();
                playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
                JLabel j = new JLabel("J" + (i+1));
                j.setHorizontalAlignment(SwingConstants.CENTER);
                playerPanel.add(j);
                playerPanel.add(L[i]);
                playerGeneralPannel.add(playerPanel);
                playerGeneralPannel.add(Box.createHorizontalGlue());
            }
        }
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(playerGeneralPannel);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(buttonPanel);
        this.add(Box.createRigidArea(new Dimension(0,20)));
    }

    public void updatePlayerInfo(int current){
        for (int i = 0; i < 4; i++) {
            if(this.players.get(i).getType()!=PlayerType.None){
                L[i].setText("[ " + String.format("%3s ",this.players.get(i).getEcus()) + "ecus    " + 
                String.format("%3s ",this.players.get(i).getPointVictoire()) + "victoire    "+
                String.format("%3s ",this.players.get(i).getAction())  + "actions    "+
                String.format("%3s ",this.players.get(i).cards.getNbBuilds())  + "batiments    "+
                String.format("%3s ",this.players.get(i).cards.getNbBuilders())  + "ouvriers ]");
                if(i == current){
                    L[i].setBackground(Color.ORANGE);
                } else {
                    L[i].setBackground(null);
                }
            }
        }
    }
}