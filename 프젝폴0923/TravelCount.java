package hello;

import java.util.Scanner;

public class TravelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("여행지를 입력하세요: ");
        String travel = scanner.nextLine();

        System.out.print("인원수를 입력하세요: ");
        int people = scanner.nextInt();

        System.out.print("숙박일을 입력하세요: ");
        int nights = scanner.nextInt();

        System.out.print("1인당 항공료를 입력하세요: ");
        int airplane = scanner.nextInt();

        System.out.print("1방 숙박비를 입력하세요: ");
        int roomRate = scanner.nextInt();

        int rooms = (people + 1) / 2; 
        int days = (nights + 1);

        int totalAirplane = people * airplane;
        int totalRoomCost = rooms * roomRate * nights;
        int totalCost = totalAirplane + totalRoomCost;

        System.out.println(people + "명의 " + travel + " " + nights + "박" + 
        days + "일 여행에는 방이 " + rooms + "개 필요하며 경비는 " + totalCost + "원 입니다.");

        scanner.close();
    }
}