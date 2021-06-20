package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PromptPanel extends JPanel{
    private JLabel text;
    public PromptPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.text = new JLabel();
        this.text.setHorizontalAlignment(SwingConstants.CENTER);
        this.text.setText("bienvenue dans les batisseurs");
        this.text.setFont(this.text.getFont().deriveFont(20f));
        JPanel textzone = new JPanel();
        textzone.setLayout(new BoxLayout(textzone, BoxLayout.Y_AXIS));
        textzone.add(Box.createRigidArea(new Dimension(0,20)));
        textzone.add(this.text);
        textzone.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(Box.createHorizontalGlue());
        this.add(textzone);
        this.add(Box.createHorizontalGlue());
    }

    public void update(ArrayList<String> text){
        this.text.setText(String.join("\n", text));
    }
}