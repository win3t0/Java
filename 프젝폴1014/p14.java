package project;

import java.util.Scanner;

public abstract class p14 {
    private p14 next;

    public p14() {
        next = null;
    }

    public void setNext(p14 obj) {
        next = obj;
    }

    public p14 getNext() {
        return next;
    }

    public abstract void draw();

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}

class Line extends p14 {
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends p14 {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends p14 {
    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    private p14 head;

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

    private void insertShape(Scanner sc) {
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        int draw = sc.nextInt();
        p14 shape = null;

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

        shape.setNext(head);
        head = shape;
    }


    private void deleteShapeAtPosition(Scanner sc) {
        System.out.print("삭제할 도형의 위치>>");
        int position = sc.nextInt();

        if (position < 1) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        if (head == null) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        if (position == 1) {
            head = head.getNext();
            return;
        }

        p14 current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current.getNext() == null) {
                System.out.println("삭제할 수 없습니다.");
                return;
            }
            current = current.getNext();
        }

        if (current.getNext() == null) {
            System.out.println("삭제할 수 없습니다.");
        } else {
            current.setNext(current.getNext().getNext());
        }
    }


    private void showAllShapes() {
        if (head == null) {
            System.out.println("출력할 도형이 없습니다.");
            return;
        }

        p14 current = head;
        while (current != null) {
            current.draw();
            current = current.getNext();
        }
        System.out.println();
    }
}
