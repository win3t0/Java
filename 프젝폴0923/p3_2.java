package hello;

public class p3_2 {
	public static void main(String[] args) {
		int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
		for(int i=0; i<n.length; i++) {
			if(n[i] > 0 && n[i] % 4 == 0) {
					System.out.print(n[i] + " ");
					}
			}
	}		// 배열 n의 양수 이면서 4로 나누어 떨어지는 값들을 구하는 코드입니다. p166 2_1에 대한 답변.
}