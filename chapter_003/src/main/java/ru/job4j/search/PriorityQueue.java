package ru.job4j.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() <= tasks.get(i).getPriority()) {
                    tasks.add(i, task);
                    return;
                }
            }
            tasks.addLast(task);
        }
//        tasks.sort(new Comparator<Task>() {
//            @Override
//            public int compare(Task t1, Task t2) {
//                return t1.getPriority() - t2.getPriority();
//            }
//        });
    }


    public Task take() {
        return this.tasks.poll();
    }
}
