package project;

import java.util.HashMap;
import java.util.Scanner;

class Location {
    int lat, lon; // 위도(latitude), 경도(longitude)

    public Location(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }
}

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Location> city = new HashMap<>();

        System.out.println("도시, 경도, 위도를 입력하라");
        for (int i = 0; i < 4; i++) {
            String name = sc.next();
            int lat = sc.nextInt();
            int lon = sc.nextInt();
            city.put(name, new Location(lat, lon));
        }

        System.out.println("----------------------------------");

        System.out.println("저장된 도시와 위치:");
        for (String key : city.keySet()) {
            Location town = city.get(key);
            System.out.println(String.format("%-6s %-6d %-6d", key, town.getLat(), town.getLon()));
        }

        System.out.println("----------------------------------");

        System.out.println("도시 이름을 입력하라. '그만'을 입력하면 종료한다.");
        while (true) {
            String input = sc.next(); // 도시 이름 입력
            if (input.equals("그만")) { // 종료 조건
                break;
            }

            if (city.containsKey(input)) {
                Location town = city.get(input);
                System.out.println(String.format("%-6s %-6d %-6d", input, town.getLat(), town.getLon()));
            } else {
                System.out.println(input + "는(은) 등록되지 않은 도시입니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
