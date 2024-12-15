package project;

import java.util.Scanner;

class Player{
	String name;
	int[] dice;
	
	public Player(String name) {
		this.name = name;
		dice = new int[3];
	}
	

	public void throwDice() {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = (int)(Math.random()*3);
			System.out.print("   "+dice[i]);
		}
	}
	

	public boolean check() {
		int num = dice[0];
		for (int i = 1; i < dice.length; i++) {
			if(num != dice[i]) {
				System.out.println("   아쉽군요!");
				return false;
			}
		}
		System.out.println("   " + name + "님이 이겼습니다");
		return true;
	}
}

public class p11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("갬블링 게임에 참여할 선수 숫자>>>");
		int people = sc.nextInt();
		Player[] player = new Player[people];
		

		for (int i = 0; i < people; i++) {
			System.out.print((i+1)+"번째 선수 이름>>");
			String name = sc.next();
			player[i] = new Player(name);
		}
		sc.nextLine();

		
		int turn = 0;
		while(true) {
			System.out.print("["+player[turn].name+"]:<Enter>");
			sc.nextLine();
			

			player[turn].throwDice();
			

			if(player[turn].check())
				break;
			

			turn++;
			if(turn >= people)
				turn = 0;
		}
		
		sc.close();
	}
}
