package chapter6;

class Student{
	String name;
	int id;
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public boolean equals(Object obj) {
		Student a = (Student)obj;
		if(name == a.name && a.id == id)
			return true;
		return false;
		
	}
	
	public String toString() {
		return "학번이 " + id + "인 " + name;
	}
	
}

public class test1 {
	public static void main(String[] args) {
		Student a = new Student("황기태", 23);
		Student b = new Student("황기태", 77);
		System.out.println(a);
		if(a.equals(b))
			System.out.println("같은 학생입니다");
		else
			System.out.println("다른 학생입니다");
	}
}
