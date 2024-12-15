package week5_homework;

import java.util.Scanner;

class Song{
	String title;
	String singer;
	String year;
	String lang;
	
	public Song(String title, String singer, String year, String lang) {
		super();
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
	}
	
	void show() {
		System.out.println(year+"년 "+lang+"의 "+singer+"이(가) 부른 "+title);
	}
	
}

public class test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("노래제목, 가수이름, 발표년도, 가수나라을 입력해하세요>>");
		String title = sc.next();
		String singer = sc.next();
		String year = sc.next();
		String lang = sc.next();
		Song song = new Song(title,singer,year,lang);
		song.show();
		sc.close();
	}
}
