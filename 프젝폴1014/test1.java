package week7_homework;

class TV{
	private int size;
	
	public TV(int size) {
		this.size = size;
	}
	
	protected int getSize() {
		return size;
	}
}

class ColorTV extends TV{
	int color;
	
	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	void printProperty() {
		// 상속을 받았더라도 접근자가 private라면 클래스 내부에서 밖에 접근할 수 없다
		// (그래서 get메서드 씀)
		System.out.println(getSize()+"인치 "+color+"컬러");
	}
	
}

public class test1 {
	public static void main(String[] args) {
		ColorTV myTv = new ColorTV(65, 65536);
		myTv.printProperty();
	}
}
