package chapter6;
import java.util.Random;
import java.util.Scanner;

public class test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // 5x5 배열 선언
        char[][] grid = new char[5][5];

        // 배열 초기화 (빈 칸을 '.'으로 설정)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }

        // 사용자로부터 문자열 입력받기
        System.out.print("단어>>");
        String input = sc.nextLine();

        // 입력 유효성 검사
        if (input.length() > 5) {
            System.out.println("5자리 이하의 단어만 입력 가능합니다.");
            return;
        }

        // 방향 무작위 선택 (0: 가로, 1: 세로, 2: 대각선)
        int direction = random.nextInt(3);

        // 시작 위치 무작위 선택
        int row, col;
        boolean validStart = false;

        do {
            row = random.nextInt(5);
            col = random.nextInt(5);

            // 시작 위치가 유효한지 확인
            validStart = switch (direction) {
                case 0 -> col + input.length() <= 5;              // 가로
                case 1 -> row + input.length() <= 5;              // 세로
                case 2 -> row + input.length() <= 5 && col + input.length() <= 5; // 대각선
                default -> false;
            };
        } while (!validStart);

        // 단어를 배열에 배치
        for (int i = 0; i < input.length(); i++) {
            grid[row][col] = input.charAt(i);
            switch (direction) {
                case 0 -> col++; // 가로
                case 1 -> row++; // 세로
                case 2 -> { row++; col++; } // 대각선
            }
        }

        // 나머지 빈 칸을 무작위 소문자로 채우기
        fillEmptySpaces(grid, random);

        // 결과 출력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 빈 칸을 무작위 소문자로 채우기
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
