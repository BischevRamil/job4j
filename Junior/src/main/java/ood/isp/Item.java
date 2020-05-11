package ood.isp;

public class Item implements Comparable<Item> {
    private String name;
    private int level;

    public Item(String name) {
        this.name = name;
        this.parseLevel();
    }

    private void parseLevel() {
        this.level = (int) this.name.chars().filter(ch -> ch == '.').count();
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.getName());
    }
}
