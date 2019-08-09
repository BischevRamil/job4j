package ru.job4j.oop.profession;

public class Engineer extends Profession {
    private String degree;

    public Engineer(String name, String surname, String education, String birthday, String degree) {
        super(name, surname, education, birthday);
        this.degree = degree;
    }

    public String getPhdDegree() {
        return this.degree;
    }

    public boolean knowMath() {
        return true;
    }
}
