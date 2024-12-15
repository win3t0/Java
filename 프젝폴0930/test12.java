package week5_homework;

import java.util.Scanner;

class Dictionary{
	private static String[] kor ={"사랑", "아기", "돈", "미래", "희망"};
	private static String[] eng ={"love", "baby", "money", "future", "hope"};
	
	public static String kor2Eng(String word) {
		for (int i = 0; i < eng.length; i++) {
			if(word.equals(kor[i]))
				return eng[i];
		}
		word = "없음";
		return word;
	}
}

public class test12 {
	public static void main(String[] args) {
//		Dictionary dic = new Dictionary();
		Scanner sc = new Scanner(System.in);
		System.out.println("한영 단어 검색 프로그램입니다");
		
		while(true) {
			System.out.print("한글 단어?");
			String word = sc.next();
			
			if(word.equals("그만"))
				break;
			
			String answer = Dictionary.kor2Eng(word);
			
			if(answer.equals("없음"))
				System.out.println(word+"는 저의 사전에 없습니다.");
			else
				System.out.println(word+"은(는) "+answer);
		}	
	}
}
