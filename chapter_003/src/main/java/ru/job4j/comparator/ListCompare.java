package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int l1 = left.length();
        int l2 = right.length();
        int lmin = Math.min(l1, l2);
        int charCompare = 0;
        for (int i = 0; i < lmin; i++) {
            charCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (charCompare != 0) {
                break;
            }
        }
        return charCompare != 0 ? charCompare : l1 - l2;
    }
}
