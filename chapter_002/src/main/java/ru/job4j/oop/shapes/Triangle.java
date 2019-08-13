package ru.job4j.oop.shapes;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +\n");
        pic.append("  +  +\n");
        pic.append("+     +\n");
        pic.append("+++++++");
        return pic.toString();
    }
}
