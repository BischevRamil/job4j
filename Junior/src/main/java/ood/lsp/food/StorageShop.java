package ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class StorageShop implements IStorage {
    private List<Food> listFood;

    public StorageShop() {
        this.listFood = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        if (this.accept(food) && food.getShelfLife() < 75) {
            this.listFood.add(food);
        } else if (this.accept(food) && food.getShelfLife() >= 75) {
            food.setDiscount(25);
            this.listFood.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        return food.getShelfLife() >= 25 && food.getShelfLife() < 100;
    }

    @Override
    public List<Food> getFoodList() {
        return this.listFood;
    }
}
