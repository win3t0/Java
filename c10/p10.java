package chapter10_homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test10 extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private List<JLabel> blocks = new ArrayList<>(); // 블록을 저장할 리스트
    private JLabel selectedBlock = null; // 선택된 블록
    private Point mouseOffset; // 마우스 오프셋

    public test10() {
        setTitle("블록 드래그 앱"); // 프레임 제목 설정
        setSize(800, 600); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
        setLayout(null); // 절대 위치 설정을 위해 레이아웃을 null로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정

        addKeyListener(this); // 키 리스너 추가
        addMouseListener(this); // 마우스 리스너 추가
        addMouseMotionListener(this); // 마우스 모션 리스너 추가
    }

    // 키가 눌렸을 때 호출되는 메소드
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') { // 'm' 또는 'M' 키 확인
            createBlock(); // 블록 생성 메소드 호출
        }
    }

    // 새로운 블록을 생성하는 메소드
    private void createBlock() {
        JLabel block = new JLabel(); // 새로운 JLabel 생성
        block.setOpaque(true); // 배경색이 보이도록 설정
        block.setBackground(getRandomColor()); // 랜덤 배경색 설정
        block.setSize(80, 80); // 블록 크기 설정
        block.setLocation(100, 100); // 초기 위치 설정
        add(block); // 프레임에 블록 추가
        blocks.add(block); // 리스트에 블록 추가
        repaint(); // 화면 갱신
    }

    // 랜덤 색상을 생성하는 메소드
    private Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // RGB 랜덤 생성
    }

    // 마우스 버튼이 눌렸을 때 호출되는 메소드
    @Override
    public void mousePressed(MouseEvent e) {
        for (JLabel block : blocks) { // 모든 블록을 순회
            if (block.getBounds().contains(e.getPoint())) { // 마우스가 블록 안에 있는지 확인
                selectedBlock = block; // 선택된 블록으로 설정
                mouseOffset = new Point(e.getX() - block.getX(), e.getY() - block.getY()); // 오프셋 계산
                // 선택된 블록을 최상위로 이동
                setComponentZOrder(block, 0);
                repaint();
                break;
            }
        }
    }

    // 마우스를 드래그할 때 호출되는 메소드
    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedBlock != null) { // 블록이 선택된 경우
            int newX = e.getX() - mouseOffset.x; // 새로운 X 좌표 계산
            int newY = e.getY() - mouseOffset.y; // 새로운 Y 좌표 계산
            // 화면 경계를 벗어나지 않도록 좌표 제한
            newX = Math.max(0, Math.min(newX, getWidth() - selectedBlock.getWidth()));
            newY = Math.max(0, Math.min(newY, getHeight() - selectedBlock.getHeight()));
            selectedBlock.setLocation(newX, newY); // 블록 위치 변경
            repaint(); // 화면 갱신
        }
    }

    // 마우스 버튼이 놓였을 때 호출되는 메소드
    @Override
    public void mouseReleased(MouseEvent e) {
        selectedBlock = null; // 선택된 블록 해제
    }

    // 사용하지 않는 마우스 이벤트 메소드들
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    // 사용하지 않는 키 이벤트 메소드들
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        // 이벤트 디스패치 스레드에서 GUI 생성
        SwingUtilities.invokeLater(() -> new test10());
    }
}
