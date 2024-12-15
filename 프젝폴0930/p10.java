package project;
import java.util.Scanner;

class DayDiary {
    String text;

    DayDiary() {
        text = "...";
    }

    void setDayDiary(String text) {
        this.text = text;
    }

    String getDayDiary() {
        return text;
    }
}

public class test10 {
    int year;
    int month;

    test10(int year, int month) {
        this.year = year;
        this.month = month;
    }

    void run() {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
        Scanner sc = new Scanner(System.in);

        DayDiary[] diary = new DayDiary[30];
        for (int i = 0; i < diary.length; i++) {
            diary[i] = new DayDiary();
        }

        int answer = 0;
        while (answer != 3) {
            this.getMenu();
            answer = sc.nextInt();
            sc.nextLine();

            if (answer == 1) {
                System.out.print("날짜를 입력하세요(1~30): ");
                int day = sc.nextInt();
                sc.nextLine();
                System.out.print("일기 내용을 입력하세요: ");
                String diaryText = sc.nextLine();
                write(day, diaryText, diary);
            } else if (answer == 2) {
                show(diary);  // 일기 보기
            } else if (answer == 3) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
        }
        sc.close();
    }


    void write(int day, String text, DayDiary[] diary) {
        diary[day - 1].setDayDiary(text);
    }


    void show(DayDiary[] diary) {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 내용 *****");
        for (int i = 0; i < diary.length; i++) {
            System.out.print((i + 1) + "일: " + diary[i].getDayDiary() + "\t");
            if ((i + 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    void getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3>> ");
    }

    public static void main(String[] args) {
        test10 monthDiary = new test10(2024, 10);
        monthDiary.run();
    }
}
