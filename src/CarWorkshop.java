class CarWorkshop extends Bengkel {

    public CarWorkshop() {
        super();
    }
    @Override
    public boolean isCarOwnedByOwner(int carId, int ownerId) {
        try {
            CarOwner carOwner = getCarOwnerById(ownerId);
            return carOwner.getCarById(carId) != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void addCarOwner(CarOwner carOwner) {
        if (!isCarOwnerIdExist(carOwner.getId())) {
            this.carOwners.add(carOwner);
            System.out.println("Car owner successfully added");
        } else {
            System.out.println("Car owner with ID " + carOwner.getId() + " already exists");
        }
    }

    private boolean isCarOwnerIdExist(int id) {
        for (CarOwner carOwner : this.carOwners) {
            if (carOwner.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void serviceCar(int carId, int carOwnerId) {
        try {
            Car car = this.getCarById(carId);

            CarOwner carOwner = this.getCarOwnerById(carOwnerId);
            int carOwnerIndex = this.getCarOwnerIndex(carOwner);
            this.cars.remove(car);
            this.carOwners.get(carOwnerIndex).getCarsOwned().add(car);
            System.out.println("Car with id " + car.getId() + " has been successfully serviced by car owner with ID " + carOwner.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void returnCar(int carId, int carOwnerId) {
        try {
            CarOwner carOwner = this.getCarOwnerById(carOwnerId);
            int carOwnerIndex = this.getCarOwnerIndex(carOwner);

            Car car = this.carOwners.get(carOwnerIndex).getCarById(carId);

            if (car == null) {
                throw new Exception("Car with id " + carId + " is not owned by car owner with ID " + carOwner.getId());
            }

            this.cars.add(car);
            this.carOwners.get(carOwnerIndex).getCarsOwned().remove(car);
            System.out.println("Car with id " + car.getId() + " has been successfully returned by car owner with ID " + carOwner.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addCar(Car car) {
        if (!isCarIdExist(car.getId())) {
            this.cars.add(car);
            System.out.println("Car successfully added");
        } else {
            System.out.println("Car with ID " + car.getId() + " already exists");
        }
    }

    private boolean isCarIdExist(int id) {
        for (Car car : this.cars) {
            if (car.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
