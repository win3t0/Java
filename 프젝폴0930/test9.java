package week5_homework;

import java.util.Scanner;

class Player2 {
    String name;
    int score;
    int number;

    public Player2(String name) {
        this.name = name;
        this.score = 0; // 점수 초기화
    }

    void success() {
        score++;
    }

    void getNumber(int number) {
        this.number = number;
    }
}

public class test9 {
    static int GuessGame() {
        int hiddenAnswer = (int) (Math.random() * 100 + 1);
        return hiddenAnswer;
    }

    public static void main(String[] args) {
        System.out.println("*** 예측 게임을 시작합니다 ***");
        Scanner sc = new Scanner(System.in);

        System.out.print("게임에 참여할 선수 수>> ");
        int users = sc.nextInt();
        sc.nextLine(); // 남아있는 개행 문자 제거
        Player2[] player = new Player2[users];
        for (int i = 0; i < player.length; i++) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            String playerName = sc.nextLine();
            player[i] = new Player2(playerName);
        }

        boolean playAgain = true;

        while (playAgain) {
            int winner = 0;
            int smallest = 100;
            int[] answer = new int[player.length];
            int hiddenAnswer = GuessGame();
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요");
            
            for (int i = 0; i < answer.length; i++) {
                System.out.print(player[i].name + ">> ");
                answer[i] = sc.nextInt();
                answer[i] = Math.abs(hiddenAnswer - answer[i]);
                if (smallest > answer[i]) {
                    smallest = answer[i]; // 작은 값 업데이트
                    winner = i; // 승자 업데이트
                }
            }
            player[winner].success();
            System.out.println("정답은 " + hiddenAnswer + "입니다. " + player[winner].name + " 이(가) 이겼습니다. 승점 1점 확보!");

            // 게임을 계속할지 묻기
            System.out.print("한 번 더 하시겠습니까? (yes/no)>> ");
            sc.nextLine(); // 남아 있는 개행 문자 제거
            String answerAgain = sc.nextLine();
            if (!answerAgain.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        // 최종 승자 결정
        int finerWinner = 0;
        for (int i = 0; i < player.length; i++) {
            System.out.print(player[i].name + ": " + player[i].score + "점 ");
            if (player[finerWinner].score < player[i].score) { // 더 높은 점수를 가진 플레이어 찾기
                finerWinner = i;
            }
        }
        System.out.println();
        System.out.println(player[finerWinner].name + "이(가) 최종 승리하였습니다!");

        sc.close(); // Scanner 닫기
    }
}
