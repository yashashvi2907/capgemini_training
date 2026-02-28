package oops_concept;

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Day11_Abstraction {

    public static void main(String[] args) {

        Shape s = new Circle();
        s.draw();
    }
}