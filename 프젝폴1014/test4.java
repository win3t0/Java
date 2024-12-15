package week7_homework;
//상속받은 Point 클래스는 test3에서 확인
class ColorPoint2 extends Point{
	String color;
	
	// 오버로딩 : 같은 이름의 메소드를 인수의 갯수나 데이터 타입을 바꾸어 여러개 만들 수 있음
	public ColorPoint2() {
		super(0,0);
		color = "WHITE";
	}
	
	public ColorPoint2(int x, int y) {
		super(x, y);
		color = "BLACK";
	}
	
	public ColorPoint2(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	void set(int x, int y) {
		move(x, y);
	}
	
	void set(String color) { 
		this.color = color;
	}
	
	public String toString() {
		String str = color+"색의 ("+getX()+","+getY()+")의 점";
		return str;
	}
	
	// 두 점 사이의 거리는 유클리드 거리 공식 활용
	public double getDistance(ColorPoint2 criticalPoint){
		return Math.sqrt(Math.pow(criticalPoint.getX() - this.getX(), 2) + 
				Math.pow(criticalPoint.getY() - this.getY(), 2));
	}
}

public class test4 {
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2();
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10,10,"RED");
		cp.set("BLUE");
		cp.set(10,20);
		System.out.println(cp.toString() + "입니다.");
		
		ColorPoint2 thresholdPoint = new ColorPoint2(100,100);
		System.out.println("cp에서 임계점까지의 거리는 "+cp.getDistance(thresholdPoint));
	}
}
