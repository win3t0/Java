package week7_homework;

import java.util.Scanner;

interface IStack{
	int capacity();
	int length();
	boolean push(String val);
	String pop();
}

class StringStack implements IStack{
	protected String stack[];
	protected int top = 0;
	
	public StringStack(int size) {
		stack = new String[size];
	}
	public int capacity() {
		return stack.length - top;
	}
	public int length() {
		return stack.length;
	}
	public boolean push(String val) {
		if(stack.length == top )
			return false;
		
		stack[top] = val;
		top++;
		return true;
	}
	public String pop() {
		if(stack[0] == null)
			return null;
		String str = "";
		for (int i = top-1; i >= 0; i--) {
			str += stack[i] + " ";
		}
		return str;
	}
}

public class test11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("스택 용량>>");
		int size = sc.nextInt();
		StringStack stack = new StringStack(size);
		
		while(true) {
			System.out.print("문자열 입력>>");
			String answer = sc.next();
			sc.nextLine();
			
			if(answer.equals("그만"))
				break;
			
			if(!(stack.push(answer)))
				System.out.println("스택이 꽉 차서 디지털 저장 불가");
		}
		System.out.println("스택에 전장된 문자열 팝 : "+stack.pop());
		sc.close();
	}
}
