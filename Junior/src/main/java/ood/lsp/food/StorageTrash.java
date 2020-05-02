package ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class StorageTrash implements IStorage {
    private List<Food> listFood;

    public StorageTrash() {
        this.listFood = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.listFood.add(food);
    }

    @Override
    public List<Food> getFoodList() {
        return this.listFood;
    }
}
