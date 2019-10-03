package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (var person: persons) {
            if (person.getSurname().contains(key) || person.getName().contains(key) || person.getAddress().contains(key) || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
