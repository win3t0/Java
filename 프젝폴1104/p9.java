package project;

import java.util.Random;
import java.util.Scanner;

public class p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char[][] grid = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }

        System.out.print("단어>>");
        String input = sc.nextLine();

        if (input.length() > 5) {
            System.out.println("5자리 이하의 단어만 입력 가능합니다.");
            return;
        }

        int direction = random.nextInt(3);
        int row, col;
        boolean validStart;

        do {
            row = random.nextInt(5);
            col = random.nextInt(5);

            validStart = switch (direction) {
                case 0 -> col + input.length() <= 5;
                case 1 -> row + input.length() <= 5;
                case 2 -> row + input.length() <= 5 && col + input.length() <= 5;
                default -> false;
            };
        } while (!validStart);

        for (int i = 0; i < input.length(); i++) {
            grid[row][col] = input.charAt(i);
            switch (direction) {
                case 0 -> col++;
                case 1 -> row++;
                case 2 -> { row++; col++; }
            }
        }

        fillEmptySpaces(grid, random);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillEmptySpaces(char[][] grid, Random random) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = (char) ('a' + random.nextInt(26));
                }
            }
        }
    }
}
