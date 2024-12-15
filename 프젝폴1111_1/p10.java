package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//1, 한 라인을 입력받아 ArrayList에 저장
//2, 중복된 것을 없애거나 애초에 저장하지 않는다
//3, 그리고 모두 출력한다

public class test10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("문자열들을 입력하세요>>");
			String str = sc.nextLine();
			
			if(str.equals("그만"))
				break;
			
			// 문자열 자르기
			String[] words = str.split(" ");
			
			//ArrayList에 넣기
			ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
			
			//중복제거작업
			for (int i = 0; i < wordList.size(); i++) {
				for (int j = i+1; j < wordList.size(); j++) {
					if(wordList.get(i).equals(wordList.get(j))) {
						wordList.remove(j);
						j--;
					}
				}
			}
			
			//모두 출력
			for(String w : wordList)
				System.out.print(w + " ");
			System.out.println();
		}
		sc.close();
	}
}
