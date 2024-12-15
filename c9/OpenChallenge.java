package project;

import java.awt.*;
import javax.swing.*;

public class OpenChallenge extends JFrame {
	private String text ="I can't help falling in love with you";
	
	public OpenChallenge() {
		super("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);

		setSize(400,300);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~ "));
			add(new JButton("New Text"));
		}
	}
	
	class SouthPanel extends JPanel {
		public SouthPanel() {
			setBackground(Color.YELLOW);
			setLayout(new FlowLayout());
			add(new JLabel("이름"));		
			add(new JTextField(10));
		}
	}
	
	class CenterPanel extends JPanel {
		public CenterPanel() {
			setLayout(null);
			setBackground(Color.WHITE);
			place(this, text);
		}
		private void place(Container c, String text) { 
			String [] words = text.split(" "); 
			for(int i=0; i<words.length; i++) {
				JLabel label = new JLabel(words[i]);
				int x = (int)(Math.random()*350);
				int y = (int)(Math.random()*180);
				label.setLocation(x,y);
				label.setSize(50, 20);
				c.add(label);
			}			
		}

	}

	public static void main(String[] args) {
		new OpenChallenge();
	}

}
