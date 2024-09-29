package hello;

import java.util.Scanner;

public class car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("자동차 상태 입력>> ");
        int status = scanner.nextInt(); 

        int temperature = status & 0b00011111; 

        if ((status & 0b01000000) == 0) {
            System.out.print("에어컨이 꺼진 상태이고 ");
        } else {
            System.out.print("에어컨이 켜진 상태이고 ");
        }

        if ((status & 0b10000000) == 0) {
            System.out.print("자동차는 정지 상태이고 ");
        } else {
            System.out.print("자동차는 달리는 상태이고 ");
        }

        System.out.printf("온도는 %d도이다.%n", temperature);

        scanner.close();
    }
}
