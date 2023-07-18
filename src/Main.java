import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    static Bengkel bengkel = new CarWorkshop();

    public static void main (String[] args) {
        initBengkelData();

        String isContinue = "y";

        while (isContinue.equals("y")) {
            showMenu();
            int selectedMenu = chooseMenu();

            if (selectedMenu == 1) {
                showCars();
            } else if (selectedMenu == 2) {
                showCarOwners();
            } else if (selectedMenu == 3) {
                addCarOwner();
            } else if (selectedMenu == 4) {
                addCar();
            } else if (selectedMenu == 5) {
                serviceCar();
            }else if (selectedMenu == 6) {
                returnCar();
            } else {
                System.out.println("wrong input");
            }

            System.out.print("continue ? (y/n) ");
            while (true) {
                String input = scan.next();
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                    isContinue = input;
                    break;
                } else {
                    System.out.println("Invalid Input. Please enter 'y' or 'n'.");
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("================================");
        System.out.println("1. List Mobil");
        System.out.println("2. list Pemilik Mobil");
        System.out.println("3. Tambah Pemilik Mobil");
        System.out.println("4. Menambah Mobil");
        System.out.println("5. service Mobil");
        System.out.println("6. Mengembalikan Mobil");
        System.out.println("================================");
    }

    public static void initBengkelData() {
        Car car1 = new Car();
        car1.setId(1);
        car1.setBrand("Toyota");

        Car car2 = new Car();
        car2.setId(2);
        car2.setBrand("Honda");

        Car car3 = new Car();
        car3.setId(3);
        car3.setBrand("BMW");

        CarOwner carOwner1 = new CarOwner();
        carOwner1.setId(1);
        carOwner1.setName("John");

        CarOwner carOwner2 = new CarOwner();
        carOwner2.setId(2);
        carOwner2.setName("Mike");

        CarOwner carOwner3 = new CarOwner();
        carOwner3.setId(3);
        carOwner3.setName("Sarah");

        bengkel.cars.add(car1);
        bengkel.cars.add(car2);
        bengkel.cars.add(car3);

        bengkel.carOwners.add(carOwner1);
        bengkel.carOwners.add(carOwner2);
        bengkel.carOwners.add(carOwner3);
    }

    public static int chooseMenu() {
        int selectedMenu = 0;
        try {
            System.out.print("Pilih menu : ");
            selectedMenu = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input Invalid, dimohon menginput angka.");
            scan.next(); // clear the scanner buffer
        }
        return selectedMenu;
    }

    public static void showCars() {
        for (Car car : bengkel.cars) {
            System.out.println(car.getId() + " " + car.getBrand());
        }
    }

    public static void showCarOwners() {
        for (CarOwner carOwner : bengkel.carOwners) {
            System.out.println(carOwner.getId() + " " + carOwner.getName());
        }
    }

    public static void addCarOwner() {
        CarOwner carOwner = new CarOwner();

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("id : ");
                carOwner.setId(scan.nextInt());

                System.out.print("nama : ");
                carOwner.setName(scan.next());

                validInput = true; // Input valid, keluar dari loop
            } catch (InputMismatchException e) {
                System.out.println("Salah inputan, Masukkan input yang valid.");
                scan.next(); // Membersihkan buffer masukan
            }
        }

        bengkel.addCarOwner(carOwner);
    }
    public static void addCar() {
        Car car = new Car();
        boolean validInput = false;
        while (!validInput){
            try {
                System.out.print("id : ");
                car.setId(scan.nextInt());

                System.out.print("Merek : ");
                car.setBrand(scan.next());

                validInput = true;
            }catch (InputMismatchException e){
                System.out.println("Salah inputan, Masukkan inout yang valid");
                scan.next();
            }
        }

        bengkel.addCar(car);
    }
    public static void serviceCar() {
        System.out.print("Id Pemilik Mobil  : ");
        int carOwnerId = scan.nextInt();

        System.out.print("Id Mobil : ");
        int carId = scan.nextInt();

        bengkel.serviceCar(carId, carOwnerId);
    }
    public static void returnCar() {
        System.out.print("Id Pemilik Mobil : ");
        int carOwnerId = scan.nextInt();

        System.out.print("Id Mobil : ");
        int carId = scan.nextInt();

        bengkel.returnCar(carId, carOwnerId);
    }
}