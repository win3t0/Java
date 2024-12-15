package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

// 도시와 위치를 쌍으로 저장하는 클래스
class CityLocationPair {
    String name;    // 도시 이름
    Location location; // 도시 위치 (위도, 경도)

    public CityLocationPair(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}

public class test7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CityLocationPair> cityList = new ArrayList<>();

        // 도시, 경도, 위도 4개 입력받기
        System.out.println("도시, 경도, 위도를 입력하라");
        for (int i = 0; i < 4; i++) {
            String name = sc.next();
            int lat = sc.nextInt();
            int lon = sc.nextInt();
            cityList.add(new CityLocationPair(name, new Location(lat, lon)));
        }

        // 구분선
        System.out.println("----------------------------------");

        // 기록된 모든 도시의 경도와 위도 출력
        System.out.println("저장된 도시와 위치:");
        for (CityLocationPair pair : cityList) {
            System.out.printf("%-6s %-6d %-6d%n", pair.name, pair.location.getLat(), pair.location.getLon());
        }

        // 구분선
        System.out.println("----------------------------------");

        // 그만이라는 입력이 들어오기 전까지 입력한 도시 출력
        System.out.println("도시 이름을 입력하라. '그만'을 입력하면 종료한다.");
        while (true) {
            String input = sc.next(); // 도시 이름 입력
            if (input.equals("그만")) { // 종료 조건
                break;
            }

            // 입력된 도시 정보 확인 및 출력
            boolean found = false;
            for (CityLocationPair pair : cityList) {
                if (pair.name.equals(input)) {
                    System.out.printf("%-6s %-6d %-6d%n", pair.name, pair.location.getLat(), pair.location.getLon());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(input + "는(은) 등록되지 않은 도시입니다.");
            }
        }

        // 종료 메시지
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
