package chapter6;

import java.util.Calendar;
import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        
        while (true) {
            System.out.print("년도 입력(-1이면 종료)>> ");
            int year = sc.nextInt();
            if (year == -1) break;

            cal.set(Calendar.YEAR, year);  // 입력한 연도로 설정
            
            for (int month = 0; month < 12; month++) {
                cal.set(Calendar.MONTH, month);  // 월 설정 (0: 1월, 1: 2월, ..., 11: 12월)
                cal.set(Calendar.DAY_OF_MONTH, 1);  // 해당 월의 첫째 날로 설정

                System.out.println("\n" + year + "년 " + (month + 1) + "월");
                System.out.println("일 월 화 수 목 금 토");

                int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 해당 월의 첫날 요일
                int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  // 해당 월의 마지막 날짜

                // 첫째 줄의 요일 맞추기 위한 공백 출력
                for (int i = 1; i < firstDayOfWeek; i++) {
                    System.out.print("   ");
                }

                // 각 날짜 출력
                for (int day = 1; day <= lastDay; day++) {
                    System.out.printf("%2d ", day);  // 날짜 출력 (2자리 정렬)

                    // 토요일에 줄 바꾸기
                    if ((day + firstDayOfWeek - 1) % 7 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();  // 각 월 끝에 줄 바꾸기
            }
        }
        
        sc.close();
    }
}
