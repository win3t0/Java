package week5_homework;

class Cube{
	private int width, depth, height;
	public Cube(int width, int depth, int height){
		this.width = width;
		this.depth = depth;
		this.height = height;
	}
	
	int getVolume() {
		return this.width * this.depth * this.height;
	}
	
	void increase(int widthUp, int depthUp, int heightUp) {
		this.width += widthUp;
		this.depth += depthUp;
		this.height += heightUp;
	}
	
	boolean isZero() {
		return (getVolume() == 0);
	}
}

public class test2 {
	public static void main(String[] args) {
		Cube cube = new Cube(1,2,3);
		System.out.println("큐브의 부피는 " + cube.getVolume());
		cube.increase(1, 2, 3);
		System.out.println("큐브의 부피는 " + cube.getVolume());
		if(cube.isZero())
			System.out.println("큐브의 부피는 0");
		else
			System.out.println("큐브의 부피는 0이 아님");
	}
}
