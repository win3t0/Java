package week5_homework;

class Rectangle{
	int x, y, width, height;

	public Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
	
	boolean isSquare() {
		return width == height;
	}
	
	boolean contains(Rectangle r) {
		return this.x <= r.x 
				&& this.y <= r.y 
				&& this.width >= width
				&& this.height >= height;
	}
	
}

public class test6 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(3, 3, 6, 6);
		Rectangle b = new Rectangle(4, 4, 6, 6);
		
		a.show();
		if(a.isSquare()) System.out.println("a는 정사각형입니다.");
		else System.out.println("a는 직사각형입니다.");
		if(a.contains(b)) System.out.println("a는 b를 포함합니다");
	}
}
