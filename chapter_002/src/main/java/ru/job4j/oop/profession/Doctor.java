package ru.job4j.oop.profession;

public class Doctor extends Profession {
    private String internship;
    private int experience;

    public Doctor(String name, String surname, String education, String birthday, String internship) {
        super(name, surname, education, birthday);
        this.internship = internship;
    }

    public String getInternship() {
        return this.internship;
    }

    public int getMagicPowersLevel() {
        return this.experience;
    }

    public Diagnose heal(Pacient first) {
        return new Diagnose();
    }

    public void setMagicPowersLevel(int level) {
        this.experience = level;
    }
}
