package hello;

import java.util.Scanner;

public class counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int priceA = 2000;
        int priceB = 1000;
        int priceC = 3000;
        
        System.out.print("**** 자바 분식입니다. 주문하면 금액을 알려 드립니다. ****\n");

        System.out.print("떡볶이 몇 인분>> ");
        int quantityA = scanner.nextInt();

        System.out.print("김말이 몇 인분>> ");
        int quantityB = scanner.nextInt();

        System.out.print("쫄면 몇 인분>> ");
        int quantityC = scanner.nextInt();

        int totalPrice = (priceA * quantityA) + (priceB * quantityB) + (priceC * quantityC);

        System.out.println("전체 금액은 " + totalPrice + " 원 입니다.");

        scanner.close();
    }
}
