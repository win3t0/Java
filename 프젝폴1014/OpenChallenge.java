package week7_homework;
import java.util.Scanner;

class Game {
    Player[] players = new Player[2];
    Player owner;

    void run() {
        System.out.println("***** 묵찌빠 게임을 시작합니다. *****");
        createPlayers();
        System.out.println("오너를 결정하기 위해 가위바위보를 시작합니다.");

        // 가위바위보를 통해 오너 결정
        while (true) {
            String userChoice = players[0].next();
            String computerChoice = players[1].next();
            if (isDraw(userChoice, computerChoice)) {
                System.out.println("비겼습니다. 다시 가위바위보를 진행합니다.");
            } else if (isWin(userChoice, computerChoice)) {
                System.out.println(players[0].getName() + "이 오너로 결정되었습니다.");
                owner = players[0];
                break;
            } else {
                System.out.println(players[1].getName() + "이 오너로 결정되었습니다.");
                owner = players[1];
                break;
            }
        }

        // 묵찌빠 게임 진행
        System.out.println("묵찌빠 게임을 시작합니다.");
        while (true) {
            Player challenger = (owner == players[0]) ? players[1] : players[0];
            String ownerChoice = owner.next();
            String challengerChoice = challenger.next();

            if (ownerChoice.equals(challengerChoice)) {
                System.out.println(owner.getName() + "이(가) 최종 승리했습니다!");
                break;
            } else if (isWin(ownerChoice, challengerChoice)) {
                System.out.println(owner.getName() + "이 승리하여 오너 자리를 유지합니다.");
            } else {
                System.out.println(challenger.getName() + "이 승리하여 오너가 변경됩니다.");
                owner = challenger;
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    void createPlayers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("선수 이름 입력>>");
        String user = sc.next();
        players[0] = new Human(user);
        System.out.print("컴퓨터 이름 입력>>");
        String ai = sc.next();
        players[1] = new AI(ai);
        System.out.println("2명의 선수를 생성 완료하였습니다.");
    }

    boolean isDraw(String choice1, String choice2) {
        return choice1.equals(choice2);
    }

    boolean isWin(String choice1, String choice2) {
        return (choice1.equals("묵") && choice2.equals("찌")) ||
               (choice1.equals("찌") && choice2.equals("빠")) ||
               (choice1.equals("빠") && choice2.equals("묵"));
    }
}

public class OpenChallenge {
    public static void main(String[] args) {
        new Game().run();
    }
}
