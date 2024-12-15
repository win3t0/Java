package week5_homework;

import java.util.Scanner;

class Player {
    String name;
    String word;

    public Player(String name) {
        this.name = name;
    }

    public void getWordFromUser(String word){
        this.word = word;
    }

    public String sayWord() {
        return word;
    }
}

public class openChallenge {
    // 생성자
    public openChallenge() {}

    // 전반적인 진행
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임에 참가하는 인원은 몇 명입니까?>> ");
        int users = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        Player[] players = new Player[users];

        for (int i = 0; i < players.length; i++) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            String playerName = sc.nextLine();
            players[i] = new Player(playerName);
        }

        String word = "아버지";  // 게임 시작 단어
        System.out.println("시작하는 단어는 " + word + "입니다");

        int currentPlayerIndex = 0;  // 현재 순서를 저장하는 변수
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];  // 현재 차례의 플레이어
            
            System.out.print(currentPlayer.name + ">> ");
            String newWord = sc.next();

            // 입력된 단어가 최소한 1글자 이상인지 확인
            if (newWord.length() == 0) {
                System.out.println("단어를 입력해야 합니다.");
                continue;  // 다시 입력받음
            }

            currentPlayer.getWordFromUser(newWord);

            // 이전 단어의 마지막 글자와 새 단어의 첫 글자 비교
            char lastChar = word.charAt(word.length() - 1);  // 이전 단어의 마지막 문자
            char firstChar = newWord.charAt(0);  // 새 단어의 첫 문자

            if (!checkSuccess(lastChar, firstChar)) {
                System.out.println(currentPlayer.name + "이(가) 졌습니다.");
                break;  // 게임 종료
            }

            // 단어 갱신 및 다음 플레이어로 넘어감
            word = newWord;
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }

        sc.close();
    }

    // 첫 글자와 마지막 글자 비교
    public boolean checkSuccess(char lastChar, char firstChar) {
        return lastChar == firstChar;
    }

    public static void main(String[] args) {
        System.out.println("끝말잇기 게임을 시작합니다...");
        openChallenge game = new openChallenge();
        game.run();
    }
}
