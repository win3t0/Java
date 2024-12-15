package week7_homework;

import java.util.Scanner;

// BaseArray는 test9에서 확인
class SortedArray extends BaseArray{
	public SortedArray(int size) {
		super(size);
	}
	public void add(int n) {
		if(nextIndex == array.length)
			return;

        int i;
        // i가 0이면 반복문에서 i의 초기값이 -1이 됨으로 바로 내려감 밑에서 array[i + 1]해서 값을 넣음
        // i가 그보다 크면 n이 자기보다 작은 값을 찾을 때까짐 반복
        for (i = nextIndex - 1; i >= 0 && array[i] > n; i--) {
            array[i + 1] = array[i];
        }
        array[i + 1] = n;
        nextIndex++;
	}
}

public class test10 {
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner sc = new Scanner(System.in);
		System.out.print(">>");
		for (int i = 0; i < sArray.length(); i++) {
			int n = sc.nextInt();
			sArray.add(n);
		}
		sArray.print();
		sc.close();
	}
}
