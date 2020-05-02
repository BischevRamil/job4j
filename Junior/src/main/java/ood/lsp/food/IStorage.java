package ood.lsp.food;

import java.util.List;

public interface IStorage {

    void add(Food food) ;

    List<Food> getFoodList();
}
