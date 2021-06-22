package view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import controller.MenuListener;

/**
 * l'interface du menu
 */
public class MenuInterface extends JPanel{
    /**
     * l'actionlistener responsable de recevoir les actions sur le menu
     */
    MenuListener ml;
    /**
     * un boutton
     */
    JButton nouvelle;
    /**
     * un boutton
     */
    JButton charger;
    /**
     * un boutton
     */
    JButton regles;
    /**
     * un boutton
     */
    JButton back;
    /**
     * un boutton
     */
    JButton S1;
    /**
     * un boutton
     */
    JButton S2;
    /**
     * un boutton
     */
    JButton S3;
    /**
     * un boutton
     */
    JButton S4;
    /**
     * un boutton
     */
    JButton S5;
    /**
     * un boutton
     */
    JButton S6;
    /**
     * le texte des regles
     */
    JLabel textRegle;
    /**
     * une element de la grille
     */
    JPanel grid1;
    /**
     * une element de la grille
     */
    JPanel grid2;
    /**
     * une element de la grille
     */
    JPanel grid3;
    /**
     * une element de la grille
     */
    JPanel grid4;
    /**
     * une element de la grille
     */
    JPanel grid5;
    /**
     * une element de la grille
     */
    JPanel grid6;
    /**
     * une element de la grille
     */
    JPanel grid7;
    /**
     * le pannel du centre
     */
    JPanel centerPanel;
    /**
     * le constructeur du MenuInterface
     * @param ml le listener
     */
    public MenuInterface(MenuListener ml){
        this.ml = ml;
        nouvelle = new JButton("Nouvelle partie");
        charger = new JButton("Charger une Partie");
        regles = new JButton("Règles");
        back = new JButton("<- retour au menu");
        S1 = new JButton("Sauvegarde 1");
        S2 = new JButton("Sauvegarde 2");
        S3 = new JButton("Sauvegarde 3");
        S4 = new JButton("Sauvegarde 4");
        S5 = new JButton("Sauvegarde 5");
        S6 = new JButton("Sauvegarde 6");
        textRegle = new JLabel("");
        textRegle.setHorizontalAlignment(0);
        nouvelle.addActionListener(ml);
        charger.addActionListener(ml);
        regles.addActionListener(ml);
        back.addActionListener(ml);
        S1.addActionListener(ml);
        S2.addActionListener(ml);
        S3.addActionListener(ml);
        S4.addActionListener(ml);
        S5.addActionListener(ml);
        S6.addActionListener(ml);
        nouvelle.setActionCommand("nouvelle");
        charger.setActionCommand("charger");
        regles.setActionCommand("regles");
        back.setActionCommand("back");
        S1.setActionCommand("1");
        S2.setActionCommand("2");
        S3.setActionCommand("3");
        S4.setActionCommand("4");
        S5.setActionCommand("5");
        S6.setActionCommand("6");
        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(new ImageIcon("data/images/logo.png").getImage().getScaledInstance(800, -1, java.awt.Image.SCALE_SMOOTH)));
        img.setAlignmentX(CENTER_ALIGNMENT);
        grid1 = new JPanel();
        grid1.setLayout(new GridLayout(1,2));
        grid1.add(back);
        grid1.add(new JLabel(""));
        grid2 = new JPanel();
        grid2.setLayout(new GridLayout(1,2));
        grid2.add(S1);
        grid2.add(S2);
        grid3 = new JPanel();
        grid3.setLayout(new GridLayout(1,2));
        grid3.add(S3);
        grid3.add(S4);
        grid4 = new JPanel();
        grid4.setLayout(new GridLayout(1,2));
        grid4.add(S5);
        grid4.add(S6);
        grid5 = new JPanel();
        grid5.setLayout(new GridLayout(1,1));
        grid5.add(nouvelle);
        grid6 = new JPanel();
        grid6.setLayout(new GridLayout(1,1));
        grid6.add(charger);
        grid7 = new JPanel();
        grid7.setLayout(new GridLayout(1,1));
        grid7.add(regles);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(img);
        centerPanel.add(grid1);
        centerPanel.add(textRegle);
        centerPanel.add(grid2);
        centerPanel.add(grid3);
        centerPanel.add(grid4);
        centerPanel.add(grid5);
        centerPanel.add(grid6);
        centerPanel.add(grid7);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createRigidArea(new Dimension(400,0)));
        this.add(centerPanel);
        this.add(Box.createRigidArea(new Dimension(400,0)));
        this.setOpaque(false);
        centerPanel.setOpaque(false);
        grid1.setOpaque(false);
        grid2.setOpaque(false);
        grid3.setOpaque(false);
        grid4.setOpaque(false);
    }

    /**
     * affiche le menu
     */
    public void menu(){
        grid1.setVisible(false);
        textRegle.setVisible(false);
        grid2.setVisible(false);
        grid3.setVisible(false);
        grid4.setVisible(false);
        grid5.setVisible(true);
        grid6.setVisible(true);
        grid7.setVisible(true);
        textRegle.setOpaque(false);
    }

    /**
     * affiche la selec des sauvegardes
     */
    public void selectionSauvegarde(){
        grid1.setVisible(true);
        textRegle.setVisible(false);
        grid2.setVisible(true);
        grid3.setVisible(true);
        grid4.setVisible(true);
        grid5.setVisible(false);
        grid6.setVisible(false);
        grid7.setVisible(false);
    }

    /**
     * l'affichage des regles
     */
    public void regles(){
        grid1.setVisible(true);
        textRegle.setVisible(true);
        grid2.setVisible(false);
        grid3.setVisible(false);
        grid4.setVisible(false);
        grid5.setVisible(false);
        grid6.setVisible(false);
        grid7.setVisible(false);
        textRegle.setOpaque(true);
    }
}
