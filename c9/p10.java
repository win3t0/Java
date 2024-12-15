package project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class p10 extends JFrame {
    public p10() {
        setTitle("Color Button Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel westPanel = new JPanel(new GridLayout(10, 1, 0, 0));
        Color[] colors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.DARK_GRAY, Color.LIGHT_GRAY
        };

        for (Color color : colors) {
            JButton button = new JButton();
            button.setBackground(color);
            westPanel.add(button);
        }

        add(westPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(random.nextInt(10)));
            label.setForeground(Color.RED);
            int x = 50 + random.nextInt(151);
            int y = 50 + random.nextInt(151);
            label.setBounds(x, y, 20, 20);
            centerPanel.add(label);
        }

        add(centerPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new p10());
    }
}
