package ru.job4j.department;

import java.util.*;

/**
 * @author ramil bischev
 * @since 2019-10-01
 */

public class SortDept {

    //Сортировка по возрастанию
    public List<Dept> sortAscending(List<Dept> list) {
        List<Dept> deptList = addMissingDept(new ArrayList<>(list));
        Comparator<Dept> comparator = new Comparator<Dept>() {
            @Override
            public int compare(Dept dept1, Dept dept2) {
                return dept1.getName().compareTo(dept2.getName());
            }
        };
        deptList.sort(comparator);
        return deptList;
    }

    //Сортировка по убыванию
    public List<Dept> sortDescending(List<Dept> list) {
        List<Dept> deptList = addMissingDept(new ArrayList<>(list));
        Comparator<Dept> comparator = new Comparator<Dept>() {
            @Override
            public int compare(Dept dept1, Dept dept2) {
                int result = 0;
                int temp = Math.min(dept1.getName().length(), dept2.getName().length());
                for (int i = 0; i < temp; i++) {
                    if (dept1.getName().charAt(i) > dept2.getName().charAt(i)) {
                        return -1;
                    } else {
                        result = dept1.getName().length() - dept2.getName().length();
                    }
                }
                return result;
            }
        };
        deptList.sort(comparator);
        return deptList;
    }

    //Метод добавляет отстутствующие департаменты
    private List<Dept> addMissingDept(List<Dept> deptList) {
        Set<String> tempSet = new TreeSet<>();
        for (Dept dept:deptList) {
            tempSet.add(dept.getName());
        }
        String name;
        for (Dept dept:deptList) {
            for (int i = 0; i < dept.getName().length(); i++) {
                if (dept.getName().charAt(i) == '\\') {
                    name = dept.getName().substring(0, i);
                    tempSet.add(name);
                }
            }
        }
        List<Dept> newListDept = new ArrayList<>();
        for (String str:tempSet) {
            newListDept.add(new Dept(str));
        }
        return newListDept;
    }
}
