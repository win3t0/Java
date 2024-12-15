package week7_homework;

interface Shape{
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("___ 다시 그립니다. ");
		draw();
	}
}

class Circle2 implements Shape{
	int radius;
	public Circle2(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println("반지름이 "+radius+"인 원");
	}
	
	public double getArea() {
		return PI * (int)Math.pow(radius, 2);
	}
}

class Oval implements Shape{
	int x, y;
	public Oval(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println(x+"x"+y+" 사각형에 내접하는 타원");
	}
	
	public double getArea() {
		return PI * (x/2) * (y/2);
	}
}

class Rectt implements Shape{
	int x, y;
	public Rectt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println(x+"x"+y+" 크기의 사각형");
	}
	
	public double getArea() {
		return x * y;
	}
}

public class test15 {
	public static void main(String[] args) {
		Shape [] list = new Shape[3];
		list[0] = new Circle2(5);
		list[1] = new Oval(20,30);
		list[2] = new Rectt(10,40);
		for (int i = 0; i < list.length; i++) {
			list[i].redraw();
		}
		for (int i = 0; i < list.length; i++) {
			System.out.println("면적은 " + list[i].getArea());
		}
	}
}
