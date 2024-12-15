package project;

import java.util.Scanner;

public class openChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] hist = new int[26];
        String line;

        System.out.println("영문을 입력하고 세미콜론을 입력하세요");

        while (true) {
            line = sc.nextLine().trim();

            if (line.equals(";")) {
                break;
            }


            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);


                if (Character.isLetter(ch)) {
                    ch = Character.toLowerCase(ch);
                    hist[ch - 'a']++;
                }
            }
        }


        System.out.println("\n알파벳 히스토그램:");
        for (int i = 0; i < hist.length; i++) {
        	System.out.println((char) (i + 'a') + ": " + hist[i]);
        }

        sc.close();
    }
}

