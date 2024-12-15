package chapter7;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정수형 벡터 생성
		Vector<Integer> v = new Vector<Integer>();
		
		// 입력한 정수 값을 벡터에 입력
		System.out.print("정수 입력(-1이면 입력 끝)>>");
		while (true) {
			int num = sc.nextInt();
			// 입력받은 값이 -1일 경우 입력 종류
			if(num == -1)
				break;
			v.add(num);
		}
		
		// 벡터의 첫 번째 값을 최솟값이라고 하고 2번째 값부터 비교하기
		int min = v.get(0);
		for (int i = 1; i < v.size(); i++) {
			// 현재 최솟값보다 작은 값이 있는 경우 최솟값 수정하기
			if(v.get(i) < min)
				min = v.get(i);
		}
		// 최솟값 출력
		System.out.println("제일 작은 수는 " + min);
		
		sc.close();
	}
}
