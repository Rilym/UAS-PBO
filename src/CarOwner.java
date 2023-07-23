import java.util.ArrayList;

class CarOwner {
    private int id;
    private String name;
    private final ArrayList<Car> carsOwned;

    public CarOwner() {
        this.carsOwned = new ArrayList<>();
        this.id = 0; // Nilai default untuk ID jika tidak diberikan nilai
        this.name = ""; // Nilai default untuk nama jika tidak diberikan nilai
    }

    public CarOwner(int id, String name) {
        this(); // Memanggil konstruktor default untuk menginisialisasi ArrayList
        this.id = id;
        this.name = name;
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
}
