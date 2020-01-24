package collections;

import java.util.*;

/**
 * Имеется n пользователей, каждому из них соответствует список email-ов
 * (всего у всех пользователей m email-ов).
 * Например:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
 * user2 ->foo@gmail.com,ups@pisem.net
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 * user4 ->ups@pisem.net,aaa@bbb.ru
 * user5 ->xyz@pisem.net
 *
 * Считается, что если у двух пользователей есть общий email, значит это
 * один и тот же пользователь. Требуется построить
 * и реализовать алгоритм, выполняющий слияние пользователей. На выходе
 * должен быть список пользователей с их email-ами (такой же как на
 * входе).
 * В качестве имени объединенного пользователя можно брать любое из
 * исходных имен. Список email-ов пользователя должен содержать только
 * уникальные email-ы.
 * Параметры n и m произвольные, длина конкретного списка email-ов никак
 * не ограничена.
 * Требуется, чтобы асимптотическое время работы полученного решения было
 * линейным, или близким к линейному.
 *
 * Возможный ответ на задачу в указанном примере:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 *
 * Поля:
 *      userMap: входящее отображение.
 *      resultMap: результирующее отображение.
 *
 */
public class Post {
    private Map<String, HashSet<String>> userMap;
    private Map<String, HashSet<String>> resultMap;

    Post() {
        this.userMap = new HashMap<>();
        this.resultMap = new HashMap<>();
    }

    public void add(String user, HashSet<String> adresses) {
        this.userMap.put(user, adresses);
    }

    /**
     * Метод строит результирующее отображение.
     * @return результирующее отображение.
     */
    public Map<String, HashSet<String>> run() {
        for (Map.Entry<String, HashSet<String>> entrySet : userMap.entrySet()) {
            if (!concat(entrySet.getValue())) {
                this.resultMap.put(entrySet.getKey(), entrySet.getValue());
            }
        }
        return this.resultMap;
    }

    /**
     * Метод добавляет проверяемый сет в результирующее отображение, если есть совпадение строк.
     * @param set Проверяемый сет.
     * @return true, если сет добавился в отображение.
     */
    private boolean concat(HashSet<String> set) {
        boolean rst = false;
        if (!this.resultMap.isEmpty()) {
            for (Map.Entry<String, HashSet<String>> entrySet : resultMap.entrySet()) {
                if (entrySet.getValue().stream().anyMatch(set::contains)) {
                    HashSet<String> tempSet = new HashSet<>(entrySet.getValue());
                    tempSet.addAll(set);
                    this.resultMap.put(entrySet.getKey(), tempSet);
                    rst = true;
                    break;
                }
            }
        }
        return rst;
    }
}
