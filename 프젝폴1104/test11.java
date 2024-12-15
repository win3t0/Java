package chapter6;

import java.util.Scanner;

class Player{
	String name;
	int[] dice;
	
	public Player(String name) {
		this.name = name;
		dice = new int[3];
	}
	
	// 주사위를 던져 수 띄우기
	public void throwDice() {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = (int)(Math.random()*3);
			System.out.print("   "+dice[i]);
		}
	}
	
	// 주사위가 모두 맞았는 확인
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

public class test11 {
	public static void main(String[] args) {
		//게임 및 유저 세팅
		Scanner sc = new Scanner(System.in);
		System.out.print("갬블링 게임에 참여할 선수 숫자>>>");
		int people = sc.nextInt();
		Player[] player = new Player[people];
		
		//Player 이름 정하기
		for (int i = 0; i < people; i++) {
			System.out.print((i+1)+"번째 선수 이름>>");
			String name = sc.next();
			player[i] = new Player(name);
		}
		sc.nextLine();
		
		// 플레이어 차례
		int turn = 0;
		while(true) {
			System.out.print("["+player[turn].name+"]:<Enter>");
			sc.nextLine();
			
			//주사위 던지기
			player[turn].throwDice();
			
			//주사위 확인
			if(player[turn].check())
				break;
			
			//다음 플레이어에게 턴 넘기기
			turn++;
			if(turn >= people)
				turn = 0;
		}
		
		sc.close();
	}
}
