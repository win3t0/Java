package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpenChallenge extends JFrame {
    public OpenChallenge() {
        super("홀짝 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 230);
        setContentPane(new MyPanel());
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private int answer;
        private JLabel label = new JLabel("?");
        private JLabel msg = new JLabel("무엇일까요?");
        private JButton[] btns = { new JButton("홀"), new JButton("짝"), new JButton("확인"), new JButton("다시") };

        public MyPanel() {
            setLayout(null);
            label.setFont(new Font("고딕", Font.PLAIN, 30));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setForeground(Color.YELLOW);
            label.setBackground(Color.MAGENTA);
            label.setOpaque(true);
            label.setSize(80, 80);
            label.setLocation(100, 20);
            add(label);
            refresh();

            msg.setSize(130, 50);
            msg.setLocation(70, 100);
            msg.setHorizontalAlignment(JLabel.CENTER);
            add(msg);

            MyAction myAction = new MyAction();

            for (int i = 0; i < btns.length; i++) {
                JButton b = btns[i];
                b.addActionListener(myAction);
                b.setSize(60, 30);
                b.setLocation(10 + i * 65, 150);
                add(b);
            }
        }

        private void refresh() {
            answer = (int) (Math.random() * 10) + 1;
            label.setText("?");
            msg.setText("무엇일까요?");
        }

        class MyAction implements ActionListener {
            private String user;

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                switch (b.getText()) {
                    case "홀":
                        user = "홀";
                        break;
                    case "짝":
                        user = "짝";
                        break;
                    case "확인":
                        check();
                        user = "";
                        break;
                    case "다시":
                        user = "";
                        refresh();
                        break;
                }
            }

            private void check() {
                if (user == null || user.length() == 0) {
                    msg.setText("홀이나 짝 먼저 선택!");
                    return;
                }

                label.setText(Integer.toString(answer));
                String res;
                if (answer % 2 == 1)
                    res = "홀";
                else
                    res = "짝";

                if (user.equals(res))
                    res += "! 맞았어요.";
                else
                    res += "! 아쉽군요";
                msg.setText(res);
            }
        }
    }

    public static void main(String[] args) {
        new OpenChallenge();
    }
}
