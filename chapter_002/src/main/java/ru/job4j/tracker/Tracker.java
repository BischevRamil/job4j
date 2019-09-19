package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.lang.System;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    //поле position сделал публичным, чтобы проверить в тестах при удалении элемента, position должен декрементироваться
    public int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        position++;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public boolean replace(String id, Item item) {
            for (Item itm:items) {
                if (itm.getId().equals(id)) {
                    itm.setId(id);
                    itm.setName(item.getName());
                    itm.setDesc(item.getDesc());
                    itm.setTime(item.getTime());
                    return true;
                }
            }
        return false;
    }

    public boolean delete(String id) {
        Iterator<Item> ItemIterator = items.iterator();
        while (ItemIterator.hasNext()) {
            Item nextItem = ItemIterator.next();
            if (nextItem.getId().equals(id)) {
                ItemIterator.remove();
                position--;
                return true;
            }
        }
//        Item[] tmp = new Item[position];
//        for (int i = 0; i < position; i++) {
//            if (this.items[i].getId().equals(id)) {
//                System.arraycopy(this.items, i + 1, tmp, i, position - i - 1);
//                System.arraycopy(tmp, i, this.items, i, position - i - 1);
//                position--;
//                return true;
//            }
//        }
        return false;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> tmp = new ArrayList<>();
        for (Item item:items) {
            if (item.getName().equals(key)) {
                tmp.add(item);
            }
        }
        return tmp;
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
