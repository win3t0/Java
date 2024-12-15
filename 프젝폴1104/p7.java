package project;

import java.util.Calendar;
import java.util.Scanner;

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();

        while (true) {
            System.out.print("년도 입력(-1이면 종료)>> ");
            int year = sc.nextInt();
            if (year == -1) break;

            cal.set(Calendar.YEAR, year);

            for (int month = 0; month < 12; month++) {
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, 1);

                System.out.println("\n" + year + "년 " + (month + 1) + "월");
                System.out.println("일 월 화 수 목 금 토");

                int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                for (int i = 1; i < firstDayOfWeek; i++) {
                    System.out.print("   ");
                }

                for (int day = 1; day <= lastDay; day++) {
                    System.out.printf("%2d ", day);

                    if ((day + firstDayOfWeek - 1) % 7 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
