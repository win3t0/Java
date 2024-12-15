package hello;

import java.util.Scanner;

public class p3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1; 

        for (; n <= 0; ) {
            System.out.print("양의 정수 입력>> ");
            n = scanner.nextInt();
        }

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
        scanner.close();
    }
}
