package project;

import java.util.Scanner;

class SortedArray extends BaseArray{
	public SortedArray(int size) {
		super(size);
	}
	public void add(int n) {
		if(nextIndex == array.length)
			return;

        int i;

        for (i = nextIndex - 1; i >= 0 && array[i] > n; i--) {
            array[i + 1] = array[i];
        }
        array[i + 1] = n;
        nextIndex++;
	}
}

public class p10 {
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
