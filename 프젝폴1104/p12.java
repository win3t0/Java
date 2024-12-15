package project;

import java.util.Scanner;
import java.util.Random;

class Player2 {
    String name;
    int number;


    public Player2(String name) {
        this.name = name;
    }


    void choiceNum(int num) {
        this.number = num;
    }


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

public class p12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("게임에 참여할 선수들 이름>> ");
            String input = sc.nextLine();
            String[] people = input.split(" ");
            Player2[] players = new Player2[people.length];


            for (int i = 0; i < people.length; i++) {
                players[i] = new Player2(people[i]);
                System.out.println(people[i] + "의 숫자를 고르세요 (1 ~ 10): ");
                int num = sc.nextInt();
                players[i].choiceNum(num);
            }


            int[] randomNumbers = new int[15];
            for (int i = 0; i < randomNumbers.length; i++) {
                randomNumbers[i] = random.nextInt(10) + 1;  // 1에서 10 사이의 난수
            }

            while (players.length > 1) {
                int[] matchCounts = new int[players.length];
                int maxMatches = 0;
                int minMatches = Integer.MAX_VALUE;
                int winnerIndex = -1;
                int loserIndex = -1;

                for (int i = 0; i < players.length; i++) {
                    int matchCount = players[i].countMatches(randomNumbers);
                    matchCounts[i] = matchCount;


                    if (matchCount > maxMatches) {
                        maxMatches = matchCount;
                        winnerIndex = i;
                    }


                    if (matchCount < minMatches) {
                        minMatches = matchCount;
                        loserIndex = i;
                    }

                    System.out.println(players[i].name + "은 " + matchCount + "번 맞췄습니다.");
                }
                System.out.println("승자: " + players[winnerIndex].name + " (" + maxMatches + "번 맞췄습니다.)");
                System.out.println("패자: " + players[loserIndex].name + " (" + minMatches + "번 맞췄습니다.)");


                Player2[] newPlayers = new Player2[players.length - 1];
                int newIndex = 0;
                for (int i = 0; i < players.length; i++) {
                    if (i != winnerIndex) {
                        newPlayers[newIndex++] = players[i];
                    }
                }

                players = newPlayers;

                if (players.length == 1) {
                    System.out.println(players[0].name + "가 최종 패자입니다.");
                    break;
                } else {
                    System.out.println("패자끼리 다시 게임을 시작합니다!\n");
                }
            }

            sc.nextLine();
        }

    }
}
