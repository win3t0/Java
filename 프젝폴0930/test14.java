package week5_homework;

import java.util.Iterator;

class VArray {
    private int[] array; // 내부 배열
    int capacity; // 현재 배열 용량
    private int count; // 저장된 개수

    // 생성자: 초기 용량으로 배열 생성
    public VArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = new int[capacity];
        this.count = 0;
    }

    // 배열의 크기 반환
    public int size() {
        return count;
    }

    // 배열에 값 추가
    public void add(int value) {
        if (count >= capacity) {
            resize(); // 배열 크기 늘리기
        }
        array[count++] = value; // 값 추가 후 count 증가
    }

    // 특정 인덱스에 값 삽입
    public void insert(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (count >= capacity) {
            resize(); // 배열 크기 늘리기
        }
        // 오른쪽으로 이동
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value; // 값 삽입
        count++; // count 증가
    }

    // 특정 인덱스의 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1]; // 왼쪽으로 이동
        }
        count--; // count 감소
        array[count] = 0; // 마지막 값 초기화 (옵션)
    }

    // 배열 크기 늘리기
    private void resize() {
        capacity *= 2; // 용량 두 배 증가
        int[] newArray = new int[capacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i]; // 기존 값 복사
        }
        array = newArray; // 새 배열로 변경
    }

    // 배열의 모든 값 출력
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


public class test14 {
	public static void main(String[] args) {
		VArray v = new VArray(5);
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		
		for (int i = 0; i < 7; i++) // 7개 저장
			v.add(i);	// 배열의 순서대로 정수 i 값 저장
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
		
		v.insert(3, 100);	// 배열의 인덱스 3에 100삽입
		v.insert(5, 200);	// 배열의 인덱스 5에 200삽입
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
		
		v.remove(10);	// 배열의 인덱스 10의 정수 삭제
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
		
		for (int i = 50; i < 55; i++) // 5개 저장
			v.add(i);	// 배열의 순서대로 정수 i 값 저장
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
	}
}
