package ood.lsp.parking;

public interface IParking {

    /**
     * Parks a car.
     * @param car Car.
     * @return true if the car is successfully parked.
     */
    boolean startParking(ICar car);

    /**
     * Finish parks a car.
     * @param car Car.
     * @return true if the car is successfully finished parking.
     */
    boolean finishParking(ICar car);

    /**
     * Counts the number of free parking spaces.
     * @return the number of free parking spaces.
     */
    int countFreeSpace();

    /**
     * Checks free parking spaces.
     * @return true if there is at least one free parking space.
     */
    boolean checkFreeSpace();
}
