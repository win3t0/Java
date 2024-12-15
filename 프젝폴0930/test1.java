package week5_homework;
class TV {
	String maker;
	int price, inch;
	
	TV(String maker,int inch, int price) {
		this.maker = maker;
		this.inch = inch;
		this.price = price;
	}
	void showTV() {
		System.out.println(maker+"에서 만든 "+price+"만원짜리의 "+inch+"인치 TV");
	}
	
}
public class test1 {
	public static void main(String[] args) {
		TV tv = new TV("samsung",50,300);
		tv.showTV();
	}
}
