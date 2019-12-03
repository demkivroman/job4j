package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Array for storing items
     */
    private final ArrayList<Item> items = new ArrayList<Item>();
    /**
     * Point for new item
     */
    private int position = 0;
    /**
     * Method for adding items into container
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        position++;
        return item;
    }

    /**
     * Method for replacing one item to enother
     * @param id - unique id of item which need be replaced
     * @param item - item to which replace
     * @return - result of operation
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = 0;
        for (Item im : items) {
            if (im.getId().equals(id)) {
                item.setId(im.getId());
                this.items.set(index, item);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Method for deleting item
     * @param id - key for deleting item
     * @return - result of operation
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item im : this.items) {
            if (im.getId().equals(id)) {
                this.items.remove(im);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * Method for looking for all items
     * @return - array with all items
     */
    public Item[] findAll() {
        List<Item> temp = new ArrayList<>();
        temp = this.items.subList(0, position);
        Item[] result = new Item[temp.size()];
        int index = 0;
        for (Item im : temp) {
            result[index++] = im;
        }
        return result;
    }

    /**
     * Method for looking for item by name
     * @param key - name of searched item
     * @return - founded items
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[this.items.size()];
        int countCoinc = 0;
        for (Item im : this.items) {
            if (im != null && im.getName().equals(key)) {
                tmp[countCoinc++] = im;
            }
        }

        return Arrays.copyOf(tmp, countCoinc);
    }

    /**
     * Method for looking for item by id
     * @param id - id of searched item
     * @return - founded item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item im : this.items) {
            if (im.getId().equals(id)) {
                result = im;
                break;
            }
        }
        return result;
    }

    /**
     * Method generate unique key for item
     * @return - unique key
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

}
