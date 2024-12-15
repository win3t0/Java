package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class test4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 품목과 가격을 각각 ArrayList에 저장
        ArrayList<String> menuNames = new ArrayList<>();
        ArrayList<Integer> menuPrices = new ArrayList<>();
        
        menuNames.add("고추장");
        menuPrices.add(3000);
        menuNames.add("만두");
        menuPrices.add(500);
        menuNames.add("새우깡");
        menuPrices.add(1500);
        menuNames.add("콜라");
        menuPrices.add(600);
        menuNames.add("참치캔");
        menuPrices.add(2000);
        menuNames.add("치약");
        menuPrices.add(10000);
        menuNames.add("연어");
        menuPrices.add(2500);
        menuNames.add("삼겹살");
        menuPrices.add(2500);
        
        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        
        // 메뉴 전체 출력
        for (int i = 0; i < menuNames.size(); i++) {
            System.out.print("[" + menuNames.get(i) + "," + menuPrices.get(i) + "] ");
        }
        System.out.println();

        while (true) {
            System.out.print("물건과 갯수를 입력하세요>>");
            int totalCost = 0; // 한 줄 입력에 대한 비용을 계산할 때마다 초기화
            String input = sc.nextLine().trim(); // 한 줄 입력 받기
            if (input.equals("그만")) { // "그만" 입력 시 종료
                break;
            }

            if (input.isEmpty()) { // 줄바꿈만 입력된 경우 처리
                System.out.println("입력이 비어 있습니다. 다시 입력해주세요.");
                continue;
            }

            // 공백 기준으로 문자열 분리
            String[] items = input.split(" ");
            for (int i = 0; i < items.length; i += 2) {
                String menuName = items[i]; // 홀수번째: 메뉴 이름

                // 메뉴가 존재하는지 확인
                if (!menuNames.contains(menuName)) {
                    System.out.println(menuName + "은(는) 없는 상품입니다. 다시 입력해주세요.");
                    continue;
                }

                // 수량이 숫자인지 확인
                int menuCount = 0;
                try {
                    if (i + 1 < items.length) { // 짝수번째가 존재하는 경우
                        menuCount = Integer.parseInt(items[i + 1]);
                    } else {
                        System.out.println("수량 정보가 누락되었습니다. 다시 입력해주세요.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("수량은 숫자로 입력해야 합니다. 다시 입력해주세요.");
                    continue;
                }

                // 메뉴의 인덱스 가져오기
                int index = menuNames.indexOf(menuName);

                // 메뉴 가격과 수량 계산하여 총 비용에 합산
                totalCost += menuPrices.get(index) * menuCount;
            }

            // 현재까지 계산된 비용 출력
            System.out.println("이번 입력에 대한 총 비용은 " + totalCost + "원입니다.");
        }

        System.out.println("프로그램이 종료되었습니다.");
        sc.close();
    }
}
