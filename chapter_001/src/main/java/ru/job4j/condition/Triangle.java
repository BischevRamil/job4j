package ru.job4j.condition;

/**
 * Класс Triangle, который вычисляет площадь треугольника.
 * Расстояние между вершинами вычисляется с помощью метода distance класса Point.
 *
 * @author Bischev Ramil
 * @version 1.0
 * @since 09-08-2019
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     *
     * @param a, b, c расстояние между вершинами треугольника
     * @return полупериод, необходимый для вычисления площади треугольника
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }


    private boolean exist(double a, double c, double b) {
        return a > 0 & b > 0 & c > 0 & a + b > c & a + c > b & b + c > a;
    }


    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ca = third.distance(first);
        double p = period(ab, bc, ca);
        if (this.exist(ab, bc, ca)) {
            // написать формулу для расчета площади треугольника.
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
        }
        return rsl;
    }
}
