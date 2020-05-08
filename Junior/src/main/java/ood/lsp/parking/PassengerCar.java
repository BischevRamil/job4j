package ood.lsp.parking;

public class PassengerCar implements ICar {
    private final int id;
    private final int size;

    public PassengerCar(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getID() {
        return 0;
    }
}
