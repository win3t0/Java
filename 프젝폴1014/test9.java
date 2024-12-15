package week7_homework;

import java.util.Scanner;

class BaseArray{
	protected int array[];
	protected int nextIndex = 0;
	
	public BaseArray(int size) {
		array = new int [size];
	}
	
	public int length() {
		return array.length;
	}
	
	public void add(int n) {
		if(nextIndex == array.length)
			return;
		array[nextIndex] = n;
		nextIndex++;
	}
	public void print() {
		for(int n : array) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}

class BinaryArray extends BaseArray{
	int threshold;
	
	public BinaryArray(int size, int threshold){
		super(size);
		this.threshold = threshold;
	}
	
	public void add(int n) {
		if(nextIndex == array.length)
			return;
		if(threshold<n)
			n = 1;
		else
			n = 0;
		array[nextIndex] = n;
		nextIndex++;
	}
}

public class test9 {
	public static void main(String[] args) {
		int threshold = 50;
		BinaryArray bArray = new BinaryArray(10, threshold);
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">>");
		for (int i = 0; i < bArray.length(); i++) {
			int n = sc.nextInt();
			bArray.add(n);
		}
		
		bArray.print();
		sc.close();
	}
}
