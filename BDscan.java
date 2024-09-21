package hello;

import java.util.Scanner;

public class BDscan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("생일 입력 하세요: ");
        int birthday = scanner.nextInt();

        int year = birthday / 10000;        
        int month = (birthday / 100) % 100; 
        int day = birthday % 100;           

        System.out.printf("%04d년 %02d월 %02d일 %n", year, month, day);

        scanner.close();
    }
}