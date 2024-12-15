package chapter6;

class Book{
	String author, title, buyer;

	public Book(String author, String title, String buyer) {
		super();
		this.author = author;
		this.title = title;
		this.buyer = buyer;
	}

	public boolean equals(Object obj) {
		Book b = (Book)obj;
		if(author == b.author && title == b.title)
			return true;
		return false;
	}
	
	public String toString() {
		return buyer + "이 구입한 도서: " + author + "의 " + title;
	}
}

public class test2 {
	public static void main(String[] args) {
		Book a = new Book("황기태", "명품자바", "김하진");
		Book b = new Book("황기태", "명품자바", "하여린");
		System.out.println(a);
		System.out.println(b);
		if(a.equals(b))
			System.out.println("같은 색");
		else
			System.out.println("다른 색");
	}
}
