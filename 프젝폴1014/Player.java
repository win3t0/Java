package week7_homework;
import java.util.Scanner;

abstract public class Player {
    protected String[] bet = {"묵", "찌", "빠"};
    protected String name;
    protected String lastBet = null;

    protected Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastBet() {
        return lastBet;
    }

    abstract public String next();
}

class Human extends Player {
    public Human(String name) {
        super(name);
    }

    @Override
    public String next() {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.print(getName() + " >> ");
            choice = sc.nextLine().trim();
            if (choice.equals("묵") || choice.equals("찌") || choice.equals("빠")) {
                break;
            } else {
                System.out.println("묵, 찌, 빠 중에서 다시 입력하세요.");
            }
        }
        lastBet = choice;
        return choice;
    }
}

class AI extends Player {
    public AI(String name) {
        super(name);
    }

    @Override
    public String next() {
        String choice = bet[(int) (Math.random() * 3)];
        lastBet = choice;
        System.out.println(getName() + " >> " + choice);
        return choice;
    }
}
