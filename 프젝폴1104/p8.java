package chapter6;

import java.util.Calendar;
import java.util.Scanner;

public class test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar now = Calendar.getInstance();
        
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;
        int nowDay = now.get(Calendar.DAY_OF_MONTH);

        System.out.println("오늘은 " + nowYear + "년 " + nowMonth + "월 " + nowDay + "일");
        
        while (true) {
            System.out.print("생일 입력(년 월 일)>> ");
            int birthYear = sc.nextInt();
            
            if (birthYear == -1)
                break;
            
            int birthMonth = sc.nextInt();
            int birthDay = sc.nextInt();
            
            Calendar birth = Calendar.getInstance();
            birth.set(birthYear, birthMonth - 1, birthDay);
            
            int yearsLived = nowYear - birthYear;
            int daysInYear = (365 - birth.get(Calendar.DAY_OF_YEAR)) + now.get(Calendar.DAY_OF_YEAR);

            int daysLived = (yearsLived - 1) * 365 + daysInYear; 
            System.out.println("오늘까지 " + daysLived + "일 살아왔습니다.");
        }
        
        sc.close();
    }
}
