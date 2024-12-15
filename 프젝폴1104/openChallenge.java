package chapter6;

import java.util.Scanner;

public class openChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] hist = new int[26]; // 알파벳 26개에 대한 카운트 배열
        String line;

        System.out.println("영문을 입력하고 세미콜론을 입력하세요");

        while (true) {
            line = sc.nextLine().trim(); // 한 줄 입력받고 양옆 공백 제거

            if (line.equals(";")) { // 세미콜론만 있는 라인 만났을 때 종료
                break;
            }

            // 입력된 텍스트에서 알파벳만 처리하고 대소문자 구분하지 않음
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // 알파벳이 아니라면 무시
                if (Character.isLetter(ch)) {
                    ch = Character.toLowerCase(ch); // 대소문자 구분 없이 처리
                    hist[ch - 'a']++; // 해당 알파벳의 인덱스에 해당하는 카운트 증가
                }
            }
        }

        // 히스토그램 출력
        System.out.println("\n알파벳 히스토그램:");
        for (int i = 0; i < hist.length; i++) {
        	System.out.println((char) (i + 'a') + ": " + hist[i]);
        }

        sc.close();
    }
}

