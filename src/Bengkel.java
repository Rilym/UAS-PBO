import java.util.ArrayList;
interface Borrowable {
    void returnCar(int carId, int carOwnerId);
}

abstract class Bengkel implements Borrowable {
    public ArrayList<Car> cars = new ArrayList<Car>();
    public ArrayList<CarOwner> carOwners = new ArrayList<CarOwner>();
    public abstract boolean isCarOwnedByOwner(int carId, int ownerId);


    public abstract void addCarOwner(CarOwner carOwner);

    public abstract void serviceCar(int carId, int carOwnerId);

    public abstract void returnCar(int carId, int carOwnerId);
    public abstract void addCar(Car car);


    protected int getCarOwnerIndex(CarOwner carOwner) {
        return this.carOwners.indexOf(carOwner);
    }

    protected CarOwner getCarOwnerById(int id) throws Exception {
        for (CarOwner carOwner : this.carOwners) {
            if (carOwner.getId() == id) {
                return carOwner;
            }
        }
        throw new Exception("Car owner with id " + id + " not found");
    }

    protected Car getCarById(int id) throws Exception {
        for (Car car : this.cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        throw new Exception("Car with id " + id + " not found");
    }
}