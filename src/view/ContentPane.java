package view;

import javax.swing.*;
import java.awt.*;
/**
 * le ContentPane qui permet de mettre une image en arrière plan
 */
public class ContentPane extends JPanel {

  /**
   * l'image de fond
   */
    private Image backgroundImage;
  
   /**
    * le constructeur de contentpane
    * @param fileName le nom de fichier de l'image
    */
    public ContentPane(String fileName) {
      backgroundImage = new ImageIcon(fileName).getImage();
    }
  
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
  
      // on dessine l'image
      g.drawImage(backgroundImage, 0, 0, this);
    }
  }