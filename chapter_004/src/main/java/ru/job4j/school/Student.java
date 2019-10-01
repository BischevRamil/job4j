package ru.job4j.school;

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
}
