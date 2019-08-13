package ru.job4j.oop.shapes;

public class Paint {

    public static void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Square square = new Square();
        draw(square);
        Triangle triangle = new Triangle();
        draw(triangle);
    }
}
