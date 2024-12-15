package week7_homework;

// 부모 클래스 Point는 test3.java
class Point3D extends Point{
	int z;
	//생성자를 입력할 때 반환식을 입력하지 않는다
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	void moveUp(int z) {
		this.z += z;
	}

	void moveDown(int z) {
		this.z -= z;
	}

	void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}
	
	public String toString() {
		String str = "("+getX()+","+getY()+","+z+")의 점";
		return str;
	}
}

public class test5 {
	public static void main(String[] args) {
		Point3D p = new Point3D(3,2,1);
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(3);
		System.out.println(p.toString() + "입니다.");
		p.moveDown(2);
		System.out.println(p.toString() + "입니다.");
		p.move(5,5);
		System.out.println(p.toString() + "입니다.");
		p.move(100,200,300);
		System.out.println(p.toString() + "입니다.");
	}
}
