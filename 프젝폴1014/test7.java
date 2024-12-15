package week7_homework;

class Point3DColor extends Point{
	private int z;
	private String color;
	
	public Point3DColor(int x, int y, int z, String color) {
		super(x,y);
		this.z = z;
		this.color = color;
	}
	
	void move(Point3DColor point) {
		move(point.getX(),point.getY());
		this.z = point.z;
	}
	
	public String toString() {
		String str = "("+getX()+","+getY()+","+z+")"+color+"의 점";
		return str;
	}
	
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point3DColor point = (Point3DColor) obj;
        return getX() == point.getX() &&
        		getY() == point.getY() &&
        		z == point.z && color.equals(point.color);
    }
}

public class test7 {
	public static void main(String[] args) {
		Point3DColor p = new Point3DColor(10,20,30,"RED");
		System.out.println(p.toString()+"입니다.");
		
		Point3DColor q = new Point3DColor(1,2,3,"BLUE");
		p.move(q);
		System.out.println(p.toString()+"입니다.");
		
		Point3DColor r = new Point3DColor(1,2,3,"RED");
		System.out.println(r.toString()+"입니다.");
		if(p.equals(r))
			System.out.println("예. 같은 위치 같은 색깔의 점입니다");
		else
			System.out.println("아니오");
	}
}
