package hello;

public class p3_1 {
	public static void main(String[] args)	{
		int sum=0, i=1;
		while (true) {
		 if(i>50)
		  break;
		 sum = sum + i;
		 i += 3;
		}
		System.out.println(sum);
	}
	// 1부터 50까지의 숫자 중 3씩 증가하는 숫자의 합을 계산합니다. p166 (1) 답변. 출력 시 425 가 출력됨.
}