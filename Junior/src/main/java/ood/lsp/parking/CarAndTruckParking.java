package ood.lsp.parking;

public class CarAndTruckParking implements IParking {
    private final IParking carParking;
    private final IParking truckParking;

    public CarAndTruckParking(IParking carParking, IParking truckParking) {
        this.carParking = carParking;
        this.truckParking = truckParking;
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
