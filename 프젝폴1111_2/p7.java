package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test7 {
	public static void main(String[] args) {
		File src = new File("c:\\temp\\heart.png");
		File dest = new File("c:\\temp\\b.png");
		
		long fileSize = src.length();
		int count = 0;
		int point = (int)fileSize/10;
		int c;
		
		System.out.println("a.jpg를 b.jpg로 복사합니다.");
		System.out.println("10%마다 *를 출력합니다");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
				count++;
				
				if(point == count) {
					System.out.print("*");
					point += (int)fileSize/10;
				}
			}
			fi.close();
			fo.close();
		}
		catch (Exception e) {
			System.out.println("파일 복사 오류");
		}
	}
}
