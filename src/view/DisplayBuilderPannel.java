package view;

import java.util.ArrayList;
import model.*;
import controller.Listener;
import javax.swing.*;
import java.awt.*;

/**
 * le panel qui affiche les batiments
 */
public class DisplayBuilderPannel extends JPanel {
    /**
     * la liste des batiments affichés
     */
    ArrayList<IBuilder> builders;
    /**
     * le listener responsable des actions
     */
    Listener al;
    /**
     * un bouton pour changer de page
     */
    JButton L;
    /**
     * un bouton pour changer de page
     */
    JButton R;
    /**
     * un bouton affichant une carte
     */
    JButton B1;
    /**
     * un bouton affichant une carte
     */
    JButton B2;
    /**
     * un bouton affichant une carte
     */
    JButton B3;
    /**
     * un bouton affichant une carte
     */
    JButton B4;
    /**
     * un bouton affichant une carte
     */
    JButton B5;
    /**
     * un bouton affichant une carte
     */
    JButton B6;

    /**
     * le constructeur de displaybuild
     * @param al le listener
     */
    public DisplayBuilderPannel(Listener al){
        this.builders = new ArrayList<IBuilder>();
        this.al = al;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        L = new JButton();
        L.setActionCommand("L");
        ImageIcon Li = new ImageIcon("data/images/L.png");
        L.setIcon( new ImageIcon(Li.getImage().getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH)));
        L.addActionListener(al);
        L.setBorderPainted(false);
        L.setContentAreaFilled(false);
        R = new JButton();
        R.setActionCommand("R");
        ImageIcon Ri = new ImageIcon("data/images/R.png");
        R.setIcon( new ImageIcon(Ri.getImage().getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH)));
        R.addActionListener(al);
        R.setBorderPainted(false);
        R.setContentAreaFilled(false);

        B1 = new JButton();
        B2 = new JButton();
        B3 = new JButton();
        B4 = new JButton();
        B5 = new JButton();
        B6 = new JButton();
        B1.addActionListener(al);
        B2.addActionListener(al);
        B3.addActionListener(al);
        B4.addActionListener(al);
        B5.addActionListener(al);
        B6.addActionListener(al);
        B1.setBorderPainted(false);
        B2.setBorderPainted(false);
        B3.setBorderPainted(false);
        B4.setBorderPainted(false);
        B5.setBorderPainted(false);
        B6.setBorderPainted(false);
        B1.setContentAreaFilled(false);
        B2.setContentAreaFilled(false);
        B3.setContentAreaFilled(false);
        B4.setContentAreaFilled(false);
        B5.setContentAreaFilled(false);
        B6.setContentAreaFilled(false);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,3));
        buttonPanel.setOpaque(false);

        buttonPanel.add(B1);
        buttonPanel.add(B2);
        buttonPanel.add(B3);
        buttonPanel.add(B4);
        buttonPanel.add(B5);
        buttonPanel.add(B6);

        this.add(Box.createRigidArea(new Dimension(50,0)));
        this.add(L);
        this.add(Box.createHorizontalGlue());
        this.add(buttonPanel);
        this.add(Box.createHorizontalGlue());
        this.add(R);
        this.add(Box.createRigidArea(new Dimension(50,0)));

    }

    /**
     * met a jour l'affichage des cartes
     * @param builders les builders a afficher
     */
    public void update(ArrayList<IBuilder> builders){
        int[] list = new int[6];
        for (int i = 0; i < 6; i++) {
            if(builders != null && builders.size() > i && builders.get(i) != null){
                list[i] = builders.get(i).getId();
            } else {
                list[i] = 0;
            }
        }
        B1.setIcon(new ImageIcon(new ImageIcon("data/cards/builder/" + list[0] + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
        B2.setIcon(new ImageIcon(new ImageIcon("data/cards/builder/" + list[1] + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
        B3.setIcon(new ImageIcon(new ImageIcon("data/cards/builder/" + list[2] + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
        B4.setIcon(new ImageIcon(new ImageIcon("data/cards/builder/" + list[3] + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
        B5.setIcon(new ImageIcon(new ImageIcon("data/cards/builder/" + list[4] + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
        B6.setIcon(new ImageIcon(new ImageIcon("data/cards/builder/" + list[5] + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));

        B1.setActionCommand(list[0] + "");
        B2.setActionCommand(list[1] + "");
        B3.setActionCommand(list[2] + "");
        B4.setActionCommand(list[3] + "");
        B5.setActionCommand(list[4] + "");
        B6.setActionCommand(list[5] + "");
    }
}