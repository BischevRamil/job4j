package ru.job4j.array;

/**
 * Класс проверяет заканчиватеся ли слово данным префиксом
 * @author Bischev Ramil
 * @since 06-08-2019
 * @version 1.0
 */

public class EndWith {
    /**
     * Проверяет. что слово заканчивается префиксом.
     * @param post префикс.
     * @return если слово заканчивается префиксом
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        int n = wrd.length-pst.length;
        for (int i=wrd.length-1; i>=n; i--) {
            if (wrd[i]!=pst[i-n]){
                result=false;
                break;
            }
        }
        return result;
    }
}
