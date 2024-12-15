package project;

import java.util.*;
import java.io.*;

public class openChallenge {
	private final int HIDDENCHAR = 2;
	private StringBuffer hiddenWord;
	private String newWord;
	private Scanner scanner;
	private int failCount;
	
	public openChallenge() { 
		scanner = new Scanner(System.in);
	}

	public void run() {
		System.out.println("지금부터 행맨 개임을 시작합니다.");
		Words words = new Words("words.txt");		
		while(true) {
			newWord = words.getRandomWord();
			if(newWord == null) break;
			makeHidden();
			go();
			System.out.print("Next(y/n)?");
			String answer = scanner.next();
			if(answer.equals("n")) 
				break;
		}
	}
	

	private void makeHidden() {
		hiddenWord = new StringBuffer(newWord);
		Random r = new Random();
		
		for(int k=0; k<HIDDENCHAR; k++) {
			int index = r.nextInt(newWord.length());
			char c = newWord.charAt(index);
			for(int i=0; i<newWord.length(); i++) {
				if(hiddenWord.charAt(i) == c)
					hiddenWord.setCharAt(i,'-');
			}
		}
	}
	


	private void go() {
		failCount=0;
		char key;
		do {
			if(failCount == 5) {
				System.out.println("5번 실패 하였습니다.");
				break;
			}
			System.out.println(hiddenWord);
			System.out.print(">>");
			String text = scanner.next();
			key =  text.charAt(0);
		}while(!complete(key));
		System.out.println(newWord);
	}
	
	private boolean complete(char key) {
		boolean hit = false;
		for(int i=0; i<newWord.length(); i++) {
			if(hiddenWord.charAt(i) == '-' && newWord.charAt(i) == key) {
				hiddenWord.setCharAt(i, key);
				hit = true;
			}
		}
		if(!hit)
			failCount++;
		for(int i=0; i<newWord.length(); i++) {
			if(hiddenWord.charAt(i) == '-')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		openChallenge app = new openChallenge();
		app.run();
	}

}

class Words {
	Vector<String> wordVector = new Vector<String>();

	public Words(String fileName) {
		try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			while(scanner.hasNext()) {
				String word = scanner.nextLine();
				wordVector.add(word);
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found error");
			System.exit(0);
		}
	}
	
	public String getRandomWord() {
		final int WORDMAX = wordVector.size();
		int index = (int)(Math.random()*WORDMAX);
		return wordVector.get(index);
	}	
}

