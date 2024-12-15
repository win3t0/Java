package week7_homework;

import java.util.Scanner;

public abstract class test14 {
    private test14 next;

    public test14() {
        next = null;
    }

    public void setNext(test14 obj) {
        next = obj;
    }

    public test14 getNext() {
        return next;
    }

    public abstract void draw();

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}

class Line extends test14 {
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends test14 {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends test14 {
    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    private test14 head;

    public GraphicEditor() {
        head = null;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");

        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4)>>");
            int answer = sc.nextInt();

            if (answer == 1) {
                insertShape(sc);
            } 
            else if (answer == 2) {
                deleteShapeAtPosition(sc);
            } 
            else if (answer == 3) {
                showAllShapes();
            } 
            else if (answer == 4) {
                System.out.println("Beauty Graphic Editor를 종료합니다.");
                break;
            } 
            else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        sc.close();
    }

    // 삽입 기능: 새로운 도형을 리스트 맨 앞에 추가
    private void insertShape(Scanner sc) {
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        int draw = sc.nextInt();
        test14 shape = null;

        if (draw == 1) {
            shape = new Line();
        } else if (draw == 2) {
            shape = new Rect();
        } else if (draw == 3) {
            shape = new Circle();
        } else {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        shape.setNext(head); // 새 도형의 next를 현재 head로 설정
        head = shape;        // head를 새 도형으로 갱신
    }

    // 특정 위치에 있는 도형 삭제
    private void deleteShapeAtPosition(Scanner sc) {
        System.out.print("삭제할 도형의 위치>>");
        int position = sc.nextInt();

        if (position < 1) { // 유효하지 않은 위치
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        if (head == null) { // 리스트가 비어 있을 때
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        if (position == 1) { // 첫 번째 위치 삭제
            head = head.getNext();
            return;
        }

        // 위치가 2 이상일 때 해당 위치의 이전 노드를 찾아 삭제
        test14 current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current.getNext() == null) {
                System.out.println("삭제할 수 없습니다.");
                return;
            }
            current = current.getNext();
        }

        // 삭제할 노드가 존재하지 않는 경우
        if (current.getNext() == null) {
            System.out.println("삭제할 수 없습니다.");
        } else {
            current.setNext(current.getNext().getNext()); // 삭제 노드를 건너뛰기
        }
    }

    // 모두 보기 기능: 리스트의 모든 도형 출력
    private void showAllShapes() {
        if (head == null) {
            System.out.println("출력할 도형이 없습니다.");
            return;
        }

        test14 current = head;
        while (current != null) {
            current.draw();
            current = current.getNext();
        }
        System.out.println();
    }
}
