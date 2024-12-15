package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p4 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\phone.txt"))) {
            System.out.println("c:\\temp\\phone.txt을 읽어 출력합니다");
            
            String line;
            int count = 1;
            
            while ((line = br.readLine()) != null) {
                System.out.println(count++ + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
