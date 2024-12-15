package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class p5 extends JFrame {
    public p5() {
        super("클릭 연습 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("C");
        c.add(label);

        label.setLocation(100,60);
        label.setSize(20, 20);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JLabel la = (JLabel)e.getSource();
                Container c = la.getParent();

                int xBound = c.getWidth() - la.getWidth();
                int yBound = c.getHeight() - la.getHeight();                
                int x = (int)(Math.random()*xBound);
                int y = (int)(Math.random()*yBound);                
                la.setLocation(x, y);
            }
        });

        setSize(300,200);
        setVisible(true);
    }
    static public void main(String [] args) {
        new p5();
    }
}
