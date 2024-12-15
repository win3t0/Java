package hello;

import java.util.Scanner;

public class Dolscan {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double EXCHANGE_RATE = 1200;

        System.out.print("$1 = 1200원 입니다. 달러를 입력하세요>> ");
        int dollars = (int)scanner.nextDouble();

        int won = (int)(dollars * EXCHANGE_RATE);

        System.out.println("$"+dollars + "는 " + won + " 원입니다.");

        scanner.close();
    }
}