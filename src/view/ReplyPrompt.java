package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Listener;

public class ReplyPrompt extends JPanel {
    private JLabel label;
    private JSlider slider;
    private JButton confirm;
    private Listener al;
    public ReplyPrompt(Listener al){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.al = al;
        this.label = new JLabel();
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.slider = new JSlider(0,3,0);
        this.slider.setMajorTickSpacing(1);
        this.slider.setPaintLabels(true);
        this.slider.setPaintTicks(true);
        this.confirm = new JButton("confirmation");
        this.confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               al.makeAction(slider.getValue()+"");
            }
        });
        this.confirm.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0,200)));
        panel2.add(Box.createRigidArea(new Dimension(0,50)));
        panel2.add(this.label);
        panel2.add(Box.createRigidArea(new Dimension(0,50)));
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));

        panel3.add(Box.createRigidArea(new Dimension(50,0)));
        panel3.add(this.slider);
        panel3.add(Box.createRigidArea(new Dimension(50,0)));

        panel2.add(panel3);
        panel2.add(Box.createRigidArea(new Dimension(0,50)));
        panel2.add(this.confirm);
        panel2.add(Box.createRigidArea(new Dimension(0,50)));
        panel.add(panel2);
        panel.add(Box.createRigidArea(new Dimension(0,200)));
        panel.setOpaque(false);
        panel2.setOpaque(true);

        this.add(Box.createRigidArea(new Dimension(300,0)));
        this.add(panel);
        this.add(Box.createRigidArea(new Dimension(300,0)));
    }
    public void update(ArrayList<String> text,int max){
        this.slider.setValue(0);
        this.slider.setMaximum(max);
        this.label.setText(String.join("\n", text));
    }
}
