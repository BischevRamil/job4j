package ood.lsp.parking;

import java.util.Objects;

public class TruckCar implements ICar {
    private final int id;
    private final int size;

    public TruckCar(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TruckCar truckCar = (TruckCar) o;
        return id == truckCar.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
