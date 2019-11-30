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
        int index = 0;
        for (Task t: tasks) {
            if (task.getPriority() < t.getPriority()) {
                tasks.add(index, task);
                break;
            }
            index++;
        }
        //tasks.add(index, task);
        if (index == tasks.size()) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
