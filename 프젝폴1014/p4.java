package project;
class ColorPoint2 extends Point{
	String color;
	
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
	
	public double getDistance(ColorPoint2 criticalPoint){
		return Math.sqrt(Math.pow(criticalPoint.getX() - this.getX(), 2) + 
				Math.pow(criticalPoint.getY() - this.getY(), 2));
	}
}

public class p4 {
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
