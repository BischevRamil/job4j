package ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class StorageWareHouse implements IStorage {
    private List<Food> listFood;

    public StorageWareHouse() {
        this.listFood = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        if (this.accept(food)) {
            this.listFood.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        return food.getShelfLife() >= 0 && food.getShelfLife() < 25;
    }

    @Override
    public List<Food> getFoodList() {
        return this.listFood;
    }

    @Override
    public void clearFoodList() {
        this.listFood.clear();
    }
}
