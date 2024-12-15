package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class p10 extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private List<JLabel> blocks = new ArrayList<>();
    private JLabel selectedBlock = null;
    private Point mouseOffset;

    public p10() {
        setTitle("블록 드래그 앱");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
            createBlock();
        }
    }

    private void createBlock() {
        JLabel block = new JLabel();
        block.setOpaque(true);
        block.setBackground(getRandomColor());
        block.setSize(80, 80);
        block.setLocation(100, 100);
        add(block);
        blocks.add(block);
        repaint();
    }

    private Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (JLabel block : blocks) {
            if (block.getBounds().contains(e.getPoint())) {
                selectedBlock = block;
                mouseOffset = new Point(e.getX() - block.getX(), e.getY() - block.getY());
                setComponentZOrder(block, 0);
                repaint();
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedBlock != null) {
            int newX = e.getX() - mouseOffset.x;
            int newY = e.getY() - mouseOffset.y;
            newX = Math.max(0, Math.min(newX, getWidth() - selectedBlock.getWidth()));
            newY = Math.max(0, Math.min(newY, getHeight() - selectedBlock.getHeight()));
            selectedBlock.setLocation(newX, newY);
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedBlock = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new p10());
    }
}
