package ru.job4j.tracker;

import java.util.*;

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
        int index = 0;
        for (Item im : this.items) {
            if (im.getId().equals(id)) {
                this.items.remove(index);
                result = true;
                position--;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Method for looking for all items
     * @return - array with all items
     */
    public Item[] findAll() {
        Item[] result = this.items.toArray(new Item[0]);
        return Arrays.copyOf(result, position - 1);
    }

    /**
     * Method for looking for item by name
     * @param key - name of searched item
     * @return - founded items
     */
    public Item[] findByName(String key) {
        List<Item> tmp = new LinkedList<>();
        int countCoinc = 0;
        for (Item im : this.items) {
            if (im != null && im.getName().equals(key)) {
                tmp.add(im);
            }
        }

        return tmp.toArray(new Item[0]);
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
