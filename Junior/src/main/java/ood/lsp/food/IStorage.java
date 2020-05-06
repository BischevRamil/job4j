package ood.lsp.food;

import java.util.List;

public interface IStorage {

    void add(Food food) ;

    boolean accept(Food f);

    List<Food> getFoodList();
}
