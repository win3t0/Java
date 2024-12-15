package project;

import java.io.File;
import java.util.Scanner;

public class p13 {
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
        String src = "c:\\";

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[" + src + "]");
            listDirectory(new File(src));

            System.out.print(">> ");
            String answer = sc.nextLine().trim();

            if (answer.equals("그만")) {
                break;
            }

            if (answer.equals("..")) {
                File currentDir = new File(src);
                String parent = currentDir.getParent();
                if (parent != null) {
                    src = parent;
                } else {
                    System.out.println("상위 디렉터리가 없습니다.");
                }
            } else {
                String nextPath = src + "\\" + answer;
                File nextDir = new File(nextPath);

                if (nextDir.exists() && nextDir.isDirectory()) {
                    src = nextPath;
                } else {
                    System.out.println("디렉터리가 존재하지 않습니다: " + nextPath);
                }
            }
        }

        sc.close();
        System.out.println("파일 탐색기를 종료합니다.");
    }
}
