package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int monthly, double percent) {
        int year = 0;
        boolean isClose = false;
        while (!isClose) {
            if ((monthly * 12) >= amount+(amount * (percent / 100))) {
                isClose = true;
                year++;
                break;
            }
            year++;
            amount = amount-(monthly*12);
        }
        return year;
    }
}
