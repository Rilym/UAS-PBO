import java.util.ArrayList;
interface Balikin {
    void returnCar(int carId, int carOwnerId);
}

abstract class Bengkel implements Balikin {
    public ArrayList<Car> cars = new ArrayList<>();
    public ArrayList<CarOwner> carOwners = new ArrayList<>();

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
        throw new Exception("Pemilik Mobil dengan Id " + id + " Tidak Ditemukan");
    }

    protected Car getCarById(int id) throws Exception {
        for (Car car : this.cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        throw new Exception("Mobil dengan Id " + id + " tidak ditemukan");
    }
}