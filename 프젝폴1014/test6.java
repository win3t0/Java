package week7_homework;
//상속받은 Point 클래스는 test3에서 확인
class PositivePoint extends Point{
	public PositivePoint(int x, int y){
		super((x < 1) ? 1 : x, (y < 1) ? 1 : y);
	}
	
	public String toString() {
		String str = "("+getX()+","+getY()+")의 점";
		return str;
	}
	
	protected void move(int x, int y) {
		if(x >= 1 && y >= 1)
			super.move(x, y);
	}
}

public class test6 {
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint(10,10);
		p.move(5,5);
		System.out.println(p.toString() + "입니다.");
		
		p.move(2,-2);
		System.out.println(p.toString() + "입니다.");
		
		PositivePoint q = new PositivePoint(-10, -10);
		System.out.println(q.toString() + "입니다.");
	}
}
