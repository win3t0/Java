package project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class p10 extends JFrame {
    private List<String> sentences;
    private String currentSentence;
    private StringBuilder playerInput;
    private JLabel feedbackLabel;

    public p10() {
        super("단어 조합 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sentences = new ArrayList<>();
        sentences.add("I can't help falling in love with you");
        sentences.add("Love is all you need");
        sentences.add("To be or not to be");
        sentences.add("May the force be with you");
        sentences.add("I'm walking on sunshine");

        playerInput = new StringBuilder();

        Container c = getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);

        setSize(600, 400);
        setVisible(true);
    }

    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY);
            setLayout(new FlowLayout());
            add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~ "));

            JButton newTextButton = new JButton("New Text");
            newTextButton.addActionListener(e -> newText());
            add(newTextButton);
        }
    }

    class SouthPanel extends JPanel {
        public SouthPanel() {
            setBackground(Color.YELLOW);
            setLayout(new FlowLayout());
            feedbackLabel = new JLabel(">>");
            feedbackLabel.setForeground(Color.BLACK);
            feedbackLabel.setPreferredSize(new Dimension(500, 30));
            feedbackLabel.setHorizontalAlignment(SwingConstants.LEFT);
            feedbackLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(feedbackLabel);
        }
    }

    class CenterPanel extends JPanel {
        public CenterPanel() {
            setLayout(null);
            setBackground(Color.WHITE);
        }

        public void placeWords(String sentence) {
            this.removeAll();
            String[] words = sentence.split(" ");
            Random rand = new Random();
            for (String word : words) {
                JLabel label = new JLabel(word);
                label.setForeground(Color.BLACK);
                label.setSize(150, 30);
                label.setLocation(rand.nextInt(Math.max(this.getWidth() - 150, 1)) + 10, 
                                  rand.nextInt(Math.max(this.getHeight() - 30, 1)) + 10);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.addMouseListener(new WordClickListener(word, label));
                label.setVerticalAlignment(SwingConstants.CENTER);
                this.add(label);
            }
            this.revalidate();
            this.repaint();
        }
    }

    class WordClickListener extends MouseAdapter {
        private String word;
        private JLabel label;

        public WordClickListener(String word, JLabel label) {
            this.word = word;
            this.label = label;
        }

        public void mouseClicked(MouseEvent e) {
            if (label.getForeground().equals(Color.GRAY)) return;

            playerInput.append(word).append(" ");
            feedbackLabel.setText(">> " + playerInput.toString().trim());
            label.setForeground(Color.GRAY);

            if (playerInput.toString().trim().equals(currentSentence)) {
                feedbackLabel.setText(">> " + playerInput.toString().trim() + " (성공!)");
            }
        }
    }

    private void newText() {
        Random rand = new Random();
        currentSentence = sentences.get(rand.nextInt(sentences.size()));
        playerInput.setLength(0);
        feedbackLabel.setText(">>");
        ((CenterPanel) getContentPane().getComponent(1)).placeWords(currentSentence);
    }

    public static void main(String[] args) {
        new p10();
    }
}
