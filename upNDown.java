package hello;

import java.util.Random;
import java.util.Scanner;

public class upNDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean again;

        do {
            int Number = random.nextInt(100); 
            int guess = -1; 
            int attempt = 1; 
            int min = 0; 
            int max = 99; 

            System.out.println("수를 결정하였습니다. 맞추어 보세요.");
            System.out.println("0~99");

            while (guess != Number) {
                System.out.print(attempt + ">> ");
                guess = scanner.nextInt();


                if (guess < min || guess > max) {
                    System.out.println("잘못된 입력입니다. " + min + "에서 " + max + "까지의 숫자를 입력하세요.");
                } else {

                    System.out.println(guess);

                    if (guess < Number) {
                        System.out.println("더 높게");
                        min = guess + 1; 
                    } else if (guess > Number) {
                        System.out.println("더 낮게");
                        max = guess - 1; 
                    } else {
                        System.out.println("맞았습니다.");
                    }


                    if (guess != Number) {
                        System.out.println(min + "~" + max);
                    }
                }

                attempt++; 
            }


            System.out.print("다시하시겠습니까(y/n) >> ");
            String text = scanner.next();
            if (text.equals("n")) {
                again = false; 
            } else {
                again = true;
            }

        } while (again);

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
