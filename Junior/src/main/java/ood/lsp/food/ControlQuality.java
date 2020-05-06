package ood.lsp.food;

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
 * Uses pattern Strategy.
 */
public class ControlQuality {
    private Context context;
    private List<Food> foodList;
    private IStorage wareHouse = new StorageWareHouse();
    private IStorage shop = new StorageShop();
    private IStorage trash = new StorageTrash();

    public ControlQuality(List<Food> foods) {
        this.foodList = foods;
    }

    public void doControl() {
        for (Food food : foodList) {
                context = new Context(this.wareHouse);
                context.addToStorage(food);
                context = new Context(this.shop);
                context.addToStorage(food);
                context = new Context(this.trash);
                context.addToStorage(food);
        }
    }

    public List<Food> getFoodsFromWareHouse() {
        return this.wareHouse.getFoodList();
    }

    public List<Food> getFoodsFromShop() {
        return this.shop.getFoodList();
    }

    public List<Food> getFoodsFromTrash() {
        return this.trash.getFoodList();
    }
}
