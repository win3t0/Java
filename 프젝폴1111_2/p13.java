package chapter8;

import java.io.File;
import java.util.Scanner;

public class test13 {
    // 디렉터리 내 파일과 폴더를 출력하는 메소드
    public static void listDirectory(File dir) {
        File[] subFiles = dir.listFiles();

        if (subFiles == null) {
            System.out.println("디렉터리를 읽을 수 없습니다.");
            return;
        }

        for (int i = 0; i < subFiles.length; i++) {
            File f = subFiles[i];
            String res = (f.isFile() ? "file" : "dir");
            System.out.print(res);
            System.out.print("\t" + f.length() + "바이트");
            System.out.printf("\t\t%20s", f.getName());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("***** 파일 탐색기입니다. *****");
        String src = "c:\\"; // 초기 디렉토리 설정

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 현재 디렉토리 출력
            System.out.println("[" + src + "]");
            listDirectory(new File(src)); // 디렉토리 목록 출력

            System.out.print(">> ");
            String answer = sc.nextLine().trim(); // 사용자 입력 받기

            // 종료 조건
            if (answer.equals("그만")) {
                break;
            }

            // 상위 디렉터리로 이동
            if (answer.equals("..")) {
                File currentDir = new File(src);
                String parent = currentDir.getParent(); // 상위 디렉터리 경로 가져오기
                if (parent != null) {
                    src = parent; // 상위 디렉터리로 이동
                } else {
                    System.out.println("상위 디렉터리가 없습니다.");
                }
            } else {
                // 하위 디렉터리로 이동
                String nextPath = src + "\\" + answer;
                File nextDir = new File(nextPath);

                if (nextDir.exists() && nextDir.isDirectory()) {
                    src = nextPath; // 하위 디렉터리로 이동
                } else {
                    System.out.println("디렉터리가 존재하지 않습니다: " + nextPath);
                }
            }
        }

        sc.close();
        System.out.println("파일 탐색기를 종료합니다.");
    }
}
