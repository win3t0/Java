package week5_homework;

public class test4 {
	int arr[] = new int[10];
	int count = 0;
	
	void put(int num) {
		if(count == 10) {
			System.out.println("값이 10개를 초과했습니다");
		}
		else {
			arr[count] = num;
			count++;
		}
	}
	
	void showAll() {
		for (int i = 0; i < count; i++) {
			 System.out.println(arr[i] + " ");
		}
	}
	
	float getAvg() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += arr[i];
		}
		return (float)(sum/(count-1));
	}
	
	public static void main(String[] args) {
		test4 avg = new test4();
		avg.put(10);
		avg.put(15);
		avg.put(100);
		avg.showAll();
		System.out.println("평균은 " + avg.getAvg());
	}
}
