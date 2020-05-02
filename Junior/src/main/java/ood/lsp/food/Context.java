package ood.lsp.food;

public class Context {
    private IStorage iStorage;

    public Context(IStorage iStorage) {
        this.iStorage = iStorage;
    }

    public void addToStorage(Food food) {
        iStorage.add(food);
    }

}
