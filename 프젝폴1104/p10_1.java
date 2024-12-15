package project;

import java.util.Random;
import java.util.Scanner;

public class p10_1 {
    public static void main(String[] args) {
        String[] arr = new String[] {"happy", "morning", "package", "together"};
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("10초 안에 단어를 맞추세요!!");
        
        while(true) {
            String question = arr[(int)(Math.random()*arr.length)];


            char[] charArray = question.toCharArray();


            int index1 = random.nextInt(question.length());
            int index2;
            do {
                index2 = random.nextInt(question.length());
            } while (index1 == index2);


            char temp = charArray[index1];
            charArray[index1] = charArray[index2];
            charArray[index2] = temp;

            
            String showQuestion =  new String(charArray);

            System.out.println(showQuestion);
            System.out.print(">>");


            long startTime = System.currentTimeMillis();
            
            String answer = sc.next();
            

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime; // 실행 시간 계산

            if (answer.equals("그만"))
                break;


            if (elapsedTime > 10000) {
                System.out.println("시간 초과! 10초가 경과했습니다.");
            } else if (answer.equals(question)) {
                System.out.println("성공!! " + (float)elapsedTime / 1000 + "초가 경과 되었습니다.");
            } else {
                System.out.println("실패!! " + question + "입니다. " + (float)elapsedTime / 1000 + "초 경과");
            }
        }
        sc.close();
    }
}
