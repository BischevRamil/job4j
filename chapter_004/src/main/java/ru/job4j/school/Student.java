package ru.job4j.school;

import java.util.Comparator;

public class Student {
    String secondName;
    private int score;

    public Student(String secondName, int score) {
        this.secondName = secondName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Student{"
                + "Name=" + secondName
                + ", score='" + score + '\''
                + '}';
    }
}
