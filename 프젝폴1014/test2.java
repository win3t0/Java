package week7_homework;
// 다른 클래스(TV, ColorTV)는 test1에 있으니 그것을 활용하기 바람

class SmartTV extends ColorTV{
	String ip;
	
	public SmartTV(String ip, int size, int color) {
		// 자식 생성자를 만들때 반드시 부모 생성자를 '먼저' 호출해야 한다
		super(size, color);
		this.ip = ip;
	}
	
	//오버라이딩 부모클래스의 메소드를 다시작성 매개변수, 리턴타입 동일
	void printProperty() {
		System.out.println("나의 SmartTV는 "+ip+" 주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}
}

public class test2 {
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000);
		smartTV.printProperty();
	}
}

