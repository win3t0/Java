package chapter11_homework;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test10 extends JFrame {
    private List<String> sentences;
    private String currentSentence;
    private StringBuilder playerInput;
    private JLabel feedbackLabel;

    public test10() {
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
            feedbackLabel = new JLabel(">>"); // 사용자 입력과 성공 메시지를 표시할 라벨
            feedbackLabel.setForeground(Color.BLACK);
            feedbackLabel.setPreferredSize(new Dimension(500, 30)); // 라벨 크기 설정
            feedbackLabel.setHorizontalAlignment(SwingConstants.LEFT); // 텍스트 정렬
            feedbackLabel.setVerticalAlignment(SwingConstants.CENTER); // 수직 정렬
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
                label.setForeground(Color.BLACK); // 기본 텍스트 색상 설정
                label.setSize(150, 30); // 텍스트 크기와 크기 맞춤
                label.setLocation(rand.nextInt(Math.max(this.getWidth() - 150, 1)) + 10, 
                                  rand.nextInt(Math.max(this.getHeight() - 30, 1)) + 10);
                label.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 중앙 정렬
                label.addMouseListener(new WordClickListener(word, label));
                label.setVerticalAlignment(SwingConstants.CENTER); // 수직 정렬
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
            if (label.getForeground().equals(Color.GRAY)) return; // 이미 클릭된 경우 무시

            playerInput.append(word).append(" ");
            feedbackLabel.setText(">> " + playerInput.toString().trim()); // 공백 제거 후 표시
            label.setForeground(Color.GRAY); // 클릭된 단어는 회색으로 변경

            if (playerInput.toString().trim().equals(currentSentence)) {
                feedbackLabel.setText(">> " + playerInput.toString().trim() + " (성공!)"); // 성공 메시지 추가
            }
        }
    }

    private void newText() {
        Random rand = new Random();
        currentSentence = sentences.get(rand.nextInt(sentences.size()));
        playerInput.setLength(0);
        feedbackLabel.setText(">>"); // 초기화
        ((CenterPanel) getContentPane().getComponent(1)).placeWords(currentSentence);
    }

    public static void main(String[] args) {
        new test10();
    }
}
