package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;
import java.lang.System;

public class Tracker {
    private final Item[] items = new Item[100];
    //поле position сделал публичным, чтобы проверить в тестах при удалении элемента, position должен декрементироваться
    public int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public boolean replace(String id, Item item) {
        for (int i = 0; i <= position; i++) {
            if (this.items[i].getId().equals(id)) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        Item[] tmp = new Item[position];
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, tmp, i, position - i - 1);
                break;
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != null) {
                System.arraycopy(tmp, i, this.items, i, position - i - 1);
                position--;
                return true;
            }
        }
        return false;
    }

    public Item[] findAll() {
        Item[] tmp = new Item[position];
        System.arraycopy(this.items, 0, tmp, 0, position);
        return tmp;
    }

    public Item[] findByName(String key) {
        ArrayList<Item> tmp = new ArrayList<Item>();
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                tmp.add(items[i]);
            }
        }
        Item[] array = tmp.toArray(new Item[0]);
        return array;
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
