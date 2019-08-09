package ru.job4j.oop;

public class Cat {
    private String food;
    private String nick;

    public void show() {
        System.out.print(this.nick + " ");
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.nick = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's name and food.");
        Cat gav = new Cat();
        gav.giveNick("cat Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's name and food.");
        Cat black = new Cat();
        black.giveNick("Black Cat");
        black.eat("fish");
        black.show();
    }
}
