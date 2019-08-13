package ru.job4j.tracker;


import java.util.Arrays;
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
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                items[i].setId(id);
                items[i].setName(item.getName());
                items[i].setDesc(item.getDesc());
                items[i].setTime(item.getTime());
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
                System.arraycopy(tmp, i, this.items, i, position - i - 1);
                position--;
                return true;
            }
        }
        return false;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[position];
        int j = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                System.arraycopy(this.items, i, tmp, j++, 1);
            }
        }
        return Arrays.copyOf(tmp, j);
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
