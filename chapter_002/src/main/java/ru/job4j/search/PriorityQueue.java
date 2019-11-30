package ru.job4j.search;

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
        for (int i = 0; i < tasks.size(); i++) {
             Task t = tasks.get(i);
             if (task.getPriority() < t.getPriority()) {
                 tasks.add(i, task);
                 break;
             }
             if (i == tasks.size() - 1) {
                 tasks.add(task);
             }
        }
        if (tasks.size() == 0) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
