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
    private JLabel[] L1;
    private JLabel[] L2;
    private JLabel[] L3;
    private JLabel[] L4;
    private JLabel[] L5;
    public PlayerInfoPannel(ArrayList<Player> players, Listener al){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
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
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(A);
        buttonPanel.add(B);
        buttonPanel.add(C);
        buttonPanel.add(D);
        buttonPanel.add(E);
        buttonPanel.add(F);
        buttonPanel.add(G);
        buttonPanel.add(H);
        buttonPanel.setMinimumSize(new Dimension(100, 180));
        buttonPanel.setBackground(Color.ORANGE);
        this.add(buttonPanel);
        L1 = new JLabel[4];
        L2 = new JLabel[4];
        L3 = new JLabel[4];
        L4 = new JLabel[4];
        L5 = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            L1[i] = new JLabel();
            L2[i] = new JLabel();
            L3[i] = new JLabel();
            L4[i] = new JLabel();
            L5[i] = new JLabel();
        }
        this.updatePlayerInfo(0);
        for (int i = 0; i < 4; i++) {
            JPanel playerPannel = new JPanel();
            playerPannel.setLayout(new BoxLayout(playerPannel, BoxLayout.Y_AXIS));
            JLabel numj = new JLabel();
            numj.setText("J" + i);
            playerPannel.add(numj);
            playerPannel.add(new JLabel(" "));
            playerPannel.add(L1[i]);
            playerPannel.add(L2[i]);
            playerPannel.add(L3[i]);
            playerPannel.add(L4[i]);
            playerPannel.add(L5[i]);
            playerPannel.setMinimumSize(new Dimension(100, 180));
            playerPannel.setBackground(Color.ORANGE);
            this.add(playerPannel);
        }

    }

    public void updatePlayerInfo(int current){
        for (int i = 0; i < 4; i++) {
            L1[i].setText(String.format("%3s ",this.players.get(i).getEcus()) + "ecus     ");
            L2[i].setText(String.format("%3s ",this.players.get(i).getPointVictoire()) + "victoire ");
            L3[i].setText(String.format("%3s ",this.players.get(i).getAction())  + "actions  ");
            L4[i].setText(String.format("%3s ",this.players.get(i).cards.getNbBuilds())  + "batiments");
            L5[i].setText(String.format("%3s ",this.players.get(i).cards.getNbBuilders())  + "ouvriers ");
        }
    }
}