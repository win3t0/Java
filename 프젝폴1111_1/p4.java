package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 물건 가격을 넣을 HashMap 생성 및 물건 등록
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("고추장", 3000);
        menu.put("만두", 500);
        menu.put("새우깡", 1500);
        menu.put("콜라", 600);
        menu.put("참치캔", 2000);
        menu.put("치약", 10000);
        menu.put("연어", 2500);
        menu.put("삼겹살", 2500);
        
        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        
        // 메뉴 전체 출력
        Set<String> keys = menu.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
        	String key = it.next();
        	int value = menu.get(key);
        	System.out.print("["+key+","+value+"]");
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
                if (!menu.containsKey(menuName)) {
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

                // 메뉴 가격과 수량 계산하여 총 비용에 합산
                totalCost += menu.get(menuName) * menuCount;
            }

            // 현재까지 계산된 비용 출력
            System.out.println("이번 입력에 대한 총 비용은 " + totalCost + "원입니다.");
        }

        System.out.println("프로그램이 종료되었습니다.");
        sc.close();
    }
}
