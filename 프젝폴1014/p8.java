package project;

import java.util.Scanner;

abstract class Box{
	protected int size;
	
	public Box(int size) {
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public abstract boolean consume();
	public abstract void print();
}

class IngredientBox extends Box{
	public IngredientBox() {
		super(5);
	}
	
	public boolean consume() {
		this.size--;
		return true;
	}
	
	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print("*");
		System.out.println(super.size);
	}
}

public class p8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***청춘 커피 자판기 입니다.***");
		IngredientBox coffee = new IngredientBox();
		IngredientBox creamer = new IngredientBox();
		IngredientBox sugar = new IngredientBox();
		
		while(true) {
			System.out.print("커피 ");coffee.print();
			System.out.print("프림 ");creamer.print();
			System.out.print("설탕 ");sugar.print();
			System.out.print("다방커피:1, 설탕커피:2, 블랙커피:3, 종료:4>>");
			
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				if(!(coffee.isEmpty() && creamer.isEmpty() && sugar.isEmpty())) {
					coffee.consume();
					creamer.consume();
					sugar.consume();
				}
				else
					System.out.println("원료가 부족합니다");
			}
			if(choice == 2) {
				if(!(coffee.isEmpty() && sugar.isEmpty())) {
					coffee.consume();
					sugar.consume();
				}
				else
					System.out.println("원료가 부족합니다");
			}
			if(choice == 3) {
				if(!(coffee.isEmpty())) {
					coffee.consume();
				}
				else
					System.out.println("원료가 부족합니다");
			}
			if(choice == 4) {
				System.out.println("청춘 커피 자판기 프로그램을 종료합니다");
				break;
			}
		}
		
		sc.close();
	}
}
