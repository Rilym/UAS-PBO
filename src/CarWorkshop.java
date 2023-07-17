class CarWorkshop extends Bengkel {

    public CarWorkshop() {
        super();
    }
    @Override
    public void addCarOwner(CarOwner carOwner) {
        if (!isCarOwnerIdExist(carOwner.getId())) {
            this.carOwners.add(carOwner);
            System.out.println("Pemilik Mobil baru berhasil ditambahkan");
        } else {
            System.out.println("Pemilik Mobil dengan ID ini" + carOwner.getId() + " Telah Tersedia");
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

            this.carOwners.get(carOwnerIndex).getCarsOwned().add(car);
            System.out.println("Mobil dengan Id " + car.getId() + " milik " + carOwner.getId() + " telah selesai di service");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void returnCar(int carId, int carOwnerId) {
        try {
            Car car = this.getCarById(carId);
            CarOwner carOwner = this.getCarOwnerById(carOwnerId);
            int carOwnerIndex = this.getCarOwnerIndex(carOwner);
            this.cars.remove(car);
            this.carOwners.get(carOwnerIndex).getCarById();

            if (car == null) {
                throw new Exception("Mobil dengan Id " + carId + " tidak dimiliki oleh pemilik mobil ID " + carOwner.getId());
            }

            this.cars.add(car);
            this.carOwners.get(carOwnerIndex).getCarsOwned().remove(car);
            System.out.println("Mobil dengan Id " + car.getId() + " telah dikembailkan ke pemilik mobil dengan ID " + carOwner.getId());
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
