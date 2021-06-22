package view;

import model.IBuild;
import model.IBuilder;
import controller.Listener;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * permet l'affichage detaillé des build, pour observer leur completion
 */
public class DisplayBuildWorkPannel extends JPanel {
    /**
     * le boutton contenant l'image du build
     */
    private JButton buildImage;
    /**
     * crées le DisplayBuildWorkPannel
     * @param al le listener qui reagis au actions
     */
    public DisplayBuildWorkPannel(Listener al){
        this.setOpaque(false);
        this.buildImage = new JButton();
        this.buildImage.setBorderPainted(false);
        this.buildImage.setContentAreaFilled(false);
        this.buildImage.setIcon(new ImageIcon(new ImageIcon("data/cards/build/0.png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
        this.buildImage.addActionListener(al);
        this.buildImage.setActionCommand("0");
        this.buildImage.setPreferredSize( new Dimension(this.buildImage.getIcon().getIconWidth(), this.buildImage.getIcon().getIconWidth()));
        this.buildImage.setMaximumSize( new Dimension(this.buildImage.getIcon().getIconWidth(), this.buildImage.getIcon().getIconWidth()));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(buildImage);
    }
    /**
     * met a jour la carte
     * @param build la carte a afficher
     */
    public void updateBuilder(IBuild build){
        if(build != null){
            this.removeAll();
            this.buildImage.setIcon(new ImageIcon(new ImageIcon("data/cards/build/" + build.getId() + ".png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
            this.buildImage.setActionCommand(build.getId()+"");
            this.buildImage.setPreferredSize( new Dimension(this.buildImage.getIcon().getIconWidth(), this.buildImage.getIcon().getIconWidth()));
            this.buildImage.setMaximumSize( new Dimension(this.buildImage.getIcon().getIconWidth(), this.buildImage.getIcon().getIconWidth()));
            this.add(buildImage);
            for(IBuilder b : build.getBuilders()){
                try{
                    BufferedImage image = ImageIO.read(new File("data/cards/builder/" + b.getId() + ".png"));
                    image = image.getSubimage(0, 0, (image.getWidth()/3), image.getHeight());
                    JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
                    this.add(label);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            } else {
            this.removeAll();
            this.buildImage.setIcon(new ImageIcon(new ImageIcon("data/cards/build/0.png").getImage().getScaledInstance(-1, 300, java.awt.Image.SCALE_SMOOTH)));
            this.buildImage.setActionCommand("0");
            this.buildImage.setPreferredSize( new Dimension(this.buildImage.getIcon().getIconWidth(), this.buildImage.getIcon().getIconWidth()));
            this.buildImage.setMaximumSize( new Dimension(this.buildImage.getIcon().getIconWidth(), this.buildImage.getIcon().getIconWidth()));
            this.add(this.buildImage);
        }

    }
}  

