import java.util.ArrayList;
class CarOwner {
    private int id;
    private String name;
    private ArrayList<Car> carsOwned;

    public CarOwner() {
        this.carsOwned = new ArrayList<Car>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getCarsOwned() {
        return carsOwned;
    }

    public Car getCarById(int carId) {
        return null;
    }
}