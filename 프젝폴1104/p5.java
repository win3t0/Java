package chapter6;

import java.util.Scanner;

public class test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
			String answer = sc.nextLine();
			if(answer == "그만")
				break;
			answer = answer.toLowerCase();
			String[] test = answer.split(" ");
			int sum = 0;
			for (int i = 0; i < test.length; i++) {
//				System.out.println(test[i]);
				if(test[i].equals("a"))
					sum += 90;
				else if(test[i].equals("b"))
					sum += 80;
				else if(test[i].equals("c"))
					sum += 70;
				else if(test[i].equals("d"))
					sum += 60;
				else if(test[i].equals("f"))
					sum += 0;
				else {
					System.out.println("입력 오류:"+test[i]);
					continue;
				}
			}
			System.out.println("평균은 "+(float)sum/test.length);
		}
		sc.close();
	}
}
