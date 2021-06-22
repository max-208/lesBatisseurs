package view;

import java.util.ArrayList;
import model.*;
import controller.Listener;
import javax.swing.*;
import java.awt.*;

/**
 * affiche les builds
 */
public class DisplayBuildPannel extends JPanel {
    /**
     * les builds a afficher
     */
    private ArrayList<IBuild> builds;
    /**
     * le listener pour les interactions utilisateurs
     */
    private Listener al;
    /**
     * le boutton pour afficher plus de cartes
     */
    private JButton L;
    /**
     * le boutton pour afficher plus de cartes
     */
    private JButton R;
    /**
     * les builds affichés
     */
    private DisplayBuildWorkPannel[] B;

    /**
     * le constructeur de DisplayBuildPannel
     * @param al le listener
     */
    public DisplayBuildPannel(Listener al){
        this.builds = new ArrayList<IBuild>();
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
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        this.B = new DisplayBuildWorkPannel[6];
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.X_AXIS));
        buttonPanel1.setOpaque(false);
        
        this.B[0] = new DisplayBuildWorkPannel(al);
        buttonPanel1.add(this.B[0]);
        buttonPanel1.add(Box.createRigidArea(new Dimension(50,0)));
        this.B[1] = new DisplayBuildWorkPannel(al);
        buttonPanel1.add(this.B[1]);
        buttonPanel1.add(Box.createRigidArea(new Dimension(50,0)));
        this.B[2] = new DisplayBuildWorkPannel(al);
        buttonPanel1.add(this.B[2]);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
        buttonPanel2.setOpaque(false);
        this.B[3] = new DisplayBuildWorkPannel(al);
        buttonPanel2.add(this.B[3]);
        buttonPanel2.add(Box.createRigidArea(new Dimension(50,0)));
        this.B[4] = new DisplayBuildWorkPannel(al);
        buttonPanel2.add(this.B[4]);
        buttonPanel2.add(Box.createRigidArea(new Dimension(50,0)));
        this.B[5] = new DisplayBuildWorkPannel(al);
        buttonPanel2.add(this.B[5]);

        buttonPanel.add(buttonPanel1);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,50)));
        buttonPanel.add(buttonPanel2);
        this.add(Box.createRigidArea(new Dimension(50,0)));
        this.add(L);
        this.add(Box.createHorizontalGlue());
        this.add(buttonPanel);
        this.add(Box.createHorizontalGlue());
        this.add(R);
        this.add(Box.createRigidArea(new Dimension(50,0)));

    }

    /**
     * met a jour les builds a afficher
     * @param builds les builds a afficher
     */
    public void update(ArrayList<IBuild> builds){
        this.builds = builds;
        for (int i = 0; i < 6; i++) {
            if(builds != null && builds.size() > i && builds.get(i) != null){
                this.B[i].updateBuilder(builds.get(i));
            } else {
                this.B[i].updateBuilder(null);
            }
        }
    }
}