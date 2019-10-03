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
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else {
            var i = 0;
            for (var item:tasks) {
                if (task.getPriority() > item.getPriority()) {
                    i++;
                } else {
                    break;
                }
            }
            tasks.add(i, task);
        }
    }


    public Task take() {
        return this.tasks.poll();
    }
}
