package chapter6;

import java.util.Scanner;

public class test6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
		String str = sc.nextLine();
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < str.length(); j++) {
				System.out.print(str.charAt((i+j)%str.length()));
			}
			System.out.println();
		}
		
		sc.close();
	}
}
