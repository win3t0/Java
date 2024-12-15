package openChallenge;

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
    public openChallenge() {}

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임에 참가하는 인원은 몇 명입니까?>> ");
        int users = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[users];

        for (int i = 0; i < players.length; i++) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            String playerName = sc.nextLine();
            players[i] = new Player(playerName);
        }

        String word = "아버지";
        System.out.println("시작하는 단어는 " + word + "입니다");

        int currentPlayerIndex = 0;
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            
            System.out.print(currentPlayer.name + ">> ");
            String newWord = sc.next();

            
            if (newWord.length() == 0) {
                System.out.println("단어를 입력해야 합니다.");
                continue;
            }

            currentPlayer.getWordFromUser(newWord);


            char lastChar = word.charAt(word.length() - 1);
            char firstChar = newWord.charAt(0);

            if (!checkSuccess(lastChar, firstChar)) {
                System.out.println(currentPlayer.name + "이(가) 졌습니다.");
                break;  // 게임 종료
            }

            word = newWord;
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }

        sc.close();
    }


    public boolean checkSuccess(char lastChar, char firstChar) {
        return lastChar == firstChar;
    }

    public static void main(String[] args) {
        System.out.println("끝말잇기 게임을 시작합니다...");
        openChallenge game = new openChallenge();
        game.run();
    }
}
