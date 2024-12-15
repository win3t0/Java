package week7_homework;

import java.util.Scanner;

abstract class Calc{
	protected String errorMsg;
	protected int a, b;
	abstract public void setValue(int a, int b);
	abstract public int calculate();
}

class Add extends Calc{
	public Add() {
		super();
		errorMsg = null;
	}
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		int result = 0;
		try {
            // 예외를 발생시키는 코드 예시
            result = a + b;
        } catch (Exception e) {
            // 예외 메시지를 문자열로 저장
        	errorMsg = e.getMessage();
        }
		finally{
			return result;
		}
	}
}

class Sub extends Calc{
	public Sub() {
		super();
		errorMsg = null;
	}
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		int result = 0;
		try {
            // 예외를 발생시키는 코드 예시
            result = a - b;
        } catch (Exception e) {
            // 예외 메시지를 문자열로 저장
        	errorMsg = e.getMessage();
        }
		finally{
			return result;
		}
	}
}

class Mul extends Calc{
	public Mul() {
		super();
		errorMsg = null;
	}
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		int result = 0;
		try {
            // 예외를 발생시키는 코드 예시
            result = a * b;
        } catch (Exception e) {
            // 예외 메시지를 문자열로 저장
        	errorMsg = e.getMessage();
        }
		finally{
			return result;
		}
	}
}

class Div extends Calc{
	public Div() {
		super();
		errorMsg = null;
	}
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		int result = 0;
        try {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            result = a / b;
        } catch (ArithmeticException e) {
            errorMsg = e.getMessage();
        }
        return result;
	}
}

public class test13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("두 정수와 연산자를 입력하시오>>");
			int a = sc.nextInt();
			int b = sc.nextInt();
			String cals = sc.next();
			
			if(cals.equals("+")) {
				Add add = new Add();
				add.setValue(a, b);
				int value = add.calculate();
				if(add.errorMsg != null) {
					System.out.println(b + "으로 더할 수 없음. 프로그램 종료");
					break;
				}
				System.out.println("계산 결과 "+value);
			}
			else if(cals.equals("-")) {
				Sub sub = new Sub();
				sub.setValue(a, b);
				int value = sub.calculate();
				if(sub.errorMsg != null) {
					System.out.println(b + "으로 뺄 수 없음. 프로그램 종료");
					break;
				}
				System.out.println("계산 결과 "+value);
			}
			else if(cals.equals("*")) {
				Mul mul = new Mul();
				mul.setValue(a, b);
				int value = mul.calculate();
				if(mul.errorMsg != null) {
					System.out.println(b + "으로 곱할 수 없음. 프로그램 종료");
					break;
				}
				System.out.println("계산 결과 "+value);
			}
			else if(cals.equals("/")) {
				Div div = new Div();
				div.setValue(a, b);
				int value = div.calculate();
				if(div.errorMsg != null) {
					System.out.println(b + "으로 나눌 수 없음. 프로그램 종료");
					break;
				}
				System.out.println("계산 결과 "+value);
			}
		}
		
		sc.close();
	}
}
