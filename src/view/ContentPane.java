package view;

import javax.swing.*;
import java.awt.*;
public class ContentPane extends JPanel {

    private Image backgroundImage;
  
    // Some code to initialize the background image.
    // Here, we use the constructor to load the image. This
    // can vary depending on the use case of the panel.
    public ContentPane(String fileName) {
      backgroundImage = new ImageIcon(fileName).getImage();
    }
  
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
  
      // Draw the background image.
      g.drawImage(backgroundImage, 0, 0, this);
    }
  }