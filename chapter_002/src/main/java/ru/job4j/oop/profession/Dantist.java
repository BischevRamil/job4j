package ru.job4j.oop.profession;

public class Dantist extends Doctor {

    public Dantist(String name, String surname, String education, String birthday, String internship) {
        super(name, surname, education, birthday, internship);
    }

    public int countTeeth(Pacient pacient) {
        return 32;
    }
}