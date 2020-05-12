package ood.isp;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

/**
 * @author Ramil Bischev
 * @since 2020-05-11
 * Class Menu implements methods show() for print menu to console, and action(item) for item execute.
 */
public class Menu implements IShow, IAction {
    private Set<Item> itemSet = new TreeSet<>();

    public void addItems(Set<Item> items) {
        this.itemSet.addAll(items);
    }

    public void addItem(Item childNode) {
        this.itemSet.add(childNode);
    }

    public void removeItem(String nodeId) throws NullPointerException {
        this.itemSet.remove(this.findByName(nodeId));
    }

    private Item findByName(String nameItem) {
        Item itemResult;
        for (Item item : this.itemSet) {
            if (item.getName().equals(nameItem)) {
                itemResult = item;
                return itemResult;
            }
        }
        return null;
    }
    @Override
    public void show() {
        for (Item item : this.itemSet) {
            int level = item.getLevel();
            for (int i = 1; i <= level; i++) {
                System.out.print("--");
            }
            System.out.println(item.getName());
        }
    }

    @Override
    public void action(Item item) {
        System.out.format("Your choose, %s", item.getName());
    }
}
