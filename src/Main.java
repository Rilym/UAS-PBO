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
        System.out.println("Selamat datang di bengkel Jawa");
        System.out.println("");
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
        Car car1 = new Car(1,"Toyota");
        Car car2 = new Car(2,"Honda");
        Car car3 = new Car(3, "BMW");
        Car car4 = new Car(1, "daihatsu");
        CarOwner carOwner1 = new CarOwner(1,"Niko");

        CarOwner carOwner2 = new CarOwner(2,"John");
        CarOwner carOwner3 = new CarOwner(3,"Mugi");

        bengkel.cars.add(car1);
        bengkel.cars.add(car2);
        bengkel.cars.add(car3);
        bengkel.cars.add(car4);

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
        System.out.println("Mobil yang akan di service dan yang sudah diservice");
        for (Car car : bengkel.cars) {
            System.out.println(car.getId() + " " + car.getBrand());
        }
    }

    public static void showCarOwners() {
        System.out.println("Pemilik mobil");
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
        System.out.println("Pastikan Id Mobil dengan Id Pemilik Mobil sama");
        System.out.println("");
        System.out.print("Id Pemilik Mobil : ");
        int carOwnerId = scan.nextInt();

        System.out.print("Id Mobil : ");
        int carId = scan.nextInt();

        bengkel.returnCar(carId, carOwnerId);
    }
}