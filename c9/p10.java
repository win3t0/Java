package chapter9;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class test10 extends JFrame {
    // 생성자
    public test10() {
        // 프레임 설정
        setTitle("Color Button Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // West 패널 생성 및 설정
        JPanel westPanel = new JPanel(new GridLayout(10, 1, 0, 0)); // 10행 1열, 간격 없음
        Color[] colors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.DARK_GRAY, Color.LIGHT_GRAY
        };

        // 버튼 생성 및 West 패널에 추가
        for (Color color : colors) {
            JButton button = new JButton();
            button.setBackground(color);
            westPanel.add(button);
        }

        add(westPanel, BorderLayout.WEST);

        // Center 패널 생성 및 설정
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null); // 절대 위치 설정
        Random random = new Random();

        // 랜덤 숫자 라벨 생성 및 Center 패널에 추가
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(random.nextInt(10)));
            label.setForeground(Color.RED);
            // 랜덤 위치 설정 (50~200)
            int x = 50 + random.nextInt(151);
            int y = 50 + random.nextInt(151);
            label.setBounds(x, y, 20, 20); // 라벨 크기 설정
            centerPanel.add(label);
        }

        add(centerPanel, BorderLayout.CENTER);

        // 프레임 위치 및 가시성 설정
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 메인 메서드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test10());
    }
}
