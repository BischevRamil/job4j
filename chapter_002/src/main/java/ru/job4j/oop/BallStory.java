package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare zayac = new Hare();
        Wolf volk = new Wolf();
        Fox lisa = new Fox();
        System.out.print("Зайц пытался съесть ");
        zayac.tryEat(kolobok);
        System.out.print("Волк пытался съесть ");
        volk.tryEat(kolobok);
        System.out.print("Лиса пыталась съесть ");
        lisa.tryEat(kolobok);
    }
}
