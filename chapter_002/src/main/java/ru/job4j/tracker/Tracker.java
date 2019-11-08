package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Array for storing items
     */
    private final Item[] items = new Item[100];
    /**
     * Point for new item
     */
    private int position = 0;
    /**
     * Method for adding items into container
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
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
        for (int index = 0; index < this.items.length; index++) {
            Item im = this.items[index];
            if (im.getId().equals(id)) {
                item.setId(im.getId());
                this.items[index] = item;
                result = true;
                break;
            }
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
        for (int index = 0; index < this.items.length; index++) {
            Item im = this.items[index];
            if (im.getId().equals(id)) {
                if (index + 1 < this.items.length && index - 1 >= -1) {
                    System.arraycopy(items, index + 1, items, index, this.items.length - index - 1);
                }
                result = true;
                break;
            }
        }
        /*String nam;
        for (Item im : this.items) {
            nam = im.getName();
        }*/
        return result;
    }

    /**
     * Method for looking for all items
     * @return - array with all items
     */
    public Item[] findAll() {
        int countNull = 0;
        for (Item im : this.items) {
            if (im == null) {
                countNull++;
            }
        }
        Item[] result = new Item[this.items.length - countNull];
        int index = 0;
        for (Item im : this.items) {
            if (im != null) {
                result[index++] = im;
            }
        }
        return result;
    }

    /**
     * Method for looking for item by name
     * @param key - name of searched item
     * @return - founded items
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[this.items.length];
        int index = 0;
        int countCoinc = 0;
        for (Item im : this.items) {
            if (im != null && im.getName().equals(key)) {
                tmp[index++] = im;
                countCoinc++;
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
