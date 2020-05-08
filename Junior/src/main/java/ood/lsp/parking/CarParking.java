package ood.lsp.parking;

public class CarParking implements IParking {
    private final int totalSpace;
    private final int spaceSize;

    public CarParking(int totalSpace, int spaceSize) {
        this.totalSpace = totalSpace;
        this.spaceSize = spaceSize;
    }

    @Override
    public boolean startParking(ICar car) {
        return false;
    }

    @Override
    public boolean finishParking(ICar car) {
        return false;
    }

    @Override
    public int countFreeSpace() {
        return 0;
    }

    @Override
    public boolean checkFreeSpace() {
        return false;
    }
}
