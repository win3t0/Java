package project;

import java.util.Iterator;

class VArray {
    private int[] array;
    int capacity;
    private int count;

    public VArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = new int[capacity];
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public void add(int value) {
        if (count >= capacity) {
            resize();
        }
        array[count++] = value; // 값 추가 후 count 증가
    }

    public void insert(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (count >= capacity) {
            resize();
        }
	    
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        count++;
    }


    public void remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--; // count 감소
        array[count] = 0;
    }


    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }


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
			v.add(i);	
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
		
		v.insert(3, 100);	
		v.insert(5, 200);	
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
		
		v.remove(10);	
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
		
		for (int i = 50; i < 55; i++) // 5개 저장
			v.add(i);	
		System.out.println("용량: " + v.capacity + ", 저장된 개수: " + v.size());
		v.printAll();
	}
}
