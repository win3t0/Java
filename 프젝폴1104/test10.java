package chapter6;

import java.util.Random;
import java.util.Scanner;

public class test10 {
	public static void main(String[] args) {
		String[] arr = new String[] {"happy", "morning", "package", "together"};
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("10초 안에 단어를 맞추세요!!");
		while(true) {
			String question = arr[(int)(Math.random()*arr.length)];
			
			 // 문자열을 char 배열로 변환
	        char[] charArray = question.toCharArray();

	        // 무작위로 두 인덱스를 선택
	        int index1 = random.nextInt(question.length());
	        int index2;
	        do {
	            index2 = random.nextInt(question.length());
	        } while (index1 == index2);  // 두 인덱스가 같으면 다시 선택

	        // 두 문자 위치 교환
	        char temp = charArray[index1];
	        charArray[index1] = charArray[index2];
	        charArray[index2] = temp;

	        // char 배열을 다시 문자열로 변환
	        String showQuestion =  new String(charArray);
	        
			System.out.println(showQuestion);
			System.out.print(">>");
			
			// 시간 세기
			long startTime = System.currentTimeMillis();
			
			String answer = sc.next();
			
			long endTime = System.currentTimeMillis();
		    long elapsedTime = endTime - startTime; // 실행 시간 계산
		    
			if(answer.equals("그만"))
				break;
			if(answer.equals(question) && elapsedTime < 10000) {
				System.out.println("성공!! " + (float)elapsedTime/1000 + "초가 경과 되었습니다");
			} else if(!(answer.equals(question)))
				System.out.println("실패!! " + question + "입니다. "+ (float)elapsedTime/1000 + "초 경과");
			else if(elapsedTime < 10000)
				System.out.println("실패!! 10초 초과. "+ elapsedTime/1000 + "초 경과");
		}
		sc.close();
	}
}
