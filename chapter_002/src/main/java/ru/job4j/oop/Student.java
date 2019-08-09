package ru.job4j.oop;

/**
 * Класс Student, который умеет играть на баяне и петь песню
 * @author Bischev Ramil
 * @version 1.0
 * @since 09-08-2019
 *
 */

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe i can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();

    }
}
