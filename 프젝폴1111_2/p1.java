package project;

import java.io.*;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File dir = new File("c:\\temp");
        
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        try (FileWriter fout = new FileWriter("c:\\temp\\phone.txt")) {
            System.out.println("전화번호 입력 프로그램입니다");
            
            while (true) {
                System.out.print("이름 전화번호>>");
                String line = sc.nextLine();
                if (line.equals("그만"))
                    break;
                fout.write(line + "\r\n");
            }
            
            System.out.println("c:\\temp\\phone.txt에 저장하였습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장이 안됩니다");
        } finally {
            sc.close();
        }
    }
}
