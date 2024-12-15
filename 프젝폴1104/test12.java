package chapter6;

import java.util.Scanner;
import java.util.Random;

class Player2 {
    String name;
    int number;  // 선수의 고른 숫자

    // 생성자
    public Player2(String name) {
        this.name = name;
    }

    // 숫자 고르기
    void choiceNum(int num) {
        this.number = num;
    }

    // 고른 숫자와 난수를 비교하여 맞춘 갯수를 셈
    int countMatches(int[] randomNumbers) {
        int matchCount = 0;
        for (int num : randomNumbers) {
            if (num == this.number) {
                matchCount++;
            }
        }
        return matchCount;
    }
}

public class test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            // 게임에 참여할 선수들 이름 입력
            System.out.print("게임에 참여할 선수들 이름>> ");
            String input = sc.nextLine();
            String[] people = input.split(" ");
            Player2[] players = new Player2[people.length];

            // Player 객체 생성 및 이름 설정
            for (int i = 0; i < people.length; i++) {
                players[i] = new Player2(people[i]);
                System.out.println(people[i] + "의 숫자를 고르세요 (1 ~ 10): ");
                int num = sc.nextInt();
                players[i].choiceNum(num);  // 각 선수의 숫자 선택
            }

            // 난수 15개 생성
            int[] randomNumbers = new int[15];
            for (int i = 0; i < randomNumbers.length; i++) {
                randomNumbers[i] = random.nextInt(10) + 1;  // 1에서 10 사이의 난수
            }

            // 게임 진행 - 패자들끼리만 계속 반복
            while (players.length > 1) {
                // 각 선수의 맞춘 숫자 세기
                int[] matchCounts = new int[players.length];
                int maxMatches = 0;
                int minMatches = Integer.MAX_VALUE;
                int winnerIndex = -1;
                int loserIndex = -1;

                for (int i = 0; i < players.length; i++) {
                    int matchCount = players[i].countMatches(randomNumbers);
                    matchCounts[i] = matchCount;

                    // 가장 많이 맞춘 사람
                    if (matchCount > maxMatches) {
                        maxMatches = matchCount;
                        winnerIndex = i;
                    }

                    // 가장 적게 맞춘 사람
                    if (matchCount < minMatches) {
                        minMatches = matchCount;
                        loserIndex = i;
                    }

                    System.out.println(players[i].name + "은 " + matchCount + "번 맞췄습니다.");
                }

                // 승자 및 패자 출력
                System.out.println("승자: " + players[winnerIndex].name + " (" + maxMatches + "번 맞췄습니다.)");
                System.out.println("패자: " + players[loserIndex].name + " (" + minMatches + "번 맞췄습니다.)");

                // 패자만 남기기
                Player2[] newPlayers = new Player2[players.length - 1];
                int newIndex = 0;
                for (int i = 0; i < players.length; i++) {
                    if (i != winnerIndex) {
                        newPlayers[newIndex++] = players[i];
                    }
                }

                players = newPlayers;  // 승자 제외한 패자들만 배열로 설정

                // 게임을 계속 진행할지 결정
                if (players.length == 1) {
                    System.out.println(players[0].name + "가 최종 패자입니다.");
                    break;  // 최종 패자가 나오면 종료
                } else {
                    System.out.println("패자끼리 다시 게임을 시작합니다!\n");
                }
            }

            sc.nextLine(); // 다음 입력을 위해 엔터키를 소비
        }

    }
}
