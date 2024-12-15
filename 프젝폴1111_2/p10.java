package chapter8;

import java.io.File;
import java.util.HashMap;

import java.io.*;
import java.util.*;

public class test10 {
    // 전화번호부를 저장할 맵
    private Map<String, String> phoneBook;

    public test10() {
        phoneBook = new HashMap<>();
    }

    // 전화번호를 파일에서 로드하는 메소드
    public void loadPhoneNumbers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phone = parts[1].trim();
                    phoneBook.put(name, phone);
                    count++;
                }
            }
            System.out.println("총 " + count + "개의 전화번호를 읽었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 사용자와의 상호작용을 처리하는 메소드
    public void startSearch() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("이름>> ");
            String name = scanner.nextLine().trim();
            if (name.equals("그만")) {
                break;
            }
            if (phoneBook.containsKey(name)) {
                System.out.println(phoneBook.get(name));
            } else {
                System.out.println("찾는 이름이 없습니다");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // PhoneSearch 객체 생성
        test10 phoneSearch = new test10();
        // 전화번호 파일 로드
        phoneSearch.loadPhoneNumbers("C:\\Temp\\phone.txt");
        // 검색 시작
        phoneSearch.startSearch();
    }
}
