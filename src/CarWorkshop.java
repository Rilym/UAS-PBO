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

            if (car == null) {
                throw new Exception("Mobil dengan Id " + carId + " tidak dimiliki oleh pemilik mobil ID " + carOwnerId);
            }

            this.cars.remove(car);
            this.carOwners.remove(carOwner);

            // Memperbarui ID mobil
            for (int i = 0; i < this.cars.size(); i++) {
                Car currentCar = this.cars.get(i);
                currentCar.setId(i + 1);
            }

            // Memperbarui ID pemilik mobil
            for (int i = 0; i < this.carOwners.size(); i++) {
                CarOwner currentOwner = this.carOwners.get(i);
                currentOwner.setId(i + 1);
            }

            carOwner.getCarsOwned().remove(car);
            System.out.println("Mobil dengan Id " + car.getId() + " telah dikembalikan ke pemilik mobil dengan ID " + carOwner.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void addCar(Car car) {
        if (!isCarIdExist(car.getId())) {
            this.cars.add(car);
            System.out.println("Mobil sudah terdaftar di bengkel untuk service");
        } else {
            System.out.println("Mobil dengan Id  " + car.getId() + " telah digunakan");
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
