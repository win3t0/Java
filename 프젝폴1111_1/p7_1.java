package project;

import java.util.ArrayList;
import java.util.Scanner;


class CityLocationPair {
    String name;
    Location location;

    public CityLocationPair(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}

public class p7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CityLocationPair> cityList = new ArrayList<>();

        System.out.println("도시, 경도, 위도를 입력하라");
        for (int i = 0; i < 4; i++) {
            String name = sc.next();
            int lat = sc.nextInt();
            int lon = sc.nextInt();
            cityList.add(new CityLocationPair(name, new Location(lat, lon)));
        }

        System.out.println("----------------------------------");

        System.out.println("저장된 도시와 위치:");
        for (CityLocationPair pair : cityList) {
            System.out.printf("%-6s %-6d %-6d%n", pair.name, pair.location.getLat(), pair.location.getLon());
        }

        System.out.println("----------------------------------");

        System.out.println("도시 이름을 입력하라. '그만'을 입력하면 종료한다.");
        while (true) {
            String input = sc.next();
            if (input.equals("그만")) {
                break;
            }

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

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
