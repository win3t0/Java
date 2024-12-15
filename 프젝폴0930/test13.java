package week5_homework;
import java.util.Scanner;

class ConcertReservationSystem {
    private String[][] seats; // 좌석 배열
    private final String[] seatTypes = {"S석", "A석", "B석"};

    public ConcertReservationSystem() {
        // 3개의 좌석 타입에 대해 각각 10개의 좌석을 생성
        seats = new String[3][10];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = "---"; // 빈 좌석
            }
        }
    }

    // 예약 메서드
    public void reserveSeat(int seatTypeIndex, String name, int seatNumber) {
        if (seatTypeIndex < 0 || seatTypeIndex >= seatTypes.length) {
            System.out.println("잘못된 좌석 타입입니다.");
            return;
        }
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("잘못된 좌석 번호입니다. 1~10 사이의 번호를 입력하세요.");
            return;
        }
        if (!seats[seatTypeIndex][seatNumber - 1].equals("---")) {
            System.out.println("이미 예약된 좌석입니다.");
            return;
        }

        // 좌석 예약
        seats[seatTypeIndex][seatNumber - 1] = name;
        System.out.println(seatTypes[seatTypeIndex] + " " + seatNumber + "번 좌석이 예약되었습니다.");
    }

    // 좌석 조회 메서드
    public void showSeats() {
        System.out.println("좌석 현황:");
        for (int i = 0; i < seatTypes.length; i++) {
            System.out.print(seatTypes[i] + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 예약 취소 메서드
    public void cancelReservation(String name) {
        boolean found = false;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].equals(name)) {
                    seats[i][j] = "---"; // 예약 취소
                    found = true;
                    System.out.println(name + "님의 예약이 취소되었습니다.");
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("해당 이름으로 예약된 좌석이 없습니다.");
        }
    }
}

public class test13 {
    public static void main(String[] args) {
        ConcertReservationSystem reservationSystem = new ConcertReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("명품콘서트홀 예약 시스템입니다.");

        do {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>> ");
            choice = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1: // 예약
                    System.out.print("좌석 구분 S(1), A(2), B(3)>> ");
                    int seatTypeInput = sc.nextInt();
                    sc.nextLine(); // 개행 문자 처리
                    int seatTypeIndex = seatTypeInput - 1; // 입력받은 숫자에 맞춰 인덱스 설정
                    System.out.print("예약자 이름: ");
                    String name = sc.nextLine();
                    System.out.print("좌석 번호(1~10): ");
                    int seatNumber = sc.nextInt();
                    reservationSystem.reserveSeat(seatTypeIndex, name, seatNumber);
                    break;

                case 2: // 조회
                    reservationSystem.showSeats();
                    break;

                case 3: // 취소
                    System.out.print("취소할 예약자 이름: ");
                    String cancelName = sc.nextLine();
                    reservationSystem.cancelReservation(cancelName);
                    break;

                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다. 다시 시도하세요.");
                    break;
            }
        } while (choice != 4);

        sc.close();
    }
}
