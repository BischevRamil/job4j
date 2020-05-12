package ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramil Bischev.
 * @since 2020-05-02.
 * The method sends products to the storage depending on the shelf life.
 * shelf life >= 0 and < 25 -> Warehouse;
 * shelf life >= 25 and < 75 -> Shop;
 * shelf life >= 75 and < 100 -> Shop with discount = 25%;
 * other shelf life -> Trash.
 *
 */
public class ControlQuality {
    private List<Food> foodList;
    private List<IStorage> storageList;

    public ControlQuality(List<Food> foods, List<IStorage> storages) {
        this.foodList = foods;
        this.storageList = storages;
    }

    public void doControl() {
        for (Food food : foodList) {
            for (IStorage storage : storageList) {
                storage.add(food);
            }
        }
    }

    public void resort() {
        this.foodList.clear();
        for (IStorage storage : storageList) {
            this.foodList.addAll(storage.getFoodList());
            storage.clearFoodList();
        }
        this.doControl();
    }
}
