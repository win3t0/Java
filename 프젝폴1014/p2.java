package project;


class SmartTV extends ColorTV{
	String ip;
	
	public SmartTV(String ip, int size, int color) {
		super(size, color);
		this.ip = ip;
	}
	
	void printProperty() {
		System.out.println("나의 SmartTV는 "+ip+" 주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}
}

public class p2 {
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000);
		smartTV.printProperty();
	}
}

